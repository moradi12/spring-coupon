package clr.Company;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class CreateCompany implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
