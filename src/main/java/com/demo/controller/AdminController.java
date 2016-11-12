package com.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Admin;
import com.demo.model.LoginLog;
import com.demo.model.User;
import com.demo.service.AdminService;
import com.demo.service.LoginLogService;
import com.demo.util.DateAndStringUtil;

@Controller
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LoginLogService loginLogService;
    
    /**
     * zhu页面
     * @param user
     * @param fileId
     * @return
     */
    @RequestMapping(value="/Admin/main")
    public ModelAndView requestAdminMain(){
    	ModelAndView mav=new ModelAndView();
        mav.setViewName("/Admin/main");
        return mav;
    }
    /**
     * index页面
     * @return
     */
    @RequestMapping(value="/index")
    public ModelAndView requestAdminIndex(){
    	ModelAndView mav=new ModelAndView();
        mav.setViewName("/index");
        return mav;
    }
    
    
    /**
     * 管理员登录
     * 如果匹配就调到main.jsp,如果不匹配就返回
     * @param user
     * @param fileId
     * @return
     */
    @RequestMapping(value="/Admin/login")
    public ModelAndView requestAdminLogin(Admin admin,HttpSession session){
    	ModelAndView mav=new ModelAndView();
    	Admin configAdmin=adminService.checkAdmin(admin);
    	if(configAdmin!=null&&!configAdmin.equals("")){
    		
    		LoginLog loginLog=new LoginLog();
    		loginLog.setIp("425.21.03.03");
    		loginLog.setUserId(configAdmin.getId());
    		System.out.println("=========管理员=========="+configAdmin.getId());
    		loginLog.setUserIdIsAdmin(1);
    		loginLog.setDate(DateAndStringUtil.date2String(new Date()));
    		loginLogService.insertLoginLog(loginLog);
    		//給session设值
    		session.setAttribute("admin", configAdmin);
    		//跳转视图
    		mav.setViewName("/Admin/main");
    	}else{
    		mav.addObject("msg", "000");
    		mav.setViewName("/index");
    	}
        return mav;
   }
    
    /**
     * 管理员修改密码
     *
     * @return
     */
    @RequestMapping(value="/Admin/updateAdmin")
    public ModelAndView requestUpdateAdmin(Admin admin,HttpSession session,String old_password){
    	
    	String oldPwd=adminService.getPwd(admin.getId());
    	String msg="";
    	if(old_password.equals(oldPwd)){
    		//跟新
    		int count=adminService.updateAdmin(admin);
    		if(count!=1){
    			msg="100";//操作失败
    		}else{
    			msg="200";
    			session.setAttribute("admin", admin);
    		}
    	}else{
    		msg="300";//密码不匹配
    	}
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("msg", msg);
    	mav.setViewName("/Admin/main");
        return mav;
   }
    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping(value="/Admin/unLogin")
    public String requestUnloginAdmin(HttpSession session){
    	session.removeAttribute("admin");
        return "redirect:/index.jsp";
   }
}
