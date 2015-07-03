package com.demo.webservice;  
  
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.User;
import com.demo.manager.IUserManager;
  
@Controller  
@RequestMapping("/user")  
public class UserWebService {  
  
	@Resource(name="userManager") 
    private IUserManager userManager;  
    public void setIUserManager(IUserManager userManager) {  
        this.userManager = userManager;  
    }  
    
    @RequestMapping("/getAll")  
    public User[] getAll() {
    	User[] arr = null;
		List<User> list = userManager.getAllUser();
		if (!list.isEmpty()) {
			arr = new User[list.size()];
			for (int i = 0; i < list.size(); i++) {
				arr[i] = list.get(i);
			}
		}
		return arr;
	}
}  