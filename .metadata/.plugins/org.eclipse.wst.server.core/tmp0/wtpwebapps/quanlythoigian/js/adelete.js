function confirmDelete(id){
	var isConfirmed = confirm("Bạn chắc chắn muốn xóa người dùng này?");
	if(isConfirmed){
		window.location.href = "/quanlythoigian/a-delete-user?id="+id;
	}
}
