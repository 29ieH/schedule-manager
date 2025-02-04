<%@ page import="model.lich" %>
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
	<style type="text/css">
	         table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th{
          text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }
        #calendar{
            margin-top: 26px;
            padding: 20px 30px;
        }
	</style>
</head>
<%
	session = request.getSession(false);
	String userName = (String)session.getAttribute("userName");
	String nofication = (String)request.getAttribute("nofication");
	if(session!=null&&userName!=null){
%>
<c:set var = "listCalendar" value = "${listCalendar}"/>
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
        <div class="hu-body">
            <h6 class="hu-body--heading">
                Lịch
            </h6>  
            <div class="hu-table">
            <p class="body-nextmonth">
                <button class="btn-calendar" onclick="previousMonth()">Previous Month</button>
                <button class="btn-calendar" onclick="nextMonth()">Next Month</button>
            </p>

  <h2 id="month-year"></h2>
  <div id="calendar"></div>

  <!-- Event Registration Modal -->
  <div id="eventModal">
    <h3 class="eventModal-heading">Đăng ký lịch</h3>
    <form id="eventForm" action="<c:url value="/add-calendar"/>" method="post">
    <div id="error-notifi" class="mess_error"></div>
    <div class="eventForm-input">
        <label for="eventName">Tên sự kiện*</label>
        <input class="eventForm-input-text" type="text" id="eventName" name="eventName" required>
    </div>
    <div class="eventForm-input">
        <label for="contetEvent">Nội dung sự kiện*</label>
        <input class="eventForm-input-text" type="text" id="contentEvent" name="contentEvent" required>
    </div>
    <div class="eventForm-input">
        <label for="eventTimeOpen">Bắt đầu vào lúc</label>
        <input type="time" id="dateTimeOpen" name="dateTimeOpen">
        <label for="eventTimeEnd">Kết thúc vào lúc</label>
        <input type="time" id="dateTimeEnd" name="dateTimeEnd">
    </div>
    <label for="eventDate">Thời gian*</label>
        <input type="date" id="eventDate" name="dateEvent" required>
    <div class="eventForm-input">
        <label for="numberRepeat">Số lần lặp trong tuần</label>
        <input style="width: 50px;" class="eventForm-input-text" type="number" id="numberRepeat" name="numberRepeat" required placeholder="1" min="1" value="1" >
    </div>
      <button class="btn-calendar" type="button" onclick="registerEvent()">Đăng ký</button>
      <button class="eventForm-close" type="button" onclick="closeModal()"><i class="fa-solid fa-circle-xmark"></i></button>
    </form>
  </div>
           </div>
        </div>
    </div>
    </div>
   </div>
   <script>
   let currentMonth = new Date().getMonth() + 1;
   let currentYear = new Date().getFullYear();
   <c:if test="${listCalendar.size()<=0}" >
   let events = [];
   </c:if>
   <c:if test="${listCalendar.size()>0}" >
   let events = [
	   <c:forEach var="item" items="${listCalendar}" varStatus="loop">
       { id : ${item.idLich},name: '${item.tenSuKien}', day: ${item.ngay}, month: ${item.thang}, year: ${item.nam} }<c:if test="${!loop.last}">,</c:if>
     </c:forEach>
   ];
   </c:if>
   console.log(events);
   function openModal(day) {
     const eventDate = new Date(Date.UTC(currentYear, currentMonth - 1, day));
     document.getElementById("eventDate").valueAsDate = eventDate;
     document.getElementById("eventModal").style.display = "block";
   }
   function closeModal() {
     document.getElementById("eventModal").style.display = "none";
   }

   function registerEvent() {
     let check = true;
     var diverror = document.getElementById("error-notifi");
     const form = document.getElementById("eventForm");
     const eventName = document.getElementById("eventName").value;
     const eventContent = document.getElementById("contentEvent").value;
     const timeOpen = document.getElementById("dateTimeOpen").value;
     const timeEnd = document.getElementById("dateTimeEnd").value;
     const numberRepeat = document.getElementById("eventDate").value;
     const eventDate = document.getElementById("numberRepeat").value;
     if(eventName.trim().length<=0){
       check = false;
     }
     if(eventContent.trim().length<=0){
       check = false;
     }
     if(numberRepeat.trim().length<=0){
       check = false;
     }
     if(eventDate.trim().length<=0){
       check = false;
     }
     if(timeOpen.length>0&&timeEnd.length>0){
    	 if(timeOpen>=timeEnd){
    		 check = false; 
    	 }
     }
     console.log(check);
     if(check){
       form.submit();
       closeModal();
     }else{
        diverror.innerHTML = "Vui lòng không bỏ trống các trường *!";
     }
   }
   function getMonthName(month) {
	     const monthNames = ["January", "February", "March", "April", "May","June", "July", "August", "September", "October", "November", "December"];
	     return monthNames[month - 1];
	}
   function renderCalendar(month, year) {
	 let plus = '+';
     let calendarContent = '';
     let daysInMonth = new Date(year, month, 0).getDate();
     let firstDayOfWeek = new Date(year, month - 1, 1).getDay();
     calendarContent += '<table>';
     calendarContent += '<tr><th>Sun</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th></tr>';
     calendarContent += '<tr>';
     for (let i = 0; i < 42; i++) {
       let day = i - firstDayOfWeek + 1;
       let eventsOnDay = events.filter(e => e.day === day && e.month === currentMonth && e.year === year);
       console.log(eventsOnDay);
       if (i<firstDayOfWeek || day>daysInMonth) {
         calendarContent += '<td></td>';
       } else {
         calendarContent += '<td>';
         if (eventsOnDay.length > 0) {
           calendarContent += '<div class="event-container-calendar">';
           eventsOnDay.forEach(element => {
        	 console.log(element.name);
        	 calendarContent += '<div class="event-calendar"><a class ="calendar-link" href="<c:url value="/view-calendar?id='+element.id+'"/>">'+ element.name +'</a></div>';
           });
           let thisday = day;
           calendarContent += '<button class ="event-plus-btn" onclick="openModal('+thisday+')"><i class="fa-solid fa-plus"></i></button>';
           calendarContent += '</div>';
         } else {
        	 let thisday = day;
        	 calendarContent += '<button style="width: 122px;height: 80px; background:none; border : none; color:white;" onclick="openModal('+thisday+')">'+day+'</button>';
         }
         calendarContent += '</td>';
       }

       if (i % 7 === 6) {
         calendarContent += '</tr>';
         if (day > daysInMonth) {
           break;
         }
         calendarContent += '<tr>';
       }
     }

     calendarContent += '</table>';
     document.getElementById("calendar").innerHTML = calendarContent;
     document.getElementById("month-year").innerText = getMonthName(month)+" "+year;
   }

   function nextMonth() {
     currentMonth++;
     if (currentMonth > 12) {
       currentMonth = 1;
       currentYear++;
     }
     console.log("Next Month:", currentMonth, currentYear);
     renderCalendar(currentMonth, currentYear);
   }

   function previousMonth() {
     currentMonth--;
     if (currentMonth < 1) {
       currentMonth = 12;
       currentYear--;
     }
     console.log("Previous Month:", currentMonth, currentYear);
     renderCalendar(currentMonth, currentYear);
   }
   // Initial rendering
   renderCalendar(currentMonth, currentYear);
   </script>
</body>
<% } else {
	response.sendRedirect("/quanlythoigian/views/dangnhap.jsp");
} %>
</html>