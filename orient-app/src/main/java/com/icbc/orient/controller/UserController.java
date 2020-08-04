package com.icbc.orient.controller;

import com.alibaba.fastjson.JSONObject;
import com.icbc.orient.Bean.Industry;
import com.icbc.orient.Bean.JwtUser;
import com.icbc.orient.Bean.ReturnType;
import com.icbc.orient.Service.JwtUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private JwtUserService jwtUserService;

    public UserController(){}

    @ApiOperation("注册接口")
    @GetMapping("/register")
    public ReturnType Register(HttpServletRequest request) throws Exception{
        ReturnType rt = new ReturnType();
        try {
            String phone=request.getParameter("phone");
            String username=request.getParameter("username");
            String password=request.getParameter("password");

            Integer integer=jwtUserService.addUser(username,password,phone);
            rt.setCode("200");
            rt.setMsg("成功");
            rt.setSuccess(true);
            rt.setResult(integer);
        }catch (Exception e) {
               rt.setCode("422");
               rt.setMsg("手机号已注册");
               rt.setSuccess(false);
               rt.setResult(null);
        }
        return rt;
    }

    @ApiOperation("删除用户")
    @GetMapping("/UserDelete")
    public ReturnType UserDelete(HttpServletRequest request) throws Exception{
        ReturnType rt = new ReturnType();

            String username=request.getParameter("username");
            boolean deleteUser=jwtUserService.DeleteUser(username);
            if(deleteUser){
            rt.setCode("200");
            rt.setMsg("成功");
            rt.setSuccess(deleteUser);
            rt.setResult(null);}
            else
            {
                rt.setCode("500");
                rt.setMsg("不存在此用户");
                rt.setSuccess(deleteUser);
                rt.setResult(null);
            }

        return rt;
    }

    @ApiOperation("修改用户权限")
    @GetMapping("/UserRole")
    public ReturnType UserRole(HttpServletRequest request) throws Exception{
        ReturnType rt = new ReturnType();
            String username=request.getParameter("username");
            String role=request.getParameter("role");
            boolean editUserRole=jwtUserService.editUserRole(username,role);
            if(editUserRole){
            rt.setCode("200");
            rt.setMsg("成功");
            rt.setSuccess(editUserRole);
            rt.setResult(null);
        }else{
            rt.setCode("400");
            rt.setMsg("修改失败");
            rt.setSuccess(editUserRole);
            rt.setResult(null);
        }
        return rt;
    }

    @ApiOperation("展示所有用户信息")
    @GetMapping("/UserInfo")
    public ReturnType UserInfo() throws Exception{
        ReturnType rt = new ReturnType();
        try {

            List<JwtUser> userList=jwtUserService.loadAllUser();
            rt.setCode("200");
            rt.setMsg("成功");
            rt.setSuccess(true);
            rt.setResult(userList);
        }catch (Exception e) {
            rt.setCode("400");
            rt.setMsg("查询失败");
            rt.setSuccess(false);
            rt.setResult(null);
        }
        return rt;
    }
}
