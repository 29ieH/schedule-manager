package model;

import java.sql.Time;

public class lich {
	private int idLich;
	private int idNguoiDung;
	private String tenSuKien;
	private int ngay;
	private int thang;
	private int nam;
	private String noiDung;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	public lich() {}
	public lich(int idLich, int idNguoiDung, String tenSuKien, int ngay, int thang, int nam, String noiDung,
			Time thoiGianBatDau, Time thoiGianKetThuc) {
		this.idLich = idLich;
		this.idNguoiDung = idNguoiDung;
		this.tenSuKien = tenSuKien;
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
		this.noiDung = noiDung;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
	public int getIdLich() {
		return idLich;
	}
	public void setIdLich(int idLich) {
		this.idLich = idLich;
	}
	public int getIdNguoiDung() {
		return idNguoiDung;
	}
	public void setIdNguoiDung(int idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}
	public String getTenSuKien() {
		return tenSuKien;
	}
	public void setTenSuKien(String tenSuKien) {
		this.tenSuKien = tenSuKien;
	}
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
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
	@Override
	public String toString() {
		return "lich [idLich=" + idLich + ", idNguoiDung=" + idNguoiDung + ", tenSuKien=" + tenSuKien + ", ngay=" + ngay
				+ ", thang=" + thang + ", nam=" + nam + ", noiDung=" + noiDung + ", thoiGianBatDau=" + thoiGianBatDau
				+ ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		lich other = (lich) obj;
		if (idLich != other.idLich)
			return false;
		if (idNguoiDung != other.idNguoiDung)
			return false;
		if (nam != other.nam)
			return false;
		if (ngay != other.ngay)
			return false;
		if (noiDung == null) {
			if (other.noiDung != null)
				return false;
		} else if (!noiDung.equals(other.noiDung))
			return false;
		if (tenSuKien == null) {
			if (other.tenSuKien != null)
				return false;
		} else if (!tenSuKien.equals(other.tenSuKien))
			return false;
		if (thang != other.thang)
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
