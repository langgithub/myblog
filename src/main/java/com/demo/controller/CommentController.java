package com.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Comment;
import com.demo.model.User;
import com.demo.service.CommentService;
import com.demo.util.DateAndStringUtil;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/Admin/comment")
	public ModelAndView requestCommentList(){
		System.out.println("=================requestCommentList============");
		List<Comment> commentList=commentService.queryList();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/Admin/comment");
		mav.addObject("commentList", commentList);
		return mav;
	}
	
	/**
	 * 删除一条评论
	 * @return
	 */
	@RequestMapping(value="/Admin/delete_comment")
	public ModelAndView requestdeleteCommentById(int id){
		System.out.println("=================requestdeleteCommentById============"+id);
		commentService.deleteCommentById(id);
		return requestCommentList();
	}
	/**
	 * 在session中查询，有就保存，没有就叫用户登录
	 * @param content
	 * @return
	 */
    @ResponseBody
    @RequestMapping(value="/blog/pinglun",method=RequestMethod.POST)
    public Map<String, String> pingLun(Comment comment,HttpSession session){
    	Map<String, String> map=new HashMap<String, String>();
    	System.out.println("============/blog/pinglun============="+comment.toString());
    	User user=(User) session.getAttribute("user");
    	if(user==null||user.equals(" ")){
    		map.put("code", "000");
    	}else{
    		String date=DateAndStringUtil.date2String(new Date());
    		comment.setDate(date);
    		comment.setUserId(0);
    		commentService.insertComment(comment);

    		map.put("code", "200");
    		map.put("name", user.getName());
    		map.put("comment", comment.getComment());
    		map.put("date", date);
    	}
    	
        return map;
    }
}
