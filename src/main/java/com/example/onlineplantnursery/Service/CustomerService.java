package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public Customer validateCustomer(String username, String password);
    public Customer addCustomer(Customer customer);
    public Customer removeCustomer(Integer customerId);
}
