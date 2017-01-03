package callback;

public class PaintFrame {
	public static void drawFrame(MyFrame f){
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息栈");
		
		//画窗口

		f.paint();
	}

}
