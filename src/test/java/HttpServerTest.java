import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

public class HttpServerTest {

    @Test
    public void testParse() throws IOException {
        HttpServer testServer = new HttpServer(8080);
        String request = "GET / HTTP/1.1\nHost: localhost:8080";
        testServer.parse(new BufferedReader(new StringReader(request)));
    }

    @Test
    public void testSend() {
        HttpServer testServer = new HttpServer(8081);
        testServer.send(new PrintWriter(System.out), "Hello");
    }

    @Test
    public void blah() {
        
    }

    @Test
    public void foobar() {
        
    }
}
