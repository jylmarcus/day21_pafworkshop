package paf.visa.day21_pafworkshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.visa.day21_pafworkshop.model.Customer;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomers(final int limit, final int offset) {
        final List<Customer> result = template.query(
            "select * from northwind limit ? offset ?",
            (rs, int) -> {
                Customer cust = new Customer();
                //cust.setAttribute(rs.getX(attr_name))
            },
            limit, offset
        );

    return (Collections.unmodifiableList(result));
    }
}
