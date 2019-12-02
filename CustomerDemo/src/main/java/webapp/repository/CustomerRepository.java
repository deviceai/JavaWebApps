package webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.model.Customer;

/**
 * Repository interface for customer class
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
