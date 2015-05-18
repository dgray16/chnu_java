import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int port = 1234;

        try{
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a request...");

            Socket socket = serverSocket.accept();
            System.out.println("New request received");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String incomeMsg = dataInputStream.readUTF();
            System.out.println("Msg from client: " + incomeMsg);
            dataOutputStream.writeUTF("Thanks for request, here are your responce!");
            dataOutputStream.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
