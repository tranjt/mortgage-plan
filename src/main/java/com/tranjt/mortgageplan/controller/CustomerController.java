package com.tranjt.mortgageplan.controller;

import com.tranjt.mortgageplan.dto.CustomerRequestDTO;
import com.tranjt.mortgageplan.dto.CustomerResponseDTO;
import com.tranjt.mortgageplan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        List<CustomerResponseDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerResponseDTO> addCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        CustomerResponseDTO newCustomer = customerService.addCustomer(customerRequestDTO);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable("id") Long id,
            @Valid @RequestBody CustomerRequestDTO customerRequestDTO
    ) {
        CustomerResponseDTO updatedCustomer = customerService.updateCustomer(customerRequestDTO, id);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
