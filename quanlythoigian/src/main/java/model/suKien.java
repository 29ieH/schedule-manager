package model;

import java.sql.Date;
import java.sql.Time;

public class suKien extends abstractModel{
	private int idSuKien;
	private int idUser;
	private String tenSuKien;
	private String moTaNgan;
	private Date ngayDienRaSuKien;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	private String diaDiem;
	private int henGioTruocSuKien;
	private String nhungNguoiThamGia;
	private String loaiSuKien;
	private int suKienUuTien;
	private int hoanThanh;
	public suKien() {}
	
	public suKien(int idSuKien, int idUser, String tenSuKien, String moTaNgan, Date ngayDienRaSuKien,
			Time thoiGianBatDau, Time thoiGianKetThuc, String diaDiem, int henGioTruocSuKien, String nhungNguoiThamGia,
			String loaiSuKien, int suKienUuTien,int hoanThanh,Date ngayTao,Date ngayCapNhap) {
		super();
		this.idSuKien = idSuKien;
		this.idUser = idUser;
		this.tenSuKien = tenSuKien;
		this.moTaNgan = moTaNgan;
		this.ngayDienRaSuKien = ngayDienRaSuKien;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.diaDiem = diaDiem;
		this.henGioTruocSuKien = henGioTruocSuKien;
		this.nhungNguoiThamGia = nhungNguoiThamGia;
		this.loaiSuKien = loaiSuKien;
		this.suKienUuTien = suKienUuTien;
		this.hoanThanh = hoanThanh;
		this.ngayTao = ngayTao;
		this.ngayCapNhap = ngayCapNhap;
	}
	
	


	public suKien(int idSuKien, int idUser, String tenSuKien, String moTaNgan, Date ngayDienRaSuKien,
			Time thoiGianBatDau, Time thoiGianKetThuc, String diaDiem, int henGioTruocSuKien, String nhungNguoiThamGia,
			String loaiSuKien, int suKienUuTien,int hoanThanh) {
		super();
		this.idSuKien = idSuKien;
		this.idUser = idUser;
		this.tenSuKien = tenSuKien;
		this.moTaNgan = moTaNgan;
		this.ngayDienRaSuKien = ngayDienRaSuKien;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.diaDiem = diaDiem;
		this.henGioTruocSuKien = henGioTruocSuKien;
		this.nhungNguoiThamGia = nhungNguoiThamGia;
		this.loaiSuKien = loaiSuKien;
		this.suKienUuTien = suKienUuTien;
		this.hoanThanh = hoanThanh;
	}

	public int getIdSuKien() {
		return idSuKien;
	}
	public void setIdSuKien(int idSuKien) {
		this.idSuKien = idSuKien;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getTenSuKien() {
		return tenSuKien;
	}
	public void setTenSuKien(String tenSuKien) {
		this.tenSuKien = tenSuKien;
	}
	public String getMoTaNgan() {
		return moTaNgan;
	}
	public void setMoTaNgan(String moTaNgan) {
		this.moTaNgan = moTaNgan;
	}
	public Date getNgayDienRaSuKien() {
		return ngayDienRaSuKien;
	}
	public void setNgayDienRaSuKien(Date ngayDienRaSuKien) {
		this.ngayDienRaSuKien = ngayDienRaSuKien;
	}
	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public Time getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(Time thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public int getHenGioTruocSuKien() {
		return henGioTruocSuKien;
	}
	public void setHenGioTruocSuKien(int henGioTruocSuKien) {
		this.henGioTruocSuKien = henGioTruocSuKien;
	}
	public String getNhungNguoiThamGia() {
		return nhungNguoiThamGia;
	}
	public void setNhungNguoiThamGia(String nhungNguoiThamGia) {
		this.nhungNguoiThamGia = nhungNguoiThamGia;
	}
	public String getLoaiSuKien() {
		return loaiSuKien;
	}
	public void setLoaiSuKien(String loaiSuKien) {
		this.loaiSuKien = loaiSuKien;
	}
	public int getSuKienUuTien() {
		return suKienUuTien;
	}
	public void setSuKienUuTien(int suKienUuTien) {
		this.suKienUuTien = suKienUuTien;
	}
	
	public int getHoanThanh() {
		return hoanThanh;
	}

	public void setHoanThanh(int hoanThanh) {
		this.hoanThanh = hoanThanh;
	}

	@Override
	public String toString() {
		return "suKien [idSuKien=" + idSuKien + ", idUser=" + idUser + ", tenSuKien=" + tenSuKien + ", moTaNgan="
				+ moTaNgan + ", ngayDienRaSuKien=" + ngayDienRaSuKien + ", thoiGianBatDau=" + thoiGianBatDau
				+ ", thoiGianKetThuc=" + thoiGianKetThuc + ", diaDiem=" + diaDiem + ", henGioTruocSuKien="
				+ henGioTruocSuKien + ", nhungNguoiThamGia=" + nhungNguoiThamGia + ", loaiSuKien=" + loaiSuKien
				+ ", suKienUuTien=" + suKienUuTien + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		suKien other = (suKien) obj;
		if (diaDiem == null) {
			if (other.diaDiem != null)
				return false;
		} else if (!diaDiem.equals(other.diaDiem))
			return false;
		if (henGioTruocSuKien != other.henGioTruocSuKien)
			return false;
		if (hoanThanh != other.hoanThanh)
			return false;
		if (idSuKien != other.idSuKien)
			return false;
		if (idUser != other.idUser)
			return false;
		if (loaiSuKien == null) {
			if (other.loaiSuKien != null)
				return false;
		} else if (!loaiSuKien.equals(other.loaiSuKien))
			return false;
		if (moTaNgan == null) {
			if (other.moTaNgan != null)
				return false;
		} else if (!moTaNgan.equals(other.moTaNgan))
			return false;
		if (ngayDienRaSuKien == null) {
			if (other.ngayDienRaSuKien != null)
				return false;
		} else if (!ngayDienRaSuKien.equals(other.ngayDienRaSuKien))
			return false;
		if (nhungNguoiThamGia == null) {
			if (other.nhungNguoiThamGia != null)
				return false;
		} else if (!nhungNguoiThamGia.equals(other.nhungNguoiThamGia))
			return false;
		if (suKienUuTien != other.suKienUuTien)
			return false;
		if (tenSuKien == null) {
			if (other.tenSuKien != null)
				return false;
		} else if (!tenSuKien.equals(other.tenSuKien))
			return false;
		if (thoiGianBatDau == null) {
			if (other.thoiGianBatDau != null)
				return false;
		} else if (!thoiGianBatDau.equals(other.thoiGianBatDau))
			return false;
		if (thoiGianKetThuc == null) {
			if (other.thoiGianKetThuc != null)
				return false;
		} else if (!thoiGianKetThuc.equals(other.thoiGianKetThuc))
			return false;
		return true;
	}
	
	
	
}
