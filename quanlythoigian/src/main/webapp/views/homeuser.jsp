<%@page import="serviceImpU.thoiKhoaBieuServiceImp"%>
<%@page import="model.thoiKhoaBieu"%>
<%@page import="java.util.List"%>
<%@page import="model.nguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file = "../util/taglib.jsp"%>
     <%@include file = "../util/libweb.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="<c:url value ="/js/edittkb.js"/>"></script>
</head>
	<c:set var = "list2S" value = "${applicationScope.t2S}"/> 
	<c:set var = "list2C" value = "${applicationScope.t2C}"/>
	<c:set var = "list3S" value = "${applicationScope.t3S}"/>
	<c:set var = "list3C" value = "${applicationScope.t3C}"/>
	<c:set var = "list4S" value = "${applicationScope.t4S}"/>
	<c:set var = "list4C" value = "${applicationScope.t4C}"/>
	<c:set var = "list5S" value = "${applicationScope.t5S}"/>
	<c:set var = "list5C" value = "${applicationScope.t5C}"/>
	<c:set var = "list6S" value = "${applicationScope.t6S}"/>
	<c:set var = "list6C" value = "${applicationScope.t6C}"/>
	<c:set var = "list7S" value = "${applicationScope.t7S}"/>
	<c:set var = "list7C" value = "${applicationScope.t7C}"/>
	<c:set var = "listCnS" value = "${applicationScope.cnS}"/>
	<c:set var = "listCnC" value = "${applicationScope.cnC}"/>
	
