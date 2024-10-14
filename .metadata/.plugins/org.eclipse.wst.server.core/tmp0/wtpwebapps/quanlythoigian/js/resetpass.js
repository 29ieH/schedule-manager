function mySubmit(){
     var myForm = document.getElementById('myForm');
    var mess_error_currentpass = document.getElementById('error-currentpass');
    var mess_error_newpass = document.getElementById('error-newpass');
    var mess_error_reenterpass = document.getElementById('error-re-enterpass');
    var error = false;
    var currentPassValue = document.getElementById('currentpass').value;
    console.log(currentPassValue);
    var newPassValue = document.getElementById('newpass').value;
      console.log(newPassValue);
    var reenterpassValue = document.getElementById('re-enterpass').value;
    console.log( reenterpassValue);
    if(currentPassValue.trim().length<=0){
        error = true;
        mess_error_currentpass.innerHTML = "Mật khẩu không được bỏ trống";
    }
    if(newPassValue.trim().length<=0){
        error = true;
        mess_error_newpass.innerHTML = "Mật khẩu không được bỏ trống";
    }
    if(reenterpassValue.trim().length<=0){
        error = true;
        mess_error_reenterpass.innerHTML = "Mật khẩu không được bỏ trống";
    }else{
        if(newPassValue!==reenterpassValue){
            error = true;
            mess_error_reenterpass.innerHTML = "Mật khẩu không khớp !";
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