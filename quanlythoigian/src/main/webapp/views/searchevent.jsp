<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file = "../util/taglib.jsp"%>
      <%@include file = "../util/libweb.jsp"%>
      <%@include file = "../util/libpagination.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String userName = (String)session.getAttribute("userName");
	if(session!=null&&userName!=null){
%>
<c:set var = "list" value = "${applicationScope.listResult}"/>
<c:set var = "name" value = "${applicationScope.name}"/>
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
               Danh Sách Sự kiện
            </h6>
            <div class="hu-sk--content">
                <div class="row-body m-t-40">
                <p class="sk-body-subsearch">Danh sách sự kiện với tên là : ${name}</p>
                <div class="sk-body--search">
                    <form action="<c:url value ="/search-sukien"/>" class = "reset-margin">
                        <input class="sk-body--input" type="text" name="tensukien" id="" placeholder="Nhập vào tên sự kiện đễ tìm kiếm"> 
                        <button class = "sk-body--submit" type="submit">
                            <i class="dashboard__search--icon fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>
                </div>
           	 </div>
                <div class="sk-body-listevent">
                <c:if test="${list.size()<=0}">
                    <div class="sk-body-listevent--none">
                        <h4 class="sk-body-listevent--none--heading">Không tìm thấy sự kiện nào có tên : ${name}</h4>
                    </div>  
                </c:if>
                <c:if test="${list.size()>0}">
                <ul class="sk-body-listevent--list">
                <c:forEach var="item" items="${list}">
                    <li class="sk-body-listevent--item">
                        <div class="r">
                            <p class="sk-body-listevent--text w-280px">Tên sự kiện : ${item.tenSuKien} </p>
                            <p class="sk-body-listevent--text w-320px">Mô tả sự kiện : ${item.moTaNgan}</p>
                            <p class="sk-body-listevent--text w-280px">Địa điểm : ${item.diaDiem}</p>
                            <c:if test="${item.suKienUuTien==1}">
                            <p style="color: orangered; font-size: 16px;">Ưu tiên *</p>
                            </c:if>
                        </div>
                        <div class="r">
                            <p class="sk-body-listevent--text w-280px">Thời gian bắt đầu : ${item.thoiGianBatDau}</p>
                            <p class="sk-body-listevent--text w-280px">Thời gian kết thúc : ${item.thoiGianKetThuc}</p>
                            <p class="sk-body-listevent--text w-280px">Ngày diễn ra sự kiện : ${item.ngayDienRaSuKien}</p>
                        </div>
                    </li>
                    </c:forEach>
                </ul>
                 </c:if>
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