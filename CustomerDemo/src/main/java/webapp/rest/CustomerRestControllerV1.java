package webapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import webapp.model.Customer;
import webapp.service.CustomerService;

import java.util.Optional;

@RestController
@RequestMapping("api/vl/customers/")
public class CustomerRestControllerV1 {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
        if(customerId == null){
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> customer = this.customerService.getById(customerId);

        if(customer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
}
