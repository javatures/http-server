import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private BufferedReader reader;
    private String method;
    private String path;
    private Map<String, String> headers;

    public Request(BufferedReader bufferedReader) throws IOException {
        this.reader = bufferedReader;
        this.headers = new HashMap<>();
        parse();
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    private void parse() throws IOException {
        String requestLine = reader.readLine();
        String[] splitRequestLine = requestLine.split(" ");
        this.method = splitRequestLine[0];
        this.path = splitRequestLine[1];

        String header;
        while ((header = reader.readLine()).length() != 0) {
            String[] headerTokens = header.split(":");
            headers.put(headerTokens[0], headerTokens[1]);
        }
    }
    
}
