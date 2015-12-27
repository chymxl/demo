package com.demo.controller.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping(value="/helloworld")
	public ModelAndView sayHello(@RequestParam(value="name", defaultValue="world")String name){
		ModelAndView model = new ModelAndView("helloworld");
		model.addObject("ret", "hello " + name);
		return model;
	}
}
