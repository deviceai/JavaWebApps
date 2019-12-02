package webapp.service;

import com.sun.tools.javac.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.model.Customer;
import webapp.repository.CustomerRepository;

import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);

    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }
}
