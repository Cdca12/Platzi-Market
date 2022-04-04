package com.platzi.market.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlatziUserDetailsService implements UserDetailsService {

    private static List<User> users;

    public PlatziUserDetailsService() {
         users = new ArrayList<>();
         users.add(new User("cdca", "{noop}platzi", new ArrayList<>()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findAny();
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
        return user.get();
    }

}
