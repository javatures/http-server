import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        int port;

        Properties properties = new Properties();
        try{
            properties.load(new FileReader("config.properties"));
            port = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException ex) {
            System.err.println("Reading properties oops!");
            port = 8080;
        }

        HttpServer server = new HttpServer(port);
        System.out.println("Starting server on port " + port);
        server.start();
    }
}
