<%@page import="serviceImpU.suKienServiceImp"%>
<%@page import="model.suKien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file = "../util/taglib.jsp"%>
      <%@include file = "../util/libweb.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value ="/js/ipcalendar.js"/>"></script>
</head>
<%		String mess = (String)request.getAttribute("errorMessage");
		mess = (mess!=null) ? mess:"";
%>
<%
	String userName = (String)session.getAttribute("userName");
	String nofication = (String)request.getAttribute("nofication");
	if(session!=null&&userName!=null){
		
%>
<% if(nofication!=null) {%>
	<script src="<c:url value = "/js/noficationMess.js"/>"></script>
<%}%>
	<c:set var="model" value="${applicationScope.lichModel}"/>
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
                        <a href="<c:url value="/views/homeuser.jsp"/>" class="header__navbar--link">Trang Chủ
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
                </ul>
            </div>
        </div>
        <div class="hu-content pd-b-40">
          <div class="dashboard">
            <div class="dashboard__user">
                <img class="dashboard__img" src="<c:url value = "/img/usernam.png"/>" alt="">
                <div class="dashboard__user--info">
                    <p class="dashboar__name"><c:out value = "<%=userName%>"/></p>
                <p class="dashboard__user-logout"> <a class="dashboard__user-logout--link" href="<c:url value="/dang-xuat"/>"><i class="fa-solid fa-right-from-bracket"></i> Đăng xuất</a></p>
                </div>
                <div class="dashboard__online"></div>
            </div>
            <div class="dashboard__search">
                <input class="dashboard__search--input" type="text" name="" id=""> 
                <a class="dashboard__search--link "  href=""><i class="color-2 dashboard__search--icon fa-solid fa-magnifying-glass"></i></a>
            </div>
            <h6 class="dashboard__heading">Danh sách chức năng</h6>
               <ul class="dashboard__list">
                <li class="dashboard__item tkb">
                    <a class="dashboard__item--link" href="<c:url value ="/data-tkb"/>">
                        <i class="dashboard__item--icon fa-solid fa-calendar-days"></i> 
                        Thời khóa biểu
                    </a>
                    <ul class="dashboard__item-childmn child-tkb">
                        <li class="dashboard__item-childmn-item">
                            <a href="<c:url value ="/views/addtkb.jsp"/>" class="dashboard__item-childmn-link">
                                <i class="fa-solid fa-plus m-r-10"></i>
                                Thêm lịch
                            </a>
                        </li>
                    </ul>   
                </li>
                <li class="dashboard__item sk sukien">
                    <a class="dashboard__item--link" href="<c:url value ="/data-sukien"/>">
                        <i class="dashboard__item--icon fa-solid fa-business-time"></i>
                   	 Sự kiện hôm nay
                    </a>
               
                     <ul class="dashboard__item-childmn child-sk">
                        <li class="dashboard__item-childmn-item">
                            <a href="<c:url value ="/views/addevent.jsp"/>" class="dashboard__item-childmn-link">
                                <i class="fa-solid fa-plus m-r-10"></i>
                                Thêm sự kiện
                            </a>
                        </li>
                        <li class="dashboard__item-childmn-item">
                            <a href="<c:url value ="/dtb-bevent"/>?page=1&maxItemsPage=5" class="dashboard__item-childmn-link">
                                <i class="fa-solid fa-clock-rotate-left m-r-10"></i>
                            Sự kiện đã diễn ra
                            </a>
                        </li>
                    </ul> 
                </li>
                <li class="dashboard__item timeline">
                    <a class="dashboard__item--link" href="<c:url value ="/data-timeline"/>">
                        <i class="dashboard__item--icon fa-solid fa-business-time"></i>
                    Thời gian một ngày
                    </a>
                    <ul class="dashboard__item-childmn child-tl">
                        <li class="dashboard__item-childmn-item">
                            <a href="<c:url value="/data-timeline-cmp"/>" class="dashboard__item-childmn-link">
                                <i class="fa-regular fa-lightbulb m-r-10"></i>
                                Những hoạt động đã hoàn thành
                            </a>
                        </li>
                    </ul> 
                </li>
                 <li class="dashboard__item calendar">
                    <a class="dashboard__item--link" href="<c:url value ="/data-calendar"/>">
                        <i class="dashboard__item--icon fa-solid fa-calendar"></i>
                    Lịch
                    </a>
                    <div class="calendar-underline"></div>
                </li>
            </ul>
        </div>
      <div  style="padding: 20px 30px;" class="hu-body">
            <h6 class="a-table__heading">Chi tiết sự kiện</h6>
            <form action="<c:url value = "/update-calendar"/>" id="myForm">
            	<input type="hidden" name = "id" value ="${model.idLich}">
                <div class="a_form--user">  
                    <div class="a_form--info">
                        <ul class="a_form--list">
                            <li class="a_form--item">
                                <div class="r">
                                    <div class="w-260px">
                                        <span>Tên sự kiện</span>
                                        <input class="a_form--input" type="text" value="${model.tenSuKien}" name="tenSuKien" id="tenSuKien" onblur="myblur(this.id)">
                                        <div id="error-tenSuKien" class="mess_error"></div>
                                    </div>
                                    <div class="w-260px">
                                    <span>Nội dung</span>
                                    <input class="a_form--input w-260px" type="text" value="${model.noiDung}" name="noiDung" id="noiDung"  onblur="myblur(this.id)">
                                    <div id="error-noiDung" class="mess_error"></div>
                                    </div>
                                </div>
                                <div class="r">
                                 <span style ="line-height:36px;margin-right:70px;">Ngày diễn ra sự kiện</span>
                                <div style = "width:22px; ">
                                <input style = "width:22px;text-align: center;" class="a_form--input " type="text" value="${model.ngay}" name="day" id="day"  onblur="myblur(this.id)">
                                </div>
                                <div style = "width:25px; ">
                                <input style = "width:22px;text-align: center;" class="a_form--input " type="text" value="${model.thang}" name="month" id="month"  onblur="myblur(this.id)">
                                </div>
                                <div style = "width:40px;">
                                <input style = "width:40px;text-align: center;" class="a_form--input" type="text" value="${model.nam}" name="year" id="year"  onblur="myblur(this.id)">
                                </div>                                
                                </div>
                                <div id="error-day" class="mess_error"></div>
                                <div id="error-month" class="mess_error"></div>
                                <div id="error-year" class="mess_error"></div>
                            <c:if test="${model.thoiGianBatDau=='00:00:00'&&model.thoiGianKetThuc=='00:00:00'}">
                            	<div>
                            	<span>Chưa có thông tin về thời gian diễn ra sự kiện</span>
                            	<p>Bạn có thể cập nhập thời gian tại đây</p>
                            	</div>
                            	<div class="r">
                            	<div class="w-260px">
                                    <span>Thời gian bắt đầu</span>
                                <input style = "width:160px;" class="a_form--input" type="time"  name="thoiGianBatDau" id="thoiGianBatDau"  onblur="myblur(this.id)">
                                <div id="error-thoiGianBatDau" class="mess_error"></div>
                                </div>
                                <div class="w-260px">
                                    <span>Thời gian kết thúc</span>
                                <input style = "width:160px;" class="a_form--input" type="time" name="thoiGianKetThuc" id="thoiGianKetThuc"  onblur="myblur(this.id)">
                                <div id="error-thoiGianKetThuc" class="mess_error"></div>
                                </div>
                            	</div>
                            	</c:if>
                            	<c:if test="${model.thoiGianBatDau!='00:00:00'||model.thoiGianKetThuc!='00:00:00'}">
                           	 <div class="r">
                                <div class="w-260px">
                                    <span>Thời gian bắt đầu</span>
                                <input class="a_form--input w-260px" type="time" value="${model.thoiGianBatDau}" name="thoiGianBatDau" id="thoiGianBatDau"onblur="myblur(this.id)" >
                                <div id="error-thoiGianBatDau" class="mess_error"></div>
                                </div>
                                <div class="w-260px">
                                    <span>Thời gian kết thúc</span>
                                <input class="a_form--input w-260px" type="time" value="${model.thoiGianKetThuc}" name="thoiGianKetThuc" id="thoiGianKetThuc" onblur="myblur(this.id)">
                                <div id="error-thoiGianKetThuc" class="mess_error"></div>
                                </div>
                            </div>
                               </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
                <input style="margin-left:512px;" class="a-table__submit" type="button" onclick="sendForm()" value="Cập nhật">
            </form>
             <button class="a-table__submit cld-btn" onclick="confirmDelete('${model.idLich}')">Xóa sự kiện này</button>
        </div>
    </div>
    </div>
        </div>
</body>
<% } else {
	response.sendRedirect("/quanlythoigian/views/dangnhap.jsp");
} %>
</html>