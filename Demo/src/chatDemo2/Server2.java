package chatDemo2;
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

        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;

        public MutilServer(){}
        public MutilServer(Socket socket){
            this();
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.CloseAll(dis,dos);
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
            String msg1 = "来自聊天室的消息：";
            //装饰 发送数据
            try {
                if(null != msg && !msg.equals("")) {
                    dos.writeUTF(msg1 + msg);
                    dos.flush();
                }
            } catch (IOException e) {
                isRunning =false;
                CloseUtil.CloseAll(dis,dos);
            }
            return ;

        }

        public  void sendOthers(){
            String msg = Rrecive();
            for (MutilServer other :all){
                if (other == this){
                    continue;
                }else {
                    other.Rsend(msg);
                }
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                sendOthers();
            }
        }
    }


}
