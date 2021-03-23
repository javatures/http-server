import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private ServerSocket serverSocket;

    public HttpServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.err.println("Oops!");
            System.exit(1);
        }
    }

    public void start() {
        try {
            Socket client;
            while ((client = serverSocket.accept()) != null) {
                System.out.println("Incoming request!");
                handle(client);
            }
        } catch (IOException ex) {
            System.err.println("Starting oops!");
        }
    }

    /**
     * handle method will take a Socket and print the incoming message and send back a Hello World.
     * 
     * @param client Incoming Socket
     */
    private void handle(Socket client) {
        try {
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            // Read request through BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Text to send back
            String body = "Hello World";

            // Print response through PrintWriter
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Length: " + body.length());
            writer.println("Content-Type: text/plain");
            writer.println();
            writer.println(body);
        } catch (IOException ex) {
            System.err.println("Handling oops!");
        }
    }
}
