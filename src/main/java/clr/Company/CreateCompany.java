package clr.Company;

import Exceptions.CompanyNotFoundException;
import Exceptions.ErrMsg;
import Service.CompanyService;
import beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Order(3)
public class CreateCompany implements CommandLineRunner {

    @Autowired
    CompanyService companyService;
    @Override
    public void run(String... args) throws Exception  {
        try {
            List<Company> companies = Arrays.asList(
                    beans.Company.builder()
                            .name("Nike")
                            .email("Nike@Nike.com")
                            .password("3232gg")
                            .build(),
                    beans.Company.builder()
                            .name("Prada")
                            .email("Prada@Prada.com")
                            .password("Prada789")
                            .build()
            );
            // Save all companies
            companyService.saveAll(companies);
        } catch (CompanyNotFoundException e) {
            throw new CompanyNotFoundException(ErrMsg.DATABASE_CONNECTION_ERROR.getMsg());
        }
    }
}

