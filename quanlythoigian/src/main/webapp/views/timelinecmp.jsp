<%@page import="model.nguoiDung"%>
<%@page import="serviceImpU.suKienServiceImp"%>
<%@page import="model.suKien"%>
<%@page import="java.util.List"%>
<%@page import = "java.time.LocalDate"%>
<%@page import = "java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@include file = "../util/taglib.jsp"%>
      <%@include file = "../util/libweb.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value ="/js/indexevent.js"/>"></script>
</head>
	<c:set var = "list" value = "${applicationScope.list}"/>
<%
	String userName = (String)session.getAttribute("userName");
	if(session!=null&&userName!=null){
		
%>
<body style="background-color: black;">
    <div class="web">
        <div class="width-1280">
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
        <div class="hu-content m-h">
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
                    <div class="sk-underline"></div>
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
                </li>
            </ul>
        </div>
        <div class="hu-body">
            <h6 class="sk-body-heading">
               Timeline một ngày
            </h6>
            <div class="hu-ie-content">
                <div class="hu-ie-content-body">
                    <div class="hu-ie-content--ut">
                        <h6 class="hu-ie-content--heading color-2">Những sự kiện đã hoàn thành trong ngày hôm nay</h6>
                        <ul class="hu-ie-content--ut-list">
                        <c:if test="${list.size()<= 0}">
                          <li class="hu-ie-content--ut-item hu-ie-content-no" >
                                <h4 class="hu-ie-content-no--text">
                                    Hôm nay bạn chưa hoàn thành hoạt động nào cả
                                </h4>
                             
                            </li>
                        </c:if>
                        <c:if test="${list.size()>0}">
                    	<c:forEach var ="item" items="${list}">
                            <li class="hu-ie-content--ut-item">
                                <div class="hu-ie-content--ut-item-top">
                                    <p class="hu-ie-content-text">Tên sự kiện</p>
                                    <p class="hu-ie-content-text w-156px">Mô tả sự kiện</p>
                                    <p class="hu-ie-content-text">Thời gian diễn ra</p>
                                </div>
                                <div class="hu-ie-content--ut-item-reptop">
                                    <p class="hu-ie-content-text-r">${item.tenHoatDong}</p>
                                    <p class="hu-ie-content-text-r w-156px">${item.moTaNgan}</p>
                                    <p class="hu-ie-content-text-r">
                                    ${item.thoiGianBatDau} - ${item.thoiGianKetThuc}</p>
                                </div>
                                <div class="hu-ie-content--ut-item-bot m-t-10">
                                    <p class="hu-ie-content-text w-156px">Địa điểm</p>
                                </div>
                                <div class="hu-ie-content--ut-item-repbot">
                                    <p class="hu-ie-content-text-r w-156px">${item.diaDiem}</p>
                                </div>
                            </li>
                            </c:forEach>
                        </c:if>
                        </ul>
                    </div>
             </div>
            </div>
        </div>
    </div>
        </div>
    </div>
</body>
<% } else {
	response.sendRedirect("/quanlythoigian/views/dangnhap.jsp");
} %>
</html>