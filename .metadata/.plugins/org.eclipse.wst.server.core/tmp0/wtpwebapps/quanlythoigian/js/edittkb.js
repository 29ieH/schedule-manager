document.addEventListener('DOMContentLoaded', function() {
    const editIcons = document.querySelectorAll('.btn.fa-solid.fa-pen-to-square.color-util');

    editIcons.forEach(editIcon => {
        editIcon.addEventListener('click', () => {
            // Tìm phần tử cha gần nhất có class "hu-table--column"
            const parentColumn = editIcon.closest('.hu-table--column');
    
            // Tìm các phần tử con cần ẩn và hiện
            const columnContent = parentColumn.querySelector('.hu-table--column-content');
            const columnEdit = parentColumn.querySelector('.hu-table--column-edit');
    
            // Ẩn phần tử content và hiện phần tử edit
            columnContent.style.display = 'none';
            columnEdit.style.display = 'block';
        });
    });
});
function sendForm(event) {
    // Lấy nút "Lưu" mà người dùng đã bấm
    var saveButton = event.currentTarget;

    // Tìm phần tử chứa dữ liệu biểu mẫu (container)
    var container = saveButton.closest('.data-container');

    // Lấy các phần tử cần thiết trong container
    var myForm = document.getElementById('myForm');
    console.log(myForm);
    var messErrorNoidung = container.querySelector('#error-noiDung');
    var messErrorThoiGianBatDau = container.querySelector('#error-thoiGianBatDau');
    var messErrorThoiGianKetThuc = container.querySelector('#error-thoiGianKetThuc');
    var noiDungInput = container.querySelector('#noiDung');
    var thoiGianBatDauInput = container.querySelector('#thoiGianBatDau');
    var thoiGianKetThucInput = container.querySelector('#thoiGianKetThuc');
    var id = container.querySelector('#id');
    var thu = container.querySelector('#thu');
    // Khởi tạo biến lỗi
    var error = false;

    // Lấy giá trị từ các trường dữ liệu
    var noiDungValue = noiDungInput.value;
    var thoiGianBatDauValue = thoiGianBatDauInput.value;
    var thoiGianKetThucValue = thoiGianKetThucInput.value;
    var idValue = id.value;
    var thuValue = thu.value;
    // Xử lý kiểm tra lỗi
    if (noiDungValue.trim().length <= 0) {
        error = true;
        messErrorNoidung.innerHTML = 'Vui lòng nhập nội dung của bạn!';
    }else{
    	noiDungInput.value = noiDungValue;
    }
    if (thoiGianBatDauValue.trim().length <= 0) {
        error = true;
        messErrorThoiGianBatDau.innerHTML = 'Vui lòng nhập thời gian bắt đầu!';
    }else{
    	thoiGianBatDauInput.value = thoiGianBatDauValue;
    }
    if (thoiGianKetThucValue.trim().length <= 0) {
        error = true;
        messErrorThoiGianKetThuc.innerHTML = 'Vui lòng nhập thời gian kết thúc!';
    }else{
    	thoiGianKetThucInput.value = thoiGianKetThucValue;
    }
    if (thoiGianBatDauValue.trim().length > 0 && thoiGianKetThucValue.trim().length > 0) {
        if (thoiGianBatDauValue >= thoiGianKetThucValue) {
            error = true;
            messErrorThoiGianBatDau.innerHTML = 'Thời gian không hợp lệ!';
        }
    }
    var tgbd = thoiGianBatDauInput.value;
    var tgkt = thoiGianKetThucInput.value;
    // Nếu không có lỗi, gửi biểu mẫu
    if (!error) {
    	const url = `/quanlythoigian/sua-thoi-khoa-bieu?id=${idValue}&thu= ${thuValue} &noiDung=${encodeURIComponent(noiDungValue)}&thoiGianBatDau=${encodeURIComponent(tgbd)}&thoiGianKetThuc=${encodeURIComponent(tgkt)}`;
//        myForm.submit();
    	window.location.href = url;
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
function confirmDelete(id) {
    console.log("check");
    var isConfirmed = confirm("Bạn có chắc chắn muốn xóa lịch không?");
    if (isConfirmed) {
        window.location.href = "/quanlythoigian/xoa-lich?id=" + id;
    }
}