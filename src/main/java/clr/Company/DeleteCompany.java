package clr.Company;

import Repository.CompaniesRepository;
import Service.CompanyService;
import beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(5)
public class DeleteCompany implements CommandLineRunner {

    @Autowired
    CompanyService companyService;
    @Autowired
    CompaniesRepository companiesRepository;
    @Override
    public void run(String... args) throws Exception {

        Optional<Company> companyToDelete = companiesRepository.findById(1); // Change the id to the one you want to delete
        companyToDelete.ifPresent(company -> {
            companiesRepository.delete(company);
            System.out.println("Company deleted successfully");
        });

    }
}

