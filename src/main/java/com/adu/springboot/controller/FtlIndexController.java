package com.adu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FtlIndexController {

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(int i) {
        int j = 1 / i;
        return j+"success";
    }

    @RequestMapping("/getMember")
    @ResponseBody
    public String getMember(String name,Integer age) {
        return name;
    }

    @RequestMapping("/index")
    @ResponseBody
    public Map<String,String> index() {
        Map<String,String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","1");
        return map;
    }

    @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String,String> map) {

        map.put("name","zhangsan");
        map.put("age","1");
        return "ftlIndex";
    }
}
