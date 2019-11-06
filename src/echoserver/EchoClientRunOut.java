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
            // Reads bytes from the input stream and writes them to the standard output
            InputStream input = client.getInputStream();
            int read;
            while ((read = input.read()) != -1) {
                System.out.write(read);
            }

            //Flushes the rest and then shutdowns the socket/client so it can be used later
            System.out.flush();
            client.shutdownOutput();

        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);

        }
    }

}