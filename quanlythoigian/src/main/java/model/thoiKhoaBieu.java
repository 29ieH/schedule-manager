package model;

import java.sql.Date;
import java.sql.Time;

public class thoiKhoaBieu extends abstractModel {
	private int idThoiKhoaBieu;
	private int idUser;
	private String thu;
	private String noiDung;
	private Time thoiGianBatDau;
	private Time thoiGianKetThuc;
	public thoiKhoaBieu() {}
	

	public thoiKhoaBieu(int idThoiKhoaBieu, int idUser, String thu, String noiDung,Time thoiGianBatDau,
			Time thoiGianKetThuc,Date ngayTao,Date ngayCapNhap) {
		super();
		this.idThoiKhoaBieu = idThoiKhoaBieu;
		this.idUser = idUser;
		this.thu = thu;
		this.noiDung = noiDung;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.ngayTao = ngayTao;
		this.ngayCapNhap = ngayCapNhap;
	}
	
	

	public thoiKhoaBieu(int idThoiKhoaBieu, int idUser, String thu, String noiDung, Time thoiGianBatDau,
			Time thoiGianKetThuc) {
		super();
		this.idThoiKhoaBieu = idThoiKhoaBieu;
		this.idUser = idUser;
		this.thu = thu;
		this.noiDung = noiDung;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}


	public int getIdThoiKhoaBieu() {
		return idThoiKhoaBieu;
	}
	public void setIdThoiKhoaBieu(int idThoiKhoaBieu) {
		this.idThoiKhoaBieu = idThoiKhoaBieu;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getThu() {
		return thu;
	}
	public void setThu(String thu) {
		this.thu = thu;
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
		return "thoiKhoaBieu [idThoiKhoaBieu=" + idThoiKhoaBieu + ", idUser=" + idUser + ", thu=" + thu + ", noiDung="
				+ noiDung + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		thoiKhoaBieu other = (thoiKhoaBieu) obj;
		if (idThoiKhoaBieu != other.idThoiKhoaBieu)
			return false;
		if (idUser != other.idUser)
			return false;
		if (noiDung == null) {
			if (other.noiDung != null)
				return false;
		} else if (!noiDung.equals(other.noiDung))
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
		if (thu == null) {
			if (other.thu != null)
				return false;
		} else if (!thu.equals(other.thu))
			return false;
		return true;
	}
	
	
}
