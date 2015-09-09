package ddd.ecommerce.domain;

import ddd.ecommerce.domain.customer.Customer;
import ddd.ecommerce.domain.customer.CustomerId;
import ddd.ecommerce.domain.customer.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryMock implements CustomerRepository {
    private static final Map<CustomerId, Customer> customers = new HashMap<CustomerId, Customer>();

    @Override
    public Customer store(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public Customer get(CustomerId customerId) {
        return customers.get(customerId);
    }
}
