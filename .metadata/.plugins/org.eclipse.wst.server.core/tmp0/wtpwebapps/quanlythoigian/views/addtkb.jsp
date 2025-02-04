<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file = "../util/taglib.jsp"%>
      <%@include file = "../util/libweb.jsp"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value ="/js/addtkb.js"/>"></script>
</head>
<% String error = (String)request.getAttribute("errorMess");
	error = (error!=null) ? error : "";
	String thu = request.getParameter("thu");
	thu = (thu!=null) ? thu : "";
	String noiDung = request.getParameter("noiDung");
	noiDung = (noiDung!=null) ? noiDung : "";
	String tgbd = request.getParameter("thoiGianBatDau");
	tgbd = (tgbd!=null) ? tgbd : "";
	String tgkt = request.getParameter("thoiGianKetThuc");
	tgkt = (tgkt!=null) ? tgkt : "";
%>
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
        <div class="hu-content">
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
                    <div class="tkb-underline"></div>
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
                </li>
            </ul>
        </div>
        <div class="hu-body pd-b-40">
            <h6 class="hu-body--heading">
                Thêm thời khóa biểu
            </h6>
            <div class="addtkb-content m-t-40">
                <div class="addtkb--img">
                    <img class="addtkb--img-item" src="<c:url value = "/img/calendar2023.jpg"/>" alt="">
                </div>
                <div class="addtkb--form">
                <form id="myForm" action="<c:url value ="/them-thoi-khoa-bieu"/>" method = "get">
                	<div class="mess_error w-284px"><%=error%></div>
                    <div class="mb-3 ">
                        <label for="floatingTextarea" class="form-label"> Chọn thứ ngày muốn lên lịch</label>
                        <select class="form-select color-input w-156px" aria-label="Default select example" name="thu" id="thu" onblur="myblur(this.id)">
                        	<%if(thu!=""){%>
                        	<option selected><%=thu%></option>
                        	<%} else { %>
                        	<option selected>Vui lòng chọn</option>
                        	<%} %>
                            <option value="Thứ 2">Thứ 2</option>
                            <option value="Thứ 3">Thứ 3</option>
                            <option value="Thứ 4">Thứ 4</option>
                            <option value="Thứ 5">Thứ 5</option>
                            <option value="Thứ 6">Thứ 6</option>
                            <option value="Thứ 7">Thứ 7</option>
                            <option value="Chủ Nhật">Chủ Nhật</option>
                          </select>
                          <div id="error-thu" class="mess_error w-156px"></div> 
                    </div>
                    <div class="form-floating mb-3">
                        <textarea  id="noiDung" class="form-control" placeholder="Leave a comment here"  name="noiDung"  onblur="myblur(this.id)"><%=noiDung%></textarea>
                        <label for="floatingTextarea">Thêm nội dung</label>
                        <div  id="error-noiDung" class="mess_error w-280px"></div>
                    </div>
                      <div class="mb-3 r">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Thời gian bắt đầu</label>
                            <input type="time" class="form-control m-r-20"  aria-describedby="emailHelp" name="thoiGianBatDau" id="thoiGianBatDau"  value="<%=tgbd%>"  onblur="myblur(this.id)">
                            <div id="error-thoiGianBatDau" class="mess_error w-156px"></div>
                          </div>
                          
                          <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Thời gian kết thúc</label>
                            <input type="time" class="form-control"  aria-describedby="emailHelp" name="thoiGianKetThuc" id="thoiGianKetThuc"  value="<%=tgkt%>"  onblur="myblur(this.id)">
                            <div id="error-thoiGianKetThuc" class="mess_error w-156px"></div>
                          </div>
                      </div>
                      <button type="button" class = "addtkb-submit" onclick="sendForm()">Thêm lịch</button>
                </form>
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