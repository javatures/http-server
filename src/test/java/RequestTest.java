import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RequestTest {

    @Test
    public void getMethodGetTest() throws IOException {
        String request = "GET / HTTP/1.1\nHost: localhost";
        Request testRequest = new Request(new BufferedReader(new StringReader(request)));

        String actual = testRequest.getMethod();
        String expected = "GET";
        assertEquals(expected, actual);
    }

    @Test
    public void getMethodPostTest() throws IOException {
        String request = "POST / HTTP/1.1\nHost: localhost";
        Request testRequest = new Request(new BufferedReader(new StringReader(request)));

        String actual = testRequest.getMethod();
        String expected = "POST";
        assertEquals(expected, actual);
    }

    @Test
    public void getPathSlashTest() throws IOException {        
        String request = "GET / HTTP/1.1\nHost: localhost";
        Request testRequest = new Request(new BufferedReader(new StringReader(request)));

        String actual = testRequest.getPath();
        String expected = "/";
        assertEquals(expected, actual);
    }

    @Test
    public void getPathAboutTest() throws IOException {        
        String request = "POST /about.html HTTP/1.1\nHost: localhost";
        Request testRequest = new Request(new BufferedReader(new StringReader(request)));

        String actual = testRequest.getPath();
        String expected = "/about.html";
        assertEquals(expected, actual);
    }

    @Test
    public void getHeadersHost() throws IOException {
        String request = "POST /about.html HTTP/1.1\nHost: localhost\nContent-type: text/plain";
        Request testRequest = new Request(new BufferedReader(new StringReader(request)));

        String actual = testRequest.getHeader("Host");
        String expected = "localhost";
        assertEquals(expected, actual);
    }
}
