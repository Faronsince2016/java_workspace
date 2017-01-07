package chatDemo3;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faron on 2017/1/3.
 */
public class Server2{
    private List<MutilServer> all = new ArrayList<MutilServer>();
    public static void main(String[] args) throws IOException {
        new Server2().start();
    }

    public  void start() throws IOException {
        ServerSocket server = new ServerSocket(10010);
        while(true){
            Socket socket = server.accept();
            MutilServer channel = new MutilServer(socket);
            all.add(channel);
            new Thread(channel).start();
        }
    }

    class MutilServer implements Runnable {
        private String name;
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;

        public MutilServer(){}
        public MutilServer(Socket socket){
            this();
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                this.name =dis.readUTF();
                //System.out.println(this.name);
                this.Rsend("欢迎进入聊天室！");
                sendOthers(this.name+"进入了聊天室",true);
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.CloseAll(dis, dos);
            }
        }
        public String Rrecive()  {

            //通过管道接受数据
            try {
                return dis.readUTF();
            } catch (IOException e) {
                return null;
            }
        }
        public void Rsend(String msg)  {
            //装饰 发送数据
            try {
                if(null != msg && !msg.equals("")) {
                    dos.writeUTF(msg);
                    dos.flush();
                }
            } catch (IOException e) {
                isRunning =false;
                CloseUtil.CloseAll(dis, dos);
            }
            return ;

        }

        public  void sendOthers(String msg,boolean sys){
            if(msg.startsWith("@")){//私聊
                //获取名字
                String name = msg.substring(1,msg.indexOf(":"));
                //获取私聊内容
                String content = msg.substring(msg.indexOf(":")+1);
                //遍历所有客户，找到私聊对象并发送数据
                for (MutilServer other:all){
                    //System.out.println(other.name);
                    if (other.name.equals(name)){
                       // System.out.println(other.name);
                        other.Rsend(this.name+"对您悄悄说："+content);
                    }
                }

            }else {
                for (MutilServer other : all) {
                    if (other == this) {
                        continue;
                    } else {
                        if (sys) {
                            other.Rsend("系统信息：" + msg);
                        }else{
                            other.Rsend(this.name + "对所有人说：" + msg);

                        }
                    }
                }
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                sendOthers(Rrecive(),false);
            }
        }

    }


}
