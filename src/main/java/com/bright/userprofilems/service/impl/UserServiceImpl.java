package com.bright.userprofilems.service.impl;

import com.bright.userprofilems.dto.request.UserRequestDto;
import com.bright.userprofilems.dto.response.UserResponseDto;
import com.bright.userprofilems.exception.user.DuplicateUserException;
import com.bright.userprofilems.mapper.UserMapper;
import com.bright.userprofilems.model.User;
import com.bright.userprofilems.repository.UserRepository;
import com.bright.userprofilems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        //Check whether user is existing or not
        Optional<User> optionalUser = userRepository.findByUsername(userRequestDto.username());
        if (optionalUser.isPresent()) {
            throw new DuplicateUserException("Username already exists");
        }
        System.out.println("dto: " + userRequestDto);
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        User savedUser = userRepository.save(user);
        System.out.println("saved user: " + userMapper.userToUserResponseDto(savedUser));
        return userMapper.userToUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(String username, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public void deleteUserByUsername(String username) {

    }

    @Override
    public UserResponseDto findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return List.of();
    }
}
