import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * --------------------------------------------
 * Author: Vihanga Nimsara(kvn2004)
 * GitHub: https://github.com/kvn2004
 * --------------------------------------------
 * Created: 3/28/2025 11:46 AM
 * Project: SocketProgramming
 * --------------------------------------------
 **/

public class client {
    public static void main(String[] args) {
        String s = " ";
        Scanner sc = new Scanner(System.in);

        try {
            //remote socket
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Client Active...");
            while (!s.equalsIgnoreCase("bye")) {
                s = sc.nextLine();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(s);
                out.flush();

                DataInputStream in = new DataInputStream(socket.getInputStream());
                s = in.readUTF();
                System.out.println(s);
            }
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
