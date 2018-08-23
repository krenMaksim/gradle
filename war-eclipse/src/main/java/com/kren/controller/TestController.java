package com.kren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TestController {

    // @GetMapping()
    // public String test() {
    // System.out.println(testBean);
    // return "test";
    // }
    // http://localhost:8080/simple-spring-mvc/var/1?myParam=myValue&id=1
    @GetMapping(path = "var/{variable}", params = "myParam=myValue")
    public String testVariable(@PathVariable String variable, @RequestParam String myParam, @RequestParam int id) {
	System.out.println(variable);
	System.out.println(myParam);
	System.out.println(id);
	return "test";
    }

    // на постмане обязательно x-www-form-urlencoded
    @PostMapping(path = "/post")
    public String testRequestBody(@RequestParam String test, @RequestParam String myParam) {
	System.out.println(myParam);
	System.out.println(test);
	return "test";
    }

    @PostMapping(path = "/body")
    public String testRequestBody(@ModelAttribute TestBean test) {
	System.out.println(test);
	return "test";
    }

    @PostMapping(path = "/atrr")
    public String testRequestAtrr(@RequestAttribute String test) {
	System.out.println(test);
	return "test";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
	model.addAttribute("msg", "Welcome to My Country");
    }
}

class TestBean {
    private String myParam;
    private String test;

    public String getMyParam() {
	return myParam;
    }

    public void setMyParam(String myParam) {
	this.myParam = myParam;
    }

    public String getTest() {
	return test;
    }

    public void setTest(String test) {
	this.test = test;
    }

    @Override
    public String toString() {
	return "TestBean [myParam=" + myParam + ", test=" + test + "]";
    }
}
