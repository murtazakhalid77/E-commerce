package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CustomerDTO;
import com.Eshop.eshop.Service.ICustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class CustomerController {
     ICustomerService customerService;

    public CustomerController(ICustomerService ICustomerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @PostMapping("/customer")
    ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO){
        return  ResponseEntity.ok(customerService.addCustomer(customerDTO));
    }
    @GetMapping("/customer/{id}")
    ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return  ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PatchMapping("/customer/{id}")
    ResponseEntity<CustomerDTO> updateCustomerbyId(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return  ResponseEntity.ok(customerService.updateCustomerById(id,fields));
    }
    @PutMapping("/customer/{id}")
    ResponseEntity<CustomerDTO> deleteCustomerById(@PathVariable Long id){
        return  ResponseEntity.ok(customerService.deleteCustomerById(id));
    }

}
