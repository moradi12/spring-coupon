package Service;

import Exceptions.ErrMsg;
import Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean checkCustomerExistence(String email, String password) throws AuthenticationException {
        if (!customerRepository.existsByEmailAndPassword(email, password)) {
            throw new AuthenticationException(ErrMsg.AUTHENTICATION_FAILED.getMsg());
        }
        return true;
    }

}

