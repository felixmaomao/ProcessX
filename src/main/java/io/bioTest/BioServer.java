package io.bioTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class BioServer {
    //默认端口号
    private static int DEFAULT_PORT = 12345;
    //服务端socket 单例
    private static ServerSocket server;

    public static void Start() throws IOException {
        Start(DEFAULT_PORT);
    }

    public static void Start(int port) throws IOException {
        if (null != server) {
            return;
        }
        try {
            server = new ServerSocket(port);
            System.out.println("服务器已启动,端口号为:" + port);
            //通过死循环监听客户端连接
            //如果客户端一直没有连接进来,将会阻塞再server.accept上
            while (true) {
                Socket socket = server.accept();
                //创建新线程来处理这个socket链路
                new Thread(new BioServerHandler(socket)).start();
            }
        } finally {
            if (server != null) {
                System.out.println("服务器已关闭");
                server.close();
                server = null;
            }
        }
    }
}
