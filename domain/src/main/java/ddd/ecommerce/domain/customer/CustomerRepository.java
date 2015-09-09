package ddd.ecommerce.domain.customer;


public interface CustomerRepository {
    public Customer store(Customer customer);
    public Customer get(CustomerId customerId);
}
