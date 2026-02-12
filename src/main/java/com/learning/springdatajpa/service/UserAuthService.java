package com.learning.springdatajpa.service;

import com.learning.springdatajpa.repository.UserAuthRepository;
import com.learning.springdatajpa.security.UserAuthEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAuthService implements UserDetailsService {
    private UserAuthRepository userAuthRepository;
    private PasswordEncoder passwordEncoder;
    public void save(UserAuthEntity userAuth){
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        userAuthRepository.save(userAuth);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userAuthRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
