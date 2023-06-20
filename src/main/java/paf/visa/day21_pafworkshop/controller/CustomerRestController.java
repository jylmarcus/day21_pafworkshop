package paf.visa.day21_pafworkshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import paf.visa.day21_pafworkshop.model.Customer;
import paf.visa.day21_pafworkshop.model.Order;
import paf.visa.day21_pafworkshop.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    CustomerService svc;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return svc.getAllCustomers();
    }

    @GetMapping("/customers")
    public List<Customer> getCustomersWithLimitOffset(@RequestParam(name = "limit", defaultValue = "5", required = false) int limit, @RequestParam(name = "offset", defaultValue = "0", required = false) int offset) {
        return svc.getCustomers(limit, offset);
    }

    @GetMapping(path = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@PathVariable("id") int id){
        return svc.getCustomerById(id);
    }

    @GetMapping(path = "/customers/{customer_id}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getCustomerOrder(@PathVariable("customer_id") int id) {
        return svc.getCustomerOrders(id);
    }
}
