<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

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
		 z-index:10;
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
	     width:100%;height:2630px;
	     overflow:hidden;
	     margin-bottom:30px;
	  }
	  #nav-body .nav{
	     width:85%;height:2630px;
		 margin:0px auto;
		 position:relative;
	  }
	  #nav-body .nav .nav-left{
	     width:70%;height:2630px;
	     left:-500px;
		 position:absolute;
		
	  }
	  #nav-body .nav .nav-left .con{
	     width:100%;height:500px;
	     overflow:hidden;
		 background:#ffffff;
		 box-shadow:1px 1px 5px #505050;
		 margin-bottom:10px;
		
	  }
	  #nav-body .nav .nav-left .con .wenzhang{
	     width:95%;height:400px;
		 margin:0px 20px;
		 overflow:hidden;
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
	  #nav-body .nav .nav-left .con .more{
		 width:100%;height:20px;
		 padding:20px 20px;
	  }
	  #nav-body .nav .nav-left .con .more a{
		 font-size:14px;
		 font-family:"Microsoft yahei";
		 color:#35587b;
		 cursor:pointer;
	  }
	  #nav-body .nav .nav-left .con .more a:hover{
		  color:#2f4d6a;
	  }
     /****navleft-foot****/
	 #nav-body .nav .nav-left .navleft-foot{
	     width:100%;height:40px;
		 background:#fff;
		 position:relative;
		 box-shadow:1px 1px 5px #979DA0;
		 font-size:14px;
		 
		 font-family:"Microsoft yahei";
	 }
     #nav-body .nav .nav-left .navleft-foot .pre{
	     position:absolute;
	     cursor:pointer;
		 top:10px;
		 left:20px;
	 }
	 #nav-body .nav .nav-left .navleft-foot .pre:hover{
	     color:#3399cc;
	 }
	 #nav-body .nav .nav-left .navleft-foot .page{
	    text-align:center;
		line-height:40px;
	 }
	 #nav-body .nav .nav-left .navleft-foot .next{
	     position:absolute;
		 right:20px; top:10px;
         cursor:pointer;
	 }
	 #nav-body .nav .nav-left .navleft-foot .next:hover{
	     color:#3399cc;
	 }
	 /*nav-right*/
	  #nav-body .nav .nav-right{
	     width:26%;height:100%;
		 right:-200px;
		 position:absolute;
	  }
	  #nav-body .nav .nav-right .myinfo{
	     width:100%;height:300px;
		 background:#ffffff;
		 box-shadow:1px 1px 5px #979DA0;
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
	     width:74%;height:22px;
	 }
	 #nav-body .nav .nav-right .nav-search-box .search-box a{
		 padding:4px 2%;
		 background-color:#2980b9;
		 border-radius:3px;
		 color:#ffffff;
		 font-size:15px;
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
  </style>
 </head>
 <body>
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
	        <c:forEach items="${fileModelList}" var="fileModel">
			    <div class="con div1">
				   <div class="wenzhang">
				       <h2>${fileModel.title}</h2>
					   <p class="date">${fileModel.date}</p>
					   <div class="content">
					      <h2>前言</h2>
						  <p class="guoduimg"></p>
						  <p class="text">
						      ${fileModel.content}
	                      </p>
					   </div>
				   </div>
				   
				   <div class="more">
					 <a href="<%=basePath %>/blog/oneFile?id=${fileModel.id}">[more]</a>
				   </div>
				</div>
			</c:forEach>
			
		    <!--navleft-foot-->
	        <div class="navleft-foot">
	           <c:if test="${currentPage-1>0}">
                   <a class="pre" href=" <%=basePath%>/blog/getpage?wantpage=${currentPage-1}">上一页</a>
	           </c:if>
			   <div class="page">${currentPage}/${maxpage}</div>
			   <c:if test="${currentPage<maxpage}">
			       <a class="next" href=" <%=basePath%>/blog/getpage?wantpage=${currentPage+1}">下一页</a>
			   </c:if>
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
   
   <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript">
      
      function getCommon(){
    	  this.head=$("#nav-head .load");
    	  this.left=$("#nav-body .nav .nav-left");
    	  this.right=$("#nav-body .nav .nav-right");
    	  return this;
      }
      $(function(){
    	  var common=getCommon();
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
      	  $(window).resize(function(){ 
      		  console.log(document.body.clientWidth);
       		if(document.body.clientWidth<1070){ 
       		  // window.resizeTo(document.body.clientWidth,1070);
       			common.right.css("display","none");
       			common.left.css("width","100%");
       		}else{
       			common.right.css("display","block");
       			common.left.css("width","70%");
       		}
          });
      });

   </script>
 </body>
</html>
