package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.ProductDTO;
import com.Eshop.eshop.Dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<UserDTO> getAllUser();

    UserDTO addUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    UserDTO updateUserById(Long id, Map<String, Object> fields);

    UserDTO deleteUserById(Long id);
}
