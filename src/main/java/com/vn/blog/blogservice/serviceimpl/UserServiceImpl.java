package com.vn.blog.blogservice.serviceimpl;


import com.vn.blog.blogservice.converter.DtoConvertUtils;
import com.vn.blog.blogservice.dto.User;
import com.vn.blog.blogservice.exceptions.UserNotFoundException;
import com.vn.blog.blogservice.repository.UserRepo;
import com.vn.blog.blogservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepo userRepo;

    @Override
    public User getUserById(Long id) {
        if(id == null){
            throw new UserNotFoundException("User Id not valid Please Try Again");
        }
        return DtoConvertUtils.convertUserEntityToDTO(userRepo.findById(id).get());
    }
}
