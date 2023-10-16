
package SERVER;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SERVER {
    private static int port = 9999; // Cổng kết nối máy chủ

    public static void main(String[] args) {
        
        setServerPort(9999); // Đặt cổng của máy chủ
        startServer();
    }

    public static void setServerPort(int serverPort) {
        port = serverPort;
    }

    public static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is waiting to accept connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from client: " + clientSocket.getInetAddress());

                // Thực hiện xử lý kết nối với máy khách ở đây
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}