package chat.service;

import chat.dao.UserRepository;
import chat.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    private final AuthoritiesUser authoritiesUser;
    @Autowired
    public UserDetailsServiceImp(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, AuthoritiesUser authoritiesUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authoritiesUser = authoritiesUser;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        UserBuilder builder = null;
        if(user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.authorities("USER");
            authoritiesUser.addAuthoritiesUsername(username);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

}
