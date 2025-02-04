<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file = "../util/taglib.jsp"%>
      <%@include file = "../util/libweb.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value ="/js/indextimeline.js"/>"></script>
</head>
<c:set var="listAll" value="${applicationScope.listAll}"/>
<%
	String tenSuKien = request.getParameter("tenSuKienz");
	tenSuKien = (tenSuKien!=null) ? tenSuKien:"";
	String moTaNgan = request.getParameter("moTaNganz");
	moTaNgan = (moTaNgan!=null) ? moTaNgan:"";
	String diaChi = request.getParameter("diaChiz");
	diaChi = (diaChi!=null) ?diaChi:"";
	String thoiGianBatDau = request.getParameter("thoiGianBatDauz");
	thoiGianBatDau = (thoiGianBatDau!=null) ? thoiGianBatDau:"";
	String thoiGianKetThuc = request.getParameter("thoiGianKetThucz");
	thoiGianKetThuc = (thoiGianKetThuc!=null) ? thoiGianKetThuc:"";
	String userName = (String)session.getAttribute("userName");
	String nofication = (String)request.getAttribute("nofication");
	if(session!=null&&userName!=null){
		
%>
<% if(nofication!=null) {%>
	<script src="<c:url value = "/js/noficationMess.js"/>"></script>
<%}%>
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
                <li class="dashboard__item tl timeline">
                    <a class="dashboard__item--link" href="<c:url value ="/data-timeline"/>">
                        <i class="dashboard__item--icon fa-solid fa-business-time"></i>
                    Thời gian một ngày
                    </a>
                    <div class="tl-underline"></div>
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
               Time line
            </h6>
            <div class="tl-body">
                <div class="tl-body--content">
                    <h6 class="tl-body--content-text">List timeline</h6>
                    <c:if test="${listAll.size()<=0}">
                    </c:if>
                    <c:if test="${listAll.size()>0}">
                    <ul class="tl-body--content-list">
                    <c:forEach var="item" items="${listAll}">
                    	<c:if test="${item.hoanThanh!=1}">
                        <li class="tl-body--content-item">
                            <div class="r tl-body-on">
                            <div>
                                <div class="hu-tl-body--list-top">
                                    <p class="hu-tl-body--list-text w-156px"><span class = "hu-tl-body--list-text--title">Tên Hoạt Động </span><br> ${item.tenHoatDong}</p>
                                    <p class="hu-tl-body--list-text w-210px"><span class = "hu-tl-body--list-text--title">Mô tả ngắn</span> <br> ${item.moTaNgan}</p>
                                </div>
                                <div class="hu-tl-body--list-bot">
                                    <p class="hu-tl-body--list-text w-260px"><span class = "hu-tl-body--list-text--title">Địa điểm</span> <br> ${item.diaDiem}</p>
                                    <p class="hu-tl-body--list-text w-156px"><span class = "hu-tl-body--list-text--title">Thời gian</span> <br>
                                    ${item.thoiGianBatDau} - ${item.thoiGianKetThuc}
                                     </p>
                                </div>
                            </div>
                            <div>
                                <div class="hu-tl-body--timeline">
                                    <button style="border: none;background-color: #3b3a3a;"><i class="hu-tl-body--timeline-icon fa-solid fa-pen"></i></button>
                                    <a href="javascript:void(0);" onclick="confirmDelete(${item.idThoiGianTrongNgay})"><i class="hu-tl-body--timeline-icon fa-solid fa-trash"></i></a>
                                    <a href="javascript:void(0);" onclick="confirmComplete(${item.idThoiGianTrongNgay})"><i class="hu-tl-body--timeline-icon fa-solid fa-check"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="tl-body-hide">
                            <!-- <li class=""> -->
                                 <form action="<c:url value="/edit-timeline"/>" method="get" id="myForm">  
                            
                                    <input type="hidden" id ="id" name="id" value="${item.idThoiGianTrongNgay}">
                                    <div class="r">
                                        <div class="m-r-10">
                                            <textarea class="w-156px textarea-edit" name="tenSuKien" id="tenSuKien" cols="30" rows="2" onblur="myblur(this.id)">${item.tenHoatDong}</textarea>
                                            <div id="error-tenSuKien" class="mess_error w-156px"></div>
                                        </div>
                                        <div>
                                            <textarea class="w-210px textarea-edit" name="moTaNgan" id="moTaNgan" cols="30" rows="2" onblur="myblur(this.id)">${item.moTaNgan}</textarea>
                                            <div id="error-moTaNgan" class="mess_error w-210px"></div>
                                        </div>
                                    </div>
                                    <div class="r">
                                        <div  class="m-r-10">
                                            <textarea class="w-260px textarea-edit" name="diaChi" id="diaChi" cols="30" rows="2" onblur="myblur(this.id)">${item.diaDiem}</textarea>
                                            <div id="error-diaChi" class="mess_error w-260px"></div>
                                        </div>
                                        <div class="w-156px">
                                            <input class="textarea-edit" type="time" name="thoiGianBatDau" id="thoiGianBatDau" name="thoiGianBatDau" onblur="myblur(this.id)" value = "${item.thoiGianBatDau}">
                                            <div id="error-thoiGianBatDau" class="mess_error w-156px"></div>
                                            <input class="textarea-edit" type="time" name="thoiGianKetThuc" id="thoiGianKetThuc" name ="thoiGianKetThuc" onblur="myblur(this.id)" value = "${item.thoiGianKetThuc}"> 
                                            <div id="error-thoiGianKetThuc" class="mess_error w-156px"></div>
                                        </div>
                                        <button class = "tl-body-sendedit" type="button" onclick="sendForm(this)" form = "myForm"><i class="fa-solid fa-circle-check"></i></button>
                                    </div>
                                </form>
                            <!-- </li> -->
                        </div>
                        </li>
                        </c:if>
                       </c:forEach>
                    </ul>
        	  </c:if>
                </div>
                <div class="tl-body--add">
                    <h6 class="tl-body--content-text">Thêm timeline</h6>
                 <form class="hu-tl-body--form" action="<c:url value = "/add-timeline"/>" id="myFormz">
                        <div class="mb-3 m-b-10">
                            <label for="themSuKien" class="form-label">Thêm tên sự kiện</label>
                            <input type="text" class="form-control" id="tenSuKienz"  name="tenSuKienz" onblur="myblur(this.id)" value="<%=tenSuKien%>">
                            <div id="error-tenSuKienz" class="mess_error"></div>
                        </div>
                        <div class="form-floating mb-3 m-b-10">
                                <input  type="text" class="form-control" id="moTaNganz"  name="moTaNganz" onblur="myblur(this.id)" value="<%=moTaNgan%>">
                                <label for="floatingInput">Mô tả ngắn</label>
                                <div id="error-moTaNganz" class="mess_error"></div>
                        </div>
                        <div class="form-floating mb-3 m-b-10">
                            <input  type="text" class="form-control" id="diaChiz" name="diaChiz" onblur="myblur(this.id)" value="<%=diaChi%>">
                            <label for="floatingInput">Địa điểm</label>
                            <div id="error-diaChiz" class="mess_error"></div>
                      </div>
                   <div class="mb-3 m-b-10">
                        <div class="tl-body--add-time">
                            <div>
                            <label for="themSuKien" class="form-label">Thời gian bắt đầu</label>
                            <input type="time" class="form-control" id="thoiGianBatDauz"  name="thoiGianBatDauz" onblur="myblur(this.id)" value="<%=thoiGianBatDau%>">    
                            <div id="error-thoiGianBatDauz" class="mess_error w-156px"></div>                          
                            </div>
                            <div>
                            <label for="themSuKien" class="form-label">Thời gian kết thúc</label>
                            <input type="time" class="form-control" id="thoiGianKetThucz"  name="thoiGianKetThucz" onblur="myblur(this.id)" value="<%=thoiGianKetThuc%>">
                            <div id="error-thoiGianKetThucz" class="mess_error w-156px"></div> 
                            </div>
                        </div>
                      </div>
                            <input class="tl-body--submit" type="button" onclick="sendFormz()" value="Tạo timeline">
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