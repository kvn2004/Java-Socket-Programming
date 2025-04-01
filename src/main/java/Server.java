import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/28/2025 11:38 AM
 * Project: SocketProgramming
 * --------------------------------------------
 **/

public class Server {
    public static void main(String[] args) {
//        SERVER SIDE
        String s = "";

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Starting Server...");

            ServerSocket serverSocket = new ServerSocket(5000);

            Socket socket = serverSocket.accept();

            System.out.println("Client Connected...");
            while (!s.equalsIgnoreCase("bye")) {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                s = in.readUTF();
                System.out.println(s);

                s = sc.nextLine();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(s);
                out.flush();
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
