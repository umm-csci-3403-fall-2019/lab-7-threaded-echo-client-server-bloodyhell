package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class EchoRunnable implements Runnable{

    public  EchoRunnable(int port) {
        ServerSocket sock = new ServerSocket(port);
    }

    public void run() {
        Socket client = sock.accept();
        System.out.println("Got a request!");
        InputStream  input = client.getInputStream();
        int read;
        OutputStream output = client.getOutputStream();
        while((read = input.read()) != -1){
            output.write(read);
        }

        input.close();
        output.close();
    }
}