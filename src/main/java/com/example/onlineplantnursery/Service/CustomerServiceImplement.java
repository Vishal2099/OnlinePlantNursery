package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Customer;
import com.example.onlineplantnursery.Exception.UserNotFoundException;
import com.example.onlineplantnursery.Repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImplement implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    @Override
    public Customer validateCustomer(String username, String password) {
        Customer customer=new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        try {
            if (customerRepository.exists(Example.of(customer)))
                return customer;
            else
                throw new UserNotFoundException("User not found");
        } catch (UserNotFoundException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer removeCustomer(Integer customerId) {
        Optional<Customer> userTemp = customerRepository.findById(customerId);
        if (userTemp.isPresent()) {
            customerRepository.deleteById(customerId);
            return customer;
        } else
            return null;
    }
}