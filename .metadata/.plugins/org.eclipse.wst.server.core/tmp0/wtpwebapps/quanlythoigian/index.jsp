<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file = "/util/taglib.jsp"%>
<!DOCTYPE html>
<html>
 <title>Document</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/base.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%String nofication = (String)request.getAttribute("nofication");%>
<% if(nofication!=null) {%>
	<script src="<c:url value = "/js/noficationMess.js"/>"></script>
<%}%>
<body style="background-color: black;">
  <div class="web">
        <div class="width-1280">
            <div  id ="div__error-mess" class="error__edit-mess">
                <button id = "div__error-close" class="error__edit-mess--close">
                    <i class="fa-regular fa-circle-xmark"></i>
                </button>
                <h5 class="error__edit-mess--heading">
                    Thông Báo !
                </h5>
                <p class="error__edit-mess--text"> 
                   <%=nofication%>
                </p>
            </div>
        <div class="header">
            <div class="header__contact">
                <ul class="header__contact--list ">
                    <li class="header__contact--item">
                        <i class="contact__icon fa-solid fa-envelope color-2"></i>
                        <span class="contact__content">thaihien29403@gmail.com</span>
                    </li>
                    <li class="header__contact--item">
                        <i class="contact__icon fa-solid fa-phone color-2"></i>
                        <span class="contact__content">07696***46</span>
                    </li>
                </ul>
                <ul class="header__contact--list ">
                    <a href="" class="header__contact--link">
                        <i class="contact__icon fa-brands fa-facebook"></i>
                    </a>
                    <a href="" class="header__contact--link">
                        <i class="contact__icon fa-brands fa-instagram"></i>
                    </a>
                    <a href="" class="header__contact--link">
                        <i class="contact__icon fa-brands fa-github"></i>
                    </a>
                    <a href="" class="header__contact--link">
                        <i class="contact__icon fa-brands fa-twitter"></i>
                    </a>
                </ul>
            </div>
            <div class="header__navbar">
                <ul class="header__navbar--list">
                        <h3 class="header__logo">Teinhmei</h3>
                </ul>
                <ul class="header__navbar--list">
                    <li class="header__navbar--item">
                        <a href="" class="header__navbar--link">Trang Chủ
                        </a>
                    </li>
                    <li class="header__navbar--item">
                        <a href="" class="header__navbar--link">Giới Thiệu
                        </a>
                    </li>
                    <li class="header__navbar--item">
                        <a href="" class="header__navbar--link">Dịch Vụ
                        </a>
                    </li>
                    <li class="header__navbar--item">
                        <a href="<c:url value = "/views/dangnhap.jsp"/>" class="header__navbar--link">Đăng Nhập
                        </a>
                    </li>
                    <li class="header__navbar--item">
                        <a href="<c:url value = "/views/dangky.jsp"/>" class="header__navbar--link">Đăng Ký
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="content">
            <div class="content__title">
                <h2 class="content__title--heading">
                    Chào mừng bạn đến với TEINHMEI
                </h2>
                <p class="content__title--sub">
                    Đây là một trang web mà mình viết ra đễ dành cho bản thân <br>  
                    mình về việc quản lý thời gian hoạt động trong ngày. Để <br> 
                    thỏa ước mơ từ bé là tạo ra một sản phẩm,một website mà có <br>
                    thể phục vụ bản thân và mọi người. Vì vậy nên mình muốn chia  <br>
                    sẽ công khai lên website, nếu bạn có nhu cầu thì hãy sử dụng nó <br> 
                    nhé, hy vọng sẽ mang lại trải nghiệm tốt cho mọi người.
                </p>
                <a class="content__title--start" href="views/dangnhap.jsp">Bắt đầu sử dụng</a>
            </div>
            <div class="content__img">
                <img  class="content__img--content" src="img/time2.jpg" alt="">
                 <p class="content__title--title">
                    Bạn có thể trì hoãn <br> nhưng thời gian thì không
                </p>
            </div>
        </div>
    </div>
    </div>
</body>
</html>