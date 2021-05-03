package com.example.challenge_alkemy.security;

import com.example.challenge_alkemy.model.Users;
import com.example.challenge_alkemy.repositories.usersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    private usersRepository usuariosRepositorio;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users usu = usuariosRepositorio.findByUsername(username);
        /*UserBuilder builder = null;
        if(usu != null){
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(usu.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }*/
        if(usu == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new MyUserDetails(usu);
    }
    
}
