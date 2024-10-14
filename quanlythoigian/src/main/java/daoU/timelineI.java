package daoU;

import java.util.List;

import model.nguoiDung;
import model.thoiGianTrongNgay;

public interface timelineI {
	List<thoiGianTrongNgay> selectOne(int id);
	List<thoiGianTrongNgay> selectAll(nguoiDung u);
	int addOne(nguoiDung u,thoiGianTrongNgay tg);
	boolean delete(nguoiDung u,int id);
	boolean complete(nguoiDung u,int id);
	boolean update(nguoiDung u,thoiGianTrongNgay timeline);
	boolean reset(nguoiDung u,thoiGianTrongNgay timeline);
	boolean resetList(nguoiDung u,List<thoiGianTrongNgay> list);
	boolean resetAll();
	List<thoiGianTrongNgay> listComplete(int idUser);
}
