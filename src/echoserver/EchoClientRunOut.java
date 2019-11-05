package echoserver;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class EchoClientRunOut implements Runnable {

    private Socket client;

    public EchoClientRunOut(Socket socket) {
        client = socket;
    }

    public void run() {
        try {
            InputStream input = client.getInputStream();
            int read;
            while ((read = input.read()) != -1) {
                System.out.write(read);
            }

            System.out.flush();
            client.shutdownOutput();

        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);

        }
    }

}