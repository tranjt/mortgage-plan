package com.tranjt.mortgageplan.service;

import com.tranjt.mortgageplan.dto.CustomerRequestDTO;
import com.tranjt.mortgageplan.dto.CustomerResponseDTO;
import com.tranjt.mortgageplan.model.Customer;
import com.tranjt.mortgageplan.repository.CustomerRepository;
import com.tranjt.mortgageplan.utils.MortgageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MortgageCalculator mortgageCalculator;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, MortgageCalculator mortgageCalculator) {
        this.customerRepository = customerRepository;
        this.mortgageCalculator = mortgageCalculator;
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return createCustomerResponseDTOList(customers);
    }

    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer(
                customerRequestDTO.getName(),
                customerRequestDTO.getTotalLoan(),
                customerRequestDTO.getInterest(),
                customerRequestDTO.getYears()
        );
        customer = customerRepository.save(customer);
        return createCustomerResponseDTO(customer);
    }

    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO, Long id) {
        Customer customer = new Customer(
                id,
                customerRequestDTO.getName(),
                customerRequestDTO.getTotalLoan(),
                customerRequestDTO.getInterest(),
                customerRequestDTO.getYears()
        );
        customer = customerRepository.save(customer);
        return createCustomerResponseDTO(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private List<CustomerResponseDTO> createCustomerResponseDTOList(List<Customer> customers) {
        return customers.stream()
                .map(this::createCustomerResponseDTO)
                .collect(Collectors.toList());
    }

    private CustomerResponseDTO createCustomerResponseDTO(Customer customer) {
        double fixedMonthlyPayment = mortgageCalculator.calculateMonthlyPayment(
                customer.getInterest(),
                customer.getTotalLoan(),
                customer.getYears()
        );

        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getTotalLoan(),
                customer.getInterest(),
                customer.getYears(),
                fixedMonthlyPayment
        );
    }

}

