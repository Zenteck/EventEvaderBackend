import com.Codeclan.example.eventevaderscraper.clients.EmailClient;

public class TestJavaMail {

    public static void main(String[] args) {
        try {

            EmailClient.sendMail("azhar981@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
