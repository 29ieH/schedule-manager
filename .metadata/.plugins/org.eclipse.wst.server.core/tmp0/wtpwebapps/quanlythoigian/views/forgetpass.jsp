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
</head>
<% String nofication = (String)request.getAttribute("nofication"); %>
<% if(nofication!=null) {%>
	<script src="<c:url value = "/js/noficationMess.js"/>"></script>
<%}%>
 <body  style="background-color: black;">
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
                    <div class="rs__heading">
                        <h4 class="rs__heading--title">
                            Đặt lại mật khẩu
                        </h4>
                    </div>
                    <div style="justify-content: center; margin-top: 180px;" class="r">
                    <div class="rs__content">
                        <div class="rs__content--heading">
                            <a class="rs__content--back" href="<c:url value="/index.jsp"/>"><i class="fa-solid fa-arrow-left"></i></a>
                            <h4 class="rs__content--title">Đặt lại mật khẩu</h4>
                        </div>	
                        <form action="<c:url value="/sendmailresetpsw"/>">
                            <input class="rs__content--input" type="email" name="email" id="" placeholder="Nhập vào email của bạn">
                            <br>
                            <button class="rs__content--button" type="submit">Tiếp theo</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>