package com.demo.tempcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemperatureController {

	@RequestMapping("convertTemperature")
	public String home(ModelMap model) {
		System.out.println("This utility converts temperature");
		return "converttemperature.jsp";
	}
	
}
