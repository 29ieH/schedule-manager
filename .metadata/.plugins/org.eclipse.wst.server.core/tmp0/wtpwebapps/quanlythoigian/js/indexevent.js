document.addEventListener("DOMContentLoaded", function () {
    var eventSelector = document.getElementById("eventSelector");
    var events = document.querySelectorAll(".event.hoc-tap");
  
    // Tự động chọn tùy chọn "Học tập"
    eventSelector.value = "hoc-tap";
  
    // Hiển thị các sự kiện "Học tập" ban đầu
    events.forEach(function (event) {
      event.style.display = "block";
    });
    // Lắng nghe sự kiện thay đổi của người dùng
    eventSelector.addEventListener("change", function () {
      var selectedValue = this.value;
      var allEvents = document.querySelectorAll(".event");
      // Ẩn tất cả các sự kiện
      allEvents.forEach(function (event) {
        event.style.display = "none";
      });
      // Hiển thị các sự kiện thuộc loại được chọn
      var selectedEvents = document.querySelectorAll("." + selectedValue);
      selectedEvents.forEach(function (event) {
        event.style.display = "block";
      });
    });
  });
function confirmDelete(id){
	var isConfirmed = confirm("Bạn có chắc chắn xóa sự kiện này không?");
	if(isConfirmed){
		window.location.href ="/quanlythoigian/delete-sukien?id="+id;
	}
}
  // Time line
  