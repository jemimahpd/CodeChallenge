package com.demo.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("FileUploadUtilityhome")
	//@ResponseBody
	public String home(ModelMap model) {
		System.out.println("File upload utility started");
		//model.addAttribute("message", "This utility uploads your file to MySQL server after validation.");
		return "fileupload.jsp";
	}
	
	@RequestMapping("/fileupload")
	public String fileupload(@RequestParam("file") MultipartFile file,ModelMap model) throws IOException {
		System.out.println("File got uploaded and is being processed!");
		List<User> list = new ArrayList<User>();
		if (file.isEmpty()) {
			System.out.println("File is empty");
		}
		else {
			System.out.println("File is not empty");
		}
		System.out.println(file.getOriginalFilename() + " uploaded successfully and size is "+file.getSize()); 
	BufferedReader br;
	String userid="";
	 int coins=0;
	 String username="";
	 int loop=0;
	 boolean status=true;
	 StringBuffer message=new StringBuffer("<B>Status: </B>");
	//List<String> result = new ArrayList<>();
	try {

	     String line;
	     InputStream is = file.getInputStream();
	     br = new BufferedReader(new InputStreamReader(is));
	     while ((line = br.readLine()) != null) {
	    	 String user[];
	    	 
	    	 if(line.contains(",") && StringUtils.countOccurrencesOf(line, ",")==2) {
	    		 loop++;
	    		 user=line.split(",");
	    		 userid=user[0];
	    		 if(String.valueOf(userid).length()==10) {
	    			 Integer.parseInt(userid);//to check if userid is a valid integer
	    			 coins=Integer.parseInt(user[1]);
		    			 if(coins>0) {
		    				 username=user[2].toString();
		    				 System.out.println(userid+ " record successfully validated!");
		    				 
		    				    User u = new User();
		    				    u.setUserid(userid);
		    				    u.setCoins(coins);
		    				    u.setUsername(username);
		    				    list.add(u);
		    				    
		    				    //return "Saved";
		    			 }else {
		    				 message.append("Coin value is not a natural number for user:").append(userid).append(".");
		    				 status=false;
		    				 break;
		    			 }
	    		 }else {
	    			 message.append("Invalid userid in row number:").append(loop).append(" Userid length is not equal to 10.");
	    			 status=false;
	    			 break;
	    		 }
	    	 }else {
	    		 message.append("Insufficient data in row number:").append(loop++).append(".");
	    		 status=false;
	    		 break;
	    	 }
	    	 }
	  } catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
		  message.append("Insufficient Data in rownumber: ").append(loop).append(".");
			 status=false;
		 }catch (IOException e) {
	    System.out.println("Unable to open File: "+e.getMessage());  
	    message.append("Unable to open File");
	    status=false;
	  }
	catch (NumberFormatException e) {
		message.append("UserID/Coins is not a Number for user:").append(userid).append(".");
		 status=false;
	 }
	if(status) {
		System.out.println("File is processed fully and ready to be inserted into DB.");
		 userRepository.saveAll(list);
		 System.out.println("File is uploaded into DB");
		 message.append("File is uploaded into DB");
		}
	else {
		System.out.println("File upload was stopped due to incorrect user details!");
		message.append("File upload was stopped due to incorrect user details!");
	}
		model.addAttribute("message", message);
		return "fileupload.jsp";
	}
}