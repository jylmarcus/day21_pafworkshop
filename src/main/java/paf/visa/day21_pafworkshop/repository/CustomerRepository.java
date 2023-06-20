package paf.visa.day21_pafworkshop.repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.visa.day21_pafworkshop.model.Customer;
import paf.visa.day21_pafworkshop.model.Order;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Customer> getAllCustomers() {
        final List<Customer> result = new ArrayList<Customer>();

        final SqlRowSet rs = template.queryForRowSet("select id, first_name, last_name, dob from customer");

        while(rs.next()){
            Customer cust = new Customer();
            cust.setId(rs.getInt("id"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));
            cust.setDob(rs.getDate("dob"));
            result.add(cust);
        }
        return result;
    }

    public List<Customer> getCustomers(final int limit, final int offset) {
        final List<Customer> result = template.query(
            "select * from customer limit ? offset ?",
            (rs, rowNum) -> {
                Customer cust = new Customer();
                cust.setId(rs.getInt("id"));
                cust.setFirstName(rs.getString("first_name"));
                cust.setLastName(rs.getString("last_name"));
                cust.setDob(rs.getDate("dob"));
                return cust;
            },
            limit, offset
            
            );

    return (Collections.unmodifiableList(result));
    }

    public Customer getCustomerById(final int id) {
        return template.queryForObject("select * from customer where id = ?", BeanPropertyRowMapper.newInstance(Customer.class), id);
    }

    public List<Order> getCustomerOrders(final int id) {
        final List<Order> result = template.query(
            "select id, customer_id, order_date, shipped_date, ship_name from order where customer_id = ?",
            (rs, rowNum) -> {
                Order ord = new Order();
                ord.setId(rs.getInt("id"));
                ord.setCustomerId(rs.getInt("customer_id"));
                ord.setOrderDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(rs.getDate("order_date").getTime()), ZoneOffset.UTC));
                ord.setShippedDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(rs.getDate("shipped_date").getTime()), ZoneOffset.UTC));
                ord.setShipName(rs.getString("ship_name"));

                return ord;
            },
            id
        );
        return result;
    }
}