<%
	session = request.getSession(false);
	String userName = (String)session.getAttribute("userName");
	String nofication = (String)request.getAttribute("nofication");
	if(session!=null&&userName!=null){
%>
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
                        <h3 class="header__logo">
                        	Teinhmei
                        </h3>
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
        <div class="hu-body">
            <h6 class="hu-body--heading">
                Thời khóa biểu
            </h6>
            <div class="hu-table">
                <table class="table">
                    <thead class="hu-table--head">
                      <tr>
                        <th scope="col">Thời gian</th>
                        <th scope="col">Thứ 2</th>
                        <th scope="col">Thứ 3</th>
                        <th scope="col">Thứ 4</th>
                        <th scope="col">Thứ 5</th>
                        <th scope="col">Thứ 6</th>
                        <th scope="col">Thứ 7</th>
                        <th scope="col">Chủ Nhật</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr class="hu-table--row">
                        <th scope="row">Sáng</th>
                        <td>
                        <c:if test="${list2S.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 2"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                            </c:if>
                         <c:if test="${list2S.size()>0}">
                        	<c:forEach var = "item" items = "${list2S}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                        <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" name = "thoiGianBatDau" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" name = "thoiGianKetThuc" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                       </c:if>
                        </td>
                        <td>
                       <c:if test="${list3S.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 3"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                         </c:if>
                         <c:if test="${list3S.size()>0}">
                        	<c:forEach var = "item" items = "${list3S}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                 <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                       <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung3s" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" name ="thoiGianBatDau3s" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" name ="thoiGianKetThuc3s" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                       </c:if>
                        </td>
                        <td>
                        <c:if test="${list4S.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 4"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${list4S.size()>0}">
                        	<c:forEach var = "item" items = "${list4S}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        
                                        <div class="data-container">
                                       <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                       </c:if>
                        </td>
                   <td>
                        <c:if test="${list5S.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 5"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${list5S.size()>0}">
                        	<c:forEach var = "item" items = "${list5S}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                 <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                        <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                       </c:if>
                        </td>
                   <td>
                       <c:if test="${list6S.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 6"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                        </c:if>
                        <c:if test="${list6S.size()>0}">
                        	<c:forEach var = "item" items = "${list6S}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                        <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                      </c:if>
                        </td>
                    <td>
                        <c:if test="${list7S.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 7"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${list7S.size()>0}">
                        	<c:forEach var = "item" items = "${list7S}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                         <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                      </c:if>
                        </td>
                    <td>
                        <c:if test="${listCnS.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Chủ Nhật"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                         </c:if>
                          <c:if test="${listCnS.size()>0}">
                        	<c:forEach var = "item" items = "${listCnS}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                       <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                     </c:if>
                        </td>
                      </tr>
                      <tr class="hu-table--row">
                        <th scope="row">Chiều</th>
                        <td>
                       <c:if test="${list2C.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 2"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                         </c:if>
                         <c:if test="${list2C.size()>0}">
                          <c:forEach var = "item" items = "${list2C}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                        <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                         </c:if>
                        </td>
                         <td>
                        <c:if test="${list3C.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 3"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${list3C.size()>0}">
                          <c:forEach var = "item" items = "${list3C}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                 <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                         <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                          </c:if>
                        </td>
                        <td>
                        <c:if test="${list4C.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 4"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${list4C.size()>0}">
                          <c:forEach var = "item" items = "${list4C}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                        <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                          </c:if>
                        </td>
                         <td>
                        <c:if test="${list5C.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 5"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${list5C.size()>0}">
                          <c:forEach var = "item" items = "${list5C}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                         <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                        </c:if>
                        </td>
                       <td>
                       <c:if test="${list6C.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 6"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${list6C.size()>0}">
                          <c:forEach var = "item" items = "${list6C}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu="/>${item.thu}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                        <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                         </c:if>
                        </td>
                        <td>
                        <c:if test="${list7C.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Thứ 7"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                         </c:if>
                         <c:if test="${list7C.size()>0}">
                          <c:forEach var = "item" items = "${list7C}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp"/>">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
                                  <div class="hu-table--column-edit">
                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
                                        <div class="data-container">
                                         <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
                                          <div class="form-floating">
                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
                                              <label for="floatingTextarea"></label>
                                              <div id="error-noiDung" class="mess_error"></div>
                                            </div>
                                            <div>
                                              <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
                                                </div>
                                                <div class="mb-3">
                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
                                                </div>
                                            </div>
                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
                                        </div>
                                      </form>
                                  </div>
                              </div>
                          </div>                                          	
                        	</c:forEach>
                          </c:if>
                        </td>
                         <td>
                        <c:if test="${listCnC.size()<=0}">
                            <div class="hu-table--none ">
                                <a class="hu-table--none-link" href="<c:url value = "/views/addtkb.jsp?thu=Chủ Nhật"/>">
                                    <i class="hu-table--none-icon fa-solid fa-plus"></i>
                                </a>
                                <p class="hu-table--none-text">Thêm lịch của bạn</p>
                            </div>
                          </c:if>
                          <c:if test="${listCnC.size()>0}">
                          <c:forEach var = "item" items = "${listCnC}">
                            <div class="hu-table--display">
                                <div class="hu-table--column">
                                  <div class="hu-table--column-content">
                                   <p class="hu-table--text">
                                 	<span class = "text-tkb-body" >${item.noiDung}</span><br> <span style = "font-size: 14px">
                                 	 (${item.thoiGianBatDau}
                                 	${item.thoiGianKetThuc})
                                 	</span>
                                  </p>
                                  <div class="hu-table--ulti">
                                  <a class="hu-table--ulti" href="<c:url value = "/views/addtkb.jsp?thu=Chủ Nhật"/>}">
                                      <i class="fa-solid fa-plus"></i>
                                  </a>
                                      <i class="btn fa-solid fa-pen-to-square color-util"></i>
                                  <a class="hu-table--ulti" href="javascript:void(0);" onclick="confirmDelete(${item.idThoiKhoaBieu})">
                                      <i class="fa-solid fa-trash"></i>
                                  </a>
                                  </div>
                                  </div>
	                                  <div class="hu-table--column-edit">
	                                      <form action="<c:url value="/sua-thoi-khoa-bieu"/>" method="get" id="myForm">
	                                        <div class="data-container">
	                                        <input  id = "id" type="hidden" name="id" value="${item.idThoiKhoaBieu}">
                                    	<input id = "thu" type="hidden" name="thu" value="${item.thu}">
	                                          <div class="form-floating">
	                                              <textarea class="pd-4 textarea-edit reset-margin bg-p w-138px" name = "noiDung" id = "noiDung">${item.noiDung}</textarea>
	                                              <label for="floatingTextarea"></label>
	                                              <div id="error-noiDung" class="mess_error"></div>
	                                            </div>
	                                            <div>
	                                              <div class="mb-3">
	                                                  <label for="exampleInputPassword1" class="form-label">Thời gian bắt đầu</label>
	                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianBatDau" value="${item.thoiGianBatDau}" >
	                                                  <div  id="error-thoiGianBatDau" class="mess_error"></div>
	                                                </div>
	                                                <div class="mb-3">
	                                                  <label for="exampleInputPassword1" class="form-label">Thời gian kết thúc</label>
	                                                  <input type="time" class=" textarea-edit reset-margin bg-p" id="thoiGianKetThuc" value="${item.thoiGianKetThuc}">
	                                                  <div  id="error-thoiGianKetThuc" class="mess_error"></div>
	                                                </div>
	                                            </div>
	                                            <input class="btn-submit" type="button" value="Lưu" onclick="sendForm(event)">
	                                        </div>
	                                      </form>
	                                  </div>
	                              </div>
	                          </div>                                          	
                        	</c:forEach>
                         </c:if>
                        </td>
                      </tr>
                    </tbody>
                  </table>
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