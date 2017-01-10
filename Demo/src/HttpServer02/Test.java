package HttpServer02;

import java.util.Arrays;

/**
 * Created by Faron on 2017/1/9.
 */
public class Test {
    public static void main(String[] args) {
        String s2 = "this is a test=";
        String sarray[] = s2.split("=");
        String[] array = Arrays.copyOf(sarray, 3);
        array[1] = null;
        array[2] = null;

        //System.out.println(array[1]+array[2]+array[3]);   NullPointException
        System.out.println(array[1] + array[2]);
    }
}
