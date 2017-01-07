package chatDemo2;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Faron on 2017/1/3.
 */
public class CloseUtil {
    public  static void CloseAll(Closeable...io){
        for(Closeable temp : io){
            if(null!=temp){
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
