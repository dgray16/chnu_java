package javaserver;


import java.net.*;
import java.io.*;


public class JavaServer {
   public static void main(String[] ar)    {
     int port = 1234;
       try {
         ServerSocket ss = new ServerSocket(port); 
         System.out.println("Waiting for a request...");

         Socket socket = ss.accept(); 
         System.out.println(" I have got a request! ");
         System.out.println();


         InputStream sIn = socket.getInputStream();
         OutputStream sOut = socket.getOutputStream();

         DataInputStream in = new DataInputStream(sIn);
         DataOutputStream out = new DataOutputStream(sOut);

         int cycle=0;
         
         String line = null;
         while(cycle < 3) {
           line = in.readUTF();
           System.out.println("The client sent me this line : " + line);
           line ="Hello, client! I'm waiting for your request";
           System.out.println(line); 
           
           out.writeUTF(line);
           out.flush(); 
           cycle++;
          
         }
      } catch(Exception x) { x.printStackTrace(); }
   }
}
