package com.nckh.UserSercvice.security;

import com.nckh.UserSercvice.repository.AuthenRepository;
import com.nckh.UserSercvice.repository.RoleRepository;
import com.nckh.UserSercvice.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserDetailService implements UserDetailsService {


    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final AuthenRepository authenRepository;



    public JwtUserDetailService(UserRepository userRepository, RoleRepository roleRepository, AuthenRepository authenRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authenRepository = authenRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.nckh.UserSercvice.model.User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found user with email: " + username);
        }
        if (!user.isVerified()) {
            throw new UsernameNotFoundException("User is not active");
        }

        return new User(user.getEmail(), user.getAuthenRecords().g);
    }
}
