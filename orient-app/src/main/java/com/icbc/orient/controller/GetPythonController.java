package com.icbc.orient.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hkd
 * @date 2020/7/21 - 21:52
 */
@RestController
public class GetPythonController {
    @Autowired
    RestTemplate restTemplate;
    @ApiOperation("调用python的接口")
    @GetMapping("/python")
    public Object hello(){
        String url = "http://47.103.137.116:20880/hello";
        Map<String,Object> map = new HashMap<String,Object>();
        String string = restTemplate.getForObject(url, String.class, map);
        return JSONObject.parseObject(string);
    }
}
