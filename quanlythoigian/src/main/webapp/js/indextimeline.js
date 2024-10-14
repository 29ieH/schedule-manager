document.addEventListener("DOMContentLoaded", function() {
// Lấy tất cả các nút sửa
const editButtons = document.querySelectorAll('.hu-tl-body--timeline-icon.fa-pen');
// Lặp qua từng nút sửa và thêm sự kiện click cho mỗi nút
editButtons.forEach(editButton => {
  editButton.addEventListener('click',function(){
    // Tìm thẻ li cha gần nhất của nút sửa được nhấn
    const listItem = editButton.closest('.tl-body--content-item');
    // Tìm thẻ có class tl-body-on và tl-body-hide bên trong thẻ li
    const tlBodyOn = listItem.querySelector('.tl-body-on');
    const tlBodyHide = listItem.querySelector('.tl-body-hide');

    // Kiểm tra nếu tlBodyOn và tlBodyHide tồn tại
    if (tlBodyOn && tlBodyHide) {
      // Ẩn thẻ có class tl-body-on
      tlBodyOn.style.display = 'none';
      // Hiện thẻ có class tl-body-hide
      tlBodyHide.style.display = 'block';
    }
  });
});
});
function sendForm(button){
    var myForm = document.getElementById('myForm');
    var mess_error_tenSuKien = document.getElementById('error-tenSuKien');
    var mess_error_moTaNgan = document.getElementById('error-moTaNgan');
    var mess_error_diaChi = document.getElementById('error-diaChi');
    var mess_error_tgbd = document.getElementById('error-thoiGianBatDau');
    var mess_error_tgkt = document.getElementById('error-thoiGianKetThuc');
    var error = false;
    var idValue = document.getElementById('id').value;
    var tenSuKienValue = document.getElementById('tenSuKien').value;
    console.log(tenSuKienValue);
    var moTaValue = document.getElementById('moTaNgan').value;
      console.log(moTaValue);
    var diaChiValue = document.getElementById('diaChi').value;
    console.log(diaChiValue);
    var thoiGianBatDauValue = document.getElementById('thoiGianBatDau').value;
    console.log( thoiGianBatDauValue );
    var thoiGianKetThucValue = document.getElementById('thoiGianKetThuc').value;
    console.log(thoiGianKetThucValue);
    if(tenSuKienValue.trim().length<=0){
        error = true;
        mess_error_tenSuKien.innerHTML = 'Vui lòng nhập vào nội dung của bạn !';
    }
    if(moTaValue.trim().length<=0){
        error = true;
        mess_error_moTaNgan.innerHTML = 'Vui lòng nhập vào nội dung của bạn !';
    }
    if(diaChiValue.trim().length<=0){
        error = true;
        mess_error_diaChi.innerHTML = 'Vui lòng nhập vào nội dung của bạn !';
    }
    if(thoiGianBatDauValue.trim().length<=0){
        error = true;
        mess_error_tgbd.innerHTML = 'Vui lòng chọn thời gian bắt đầu !';
    }
    if(thoiGianKetThucValue.trim().length<=0){
        error = true;
        mess_error_tgkt.innerHTML = 'Vui lòng chọn thời gian kết thúc !';
    }
    if(thoiGianBatDauValue.trim().length>0&&thoiGianKetThucValue.trim().length>0){
        console.log('aaa')
        if(thoiGianBatDauValue>thoiGianKetThucValue){
            error = true;
            mess_error_tgbd.innerHTML = 'Thời gian không hợp lệ , vui lòng chọn lại !';
        }
    }
    console.log("aa");
    var tgbd = document.getElementById('thoiGianBatDau').value;
    var tgkt = document.getElementById('thoiGianKetThuc').value;
    if(!error){
    	const form = button.closest('form');
    	if(form){
    		form.submit();
    	}
//    	const url = `/quanlythoigian/edit-timeline?id=${idValue}&tenSuKien= ${tenSuKienValue}&moTaNgan=${encodeURIComponent(moTaValue)}&diaChi=${encodeURIComponent(diaChiValue)}&thoiGianBatDau=${encodeURIComponent(tgbd)}&thoiGianKetThuc=${encodeURIComponent(tgkt)}`;
//      myForm.submit();
//    	window.location.href = url;
    }
}
function sendFormz(){
    var myForm = document.getElementById('myFormz');
    var mess_error_tenSuKien = document.getElementById('error-tenSuKienz');
    var mess_error_moTaNgan = document.getElementById('error-moTaNganz');
    var mess_error_diaChi = document.getElementById('error-diaChiz');
    var mess_error_tgbd = document.getElementById('error-thoiGianBatDauz');
    var mess_error_tgkt = document.getElementById('error-thoiGianKetThucz');
    var error = false;
    var tenSuKienValue = document.getElementById('tenSuKienz').value;
    console.log(tenSuKienValue);
    var moTaValue = document.getElementById('moTaNganz').value;
      console.log(moTaValue);
    var diaChiValue = document.getElementById('diaChiz').value;
    console.log(diaChiValue);
    var thoiGianBatDauValue = document.getElementById('thoiGianBatDauz').value;
    console.log( thoiGianBatDauValue );
    var thoiGianKetThucValue = document.getElementById('thoiGianKetThucz').value;
    console.log(thoiGianKetThucValue);
    if(tenSuKienValue.trim().length<=0){
        error = true;
        mess_error_tenSuKien.innerHTML = 'Vui lòng nhập vào nội dung của bạn !';
    }
    if(moTaValue.trim().length<=0){
        error = true;
        mess_error_moTaNgan.innerHTML = 'Vui lòng nhập vào nội dung của bạn !';
    }
    if(diaChiValue.trim().length<=0){
        error = true;
        mess_error_diaChi.innerHTML = 'Vui lòng nhập vào nội dung của bạn !';
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
        if(thoiGianBatDauValue>=thoiGianKetThucValue){
            error = true;
            mess_error_tgbd.innerHTML = 'Thời gian không hợp lệ , vui lòng chọn lại !';
        }
    }
    console.log("aa");
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
	var isConfirmed = confirm("Bạn có chắc chắn muốn xóa hành động này không?");
	if(isConfirmed){
		window.location.href ="/quanlythoigian/timeline-delete?id="+id;
	}
}
function confirmComplete(id){
	var isConfirmed = confirm("Bạn có chắc chắn đã hoàn thành hoạt động này không?");
	if(isConfirmed){
		window.location.href = "/quanlythoigian/timeline-complete?id="+id;
	}
	
}