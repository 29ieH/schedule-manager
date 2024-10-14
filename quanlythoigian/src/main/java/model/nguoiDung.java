package model;

import java.sql.Date;

public class nguoiDung extends abstractModel{
	private int idNguoiDung;
	private int idRole;
	private String hoVaTen;
	private String taiKhoan;
	private String matKhau;
	private String email;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private int status;
	public nguoiDung() {}
	
	
	
	public nguoiDung(int idNguoiDung, int idRole, String hoVaTen, String taiKhoan, String matKhau, String email,
			Date ngaySinh, String gioiTinh, String diaChi,int status) {
		super();
		this.idNguoiDung = idNguoiDung;
		this.idRole = idRole;
		this.hoVaTen = hoVaTen;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.status = status;
	}

	public nguoiDung(int idNguoiDung, int idRole, String hoVaTen, String taiKhoan, String matKhau, String email,
			Date ngaySinh, String gioiTinh, String diaChi,int status,Date ngayTao,Date ngayCapNhap) {
		super();
		this.idNguoiDung = idNguoiDung;
		this.idRole = idRole;
		this.hoVaTen = hoVaTen;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.status = status;
		this.ngayTao = ngayTao;
		this.ngayCapNhap = ngayCapNhap;
	}

	public int getIdNguoiDung() {
		return idNguoiDung;
	}
	public void setIdNguoiDung(int idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "nguoiDung [idNguoiDung=" + idNguoiDung + ", idRole=" + idRole + ", hoVaTen=" + hoVaTen + ", taiKhoan="
				+ taiKhoan + ", matKhau=" + matKhau + ", email=" + email + ", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + ", diaChi=" + diaChi + "]";
	}

}
