// File: calendar.js
let currentMonth = new Date().getMonth() + 1;
let currentYear = new Date().getFullYear();
let events = [
  { day: 5, month:11, content: 'Event 1' },
  { day: 5,  month:12, content: 'Event 3' },
  { day: 15,  month:11, content: 'Event 2' },
];

function openModal(day) {
  const eventDate = new Date(Date.UTC(currentYear, currentMonth - 1, day));
  document.getElementById("eventDate").valueAsDate = eventDate;
  document.getElementById("eventModal").style.display = "block";
}

function closeModal() {
  document.getElementById("eventModal").style.display = "none";
}

// function registerEvent() {
//   const check = true;
//   const form = document.getElementById("eventForm");
//   const eventName = document.getElementById("eventName").value;
//   const eventContent = document.getElementById("contentEvent").value;
//   const timeOpen = document.getElementById("dateTimeOpen").value;
//   const timeEnd = document.getElementById("dateTimeEnd").value;
//   const numberRepeat = document.getElementById("eventDate").value;
//   const eventDate = document.getElementById("numberRepeat").value;
//   if(eventName.trim().length<=0){
//     check = false;
//   }
//   if(eventContent.trim().length<=0){
//     check = false;
//   }
//   if(numberRepeat.trim().length<=0){
//     check = false;
//   }
//   if(eventDate.trim().length<=0){
//     check = false;
//   }
//   if(timeOpen>=timeEnd){
//     check = false;
//   }
//   if(check){
//     form.onsubmit();
//   }
//   closeModal();
// }
function registerEvent_Plus() {
  const check = true;
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
  if(timeOpen>=timeEnd){
    check = false;
  }
  if(check){
    var formData = new FormData(document.getElementById("eventForm"));
    var xhr = new XMLHttpRequest();
    xhr.open("POST","/quanlythoigian/")
  }
  closeModal();
}

function renderCalendar(month, year) {
  let calendarContent = '';
  let daysInMonth = new Date(year, month, 0).getDate();
  let firstDayOfWeek = new Date(year, month - 1, 1).getDay();
  calendarContent += '<table>';
  calendarContent += '<tr><th>Sun</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th></tr>';
  calendarContent += '<tr>';
  for (let i = 0; i < 42; i++) {
    let day = i - firstDayOfWeek + 1;
    let eventsOnDay = events.filter(e => e.day === day && e.month == currentMonth);
    console.log(eventsOnDay);
    if (i < firstDayOfWeek || day > daysInMonth) {
      calendarContent += '<td></td>';
    } else {
      calendarContent += '<td>';
      if (eventsOnDay.length > 0) {
        calendarContent += '<div class="event-container-calendar">';
        eventsOnDay.forEach(element => {
          calendarContent += `<div class="event-calendar"><a href="zkzk.com">${element.content}</a></div>`;
        });
        calendarContent += '</div>';
      } else {
        calendarContent += `<button style="width: 122px;height: 80px; background:none; border : none; color:white;" onclick="openModal(${day})">${day}</button>`;
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
  document.getElementById("month-year").innerText = `${getMonthName(month)} ${year}`;
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

function getMonthName(month) {
  const monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
  return monthNames[month - 1];
}

// Initial rendering
renderCalendar(currentMonth, currentYear);
