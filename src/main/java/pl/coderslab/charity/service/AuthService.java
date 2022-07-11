package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;

public class AuthService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username)
                .map(UserEntity -> new User(
                        UserEntity.getEmail(),
                        UserEntity.getPassword(),
                        List.of(new SimpleGrantedAuthority(UserEntity.getRole()))))
                .orElseThrow(() -> new UsernameNotFoundException("No user with email " + username));
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
