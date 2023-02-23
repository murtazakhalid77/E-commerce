package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.ProductDTO;
import com.Eshop.eshop.Dto.UserDTO;
import com.Eshop.eshop.Exception.RecordAlreadyExistException;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.IUserService;
import com.Eshop.eshop.domain.Model;
import com.Eshop.eshop.domain.Product;
import com.Eshop.eshop.domain.User;
import com.Eshop.eshop.repositories.ProductRepository;
import com.Eshop.eshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements IUserService {
    UserRepository userRepository;
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAllByisActive(true).stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User dublicateUser =userRepository.findUserByEmailAndPhoneNumber(userDTO.getEmail(),userDTO.getPhoneNumber());
        if (dublicateUser!=null){
            if (!dublicateUser.getIsActive()){
                dublicateUser.setIsActive(true);
                return toDto(dublicateUser);
            }
            throw new RecordAlreadyExistException(String.format("User Already exist by this name and model %s",dublicateUser));
        }
        userDTO.setIsActive(true);
        return toDto(userRepository.save(toDomain(userDTO)));
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return toDto(user.get());
        }

        throw new RecordNotFoundException(String.format("User Not Found On this Id => %d",id));
    }


    @Override
    public UserDTO updateUserById(Long id, Map<String, Object> fields) {
        User user = userRepository.findById(id).get();
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Model.class,key);

            field.setAccessible(Boolean.TRUE);
            ReflectionUtils.setField(field,user,value);
        });
        return toDto(userRepository.save(user));
    }

    @Override
    public UserDTO deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            user.get().setIsActive(false);
            return toDto(userRepository.save(user.get()));
        }
        throw new RecordNotFoundException(String.format("User Not Found On this Id => %d",id));

    }
    public User toDomain(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
    public  UserDTO toDto(User user){
        return modelMapper.map(user,UserDTO.class);
    }
}
