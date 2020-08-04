package com.icbc.orient.security.simple;

import com.icbc.orient.Service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/** 配置路径访问限制,若你的用户角色比较简单,不需要存数据库,
 * 可以在ApplicationConfigurerAdapter里配置如
 *    httpSecurity
 *    .authorizeRequests()
 *    .antMatchers("/order").....
 */
@Component("accessDecisionService")
public class AccessDecisionService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication auth) {

        //不需要登录也能访问的(permitAll)
        for (String url : Arrays.asList("/stockHolds","/test","/industries","/car","/stockInfos",
                "/stockHoldings","/targetCompared","/modelResults","/fiveStockInfo",
                "/register","/seasonShare","/feedBack",
                "/consumerTest","/producerTest",
                //swagger部分不需要登录，下面不需要动
                "/swagger-ui.html","/v2/**","/swagger-resources/**","/webjars/**")) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }

        if (auth instanceof AnonymousAuthenticationToken) {
            return false;
        }

        UserDetails user = (UserDetails) auth.getPrincipal();
        String username = user.getUsername();
        Iterator it = auth.getAuthorities().iterator();
        Object role= it.next();
        String result=role.toString();
        //根据用户名查出能访问哪些url, urls=findUrlByUserName()
        List<String> urls = queryUrlByUserRole(result);
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 模拟数据库查询用户权限
     *
     * @param role
     * @return
     */
    private List<String> queryUrlByUserRole(String role) {

        switch (role) {
            case "admin":
                return Arrays.asList("/UserDelete","/UserInfo","/UserRole");
            case "user":
                return Arrays.asList("/innerMsg");
            default:
                return new ArrayList<>();
        }
    }
}
