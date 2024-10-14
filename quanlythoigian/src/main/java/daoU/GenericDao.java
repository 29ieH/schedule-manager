package daoU;

import java.util.List;

import mapper.rowMapper;
import model.suKien;

public interface GenericDao<T> {
	List<T> query(String sql, rowMapper<T> rowMapper, Object... parameters);
	int save(String sql,Object...parameters);
	boolean update(String sql,Object...parameters);
	int count(String sql,Object...parameters);
	String email(String sql,Object...parameters);
}
