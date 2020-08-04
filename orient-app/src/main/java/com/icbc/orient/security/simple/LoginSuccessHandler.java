package com.icbc.orient.security.simple;

import com.alibaba.fastjson.JSON;
import com.icbc.orient.Bean.JwtUser;
import com.icbc.orient.Bean.ReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**登录成功
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private RsaSigner signer;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        String userJsonStr = JSON.toJSONString(authentication.getPrincipal());
        String username=authentication.getName();
        String token = JwtHelper.encode(userJsonStr, signer).getEncoded();
        //JwtUser role=userDetailsService.loadUserByUsername(username)
        ReturnType rt=new ReturnType();
        rt.setCode("200");
        rt.setMsg("登录成功");
        rt.setSuccess(true);
        Iterator it = authentication.getAuthorities().iterator();
        Object role= it.next();
        String result=role.toString();
        rt.setResult(result);
        //rt.setResult(authentication.getAuthorities());
        String success=JSON.toJSONString(rt);
        response.setHeader("Access-Control-Expose-Headers","Token");
        response.setHeader("Token", token);
        response.getWriter().write(success);
    }

    public void setSigner(RsaSigner signer) {
        this.signer = signer;
    }
}
