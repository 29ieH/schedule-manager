function sendForm(){
    var myForm = document.getElementById('myForm');
    var mess_error_thu = document.getElementById('error-thu');
    var mess_error_nd = document.getElementById('error-noiDung');
    var mess_error_tgbd = document.getElementById('error-thoiGianBatDau');
    var mess_error_tgkt = document.getElementById('error-thoiGianKetThuc');
    var error = false;
    var thuValue = document.getElementById('thu').value;
    console.log(thuValue);
    var noiDungValue = document.getElementById('noiDung').value;
      console.log(noiDungValue);
    var thoiGianBatDauValue = document.getElementById('thoiGianBatDau').value;
    console.log( thoiGianBatDauValue );
    var thoiGianKetThucValue = document.getElementById('thoiGianKetThuc').value;
    console.log(thoiGianKetThucValue);
    if(thuValue.trim().length<=0||thuValue == 'Vui lòng chọn'){
        error = true;
        mess_error_thu.innerHTML = 'Vui lòng chọn thứ ngày đễ lên lịch !';
    }
    if(noiDungValue.trim().length<=0){
        error = true;
        mess_error_nd.innerHTML = 'Vui lòng nhập vào nội dung của bạn !';
    }
    if(thoiGianBatDauValue.trim().length<=0){
        error = true;
        mess_error_tgbd.innerHTML = 'Vui lòng chọn thời gian bắt đầu !';
    }else{
        document.getElementById('thoiGianBatDau').value = thoiGianBatDauValue;
    }
    if(thoiGianKetThucValue.trim().length<=0){
        error = true;
        mess_error_tgkt.innerHTML = 'Vui lòng chọn thời gian kết thúc !';
    }else{
        document.getElementById('thoiGianKetThuc').value = thoiGianKetThucValue;
    }
    if(thoiGianBatDauValue.trim().length>0&&thoiGianKetThucValue.trim().length>0){
        console.log('aaa')
        if(thoiGianBatDauValue>thoiGianKetThucValue){
            error = true;
            mess_error_tgbd.innerHTML = 'Thời gian không hợp lệ , vui lòng chọn lại !';
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