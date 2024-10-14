function sendForm(){
    var myForm = document.getElementById('myForm');
    var mess_error_name = document.getElementById('error-tenSuKien');
    var mess_error_moTa = document.getElementById('error-noiDung');
    var mess_error_day = document.getElementById('error-day');
    var mess_error_month = document.getElementById('error-month');
    var mess_error_year = document.getElementById('error-year');
    var mess_error_tgbd = document.getElementById('error-thoiGianBatDau');
    var mess_error_tgkt = document.getElementById('error-thoiGianKetThuc');
    var error = false;
    var tenSuKienValue = document.getElementById('tenSuKien').value;
    var moTaValue = document.getElementById('noiDung').value;
    var dayValue = document.getElementById('day').value;
    var monthValue = document.getElementById('month').value;
    var yearValue = document.getElementById('year').value;
    var tgbdValue = document.getElementById('thoiGianBatDau').value;
    var tgktValue = document.getElementById('thoiGianKetThuc').value;
    if(tenSuKienValue.trim().length<=0){
        error = true;
        mess_error_name.innerHTML = 'Vui lòng nhập vào tên sự kiện của bạn !';
    }
    if(moTaValue.trim().length<=0){
        error = true;
        mess_error_moTa.innerHTML = 'Vui lòng nhập mô tả về sự kiện của bạn !';
    }
    if(dayValue.trim().length<=0){
        error = true;
        mess_error_day.innerHTML += 'Vui lòng nhập ngày diễn ra sự kiện của bạn !';
    }
    if(monthValue.trim().length<=0){
        error = true;
        mess_error_month.innerHTML = 'Vui lòng nhập tháng diễn ra sự kiện của bạn !';
    }
    if(yearValue.trim().length<=0){
        error = true;
        mess_error_year.innerHTML = 'Vui lòng nhập năm diễn ra sự kiện của bạn !';
    }
    if(tgbdValue.trim().length<=0){
        error = true;
        mess_error_tgbd.innerHTML = "Vui lòng nhập vào thời gian bắt đầu !";
    }
    if(tgktValue.trim().length<=0){
        error = true;
        mess_error_tgkt.innerHTML = 'Vui lòng nhập vào thời gian kết thúc !';
    }
    if (tgbdValue.length > 0 && tgktValue.length > 0) {
        var tgbdDate = new Date("2000-01-01T" + tgbdValue);
        var tgktDate = new Date("2000-01-01T" + tgktValue);
        if (tgbdDate >= tgktDate) {
            error = true;
            mess_error_tgbd.innerHTML = "Thời gian không hợp lệ!";
        }
    }
    if(!error){
        myForm.submit();
    }
}
function myblur(id){
    var idError = "error-"+id;
    var mess = document.getElementById(idError);
    var element = document.getElementById(id).value;
    if(element.trim().length>0){
        mess.innerHTML = "";
    }
}
function confirmDelete(id){
    var result = confirm("Bạn có chắc chắn muốn xóa sự kiện này không ?");
    if(result){
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/quanlythoigian/delete-calendar?id="+encodeURIComponent(id);
        xhr.open("GET",url,true);
        xhr.send();
        window.location.href = "/quanlythoigian/data-calendar";
    }
}