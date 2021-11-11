package com.tranjt.mortgageplan.service;

import com.tranjt.mortgageplan.dto.CustomerResponseDTO;
import com.tranjt.mortgageplan.model.Customer;
import com.tranjt.mortgageplan.repository.CustomerRepository;
import com.tranjt.mortgageplan.utils.MortgageCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private MortgageCalculator mortgageCalculator = new MortgageCalculator();

    @InjectMocks
    private CustomerService customerService;


    @BeforeEach
    void setUp()  {
        customerService = new CustomerService(customerRepository, mortgageCalculator);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "John", 1000, 5, 2));
        customers.add(new Customer(2L, "Jill", 2000, 6, 3));
        customers.add(new Customer(3L, "Joe", 3000, 7, 4));

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerResponseDTO> results = customerService.getAllCustomers();

        CustomerResponseDTO expectedFirstCustomer = new CustomerResponseDTO(
                1L,
                "John",
                1000,
                5,
                2,
                43.871389734068096);

        Assertions.assertEquals(3, results.size());
        Assertions.assertEquals(expectedFirstCustomer, results.get(0));
    }

    @Test
    void testAddCustomer() {
    }

    @Test
    void testUpdateCustomer() {
    }

    @Test
    void testDeleteCustomer() {
        customerService.deleteCustomer(1L);
        verify(customerRepository).deleteById(1L);
    }
}