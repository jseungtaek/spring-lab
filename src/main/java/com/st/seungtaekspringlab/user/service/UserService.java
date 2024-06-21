package com.st.seungtaekspringlab.user.service;

import com.st.seungtaekspringlab.user.dto.SignInDto;
import com.st.seungtaekspringlab.user.dto.SignUpDto;
import com.st.seungtaekspringlab.user.entity.User;
import com.st.seungtaekspringlab.user.enums.ErrorType;
import com.st.seungtaekspringlab.user.exception.UserCustomException;
import com.st.seungtaekspringlab.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Boolean signUp(SignUpDto signUpDto) {
        Optional<User> findUser = userRepository.findByEmail(signUpDto.getEmail());
        if (findUser.isPresent())
            throw new UserCustomException(ErrorType.USER_DUPLICATE);
        else {
            User registerUser = new User(signUpDto.getEmail(), signUpDto.getName(), passwordEncoder.encode(signUpDto.getPassword()));
            userRepository.save(registerUser);
            return userRepository.findByEmail(registerUser.getEmail()).isPresent();
        }
    }

    public Boolean signIn(SignInDto signInDto) {
        User findUser = userRepository.findByEmail(signInDto.getEmail()).orElseThrow(() -> new UserCustomException(ErrorType.USER_NOT_FOUND));
        if (!passwordEncoder.matches(signInDto.getPassword(), findUser.getPassword())) {
            throw new UserCustomException(ErrorType.PASSWORD_INVALID);
        } else {
            return true;
        }
    }
}
