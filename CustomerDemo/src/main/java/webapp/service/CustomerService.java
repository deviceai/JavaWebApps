package webapp.service;

import com.sun.tools.javac.util.List;
import webapp.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getById(Long id);

    void save(Customer customer);
    void delete(Long id);

    List<Customer> getAll();
}
