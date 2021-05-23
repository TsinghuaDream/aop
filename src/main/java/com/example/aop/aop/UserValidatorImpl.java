package com.example.aop.aop;

import org.springframework.stereotype.Service;

@Service
public class UserValidatorImpl implements UserValidator{
    @Override
    public boolean validate(User user) {
        System.out.println("引入新接口" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
