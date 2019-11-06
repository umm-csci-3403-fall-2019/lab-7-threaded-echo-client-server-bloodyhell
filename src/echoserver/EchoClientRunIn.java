package echoserver;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class EchoClientRunIn implements Runnable {

    private Socket client;

    public EchoClientRunIn(Socket socket) {
        client = socket;
    }

    public void run() {
        try {
            //Reads the bytes from the Standard out and writes them to the output stream
            int read;
            OutputStream output = client.getOutputStream();
            while ((read = System.in.read()) != -1) {
                output.write(read);
            }
            //Flushes the rest and then shutdowns the socket/client so it can be used later
            output.flush();
            client.shutdownOutput();

        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);

        }

    }

}