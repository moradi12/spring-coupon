package clr;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AdminTester implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {


    }
}
