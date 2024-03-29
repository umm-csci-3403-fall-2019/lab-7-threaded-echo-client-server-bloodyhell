package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;


public class EchoServer {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		while (true) {
			Socket socket = serverSocket.accept();
//			InputStream inputStream = socket.getInputStream();
//			OutputStream outputStream = socket.getOutputStream();

			// Put your code here.
			// Creates a Runnable and then starts a thread using that runnable
			EchoRunnable myRun = new EchoRunnable(socket);
			Thread t = new Thread(myRun);
			t.start();
		}
	}
}
