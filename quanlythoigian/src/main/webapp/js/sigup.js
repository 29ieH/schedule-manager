function isValidEmail(email) {
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailPattern.test(email);
  }
function sendForm(){
    var myForm = document.getElementById('myForm');
    var mess_error_name = document.getElementById('error-hoVaTen');
    var mess_error_email = document.getElementById('error-email');
    var mess_error_tk = document.getElementById('error-taiKhoan');
    var mess_error_pw = document.getElementById('error-matKhau');
    var mess_error_npw = document.getElementById('error-nhapLaiMatKhau');
    var mess_error_date = document.getElementById('error-ngaySinh');
    var mess_error_gioitinh = document.getElementById('error-gioiTinh');
    var mess_error_diachi = document.getElementById('error-diaChi');
    var error = false;
    var hvtValue = document.getElementById('hoVaTen').value;
    console.log(hvtValue);
    var emailValue = document.getElementById('email').value;
    console.log(emailValue);
    var taiKhoanValue = document.getElementById('taiKhoan').value;
    console.log(taiKhoanValue);
    var matKhauValue = document.getElementById('matKhau').value;
      console.log(matKhauValue);
      var nhapLaiMatKhauValue = document.getElementById('nhapLaiMatKhau').value;
      console.log(nhapLaiMatKhauValue);
      var ngaySinhValue = document.getElementById('ngaySinh').value;
      console.log(ngaySinhValue);
      var gioiTinhValue = document.getElementById('gioiTinh').value;
      console.log(gioiTinhValue);
      var diaChiValue = document.getElementById('diaChi').value;
      console.log(diaChiValue);
    if(hvtValue.trim().length<=0){
        error = true;
        mess_error_name.innerHTML = 'Vui lòng nhập vào tên của bạn !';
    }
    if(emailValue.trim().value<=0){
        error = true;
        mess_error_email.innerHTML = 'Vui lòng nhập email của bạn !';
    }else{
        if(!isValidEmail(emailValue)){
            error = true;
            mess_error_email.innerHTML = 'Địa chỉ email không hợp lệ !';
        }
    }
    if(taiKhoanValue.trim().length<=0){
        error = true;
        mess_error_tk.innerHTML = 'Vui lòng nhập tài khoản của bạn !';
    }
    if(matKhauValue.trim().length<=0){
        error = true;
        mess_error_pw.innerHTML = "Vui lòng nhập mật khẩu của bạn !";
    }
    if(nhapLaiMatKhauValue.trim().length<=0){
        error = true;
        mess_error_npw.innerHTML = 'Vui lòng nhập lại mật khẩu của bạn!';
    }else{
        if(matKhauValue!==nhapLaiMatKhauValue){
            error = true;
            mess_error_npw.innerHTML = 'Mật khẩu của bạn không khớp !';
        }
    }
    if(ngaySinhValue.trim().length<=0){
        error = true;
        mess_error_date.innerHTML = 'Vui lòng nhập ngày sinh của bạn !';
    }
    if(gioiTinhValue.trim().length<=0||gioiTinhValue=='Chọn giới tính'){
        error = true;
        mess_error_gioitinh.innerHTML = 'Vui lòng chọn giới tính của bạn !';
    }
    if(diaChiValue.trim().length<=0){
        error = true;
        mess_error_diachi.innerHTML = 'Vui lòng nhập địa chỉ của bạn !';
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
function myblur(id){
    var idError = "error-"+id;
    var mess = document.getElementById(idError);
    var element = document.getElementById(id).value;
    if(element.trim().length>0){
        mess.innerHTML = "";
    }
}