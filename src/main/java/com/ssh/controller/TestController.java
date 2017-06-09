package com.ssh.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.entity.PersonTest;
import com.ssh.model.PageBean;
import com.ssh.service.TestService;

@Controller
public class TestController {


    @Autowired
    private TestService baseService;


    @RequestMapping(value = "springtest", method = RequestMethod.GET)
    public String springtest() {
        System.out.println("ok");
        // 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "NewFile";
    }

    @RequestMapping(value = "testBaseAdd", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseAdd() {
        PersonTest person = new PersonTest();
        System.out.println(person.toString());
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        System.out.println(person.toString());
        boolean b = baseService.addEntity(person);
        System.out.println(person.toString());
        return b + "</br>"+person.toString();
    }

    @RequestMapping(value = "testBaseGetById", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseGetById() {
        PersonTest per = baseService.getById(PersonTest.class, 1L);
        System.out.println(per.toString());
        return per.toString();
    }

    @RequestMapping(value = "testBaseDelete", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseDelete() {
        PersonTest person = new PersonTest();
        person.setId(1L);
        boolean b = baseService.removeEntity(person);
        return b + "";
    }

    @RequestMapping(value = "testBaseUpdate", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseUpdate() {
        PersonTest person = new PersonTest();
        person.setId(5L);
        Date d = new Date();
        person.setRemark(d.toString());
        baseService.updateEntity(person);
        return baseService.updateEntity(person) + "";
    }

    @RequestMapping(value = "testBaseQuerySql", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseQuerySql() {
        List<Map<String, Object>> result = baseService.queryBySql(null, null);
        for (Map<String, Object> person : result) {
            System.out.println(person.toString());
        }
        return result.toString();
    }

    @RequestMapping(value = "testBaseQuerySql2", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseQuerySql2() {
        List<PersonTest> result = baseService.queryBySql(null, null, PersonTest.class);
        for (PersonTest person : result) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
    
    @RequestMapping(value = "testBaseQuerySql3", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseQuerySql3() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", "2");
        param.put("username", "2");
        List<Map<String, Object>> result = baseService.queryBySqlId("test.getPerson", param);
        for (Map<String, Object> person : result) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
    
    @RequestMapping(value = "testBaseQuerySql4", method = RequestMethod.GET)
    @ResponseBody
    public String testBaseQuerySql4() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", "2");
        param.put("username", "1");
        List<PersonTest> result = baseService.queryBySqlId("test.getPerson", param, PersonTest.class);
        for (PersonTest person : result) {
            System.out.println(person.toString());
        }
        return result.toString();
    }

    @RequestMapping(value = "testBasePage", method = RequestMethod.GET)
    @ResponseBody
    public String testBasePage() {
        PageBean<PersonTest> result = baseService.queryPageBySql(null, null, 0, 0, PersonTest.class);
        for (PersonTest person : result.getResults()) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
    
    @RequestMapping(value = "testBasePage2", method = RequestMethod.GET)
    @ResponseBody
    public String testBasePage2() {
        PageBean<Map<String, Object>> result = baseService.queryPageBySql(null, null, 0, 0);
        for (Map<String, Object> person : result.getResults()) {
            System.out.println(person.toString());
        }
        return result.toString();
    }
}
