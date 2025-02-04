<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file = "../../util/taglib.jsp"%>
     <%@include file = "../../util/libweb.jsp"%>
      <%@include file = "../../util/libpagination.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	session = request.getSession(false);
	String userName = (String)session.getAttribute("userName");
	String nofication = (String)request.getAttribute("nofication");
	if(session!=null&&userName!=null){
%>
<% if(nofication!=null) {%>
	<script src="<c:url value = "/js/noficationMess.js"/>"></script>
<%}%>
<c:set var = "list" value = "${listResult}"/>
<c:set var = "currentPage" value = "${currentPage}"/>
<c:set var = "totalPage" value = "${totalPage}"/>
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
                    aaaabcdefghaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                </p>
            </div>
        <div class="header">
            <!-- <div class="header__contact">
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
            </div> -->
            <div style="margin-top: 20px;" class="header__navbar">
                <ul class="header__navbar--list">
                        <h3 class="header__logo">Teinhmei</h3>
                </ul>
                <ul class="header__navbar--list">
                    <li style="color: #ccc; font-weight: 700;" class="header__navbar--item">
                        Xin chào admin ! 
                        <a style ="color: orangered;" href="<c:url value="/a-dang-xuat"/>">Đăng xuất</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="hu-content">
        <div class="dashboard">
            <h6 class="dashboard__heading"> <i class="fa-solid fa-bars"></i> Danh sách chức năng</h6>
            <div style="margin-bottom: 20px;" class="dashboard__search">
                <input class="dashboard__search--input" type="text" name="" id=""> 
                <a class="dashboard__search--link "  href=""><i class="color-2 dashboard__search--icon fa-solid fa-magnifying-glass"></i></a>
            </div>
            <ul class="dashboard__list">
                <li class="dashboard__item tkb">
                    <a class="dashboard__item--link" href="">
                        <i class="dashboard__item--icon fa-solid fa-people-roof"></i> 
                        Quản lý tài khoản
                    </a>
                    <div class="tkb-underline"></div>
                </li>
                <li id="sukien" class="dashboard__item sukien">
                    <a class="dashboard__item--link" href="indexevent.html">
                        <i class="dashboard__item--icon fa-solid fa-newspaper"></i>
                    Quản lý bài viết
                    </a>
                </li>
            </ul>
        </div>
        <div  style="padding: 20px 30px;" class="hu-body">
            <h6 class="a-table__heading">Danh sách tài khoản user</h6>
            <c:if test="${list.size()<=0}">
            </c:if>
     		  <c:if test="${list.size()>0}">
     		  <c:set var = "count" value ="1"/>
            <form action="<c:url value="/a-dtb-user"/>" id="myForm">
            <table class="table a-table__user">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Họ và tên</th>
                    <th scope="col">Tài khoản</th>
                    <th scope="col">Mật khẩu</th>
                    <th scope="col">Email</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var = "item" items="${list}">
                  <tr>
                    <th scope="row">${count}</th>
                    <td>${item.hoVaTen}</td>
                    <td>${item.taiKhoan}</td>
                    <td> <p class="a-text-psw"> ${item.matKhau} </p> </td>
                    <td>${item.email}</td>
                    <c:if test="${item.status==1}">
                    <td>Đang hoạt động</td>
                    </c:if>
                    <c:if test="${item.status==0}">
                    <td>Tạm khóa</td>
                    </c:if>
                    <td>
                        <a class="a-table__link" href="<c:url value="/a-dtb-info"/>?id=${item.idNguoiDung}">
                            <i class="fa-solid fa-pen-to-square"></i> Edit
                        </a>
                    </td>
                  </tr>
                  <c:set var="count" value="${count+1}"/>
                  </c:forEach>
                </tbody>
              </table>
              <input type="hidden" id="page" name="page" value="">
                <input type="hidden" id="maxItemsPage" name="maxItemsPage" value="">
                <div class="m-l-30">
                    <ul class="pagination" id="pagination"></ul>
                </div>
            </form>
            </c:if>
        </div>
    </div>
        </div>
    </div>
    <script>
        var currentPage = ${currentPage};
        var totalPagez = ${totalPage};
        var limit = 5;
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPagez,
                visiblePages: 5,
                startPage : currentPage,
                onPageClick: function (event, page) {
                    if(currentPage!=page){
                         $('#page').val(page);
                         $('#maxItemsPage').val(limit);
                         $('#myForm').submit();	
                    }
                }
            });
        });
        </script>
</body>
<% } else {
	response.sendRedirect("/quanlythoigian/views/dangnhap.jsp");
} %>
</html>