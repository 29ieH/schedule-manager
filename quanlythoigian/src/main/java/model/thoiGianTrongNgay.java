package model;

import java.sql.Date;
import java.sql.Time;

public class thoiGianTrongNgay extends abstractModel {
	private int idThoiGianTrongNgay;
	private int idNguoiDung;
	private String tenHoatDong;
	private String moTaNgan;
	private String diaDiem;
	private Date ngayHienTai;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	private int hoanThanh;
	public  thoiGianTrongNgay() {}
	public thoiGianTrongNgay(int idThoiGianTrongNgay, int idNguoiDung,String tenHoatDong,String moTaNgan,String diaDiem,Date ngayHienTai,
			Time thoiGianBatDau, Time thoiGianKetThuc,int hoanThanh,Date ngayTao,Date ngayCapNhap) {
		this.idThoiGianTrongNgay = idThoiGianTrongNgay;
		this.idNguoiDung = idNguoiDung;
		this.tenHoatDong = tenHoatDong;
		this.moTaNgan = moTaNgan;
		this.diaDiem = diaDiem;
		this.ngayHienTai = ngayHienTai;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.hoanThanh = hoanThanh;
		this.ngayTao = ngayTao;
		this.ngayCapNhap = ngayCapNhap;
	}
	
	public thoiGianTrongNgay(int idThoiGianTrongNgay, int idNguoiDung,String tenHoatDong, String moTaNgan,String diaDiem, Date ngayHienTai,
		Time thoiGianBatDau, Time thoiGianKetThuc,int hoanThanh) {
		super();
		this.idThoiGianTrongNgay = idThoiGianTrongNgay;
		this.idNguoiDung = idNguoiDung;
		this.tenHoatDong = tenHoatDong;
		this.moTaNgan = moTaNgan;
		this.diaDiem = diaDiem;
		this.ngayHienTai = ngayHienTai;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.hoanThanh = hoanThanh;
	}
	public int getIdThoiGianTrongNgay() {
		return idThoiGianTrongNgay;
	}
	public void setIdThoiGianTrongNgay(int idThoiGianTrongNgay) {
		this.idThoiGianTrongNgay = idThoiGianTrongNgay;
	}
	public int getIdNguoiDung() {
		return idNguoiDung;
	}
	public void setIdNguoiDung(int idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}
	public String getMoTaNgan() {
		return moTaNgan;
	}
	public void setMoTaNgan(String moTaNgan) {
		this.moTaNgan = moTaNgan;
	}
	public Date getNgayHienTai() {
		return ngayHienTai;
	}
	public void setNgayHienTai(Date ngayHienTai) {
		this.ngayHienTai = ngayHienTai;
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
	
	public int getHoanThanh() {
		return hoanThanh;
	}
	public void setHoanThanh(int hoanThanh) {
		this.hoanThanh = hoanThanh;
	}
	
	public String getTenHoatDong() {
		return tenHoatDong;
	}
	public void setTenHoatDong(String tenHoatDong) {
		this.tenHoatDong = tenHoatDong;
	}
	
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	@Override
	public String toString() {
		return "thoiGianTrongNgay [idThoiGianTrongNgay=" + idThoiGianTrongNgay + ", idNguoiDung=" + idNguoiDung
				+ ", moTaNgan=" + moTaNgan + ", ngayHienTai=" + ngayHienTai + ", thoiGianBatDau=" + thoiGianBatDau
				+ ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaDiem == null) ? 0 : diaDiem.hashCode());
		result = prime * result + hoanThanh;
		result = prime * result + idNguoiDung;
		result = prime * result + idThoiGianTrongNgay;
		result = prime * result + ((moTaNgan == null) ? 0 : moTaNgan.hashCode());
		result = prime * result + ((ngayHienTai == null) ? 0 : ngayHienTai.hashCode());
		result = prime * result + ((tenHoatDong == null) ? 0 : tenHoatDong.hashCode());
		result = prime * result + ((thoiGianBatDau == null) ? 0 : thoiGianBatDau.hashCode());
		result = prime * result + ((thoiGianKetThuc == null) ? 0 : thoiGianKetThuc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		thoiGianTrongNgay other = (thoiGianTrongNgay) obj;
		if (diaDiem == null) {
			if (other.diaDiem != null)
				return false;
		} else if (!diaDiem.equals(other.diaDiem))
			return false;
		if (hoanThanh != other.hoanThanh)
			return false;
		if (idNguoiDung != other.idNguoiDung)
			return false;
		if (idThoiGianTrongNgay != other.idThoiGianTrongNgay)
			return false;
		if (moTaNgan == null) {
			if (other.moTaNgan != null)
				return false;
		} else if (!moTaNgan.equals(other.moTaNgan))
			return false;
		if (ngayHienTai == null) {
			if (other.ngayHienTai != null)
				return false;
		} else if (!ngayHienTai.equals(other.ngayHienTai))
			return false;
		if (tenHoatDong == null) {
			if (other.tenHoatDong != null)
				return false;
		} else if (!tenHoatDong.equals(other.tenHoatDong))
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
