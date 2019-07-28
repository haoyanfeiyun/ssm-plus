package com.haohao.controller;

import com.haohao.dao.mapper.TestBeanMapper;
import com.haohao.domain.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestBeanMapper testBeanMapper;

    @Value("${url}")
    private  String url;

    @RequestMapping("stringTest")
    @ResponseBody
    public String returnStr() {
        return "hello,即使是中文也可以";
    }

    @RequestMapping("entityTest")
    @ResponseBody
    public TestBean returnEntify() {
        TestBean testBean = new TestBean();
        testBean.setId(1);
        testBean.setName(2);
        System.out.println(this.url);
        testBeanMapper.insertSelective(testBean);
        return testBean;
    }
}