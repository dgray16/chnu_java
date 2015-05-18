package javaclient;

import java.net.*;
import java.io.*;

public class JavaClient {
    public static void main(String[] ar) {
        int serverPort = 1234; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа. 
                                      // Здесь указан адрес того самого компьютера где будет исполняться и клиент.

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            System.out.println("An effort to connect to " + address + " and port " + serverPort );
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("I am lucky!");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом. 
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в человеческий тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream inS = new DataInputStream(sin);
            DataOutputStream outS = new DataOutputStream(sout);

           
            String line = "Hello, server";
       

            while (true) {
                System.out.println( line + "  - Sending this line to the server");
                outS.writeUTF(line); // отсылаем приготовленную строку текста серверу.
                outS.flush(); // заставляем поток закончить передачу данных.
                line = inS.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("The server  sent me  : " + line);
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}