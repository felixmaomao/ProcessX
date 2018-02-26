package io;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class InputStreamTest {
    public static void main(String args[]) {
        try {
            byte bWrite[] = {'h', 'e', 'l', 'l', 'o'};
            OutputStream os = new FileOutputStream("D:/test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();
        }catch (Exception e){

        }
    }
}
