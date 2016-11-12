package com.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.FileModel;
import com.demo.model.LoginLog;
import com.demo.model.User;
import com.demo.service.FileService;
import com.demo.service.LoginLogService;
import com.demo.service.UserService;
import com.demo.util.DateAndStringUtil;
 
@Controller
public class UserController {
 
	@Autowired
	private UserService userService;

	@Autowired
	private FileService fileService;
	
	@Autowired
	private LoginLogService loginLogService;
    
   /**
    * 先判断是否有用户，有就把该值摄入session，没有就直接返回
    * @param content
    * @return
    */
    @RequestMapping(value="/blog/login")
    public ModelAndView login(User user,HttpSession session,int fileId){
    	
    	ModelAndView mav=new ModelAndView();
    	System.out.println("========login========"+user.toString()+"====="+fileId);
    	int resultCode=0;
    	User cofingUser=userService.loginUser(user);
    	if(cofingUser!=null&&!cofingUser.equals("")){
    		
    	   //日志保存
    	   LoginLog loginLog=new LoginLog();
    	   loginLog.setIp("425.21.03.03");
    	   loginLog.setUserId(cofingUser.getId());
    	   loginLog.setUserIdIsAdmin(0);
    	   loginLog.setDate(DateAndStringUtil.date2String(new Date()));
    	   loginLogService.insertLoginLog(loginLog);
    	   
    	   session.setAttribute("user", cofingUser);
    	   resultCode=200;
    	}
    	FileModel filemodel=fileService.queryFileOne(fileId);
    	mav.addObject("resultCode", resultCode);
    	mav.addObject("fileModel", filemodel);
        mav.setViewName("/blog/oneFile");
        return mav;
    }
    
    /**
     * 退出
     * @param name
     * @return
     */
    @RequestMapping(value="/blog/unlogin")
    public ModelAndView unLogin(User user,HttpSession session,int fileId){
    	//session.removeAttribute("user");
    	session.removeAttribute("user");
    	ModelAndView mav=new ModelAndView();
    	FileModel filemodel=fileService.queryFileOne(fileId);
    	mav.addObject("fileModel", filemodel);
        mav.setViewName("/blog/oneFile");
        return mav;
    }
    
    /**
     * 耦合度低换
     * @param user
     * @param fileId
     * @return
     */
    @RequestMapping(value="/blog/register")
    public ModelAndView requestRegister(User user,int fileId,HttpSession session){
    	System.out.println("============requestRegister============"+user.toString()+fileId);
    	userService.insertUser(user);
    	session.setAttribute("user", user);
    	ModelAndView mav=new ModelAndView();
    	FileModel filemodel=fileService.queryFileOne(fileId);
    	mav.addObject("fileModel", filemodel);
        mav.setViewName("/blog/oneFile");
        return mav;
    }
    
    /**
     * 用户管理
     * @param user
     * @param fileId
     * @return
     */
    @RequestMapping(value="/Admin/manage-user")
    public ModelAndView requestUserManager(){
    	List<User> userList=userService.queryUserList();
    	System.out.println("===============requestUserManager================"+userList.size());
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("userList", userList);
        mav.setViewName("/Admin/manage-user");
        return mav;
    }
    
    /**
     * 万不等以删除用户
     * @param user
     * @param fileId
     * @return
     */
    @RequestMapping(value="/Admin/delteUser")
    public ModelAndView requestDeleteUser(int id){
    	userService.deleteUser(id);
        return requestUserManager();
    }

}