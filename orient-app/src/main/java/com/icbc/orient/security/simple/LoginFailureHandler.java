package com.icbc.orient.security.simple;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import com.icbc.orient.Bean.ReturnType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        ReturnType rt=new ReturnType();
        rt.setCode("420");
        rt.setMsg("帐号错误");
        rt.setSuccess(false);
        rt.setResult(null);
        String fail=JSON.toJSONString(rt);
        response.getWriter().write(fail);
    }
}
