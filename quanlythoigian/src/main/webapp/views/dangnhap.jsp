<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file = "../util/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value ="/css/base.css"/>">
    <link rel="stylesheet" href="<c:url value ="/css/main.css"/>">
    <script src="<c:url value ="/js/login.js"/>"></script>
    <% String errorMess = (String)request.getAttribute("error");
    	errorMess = (errorMess!=null) ? errorMess:"";
    	String nofication = (String)request.getAttribute("nofication");
    %>
    <% if(nofication!=null) {%>
	<script src="<c:url value = "/js/noficationMess.js"/>"></script>
	<%}%>
</head>
<body>
	 <div class="sigup">
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
        <div class="content-sigup">
            <div class="content-sigup__img">
                <img class = "content-sigup__img-z" src="<c:url value = "/img/background-sigup.jpg"/>" alt="">
            </div>
            <form action="<c:url value ="/dang-nhap"/>"  method="post" id="myForm" class="content-sigup__title">
                <div class="content-sigup__title-1">
                    <div class="box-heading">
                        <h2 class="content-sigup__heading">Đăng nhập</h2>
                    </div>
                    <p class="content-sigup__title--sub">Nhập vào tài khoản</p>
                    <input class="content-sigup__title--input" type="text" name="taiKhoan" id="taiKhoan" required onblur="myblur(this.id)">
                    <div id="error-taiKhoan" class="mess_error"></div>
                    <p class="content-sigup__title--sub">Nhập vào mật khẩu</p>
                    <input class="content-sigup__title--input error-pw" type="password" name="matKhau" id="matKhau"  required onblur="myblur(this.id)"> <br>
                    <div id="error-matKhau" class="mess_error"></div>
                     <p class="content-sigup__check"><input type="checkbox" name="checkDieuKien" id="dieuKhoan"> Đồng ý với điều khoản của chúng tôi</p>
                     <div id="error-dieuKhoan" class="mess_error"></div>
                     <div id="error-mess" class="mess_error"><%=errorMess%></div>
                    <input class="content-sigup__submit" type="button" value="Đăng nhập" onclick="sendForm()"> <br>
                    <p style="margin: 2px 0px;"><a class="forgot__password" href="<c:url value="/views/forgetpass.jsp"/>">Quên mật khẩu</a></p>
                    <p class="content-sigup__create">Nếu bạn chưa có tài khoản thì hãy đăng ký tài khoản <a class="" href="<c:url value ="/views/dangky.jsp"/>">tại đây</a></p>
                </div>
            </form>
        </div>
    </div>
</body>
</html>