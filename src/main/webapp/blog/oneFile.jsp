<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
  <style type="text/css">
      /******common*********/
	  *{padding:0;margin:0;list-style:none;text-decoration:none;}
	  html,body{
	     width:100%;height:100%;
		  background:#E6E6E6;
	  }
      /***nav-head start****/
	  #nav-head{
	     width:100%;height:60px;
		 background-color:#3399cc;
		 position:fixed;
	  }
	  #nav-head .load{
	     display:none;
	     position:absolute;
	     width:0%;height:3px;
	     background:#0A75AB;
	  }
	  #nav-head .container{
	     width:85%;height:100%;
		 margin:auto auto;
		 position:relative;
	  }
	  #nav-head .container .log{
	     position:absolute;
		 left:0px;
		 width:120px;height:100%;
	  }
	  #nav-head .container .log .text{
	     line-height:60px;
		 font-family:"microsoft yahei"; 
		 font-size:40px;
		 color:#ffffff;
		 font-weight:100;
	  }
	  #nav-head .container ul.leader{
	     position:absolute;
		 right:0px;
		 height:100%;width:400px;
	  }
	  #nav-head .container ul.leader li{
	    float:left;
		height:100%;width:auto;
		padding:0px 11px;
	  }
	  #nav-head .container ul.leader li a{
	    height:100%;
		width:auto;
		color:#ffffff;
		font-size:15px;
		font-weight:700;
		font-family:"Microsoft yahei";
		line-height:60px;
		cursor:pointer;
	  }
	  #nav-head .container ul.leader li a:hover{
	    color:#e6e6e6;
	  }

	  /***nav-body**********/
	  #nav-body{
	     padding-top:90px;
	     width:100%;height:2800px;
	  }
	  #nav-body .nav{
	     width:85%;height:auto;
		 margin:0px auto;
		 position:relative;
	  }
	  #nav-body .nav .nav-left{
	     width:70%;height:100%;
		 position:absolute;
		 left:-500px;
		 padding-bottom:70px;
	  }
	  #nav-body .nav .nav-left .con{
	     width:100%;height:auto;
		 background:#ffffff;
		 box-shadow:1px 1px 5px #505050;
		 margin-bottom:10px;
		
	  }
	  #nav-body .nav .nav-left .con .wenzhang{
	     width:95%;height:auto;
		 margin:0px 20px;
	  }
	  #nav-body .nav .nav-left .con .wenzhang h2{
	    padding-top:30px;
	  }
	 #nav-body .nav .nav-left .con .wenzhang p.date{
	    padding-top:5px;
		padding-bottom:20px;
		line-height:20px;
		font-size:13px;
	 }
	  #nav-body .nav .nav-left .con .wenzhang .content p.guoduimg{
	     background:url("images/guodu.png");
		 width:100%;height:20px;
	  }
	 #nav-body .nav .nav-left .con .wenzhang .content p.text{
	     font-size:14px;
		 font-family:"microsoft yahei";
		 line-height:25px;
	 }
	  #nav-body .nav .nav-left .con .wenzhang .content .more{
		 width:100%;height:20px;
		 padding:20px 0px;
	  }
	  #nav-body .nav .nav-left .con .wenzhang .content .more a{
		 font-size:14px;
		 font-family:"Microsoft yahei";
		 color:#35587b;
		 cursor:pointer;
	  }
	  #nav-body .nav .nav-left .con .wenzhang .content .more a:hover{
		  color:#2f4d6a;
	  }
     /****navleft-foot****/
	 #nav-body .nav .nav-left .navleft-foot{
	     box-shadow:1px 1px 2px #b9b9b9;
         padding-top:30px;
	     width:100%;height:auto;
	     background-color:#fff;		 
	     
	 }
	 #nav-body .nav .nav-left .navleft-foot .head{
	     margin:0px 20px;
	     position:relative;
	     width:95%;height:40px;
	     font-size:14px;color:#828282;font-family:"Microsoft yahei";
	     border-bottom:1px solid #c1c1c1;
	 }
	 #nav-body .nav .nav-left .navleft-foot .head .comment{
        position:absolute;
        top:0px;left:0px;
        width:100px;height:40px;
		
        line-height:40px;text-align:center;
	 }
	 #nav-body .nav .nav-left .navleft-foot .head ul{
	    position:absolute;
	    top:0px;right:0px;
	    width:auto;height:100%;
	 }
	 #nav-body .nav .nav-left .navleft-foot .head ul li{
	    float:right;
	    width:50px;height:40px;
	    line-height:40px;text-align:center;
		cursor:pointer;
	 }
	 #nav-body .nav .nav-left .navleft-foot .head ul li:hover{
	     color:#017cb9;
	 }
	 #nav-body .nav .nav-left .navleft-foot .head ul li.native{
	    color:#017cb9;
	 }
 	 #nav-body .nav .nav-left .navleft-foot .body{
	     font-size:14px; font-family:"Microsoft yahei";
 	     margin:0px 20px;
         border-bottom:1px solid #c8c8c8;
	     margin-top:10px;
	     width:95%;height:auto;
	     
	 }
	 #nav-body .nav .nav-left .navleft-foot .body .nav{
	     display:none;
	     width:100%;
		 height:auto;
	 }
     #nav-body .nav .nav-left .navleft-foot .body .nav ul{
	     width:100%;
	     height:auto;
	 }
	 #nav-body .nav .nav-left .navleft-foot .body .nav ul li{
	     border-bottom:1px solid #e3e3e3;
		 position:relative;
		 height:100px;width:100%;
	 }
   	#nav-body .nav .nav-left .navleft-foot .body .nav ul li img{
	     border:1px solid red;
		 position:absolute;
         top:10px;left:30px;
	 }
	 #nav-body .nav .nav-left .navleft-foot .body .nav ul li div{
	     border:1px solid red;
		 position:absolute;
         top:10px;left:77px;

	 }
	 #nav-body .nav .nav-left .navleft-foot .body .nav ul li div{
	     line-height:25px;
	 }
	 #nav-body .nav .nav-left .navleft-foot .body .nav ul p.notMapper{
	     text-align:center;
	     line-height:30px;
	     font-size:14px;font-family:"Microsoft yahei";
	 }
	 #nav-body .nav .nav-left .navleft-foot .body .new{
	     display:block;
	    
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot{
	     margin:10px 20px;
		 font-size:14px;font-color:gray;font-family:"Microsoft yahei";
	     width:95%;height:150px;
	     position:relative;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot dl{
	     position:absolute;
		 height:25px;
		 padding-left:15px;
		 margin-bottom:10px;
		 z-index:2;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot dl dt{
		 height:25px;line-height:25px;
		 float:left;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot dl dd{
		 margin-left:20px;
		 height:25px;line-height:25px;
		 float:left;

	 }
	 #nav-body .nav .nav-left .navleft-foot .foot ul{
	    position:absolute;
	    right:20px;top:5px;
	    z-index:1;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot ul li a{
	    cursor:pointer;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot ul li a:hover{
	    color:#3399cc;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot input.area{
	     position:absolute;
	     z-index:0;
		 left:10%;
		 top:30px;
	     height:50px;width:90%;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot img{
	     position:absolute;
		 left:28px;
		 top:30px;
	 }
	 #nav-body .nav .nav-left .navleft-foot .foot a.pinglun{
	    position:absolute;
		background:#00a3cf;
		padding:5px 8px;
		border-radius:3px;
		cursor:pointer;
	    bottom:20px;right:10px
	 }
	 /*nav-right*/
	  #nav-body .nav .nav-right{
	     position:absolute;
	     right:-200px;
	     width:26%;height:100%;
		 float:right;
	  }
	  #nav-body .nav .nav-right .myinfo{
	     width:100%;height:300px;
		 background:#ffffff;
		 box-shadow:1px 1px 2px #aaaaaa;
		 border:1px solid #ffffff;
		 margin-bottom:30px;
	  }
	  #nav-body .nav .nav-right .nav-search-box{
	     width:100%;height:90px;
		 background:#ffffff;
		 box-shadow:1px 1px 2px #aaaaaa;
		 border:1px solid #ffffff;
		 margin-bottom:30px;
	  }
	  #nav-body .nav .nav-right .nav-search-box .nav-search{
	     border-bottom:1px solid #f6f6f6; 
	     width:100%;height:40px;
		 line-height:40px;
		 font-size:15px;
		 font-weight:700;
		 font-family:"Microsoft yahei";
		 text-indent:10px;
	  }
	  #nav-body .nav .nav-right .nav-search-box .search-box{
	     width:100%;height:40px;
		 line-height:40px;
		 text-indent:10px;
	  }
	 #nav-body .nav .nav-right .nav-search-box .search-box input{
	     width:70%;height:22px;
	 }
	 #nav-body .nav .nav-right .nav-search-box .search-box a{
		 padding:4px 10px;
		 background-color:#2980b9;
		 border-radius:3px;
		 color:#ffffff;
		 font-size:15px;
		 width:10%;
		 font-family:"Microsoft yahei";
	 }

	 #nav-body .nav .nav-right .tab{
	     width:100%;height:50px;
	     margin-bottom:30px;
		 background:#ffffff;
		 box-shadow:1px 1px 2px #aaaaaa;
		 border:1px solid #ffffff;
	 }
	 #nav-body .nav .nav-right .direcotry{
	     margin-bottom:30px;
	     width:100%;height:50px;
		 background:#ffffff;
		 box-shadow:1px 1px 2px #aaaaaa;
		 border:1px solid #ffffff;
	 }

     #foot{
	     width:100%;height:60px;
		 background:#DCDCDC;
		 line-height:60px;
		 text-align:center;
	 }
      /* 登录的遮挡层 */
	 #zhe{
	     display:none;
	     font-family:"Microsoft yahei";
	     font-size:14px;
	     width:100%;height:100%;
		 position:fixed;
		 background:#bbbbbb;
		 opacity:0.9;
		 z-index:999;
	 }
	 #zhe .login{
	     padding:10px 30px;
	     width:300px;height:300px;
		 margin:166px auto;
		 background:#ffffff;
		 opacity:1;
	 }
	 #zhe .login .loginF{
	     height:60px;width:100%;
		 line-height:60px;
		 text-indent:10px;
		 position:relative;
	 }
	 #zhe .login .loginF span{
	     position:absolute;
	     cursor:pointer;
	     right:0px;
	 }
	  #zhe ul{
	     border:1px solid yellow;
         width:100%;height:60px;
		 text-align:center;
	  }
	  #zhe ul li{
	     float:left;
		 width:80px;height:60px;
		 border:1px solid red;

	  }
	  #zhe .login input{
	     font-family:"Microsoft yahei";
	    font-size:14px;
	  }
	  #zhe .login .people{
	    width:100%;height:40px;
		padding-left:0px;
		line-height:50px;
		text-indent:-160px;
	  }
	  #zhe .login .name{
		 height:35px;
		 width:100%;
		 margin-bottom:10px;
	  }
	  #zhe .login .pwd{
		 height:35px;
		 width:100%;
	  }
	  
	  #zhe .login .submit{
	     margin-top:10px;
	     padding:6px 13px;
	     margin-left:240px;
	  }
	  
	  /* 注册的遮挡层 */
	  #loginzhe{
	     display:none;
	     font-family:"Microsoft yahei";
	     font-size:14px;
	     width:100%;height:100%;
		 position:fixed;
		 background:#bbbbbb;
		 opacity:0.95;
		 z-index:999;
	 }
	 #loginzhe .login{
	     padding:10px 30px;
	     width:300px;height:300px;
		 margin:166px auto;
		 background:#ffffff;
		 opacity:1;
	 }
	 #loginzhe .login .loginF{
	     height:60px;width:100%;
		 line-height:60px;
		 text-indent:10px;
	 }
	  #loginzhe .login input{
	    font-family:"Microsoft yahei";
	    font-size:14px;
	  }
	  #loginzhe .login .name{
		 height:35px;
		 width:100%;
		 margin-bottom:10px;
	  }
	  #loginzhe .login .pwd{
		 height:35px;
		 width:100%;
		 margin-bottom:10px;
	  }
	  #loginzhe .login .qq{
		 height:35px;
		 width:100%;
		 margin-bottom:10px;
	  }
	  
	  #loginzhe .login .email{
		 height:35px;
		 width:100%;
		 margin-bottom:10px;
	  }
	  	  
	  #loginzhe .login .submit{
	     margin-top:10px;
	     padding:6px 13px;
	     margin-left:240px;
	  }
  </style>
 </head>
 <body>
   <div id="loginzhe">
      <div class="login">
	      <form method="post" action="<%=basePath %>/blog/register">
		     <p class="loginF">注册(提示:注册成功即可评论)</p>
		     <input type="hidden" name="fileId" value="${fileModel.id}"/>
		     <input class="name" type="text" name="name" value="用户名"/>
			 <input class="pwd" type="text" name="password" value="密码"/>
			 <input class="qq" type="text" name="qq" value="qq号"/>
			 <input class="email" type="text" name="email" value="Email"/>
			 <input class="submit" type="submit"/>
		  </form>
	  </div>
   </div>
   
      <div id="zhe">
      <div class="login">
	      <form method="post" action="<%=basePath %>/blog/login">
		    <p class="loginF">社交登录方式<span>退出</span></p>
		  	<ul>
			   <li>qq</li>
			   <li>weixin</li>
			 </ul>
			 <div class="people">请填写用户名和密码</div>
			 <input type="hidden" name="fileId" value="${fileModel.id}"/>
		     <input class="name" type="text" name="name" value="用户名"/>
			 <input class="pwd" type="text" name="password" value="密码"/>
			 <input class="submit" type="submit"/>
		  </form>
	  </div>
   </div>
   
   <c:if test="${resultCode==0}">
       <script type="text/javascript">
           alert("没有这个用户，请注册");
           var logginzhe=document.getElementById("loginzhe");
           logginzhe.style.display='block';
       </script>
   </c:if>

   <div id="nav-head">
      <div class="load"></div>
      <div class="container">
          <div class="log">
             <div class="text">lang</div>
		  </div>
		  <ul class="leader">
		     <li><a href="<%=basePath %>/blog/index">首页</a></li>
			 <li><a href="<%=basePath %>/blog/archives">文件存档</a></li>
			 <li><a>移动端</a></li>
			 <li><a>pc端</a></li>
			 <li><a>服务器</a></li>
			 <li><a href="personalIntroduction/PersionalIntroduction.html">关于我</a></li>
		  </ul>
	  </div>
   </div>
   <div id="nav-body">
      <div class="nav">
	      <div class="nav-left">
		    <div class="con div1">
			   <div class="wenzhang">
			       <input type="hidden" name="fileId" value="${fileModel.id}" id="fileId"/>
			       <h2>${fileModel.title}</h2>
				   <p class="date">${fileModel.date}</p>
				   <div class="content">
				      <h2>前言</h2>
					  <p class="guoduimg"></p>
					  <p class="text">
					      ${fileModel.content}
                      </p>
					  <div class="more">
					   
					  </div>
				   </div>
			   </div>
			</div>
		    <!--navleft-foot-->
	        <div class="navleft-foot">
               <div class="head">
                  <div class="comment">${totalComment}条评论</div>
                  <ul>
                    <li class="native">最新</li>
                    <li>最热</li>
                    <li>最早</li>
                  </ul>
               </div>
               <div class="body">
                   <div class="nav new">
				    <ul>
			          <c:choose>
				          <c:when test="${commentList!=null && fn:length(commentList) > 0}">
				              <c:forEach items="${commentList}" var="comment" varStatus="list">
					             <li>
							      <img width="30" height="30">
								  <div>
								    <p>${comment.userId}</p>
									<p>${comment.comment}</p>
									<p>${comment.date }</p>
								  </div>
								 </li>
							  </c:forEach>
				          </c:when>
				          <c:otherwise>
				              <p class="notMapper">
				                                                  哦，没有匹配数据 ，  等你来抢沙发
				              </p>                          
				          </c:otherwise>
			          </c:choose>
					</ul>
				   </div>
               </div>
               <div class="foot">
			      <dl>
				    <dt>登录方式</dt>
					<dd>qq</dd>
					<dd>微信</dd>
					<dd>微博</dd>
					<dd>其他</dd>
				  </dl>
				  <ul>
				    <li>
				       <c:choose>
				          <c:when test="${sessionScope.user!=''&&!empty sessionScope.user}">
				             <a href="<%=basePath%>/blog/unlogin?fileId=${fileModel.id}"> 退出${sessionScope.user.name}</a>
				          </c:when>
				          <c:otherwise>
				             <a class="login">未登录</a>
				          </c:otherwise>
				       </c:choose>
				    </li>
				  </ul>
                  <form action="">
				      <img width="30" height="30"/>
                      <input class="area" type="text" id="pinglun"/>
                      <a class="pinglun">评论</a>
                  </form>
               </div>
	        </div>
		 </div>
		 <!--content right -->
		 <div class="nav-right">
		     <div class="nav-search-box">
				 <div class="nav-search">
					关键字搜索
				 </div>
				 <div class="search-box">
				     <input type="text"/>
					 <a>搜索</a>
				 </div>
			 </div>
			 <div class="myinfo">
			     information
			 </div>

			 <div class="tab">
			     标签
			 </div>

			 <div class="direcotry">
			     目录
			 </div>
		 </div>
	  </div>
   </div>

   <div id="foot">
      Copyright © Lang All Rights Reserved
   </div>

   <script src="js/jquery.js" ></script>
  <script type="text/javascript">
  
    function newCommon(){
    	this.aclick=$("#nav-body .nav .nav-left .navleft-foot .foot a.pinglun");
    	this.area=$("#nav-body .nav .nav-left .navleft-foot .foot .area");
    	this.login=$("#zhe");
    	this.fileId=$("#fileId");
    	this.ul=$("#nav-body .nav .nav-left .navleft-foot .body .nav ul");
    	this.aLogin=$("#nav-body .nav .nav-left .navleft-foot .foot ul li a.login");
    	this.unLogin=$("#zhe .login .loginF span");
    	this.head=$("#nav-head .load");
  	    this.left=$("#nav-body .nav .nav-left");
  	    this.right=$("#nav-body .nav .nav-right");
    	return this;
    }
	$(function(){
		
		var common=newCommon();
		
		/*动画加载*/
		common.head.animate({
	   	   width:"100%",
	    },2000,function(){
	   	   common.head.css("display","none");
	   	});
	   	common.left.animate({
	   	  left:"0px",
	   	},800);
	   	common.right.animate({
	   	   right:"0px",
	   	},500);
	   	
	   	/*动画加载结束*/
		aLogin.click(function(e){
			common.login.css("display","block");
		});
		unLogin.click(function(){
			common.login.css("display","none");
			
		});
		

		aclick.click(function(){
			var content=area.val();
			var id=fileId.val();
			//验证登录，登录就保存，没有登录就返回
			if(content!=""&&id!=""){
				alert(content);
				$.ajax({
					type: "post",
					url:"<%=basePath %>/blog/pinglun",
					data:{"comment":content,"fileId":id},
					success:function(data){
						if(data.code=="200"){
					         alert("ok");
					         var html="";
					         html+="<li>";
					         html+="<img width=\"30\" height=\"30\"/>";
					         html+="<div>";
					         html+="<p>"+data.name+"</p>";
					         html+="<p>"+data.comment+"</p>";
					         html+="<p>"+data.date+"</p>";
					         html+="</div>";
					         html+="</li>";
					         ul.append(html);
						}else{
							alert("请先登录");
							common.login.css("display","block");
						}
						
					}
				});
			}else{
				alert("请输入内容");
			}
		 });
	})
	 
	$(window).resize(function(){ 
	if(document.body.clientHeight<700){ 
	    window.resizeTo(document.body.clientHeight,300); 
	} 
	}); 
  </script>
 </body>
</html>
