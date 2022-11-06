package ru.itis.dis.S1.protocol;

import ru.itis.dis.S1.model.Transaction;
import ru.itis.dis.S1.service.XMLBankService;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 50001;

    public static void main (String[] args){
        try {
            ServerSocket server =
                    new ServerSocket(SERVER_PORT);

            Socket clientSocket = server.accept();

            System.out.println("connected");

            InputStream is = clientSocket.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is));

           Thread receiver = new Thread(new Runnable() {
               StringBuilder xml = new StringBuilder();
               String msg;
               @Override
               public void run() {
                   try {
                       msg = in.readLine();
                       while(msg != null){
                           xml.append(msg + "\n");
                           msg = in.readLine();
                       }
                       System.out.println(xml.toString());

                       Transaction transaction = XMLBankService.fromXML(xml.toString());
                       System.out.println(transaction);

                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   } catch (JAXBException e) {
                       throw new RuntimeException(e);
                   }

               }
           });

           receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int fromByteArray(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8 ) |
                ((bytes[3] & 0xFF) << 0 );
    }

}
