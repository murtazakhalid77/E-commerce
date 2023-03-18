package com.Eshop.eshop.CustomValidation;

import com.Eshop.eshop.domain.User;
import com.Eshop.eshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName,String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        User user = userRepository.findByName(userName);
        if(user != null){
            return false;
        }
        return true;


    }
}
