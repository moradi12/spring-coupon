package clr.Company;

import Repository.CompaniesRepository;
import beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(4)
public class UpdateCompany implements CommandLineRunner {

    @Autowired
    CompaniesRepository companiesRepository;

    @Override
    public void run(String... args) {
        updateCompany("Nike", "NikeV2", "Nikev2@Nike.com", "NikeeeeeE3");
        updateCompany("Prada", "PradaJr", "Prada23@Prada.com", "passwordPrada");
    }

    private void updateCompany(String companyName, String newName, String newEmail, String newPassword) {
        List<Company> companies = companiesRepository.findByName(companyName);
        if (!companies.isEmpty()) {
            Company company = companies.get(0); // Assuming you want the first company with this name
            company.setName(newName);
            company.setEmail(newEmail);
            company.setPassword(newPassword);
            companiesRepository.save(company);
            System.out.println(companyName + " updated successfully");
        } else {
            System.out.println("Failed to update " + companyName + ": Company not found");
        }
    }
}
