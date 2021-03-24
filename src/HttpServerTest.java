import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class HttpServerTest {
    HttpServer testServer;

    public static void main(String[] args) throws IOException {
        HttpServerTest test = new HttpServerTest();
        test.testServer = new HttpServer(8080);
        test.testParse();
        test.testSend();
    }

    public void testParse() throws IOException {
        String request = "GET / HTTP/1.1\r\nHost: localhost:8080\r\n";
        testServer.parse(new BufferedReader(new StringReader(request)));
    }

    public void testSend() {
        testServer.send(new PrintWriter(System.out), "Hello");
    }
}
