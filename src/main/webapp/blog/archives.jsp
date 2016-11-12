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
	  *{padding:0;margin:0;text-decoration:none;}
	  html,body{
	     width:100%;height:100%;
		  background:#E6E6E6;
	  }
      /***nav-head start****/
	  #nav-head{
	     width:100%;height:60px;
		 background-color:#3399cc;
		 position:relative;
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
		 list-style:none;
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
	     padding-top:20px;
	     width:85%;height:1500px;
	     position:relative;
	     boder:1px solid red;
	     margin:0px auto;
	     overflow:hidden;
	  }
	  #nav-body .nav{
	     padding:40px 30px;
	     width:100%;height:auto;
		 background:#ffffff;
		 box-shadow:1px 1px 2px #929292;
		 left:-500px;
		 position:absolute;
	  }
	  #nav-body .nav h1{
	    font-weight: bold;
		font-size: 1.8em;
		font-family: Pmingliu,Mingliu;
		line-height: 1em;
	  }
	  #nav-body .nav .all .img{
	     width:90%;height:20px;
	     background:url("images/guodu.png");
	  }
	  #nav-body .nav .all h2{
	     font-size:13px;
		 color:#666;
         margin-top:30px;

	  }
	  #nav-body .nav .all ul{
	     margin-left:20px;
		
	  }
	  #nav-body .nav .all ul li {
	     font-size:14px;
		 font-family:"Microsoft yahei";
		 
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
			 <li><a>关于我</a></li>
		  </ul>
	  </div>
   </div>
   <div id="nav-body">
      <div class="nav">
          <h1>Archives</h1>
		  <div class="all">
		     <!-- 迭代 -->
		     <c:forEach items="${years}" var="year">
                 <h2 class="year id2015">${year}</h2>
				 <div class="img"></div>
				 <ul class="year2015">
				    <c:forEach items="${fileModelList}" var="fileModel">
				    	<li>
						  <span>${fileModel.date}</span>
						  <a>${fileModel.title}</a>
						  <span>${fileModel.click}</span>
						</li>
				    </c:forEach>
				 </ul>  
		     </c:forEach>
		     <!--  
		     <h2 class="year id2015">2015</h2>
			 <div class="img"></div>
			 <ul class="year2015">
			    <li>
				  <span>时间</span>
				  <a>连接</a>
				  <span>点击率</span>
				</li>
				<li>
				  <span>时间</span>
				  <a>连接</a>
				  <span>点击率</span>
				</li>
			 </ul>
			 <h2 class="year2014">2014</h2>
			 <div class="img"></div>
			 <ul class="year2014">
			 	<li>
				  <span>时间</span>
				  <a>连接</a>
				  <span>点击率</span>
				</li>
				<li>
				  <span>时间</span>
				  <a>连接</a>
				  <span>点击率</span>
				</li>
			 </ul>
			 -->
		  </div>
	  </div>
   </div>
   <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript">
      
      function getCommon(){
    	  this.head=$("#nav-head .load");
    	  this.left=$(" #nav-body .nav");
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
      });
   </script>
 </body>
</html>
