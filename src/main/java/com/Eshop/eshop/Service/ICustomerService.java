package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<CustomerDTO> getAllCustomer();

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO updateCustomerById(Long id, Map<String, Object> fields);

    CustomerDTO deleteCustomerById(Long id);
}
