function sendForm(){
    var myForm = document.getElementById('myForm');
    var mess_error_tk = document.getElementById('error-taiKhoan');
    var mess_error_pw = document.getElementById('error-matKhau');
    var mess_error_check = document.getElementById('error-dieuKhoan');
    var error = false;
    var taiKhoanValue = document.getElementById('taiKhoan').value;
    console.log(taiKhoanValue);
    var matKhauValue = document.getElementById('matKhau').value;
      console.log(matKhauValue);
    var checkDieuKien = document.getElementById('dieuKhoan');
    console.log(checkDieuKien);
    if(taiKhoanValue.trim().length<=0){
        error = true;
        mess_error_tk.innerHTML = 'Vui lòng nhập tài khoản của bạn !';
    }
    if(matKhauValue.trim().length<=0){
        error = true;
        mess_error_pw.innerHTML = "Vui lòng nhập mật khẩu của bạn !";
    }
    if(!checkDieuKien.checked){
        error = true;
        mess_error_check.innerHTML = "Vui lòng đồng ý để tiếp tục !";
    }
    if(!error){
        myForm.submit();
    }
    console.log("aaaa");
}
function myblur(id){
    var idError = "error-"+id;
    var mess = document.getElementById(idError);
    var element = document.getElementById(id).value;
    if(element.trim().length>0){
        mess.innerHTML = "";
    }
}