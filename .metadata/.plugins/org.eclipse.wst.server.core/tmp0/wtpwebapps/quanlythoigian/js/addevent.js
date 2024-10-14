function timeHenGio(input){
    validFormat = /^(\d+h)?\d+p$/;
    return validFormat.test(input);
}
function sendForm(){
    var myForm = document.getElementById('myForm');
    var mess_error_name = document.getElementById('error-tenSuKien');
    var mess_error_moTa = document.getElementById('error-moTa');
    var mess_error_date = document.getElementById('error-ngay');
    var mess_error_tgbd = document.getElementById('error-thoiGianBatDau');
    var mess_error_tgkt = document.getElementById('error-thoiGianKetThuc');
    var mess_error_diaDiem = document.getElementById('error-diaDiem');
    var mess_error_henGio = document.getElementById('error-henGio');
    var mess_error_loaiSuKien = document.getElementById('error-loaiSuKien');
    var error = false;
    var tenSuKienValue = document.getElementById('tenSuKien').value;
    var moTaValue = document.getElementById('moTa').value;
    var dateValue = document.getElementById('ngay').value;
    var tgbdValue = document.getElementById('thoiGianBatDau').value;
    var tgktValue = document.getElementById('thoiGianKetThuc').value;
    var diaDiemValue = document.getElementById('diaDiem').value;
    var henGioValue = document.getElementById('henGio').value;
    var loaiSuKienValue = document.getElementById('loaiSuKien').value;
    if(tenSuKienValue.trim().length<=0){
        error = true;
        mess_error_name.innerHTML = 'Vui lòng nhập vào tên sự kiện của bạn !';
    }
    if(moTaValue.trim().length<=0){
        error = true;
        mess_error_moTa.innerHTML = 'Vui lòng nhập mô tả về sự kiện của bạn !';
    }
    if(dateValue.trim().length<=0){
        error = true;
        mess_error_date.innerHTML = 'Vui lòng nhập ngày diễn ra sự kiện của bạn !';
    }
    if(tgbdValue.trim().length<=0){
        error = true;
        mess_error_tgbd.innerHTML = "Vui lòng nhập vào thời gian bắt đầu !";
    }else{
    	document.getElementById('thoiGianBatDau').value = tgbdValue;
    }
    if(tgktValue.trim().length<=0){
        error = true;
        mess_error_tgkt.innerHTML = 'Vui lòng nhập vào thời gian kết thúc !';
    }else{
    	document.getElementById('thoiGianKetThuc').value = tgktValue;
    }
    if (tgbdValue.length > 0 && tgktValue.length > 0) {
        var tgbdDate = new Date("2000-01-01T" + tgbdValue);
        var tgktDate = new Date("2000-01-01T" + tgktValue);
        if (tgbdDate >= tgktDate) {
            error = true;
            mess_error_tgbd.innerHTML = "Thời gian không hợp lệ!";
        }
    }
    if(diaDiemValue.trim().length<=0){
        error = true;
        mess_error_diaDiem.innerHTML = 'Vui lòng nhập vào địa chỉ diễn ra sự kiện !';
    }
    if(henGioValue.trim().length<=0){
        error = true;
        mess_error_henGio.innerHTML = 'Vui lòng chọn thời gian nhắc nhở !';
    }else{
        if(!timeHenGio(henGioValue)){
            error = true;
            mess_error_henGio.innerHTML = 'Định dạng không hợp lệ , Vui lòng nhập (5p || 1h30p) !';
        }
    }
    if(loaiSuKienValue.trim().length<=0||loaiSuKienValue==='Chọn loại sự kiện'){
        error = true;
        mess_error_loaiSuKien.innerHTML = 'Vui lòng chọn loại sự kiện của bạn !';
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