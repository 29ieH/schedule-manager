<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file = "../../util/taglib.jsp"%>
     <%@include file = "../../util/libweb.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/js/adelete.js"/>"></script>
</head>
<c:set var ="result" value ="${applicationScope.listResult}"/>
<%
	session = request.getSession(false);
	if(session!=null){
%>
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
            <div style="margin-top: 20px;" class="header__navbar">
                <ul class="header__navbar--list">
                        <h3 class="header__logo">Teinhmei</h3>
                </ul>
                <ul class="header__navbar--list">
                    <li style="color: #ccc; font-weight: 700;" class="header__navbar--item">
                        Xin chào admin! <a style ="color: orangered;" href="<c:url value="/a-dang-xuat"/>">Đăng xuất</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="hu-content m-h">
        <div class="dashboard">
            <h6 class="dashboard__heading"> <i class="fa-solid fa-bars"></i> Danh sách chức năng</h6>
            <div style="margin-bottom: 20px;" class="dashboard__search">
                <input class="dashboard__search--input" type="text" name="" id=""> 
                <a class="dashboard__search--link "  href=""><i class="color-2 dashboard__search--icon fa-solid fa-magnifying-glass"></i></a>
            </div>
            <ul class="dashboard__list">
                <li class="dashboard__item tkb">
                    <a class="dashboard__item--link" href="<c:url value="/a-dtb-user?page=1&maxItemsPage=5"/>">
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
            <h6 class="a-table__heading">Chi tiết tài khoản</h6>
            <form action="<c:url value = "/a-edit-userz"/>" id="myForm">
            	<input type="hidden" name = "id" value ="${result.idNguoiDung}">
                <div class="a_form--user">   
                <c:choose>
                	<c:when test="${result.gioiTinh=='Nam'}">
                	<img src="<c:url value="/img/usernam.png"/>" alt="" class="a_form--img">  
                	</c:when>
                	<c:otherwise>
                	<img src="<c:url value="/img/nuuser.png"/>" alt="" class="a_form--img"> 
                	</c:otherwise>
                </c:choose>
                    <div class="a_form--info">
                        <ul class="a_form--list">
                            <li class="a_form--item">
                                <div class="r">
                                    <div class="w-260px">
                                        <span>Họ và tên</span>
                                        <input class="a_form--input" type="text" value="${result.hoVaTen}" name="hoVaTen">
                                        <div id="error-thoiGianBatDau" class="mess_error"></div>
                                    </div>
                                    <div class="w-260px">
                                    <span>Ngày sinh</span>
                                    <input class="a_form--input w-260px" type="text" value="${result.ngaySinh}" name="ngaySinh">
                                    <div id="error-thoiGianBatDau" class="mess_error"></div>
                                    </div>
                                </div>
                                <div class="r">
                                <div class="w-260px">
                                    <span>Tài Khoản</span>
                            
                                <input class="a_form--input w-260px" type="text" value="${result.taiKhoan}" name="taiKhoan">
                                <div id="error-thoiGianBatDau" class="mess_error"></div>
                                </div>
                                <div class="w-260px">
                                    <span>Mật khẩu</span>
                        
                                <input class="a_form--input w-260px" type="text" value="${result.matKhau}" name="matKhau">
                                <div id="error-thoiGianBatDau" class="mess_error"></div>
                                </div>                                
                            </div>
                            <div class="r">
                                <div class="w-260px">
                                    <span>Email</span>
                                
                                <input class="a_form--input w-260px" type="email" value="${result.email}" name="email">
                                <div id="error-thoiGianBatDau" class="mess_error"></div>
                                </div>
                                <div class="w-260px">
                                    <span>Trạng thái</span>
                                	<c:if test="${result.status==1}">
                                	<c:set var = "status" value="Đang hoạt động"/>
                                	</c:if>
                                	<c:if test="${result.status==0}">
                                	<c:set var = "status" value="Tạm khóa"/>
                                	</c:if>
                                    <input class="a_form--input w-260px" type="text" value="${status}" name="status">
                                    <div id="error-thoiGianBatDau" class="mess_error"></div>
                                    </div>

                            </div>
                            <div>
                                <span>Thay đổi trạn thái người dùng</span>
                            
                                <div>
                                <select class="a_form--input w-176px" aria-label="Default select example" name="editStatus">
                                    <option value="2">Không thay đổi</option>
                                    <option value="1">Mở khóa tài khoản</option>
                                    <option value="0">Khóa tài khoản</option>
                                  </select>
                                  </div>

                            </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <input style="margin-left: 644px;" class="a-table__submit" type="submit" value="Lưu">
            </form>
             <a href="javascript:void(0)" style="margin-left: 644px;" class="a-table__submit a-table__submit-delete" onclick="confirmDelete(${result.idNguoiDung})"  >Xóa tài khoản</a>
        </div>
    </div>
        </div>
    </div>
</body>
<% } else {
	response.sendRedirect("/quanlythoigian/views/dangnhap.jsp");
} %>
</html>