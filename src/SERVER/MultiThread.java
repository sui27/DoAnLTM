
package SERVER;

import java.io.*;
import java.net.*;

public class MultiThread extends Thread {
    private Socket socket;
    private int clientNumber;

    public MultiThread(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = in.readLine(); // Đọc dữ liệu từ client
            System.out.println("Client " + clientNumber + " sent: " + message);

            // Xử lý dữ liệu và gửi kết quả lại cho client
            String response = "Hello from server, client " + clientNumber + "!";
            out.println(response);

            socket.close();
            System.out.println("Client " + clientNumber + " disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void stopThread() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
