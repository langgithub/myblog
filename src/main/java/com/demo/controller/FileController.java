package com.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Category;
import com.demo.model.Comment;
import com.demo.model.FileModel;
import com.demo.model.Ftp;
import com.demo.model.PageSearch;
import com.demo.service.CategoryService;
import com.demo.service.CommentService;
import com.demo.service.FileService;
import com.demo.util.DateAndStringUtil;
import com.demo.util.FtpUtil;
import com.demo.util.UeditorConfigJson;

@Controller
public class FileController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * 罗列出文章信息
	 * @return
	 */
	@RequestMapping(value="/Admin/article")
	public ModelAndView requestFileList(){
		List<FileModel> fileModelList=fileService.queryFileList();
		ModelAndView mav=new ModelAndView();
		mav.addObject("fileModelList", fileModelList);
		mav.setViewName("/Admin/article");
		return mav;
	}
	
	/**
	 * 默认分页查询
	 * @return
	 */
	@RequestMapping(value="/blog/index")
	public ModelAndView requestFileList3(){
		System.out.println("=========requestFileList3============");
		List<FileModel> fileModelList=null;
		int count=fileService.totalRow();
		System.out.println("===================="+count);
		PageSearch pageSearch=null;
		//currentPage=0,默认查询前五条
		pageSearch=new PageSearch(1,count);
		fileModelList=fileService.queryFileListPage(pageSearch);
		System.out.println("------------------"+fileModelList.size());
		ModelAndView mav=new ModelAndView();
		mav.addObject("fileModelList", fileModelList);
		mav.addObject("currentPage", 1);
		mav.addObject("maxpage", pageSearch.getPages());
		mav.setViewName("/blog/index");
		return mav;
	}
	
	
	/**
	 * 开启分页查询，一次查询5片，传入页码
	 * 比如查询第6页 select * from table order by id limit (page-1)*5 5;
	 * page =1 不显示上一页，假如总数count%5=语数，如果余数不等于0，page=page+1 
	 * @return
	 */
	@RequestMapping(value="/blog/getpage")
	public ModelAndView getPages(int wantpage){
		
		List<FileModel> fileModelList=null;
		int count=fileService.totalRow();
		System.out.println("===================="+count);
		PageSearch pageSearch=null;
		//currentPage=0,默认查询前五条
		pageSearch=new PageSearch(wantpage,count);
		fileModelList=fileService.queryFileListPage(pageSearch);
		System.out.println("------------------"+fileModelList.size());
		ModelAndView mav=new ModelAndView();
		mav.addObject("fileModelList", fileModelList);
		mav.addObject("currentPage", wantpage);
		mav.addObject("maxpage", pageSearch.getPages());
		mav.setViewName("/blog/index");
		return mav;
	}
	/**
	 * 查询一篇文章
	 * 
	 * @return
	 */
	@RequestMapping(value="/blog/oneFile")
	public ModelAndView requestOneFile(int id){
		ModelAndView mav=new ModelAndView();
		int totalComment=0;
		System.out.println("=========requestOneFile============"+id);
		FileModel fileModel=fileService.queryFileOne(id);
		List<Comment> commentList=commentService.queryListByFileId(id);
		totalComment=commentList.size();
		mav.addObject("totalComment", totalComment);
		mav.addObject("commentList", commentList);
		mav.addObject("fileModel", fileModel);
		mav.setViewName("/blog/oneFile");
		return mav;
	}
	/**
	 * 查询所有的文章
	 * 
	 * @return
	 */
	@RequestMapping(value="/blog/archives")
	public ModelAndView requestFileList2(){
		
		List<FileModel> fileModelList=fileService.queryFileList();
		List<String> years=new ArrayList<String>();
		for (FileModel fileModel : fileModelList) {
			String year=DateAndStringUtil.dateGetYear(fileModel.getDate());
			if(!years.contains(year)){
				System.out.println(year);
				years.add(year);
			}
		}
		System.out.println("------------------"+years.size());
		ModelAndView mav=new ModelAndView();
		mav.addObject("years", years);
		mav.addObject("fileModelList", fileModelList);
		mav.setViewName("/blog/archives");
		return mav;
	}
	
	/**
	 * 调到Category添加页面
	 * @return
	 */
	@RequestMapping(value="/Admin/add-article")
	public ModelAndView requestAddFile(){
		List<Category> categoryList=categoryService.queryCategoryList();
		ModelAndView mav=new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("/Admin/add-article");
		return mav;
	}
	/**
	 * 添加一篇文章
	 * @param fileModel
	 * @return
	 */
	@RequestMapping(value="/Admin/article_add")
	public ModelAndView requestArticelAdd(FileModel fileModel){
		fileModel.setDate(DateAndStringUtil.date2String(new Date()));
		fileService.insertFile(fileModel);
		return requestFileList();
	}
	
	/**
	 * 查看需要修改的文章
	 * @param fileModel
	 * @return
	 */
	@RequestMapping(value="/Admin/update_article",method=RequestMethod.GET)
	public ModelAndView requestArticelAdd(int id){
		FileModel fileModel=fileService.queryFileOne(id);
		System.out.println("-------------------------"+fileModel);
		List<Category> categoryList=categoryService.queryCategoryList();
		ModelAndView mav=new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.addObject("fileModel", fileModel);
		mav.setViewName("/Admin/update-article");
		return mav;
	}
	
	/**
	 * 修改文章
	 * @param fileModel
	 * @return
	 */
	@RequestMapping(value="/Admin/UpdateArticle")
	public ModelAndView requestUpdateArticle(FileModel fileModel){
		System.out.println("===========requestUpdateArticle==========="+fileModel.getIsPublic());
	    fileService.updateFile(fileModel);
		return requestFileList();
	}
	/**
	 * ��ѯ��Ҫ�޸ĵ�����
	 * @param fileModel
	 * @return
	 */
	@RequestMapping(value="/Admin/delete_article",method=RequestMethod.GET)
	public ModelAndView requestDeleteArticel(int id){
		fileService.deleteFileOne(id);
		System.out.println("-------------------------"+id);
		return requestFileList();
	}
	
	@RequestMapping(value="/Admin/lib/ueditor")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            String exec = UeditorConfigJson.getConfigJson();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	public static void upload(byte[] fileByte,String path){
		File file=new File(path);
		if(file.exists()){
			FileOutputStream fos=null;
			try {
				fos=new FileOutputStream(file);
				fos.write(fileByte, 0, fileByte.length);
				fos.flush();
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/Admin/uploadImage")
	public Map uploadimage(@RequestParam(value="upfile",required=false) MultipartFile[] upfile) throws Exception{
		Map<String, String> map=new HashMap<String, String>();
		if(upfile!=null&&upfile.length>0){
			for (int i = 0; i < upfile.length; i++) {
				MultipartFile file=upfile[i];
				String fileName=file.getOriginalFilename();
				
				/***************     ftp�ϴ�  *********************/
				/*//String url="D:\\WordFile\\java\\ftp\\��Դ�ļ�վ\\"+fileName;
				Ftp f=new Ftp();
	            f.setIpAddr("127.0.0.1");
	            f.setUserName("lang");
	            f.setPwd("123456");
	            FtpUtil.connectFtp(f);
	           // File ftpFile = new File(url);  
	            FtpUtil.upload(fileName,file.getInputStream());//���ļ��ϴ���ftp��,�˴���������Ҫ�Լ��ر�
	            FtpUtil.closeFtp();
	            String url2="ftp://127.0.0.1:21/"+fileName;
				System.out.println("�ϴ��ļ�"+fileName);*/
				/***************     ftp�ϴ�  *********************/
				
				
				/****************    �ϴ���tomcat        ****************/
				/*�������ļ�·��*/
				String url="D:/WordFile/java/workspace/JavaSE/blog/src/main/webapp/upload/"+fileName;
				file.transferTo(new File(url));
				
				//�������ֱ�ӷ�����Դ
				String url2="http://localhost:8080/blog/upload/"+fileName;
				map.put("url", url2);
				map.put("original", fileName);
				map.put("type", fileName.substring(fileName.lastIndexOf(".")));
				map.put("state", "SUCCESS");
			}
		}
		return map;
	}
	
	 @RequestMapping(value = "getImage/{path}", method = RequestMethod.GET)
	    public void getImage(@PathVariable String path, HttpServletRequest request, HttpServletResponse response) {
	        FileInputStream fis = null;
	        OutputStream os = null;
	        try {
	          //  path = new String(Base64.isBase64(path), "UTF-8");
	        	System.out.println(path+"==========================");
	            fis = new FileInputStream(path);
	            os = response.getOutputStream();
	            int c;
	            byte[] b = new byte[4096];
	            while ((c = fis.read(b)) != -1) {
	                os.write(b, 0, c);
	            }
	            os.flush();
	        } catch (Exception e) {
	          //  logger.error("ueditor get image error : ", e);
	        } finally {
	            if (fis != null) {
	                try {
	                    fis.close();
	                } catch (Exception e) {

	                }
	            }
	            if (os != null) {
	                try {
	                    os.close();
	                } catch (Exception e) {

	                }
	            }
	        }
	    }
 
}
