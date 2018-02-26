package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {

        InputStream f = new FileInputStream("D:/felix.txt");
        int size = f.available();

        for (int i = 0; i < size; i++) {
            System.out.println((char) f.read() + "  ");
        }
        f.close();
    }
}
