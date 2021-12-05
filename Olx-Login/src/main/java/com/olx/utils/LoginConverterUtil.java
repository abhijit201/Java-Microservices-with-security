package com.olx.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.olx.dto.User;
import com.olx.entity.UserEntity;

public class LoginConverterUtil {

	public static User convertEntityToDto(ModelMapper modelMapper, UserEntity userEntititList) {
        return modelMapper.map(userEntititList, User.class);
    }

    public static UserEntity convertDtoToEntity(ModelMapper modelMapper, User user) {
        return modelMapper.map(user, UserEntity.class);
    }

    public static List<User> convertEntityToDto(ModelMapper modelMapper, List<UserEntity> userEntititList) {
        return userEntititList
                .stream()
                .map(advertiseEntity -> modelMapper.map(advertiseEntity, User.class))
                .collect(Collectors.toList());
    }

    public static List<UserEntity> convertDtoToEntity(ModelMapper modelMapper, List<User> users) {
        return users
                .stream()
                .map(advertise -> modelMapper.map(advertise, UserEntity.class))
                .collect(Collectors.toList());
    }
    
}
