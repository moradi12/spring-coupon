package Repository;

import beans.Companies;
import beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompaniesRepository extends JpaRepository<Companies, Integer> {
    Boolean IsCompanyExists(String email, String password);

    List<Companies> findByName(String name);

    List<Companies> findByNameOrID(String name, int id);

    List<Companies> findAllByOrderByWeightDesc();
}
