package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.CustomerDTO;
import com.Eshop.eshop.Exception.RecordAlreadyExistException;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.ICustomerService;
import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.domain.Customer;
import com.Eshop.eshop.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements ICustomerService {
    ModelMapper modelMapper;
    CustomerRepository customerRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return this.customerRepository.findAllByIsActive(true).stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer dublicateCustomer = customerRepository.findByemail(customerDTO.getEmail());
        if (dublicateCustomer!=null){
            if (!dublicateCustomer.getIsActive()){
                dublicateCustomer.setIsActive(true);
                return toDto(customerRepository.save(dublicateCustomer));
            }
            throw new RecordAlreadyExistException(String.format("Customer   Record Already Exist =>%s",customerDTO));
        }
        customerDTO.setIsActive(true);
        return toDto(customerRepository.save(toDomain(customerDTO)));

    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> coupon = customerRepository.findById(id);
        if (coupon.isPresent()){
            return toDto(coupon.get());
        }

        throw new RecordNotFoundException(String.format("Customer Not Found On this Id => %d",id));
    }

    @Override
    public CustomerDTO updateCustomerById(Long id, Map<String, Object> fields) {
        Customer customer = customerRepository.findById(id).get();
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Coupon.class,key);

            field.setAccessible(Boolean.TRUE);
            ReflectionUtils.setField(field,customer,value);
        });
        return toDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDTO deleteCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            customer.get().setIsActive(false);
            return toDto(customerRepository.save(customer.get()));
        }
        throw new RecordNotFoundException(String.format("Customer Not Found On this Id => %d",id));

    }
    public Customer toDomain(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,Customer.class);
    }
    public  CustomerDTO toDto(Customer customer){
        return modelMapper.map(customer,CustomerDTO.class);
    }


}
