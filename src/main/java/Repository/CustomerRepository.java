package Repository;

import beans.Coupon;
import beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean IsCustomerExists(String email, String password);

    void addCustomer(Customer customer);

    void deleteCustomer(int customerID);




    ////find
    List<Customer> findByID(int id);

    List<Customer> findByName(String name); // find 1
    List<Customer> findByNameOrID(String name, int id);

    List<Customer> findAllByName(String name);

}
