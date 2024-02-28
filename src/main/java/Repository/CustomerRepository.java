package Repository;

import beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean IsCustomerExists(String email, String password);
    void addCustomer(Customer customer);
    void deleteCustomer(int customerID);
    List<Customer> findByID(int id);

    List<Customer> findByName(String name); // find 1

    List<Customer> findAllByName(String name);

}
