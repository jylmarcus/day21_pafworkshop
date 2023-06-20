package paf.visa.day21_pafworkshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.visa.day21_pafworkshop.model.Customer;
import paf.visa.day21_pafworkshop.model.Order;
import paf.visa.day21_pafworkshop.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;
    
    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public List<Customer> getCustomers(int limit, int offset) {
        return repository.getCustomers(limit, offset);
    }

    public Customer getCustomerById(int id) {
        return repository.getCustomerById(id);
    }

    public List<Order> getCustomerOrders(int id) {
        return repository.getCustomerOrders(id);
    }
}
