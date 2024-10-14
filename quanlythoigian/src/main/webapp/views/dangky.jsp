<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file = "../util/taglib.jsp"%>
      <%@include file = "../util/libweb.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="<c:url value ="/js/sigup.js"/>"></script>
</head>
<%
	String messE = (String)request.getAttribute("errorEmail");
	String messTk = (String)request.getAttribute("errorTk");
	messE = (messE!=null) ? messE:"";
	messTk = (messTk!=null) ? messTk:"";
	String error = (String)request.getAttribute("error");
%>
<% if(error!=null) {%>
	<script src="<c:url value = "/js/noficationMess.js"/>"></script>
<%}%>
<body>
<div  id ="div__error-mess" class="error__edit-mess">
                <button id = "div__error-close" class="error__edit-mess--close">
                    <i class="fa-regular fa-circle-xmark"></i>
                </button>
                <h5 class="error__edit-mess--heading">
                    Thông Báo !
                </h5>
                <p class="error__edit-mess--text"> 
                	<%=error%>
                </p>
            </div>
	<div class="login">
        <div class="content-login">
            <div class="content-login__img">
                <img class = "content-login__img-z" src="<c:url value = "/img/background-sigup.jpg"/>" alt="">
            </div>
            <form action="<c:url value = "/dang-ky"/>" id="myForm" class="content-login__title" method="post">
                <div class="content-login__title-1">
                    <div class="box-heading">
                        <h2 class="content-login__heading">Đăng ký</h2>
                    </div>
                    <p class="content-login__title--sub">Nhập vào họ tên</p>
                    <input class="content-login__title--input" type="text" name="hoVaTen" id="hoVaTen" onblur="myblur(this.id)">
                    <div id = "error-hoVaTen" class="mess_error"></div>
                    <p class="content-login__title--sub">Nhập vào email</p>
                    <input class="content-login__title--input" type="email" name="email" id="email" onblur="myblur(this.id)">
                    <div id = "error-email" class="mess_error w-244px"><%=messE%></div>
                    <p class="content-login__title--sub">Nhập vào tài khoản</p>
                    <input class="content-login__title--input" type="text" name="taiKhoan" id="taiKhoan" onblur="myblur(this.id)">
                    <div id = "error-taiKhoan" class="mess_error"><%=messTk%></div>
                    <p class="content-login__title--sub">Nhập vào mật khẩu</p>
                    <input class="content-login__title--input" type="password" name="matKhau" id="matKhau" onblur="myblur(this.id)">
                    <div id = "error-matKhau" class="mess_error"></div>
                    <p class="content-login__title--sub">Nhập lại mật khẩu</p>
                    <input class="content-login__title--input" type="password" name="nhapLaiMatKhau" id="nhapLaiMatKhau" onblur="myblur(this.id)">
                    <div id = "error-nhapLaiMatKhau" class="mess_error"></div>
                    <p class="content-sigup__create">Đăng nhập <a class="" href="<c:url value ="/views/dangnhap.jsp"/>">tại đây</a></p>
                </div>
                <div class="content-login__title-2">
                    <p class="content-login__title--sub">Ngày sinh</p>
                    <input class="content-login__title--input" type="date" name="ngaySinh" id="ngaySinh" onblur="myblur(this.id)">
                    <div id = "error-ngaySinh" class="mess_error"></div>
                    <p class="content-login__title--sub">Giới tính</p>
                    <!-- <input class="content-login__title--input" type="text" name="gioiTinh" id="">
                    <div id = "error-" class="mess_error"></div> -->
                    <select class="content-login__title--input" aria-label="Default select example" name = "gioiTinh" id="gioiTinh" onblur="myblur(this.id)">
                        <option selected>Chọn giới tính</option>
                        <option value="Nam">Nam</option>
                        <option value="Nữ">Nữ</option>
                        <option value="Khác">Khác</option>
                      </select>
                    <div id = "error-gioiTinh" class="mess_error"></div>
                    <p class="content-login__title--sub">Địa chỉ</p>
                    <input class="content-login__title--input" type="text" name="diaChi" id="diaChi" onblur="myblur(this.id)">
                    <div id = "error-diaChi" class="mess_error"></div>
                    <input class="content-login__submit" type="button" value="Đăng ký" onclick="sendForm()">
                </div>

            </form>
        </div>
    </div>
</body>
</html>