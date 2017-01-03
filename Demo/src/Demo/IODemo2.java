package Demo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/1.
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
        File f = new File("F://newest.txt");
        f.createNewFile(); //这样会创建一个txt文件
        boolean mkdir = f.mkdir();//这样会创建一个文件夹，文件夹的名字是  newest.txt
    }
}
