package com.customer.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Thic controller class takes care of the incoming request URLs and provides response body
@Controller
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	ContactInfoRepository contactInfoRepo;

	//This is the first url of customer support application
	@RequestMapping("customer")
	public String customerhome(ModelMap model) {
		model.addAttribute("tableViewStyle", "visibility:hidden");
		return "customersupport.jsp";
	}

	//Fetches all Customers phone number
	@RequestMapping("allcustomerphones")
	public String fetchallCustomerphones(ModelMap model) {
		model.addAttribute("tableViewStyle", "visibility:show");
		List<CustomerPhone> customerList = customerRepo.findAllCustomerPhoneNos();
		System.out.println(customerList);
		model.addAttribute("CustomerList", customerList);
		return "customersupport.jsp";
	}

	//Takes customer id as parameter and fetches individual customers phone number
	@RequestMapping("customerphone")
	public String fetchCustomerphone(@RequestParam("custValue") String custid, ModelMap model) {
		model.addAttribute("tableViewStyle", "visibility:show");
		List<CustomerPhone> customerList = customerRepo.findCustomerPhoneNo(custid);
		System.out.println(customerList);
		model.addAttribute("CustomerList", customerList);
		return "customersupport.jsp";
	}

	//Takes customer id and phone number as parameter and activates phone number
	@RequestMapping("/customer/phone/activate/{cust_id}/{ph_no}")
	public String getCustomerContact(@PathVariable("cust_id") String custid, @PathVariable("ph_no") String phone,
			ModelMap model) {
		if (custid != null && !custid.isEmpty()) {
			if (phone != null && !phone.isEmpty()) {
				int status = contactInfoRepo.activatePhoneNo(phone, custid);
				System.out.println(status);
			}
		} else {
			System.out.println("Error! Invalid Custid");
		}
		model.addAttribute("Message", "Successfully activated the phone number");
		return "customersupport.jsp";
	}

}
