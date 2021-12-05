package com.olx.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.User;
import com.olx.entity.ExpiredToken;
import com.olx.repository.ExpiredTokensRepo;
import com.olx.repository.UserRepository;
import com.olx.utils.LoginConverterUtil;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ExpiredTokensRepo expiredTokensRepo;

    @Override
    public boolean logout(String authToken) {
    	expiredTokensRepo.save(new ExpiredToken(authToken));
        return true;
    }

    @Override
    public User registerUser(User user) {
        try {
            user.setRole("ROLE_USER");
            return LoginConverterUtil.convertEntityToDto(modelMapper, userRepository.save(LoginConverterUtil.convertDtoToEntity(modelMapper, user)));        	
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public User getUserInfo(String username) {
    	
    	
        return LoginConverterUtil.convertEntityToDto(modelMapper, userRepository.findByUsername(username));
    }

    @Override
    public boolean validateLogin(String authToken) {
        ExpiredToken blacklistedToken = expiredTokensRepo.findByBlacklistedJwt(authToken);
        return blacklistedToken != null;
    }
}