package clr.Customer;

import Service.CustomerService;
import Exceptions.CustomerException;
import Exceptions.ErrMsg;
import beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * A command-line runner component to delete a customer.
 */
@Component
public class DeleteCustomer implements CommandLineRunner {
    @Autowired
    CustomerService customerService;

    /**
     * Runs the deletion process when the application starts.
     *
     * @param args Command-line arguments
     * @throws Exception If an error occurs during the deletion process
     */
    @Override
    public void run(String... args) throws Exception {
        int customerIdToDelete = 1; // Change to the actual ID you want to delete

        try {
            Optional<Customer> optionalCustomer = customerService.getOneCustomer(customerIdToDelete);
            // Check if the customer exists first
            if (optionalCustomer.isPresent()) {
                // If the customer exists, delete it
                Customer customerToDelete = optionalCustomer.get();
                customerService.deleteCustomer(customerToDelete.getId());
                System.out.println("Customer with ID " + customerIdToDelete + " deleted successfully.");
            } else {
                // If the customer does not exist, throw an exception
                throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
            }
        } catch (CustomerException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
        }
    }
}
