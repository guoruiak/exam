package com.demo.web;  
  
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.demo.entity.User;
import com.demo.manager.IUserManager;
  
@Controller  
@RequestMapping("/user")  
public class UserController {  
  
    @Resource(name="userManager")  
    private IUserManager userManager;  
  
    @RequestMapping("/getAllUser")  
    public String getAllUser(HttpServletRequest request){  
          
        request.setAttribute("userList", userManager.getAllUser());  
          
        return "/index";  
    }  
      
    @RequestMapping("/getUser")  
    public String getUser(String id,HttpServletRequest request){  
          
        request.setAttribute("user", userManager.getUser(id));  
      
        return "/editUser";  
    }  
      
    @RequestMapping("/toAddUser")  
    public String toAddUser(){  
        return "/addUser";  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser(User user,HttpServletRequest request){  
          
        userManager.addUser(user);  
          
        return "redirect:/user/getAllUser";  
    }  
      
    @RequestMapping("/delUser")  
    public void delUser(String id,HttpServletResponse response){  
          
        String result = "{\"result\":\"error\"}";  
          
        if(userManager.delUser(id)){  
            result = "{\"result\":\"success\"}";  
        }  
          
        response.setContentType("application/json");  
          
        try {  
            PrintWriter out = response.getWriter();  
            out.write(result);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    @RequestMapping("/updateUser")  
    public String updateUser(User user,HttpServletRequest request){  
          
        if(userManager.updateUser(user)){  
            user = userManager.getUser(user.getId());  
            request.setAttribute("user", user);  
            return "redirect:/user/getAllUser";  
        }else{  
            return "/error";  
        }  
    }  
    
	@RequestMapping(value = "upload-logo", method = RequestMethod.POST)
	@ResponseBody
	public void uploadLogo(MultipartHttpServletRequest request) {
		try {
			Iterator<String> itr = request.getFileNames();
			MultipartFile file = request.getFile(itr.next());

			//JsonLogo logo = new JsonLogo();
			if (file.getBytes().length > 0) {
				//logo.setImage(new String(Base64.encodeBase64(file.getBytes())));
				System.out.println(new String(Base64.encodeBase64(file.getBytes())));
			}
			//return logo;
		} catch (Exception e) {
			// Handle exception if any
		}
		//return null;
	}
}  