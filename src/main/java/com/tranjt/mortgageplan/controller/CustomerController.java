package com.tranjt.mortgageplan.controller;

import com.tranjt.mortgageplan.dto.CustomerRequestDTO;
import com.tranjt.mortgageplan.dto.CustomerResponseDTO;
import com.tranjt.mortgageplan.dto.LoanCalcResponseDTO;
import com.tranjt.mortgageplan.service.CustomerService;
import com.tranjt.mortgageplan.service.LoanCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/mortgage-plan")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LoanCalculatorService loanCalculatorService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        List<CustomerResponseDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseDTO> addCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        CustomerResponseDTO newCustomer = customerService.addCustomer(customerRequestDTO);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable("id") Long id,
            @Valid @RequestBody CustomerRequestDTO customerRequestDTO
    ) {
        CustomerResponseDTO updatedCustomer = customerService.updateCustomer(customerRequestDTO, id);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/calculate-loan")
    public ResponseEntity<LoanCalcResponseDTO> getLoanCalculation(
            @RequestParam @Min(0) double totalLoan,
            @RequestParam @Min(0) double interest,
            @RequestParam @Min(0) int years) {

        LoanCalcResponseDTO loanCalc = loanCalculatorService.getLoanCalculation(totalLoan, interest, years);
        return new ResponseEntity<>(loanCalc, HttpStatus.OK);
    }

}
