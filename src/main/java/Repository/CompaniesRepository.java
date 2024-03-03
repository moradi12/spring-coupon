package Repository;

import beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface CompaniesRepository extends JpaRepository<Company, Integer> {
    Boolean existsByEmailAndPassword(String email, String password);

    List<Company> findAll();

    List<Company> findByName(String name);

    List<Company> findByNameID(int id);

    Company save(Company company);

    void deleteById(int companyId);
}
