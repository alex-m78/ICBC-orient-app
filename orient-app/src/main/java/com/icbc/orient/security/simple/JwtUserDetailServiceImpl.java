package com.icbc.orient.security.simple;

import com.icbc.orient.Bean.JwtUser;
import com.icbc.orient.Mapper.UserMapper;
import com.icbc.orient.Service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class JwtUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    private JwtUserService userSer;


    @Autowired
    public JwtUserDetailServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /** 模拟数据库查询
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser jwtUser=userSer.loadUserByUsername(username);

        jwtUser.setPassword(passwordEncoder.encode(jwtUser.getPassword()));
        if (jwtUser== null) {
            throw new UsernameNotFoundException("user not existed");
        }

        return jwtUser;
    }

    
}
