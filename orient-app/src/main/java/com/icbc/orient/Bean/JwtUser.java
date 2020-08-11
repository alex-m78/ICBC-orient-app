package com.icbc.orient.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@ApiModel("用户类实体")
public class JwtUser implements UserDetails {
    private int    id;@ApiModelProperty("自增id")
    private String username;@ApiModelProperty("用户名")
    private String password;@ApiModelProperty("密码")
    private String role;@ApiModelProperty("角色，被存储在authorities类内")
    private String phone;@ApiModelProperty("手机号码")
    private List<SimpleGrantedAuthority> authorities;



//    public JwtUser(String username,String password) {
//        this.username = username;
//        this.password = password;
//    }

//    public JwtUser(String username, String password, String ... roles) {
//        this.username = username;
//        this.password = password;
//        this.authorities= Arrays.stream(roles).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority(this.role));
        return list;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
