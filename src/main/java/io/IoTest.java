package io;/**
 * Created by shenwei on 2017/2/24.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**q
 * @author shenwei
 * @create 2017-02-24
 */
public class IoTest {
    public static void main(String[] args) throws IOException{
        char c;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字母，按下q退出");
        do{
            c = (char) br.read();
            System.out.println(c);
        }while(c!='q');
    }
}
