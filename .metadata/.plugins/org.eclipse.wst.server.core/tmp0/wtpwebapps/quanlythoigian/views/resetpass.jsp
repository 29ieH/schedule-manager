<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file = "../util/taglib.jsp"%>
      <%@include file = "../util/libweb.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value ="/js/resetpass.js"/>"></script>
</head>
 <body  style="background-color: black;">
            <div class="web">
                <div class="width-1280">
                    <div class="rs__heading">
                        <h4 class="rs__heading--title">
                            Đặt lại mật khẩu
                        </h4>
                    </div>
                    <div style="justify-content: center; margin-top: 120px;" class="r">
                    <div class="rs__content">
                        <div class="rs__content--heading">
                            <a class="rs__content--back" href="<c:url value="/views/forgetpass.jsp"/>"><i class="fa-solid fa-arrow-left"></i></a>
                            <h4 class="rs__content--title">Đặt lại mật khẩu</h4>
                        </div>
                        <form action="<c:url value="/checkresetpass"/>" id="myForm" method="post">
                            <input class="rs__content--input" type="password" name="currentpass" id="currentpass" placeholder="Nhập vào mật khẩu vừa nhận từ email" onblur="myblur(this.id)">
                            <div id = "error-currentpass" class="mess_error"></div>
                            <input class="rs__content--input" type="password" name="newpass" id="newpass" placeholder="Nhập vào mật khẩu mới" onblur="myblur(this.id)">
                            <div id = "error-newpass" class="mess_error"></div>
                            <input class="rs__content--input" type="password" name="re-enterpass" id="re-enterpass" placeholder="Nhập lại mật khẩu mới" onblur="myblur(this.id)">
                            <div id = "error-re-enterpass" class="mess_error"></div>
                            <br>
                            <button class="rs__content--button"  type="button" onclick="mySubmit()">Xác nhận</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>