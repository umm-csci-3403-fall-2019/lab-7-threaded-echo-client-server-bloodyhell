package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class EchoClient {
    public static final int PORT_NUMBER = 6013;

    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClient();
        client.start();
    }

    private void start() throws IOException {

        Socket socket = new Socket("localhost", PORT_NUMBER);
        InputStream socketInputStream = socket.getInputStream();
        OutputStream socketOutputStream = socket.getOutputStream();

        EchoClientRunIn runIn = new EchoClientRunIn(socket);
        EchoClientRunOut runOut = new EchoClientRunOut(socket);

        Thread tin = new Thread(runIn);
        tin.start();

        Thread tout = new Thread(runOut);
        tout.start();
    }
}