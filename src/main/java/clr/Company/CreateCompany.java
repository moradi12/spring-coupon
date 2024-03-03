package clr.Company;

import Repository.CompaniesRepository;
import beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(3)
public class CreateCompany implements CommandLineRunner {

    @Autowired
    CompaniesRepository companiesRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Company> companies = new ArrayList<>();

        Company nike = beans.Company.builder()
                .name("Nike")
                .email("Nike@Nike.com")
                .password("3232gg")
                .build();
        companies.add(nike);

        Company prada = beans.Company.builder()
                .name("Prada")
                .email("Prada@Prada.com")
                .password("Prada789")
                .build();
        companies.add(prada);

        // Save all companies
        companiesRepository.saveAll(companies);
    }
}
