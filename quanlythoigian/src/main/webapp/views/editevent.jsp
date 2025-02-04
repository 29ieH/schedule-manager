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
<script src="<c:url value ="/js/addevent.js"/>"></script>
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
	<c:set var="sk" value="${applicationScope.suKien}"/>
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
               Sửa sự kiện
            </h6>
            <div class="hu-addsk--form">
            	<div class="mess_error"><%=mess%></div>
                <form id="myForm" action="<c:url value ="/edit-sukien"/>" method="get">
                    <div class="hu-addsk--form-div">
                    	<input type ="hidden" name = "id" value ="${sk.idSuKien}">
                        <div class="hu-addsk--form-left">
                            <div class="mb-3">
                              <label for="exampleInputEmail1" class="form-label">Tên sự kiện</label>
                              <input type="text" class="form-control" id="tenSuKien" aria-describedby="emailHelp" name="tenSuKien" onblur="myblur(this.id)" value ="${sk.tenSuKien}">
                              <div id ="error-tenSuKien" class="mess_error"></div>
                            </div>
                            <div class="form-floating mb-3">
                                <textarea class="form-control" placeholder="Leave a comment here" id="moTa" name="moTa" onblur="myblur(this.id)">${sk.moTaNgan}</textarea>
                                <label for="floatingTextarea">Mô tả sự kiện</label>
                                <div id="error-moTa" class="mess_error"></div>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Ngày diễn ra sự kiện</label>
                                <input type="date" class="form-control" id="ngay" name="ngay" onblur="myblur(this.id)" value ="${sk.ngayDienRaSuKien}">
                                <div id="error-ngay" class="mess_error"></div>
                            </div>
                            <div class="hu-addsk--time">
                                <div class="mb-3 m-r-20">
                                    <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                    <input type="time" class="form-control" id="thoiGianBatDau" name="thoiGianBatDau" onblur="myblur(this.id)" value ="${sk.thoiGianBatDau}">
                                    <div id="error-thoiGianBatDau" class="mess_error"></div>
                                </div>
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                    <input type="time" class="form-control" id="thoiGianKetThuc" name="thoiGianKetThuc" onblur="myblur(this.id)" value ="${sk.thoiGianKetThuc}">
                                    <div id="error-thoiGianKetThuc" class="mess_error"></div>
                                </div>
                            </div>
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a comment here" id="diaDiem" name="diaDiem" onblur="myblur(this.id)">${sk.diaDiem}</textarea>
                                <label for="floatingTextarea">Địa điểm</label>
                                <div id="error-diaDiem" class="mess_error"></div>
                            </div>
                        </div>  
                    <div class="hu-addsk--form-right">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Hẹn giờ trước sự kiện</label>
                            <input list="options" class="form-control" id="henGio" aria-label="Default input example" name="henGio" onblur="myblur(this.id)" value = "${sk.henGioTruocSuKien}p">
                            <datalist id="options">
                              <option>5p</option>
                              <option>10p</option>
                              <option>15p</option>
                              <option>20p</option>
                              <option>1h</option>
                              <option>1h30p</option>
                            </datalist>
                            <div id="error-henGio" class="mess_error"></div>
                            </div>
                        <div class="form-floating mb-3">
                            <textarea class="form-control" placeholder="Leave a comment here" id="nguoiThamGia" name="nguoiThamGia" onblur="myblur(this.id)">${sk.nhungNguoiThamGia}</textarea>
                            <label  for="floatingTextarea">Những người tham gia</label>
                            <div id="emailHelp" class="form-text">Thêm những thành viên cùng tham gia vào sự kiện.</div>
                        </div>
                        <div class="mb-3">
                            <select class="form-select form-control" aria-label="Default select example" id = "loaiSuKien" name="loaiSuKien" onblur="myblur(this.id)">
                                <option selected>Chọn loại sự kiện</option>
                                <option value="Học tập">Học tập</option>
                                <option value="Buổi tiệc">Buổi tiệc</option>
                                <option value="Cuộc họp">Cuộc họp</option>
                              </select>
                              <div id="error-loaiSuKien" class="mess_error"></div>
                        </div>
                    <div class="mb-3 form-check">
                      <input type="checkbox" class="form-check-input" id="suUuTien" name="suUuTien" onblur="myblur(this.id)">
                      <label class="form-check-label" for="exampleCheck1">Sự kiện ưu tiên</label>
                    </div>
                </div>  
                </div>
                <button   type="button" class=" hu-addsk--submit " onclick="sendForm()">Sửa</button>
                  </form>
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