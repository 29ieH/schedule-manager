package model;

import java.sql.Date;

public class abstractModel {
	protected Date ngayTao;
	protected Date ngayCapNhap;
	protected int page;
	protected int maxItemsPage;
	protected int totlItems;
	protected int toltalPage;
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayCapNhap() {
		return ngayCapNhap;
	}
	public void setNgayCapNhap(Date ngayCapNhap) {
		this.ngayCapNhap = ngayCapNhap;
	}
	public int getPage() {
		return page; 
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxItemsPage() {
		return maxItemsPage;
	}
	public void setMaxItemsPage(int maxItemsPage) {
		this.maxItemsPage = maxItemsPage;
	}
	public int getTotlItems() {
		return totlItems;
	}
	public void setTotlItems(int totlItems) {
		this.totlItems = totlItems;
	}
	public int getToltalPage() {
		return toltalPage;
	}
	public void setToltalPage(int toltalPage) {
		this.toltalPage = toltalPage;
	}
	
}
