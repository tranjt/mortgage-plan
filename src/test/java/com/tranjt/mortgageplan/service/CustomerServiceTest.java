package com.tranjt.mortgageplan.service;

import com.tranjt.mortgageplan.dto.CustomerRequestDTO;
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

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private final MortgageCalculator mortgageCalculator = new MortgageCalculator();

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository, mortgageCalculator);
    }

    @Test
    void Should_return_all_customers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "John", 1000, 5, 2));
        customers.add(new Customer(2L, "Jill", 2000, 6, 3));
        customers.add(new Customer(3L, "Joe", 3000, 7, 4));
        CustomerResponseDTO expectedFirstCustomer = new CustomerResponseDTO(
                1L, "John", 1000, 5, 2, 43.871389734068096
        );

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerResponseDTO> results = customerService.getAllCustomers();

        Assertions.assertEquals(3, results.size());
        Assertions.assertEquals(expectedFirstCustomer, results.get(0));
    }

    @Test
    void Should_add_new_customer() {
        CustomerRequestDTO requestCustomerDTO = new CustomerRequestDTO("John", 1000, 5, 2);
        Customer customer = new Customer(1L, "John", 1000, 5, 2);
        CustomerResponseDTO expectedCustomerRespDTO = new CustomerResponseDTO(
                1L, "John", 1000, 5, 2, 43.871389734068096
        );

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        CustomerResponseDTO result = customerService.addCustomer(requestCustomerDTO);

        Assertions.assertEquals(expectedCustomerRespDTO, result);
    }

    @Test
    void Should_update_customer() {
        CustomerRequestDTO requestCustomerDTO = new CustomerRequestDTO("John", 1000, 5, 2);
        Customer customer = new Customer(1L, "John", 1000, 5, 2);
        CustomerResponseDTO expectedCustomerRespDTO = new CustomerResponseDTO(
                1L, "John", 1000, 5, 2, 43.871389734068096
        );

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        CustomerResponseDTO result = customerService.updateCustomer(requestCustomerDTO, 1L);

        Assertions.assertEquals(expectedCustomerRespDTO, result);
    }

    @Test
    void Should_delete_customer() {
        customerService.deleteCustomer(1L);

        verify(customerRepository).deleteById(1L);
    }
}