package Demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/1.
 */
public class IODemo{
          public static void main(String args[]) throws IOException {
              FileInputStream  fis = new FileInputStream("F://a.txt");
              FileOutputStream fos = new FileOutputStream("F://b.txt");


              int HasRead;
              byte[] b = new byte[1024];

              HasRead = fis.read(b);

              while(HasRead!=-1){
                  fos.write(b,0,HasRead);
                  HasRead=fis.read(b);

              }

              fos.flush();
              fis.close();
              fos.close();


          }


}