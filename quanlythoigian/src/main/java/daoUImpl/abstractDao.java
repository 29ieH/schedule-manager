package daoUImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import daoU.GenericDao;
import mapper.rowMapper;

public class abstractDao<T> implements GenericDao<T>{
	public Connection getConnection() {
		Connection con  = null;
		try {
			String user = "sa";
			String passwor = "th290403";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String url = "jdbc:sqlserver://localhost:1433;databaseName=dtb_dacn;integratedSecurity=true";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=dtb_dacn";
			con = DriverManager.getConnection(url, user, passwor);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
}
	private void setParameters(PreparedStatement pst, Object... parameters) {
		try {
			for(int i = 0 ; i < parameters.length ; i++) {
				Object paras = parameters[i];
				int index = i+1;
				if(paras instanceof String) {
					pst.setString(index, (String) paras);
				}
				if(paras instanceof Integer) {
					pst.setInt(index, (Integer)paras);
				}
				if(paras instanceof Date) {
					pst.setDate(index, (Date)paras);
				}
				if(paras instanceof Time) {
					pst.setTime(index, (Time)paras);
				}
				if(paras instanceof Float) {
					pst.setFloat(index, (Float)paras);
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<T> query(String sql, rowMapper<T> rowMapper, Object... parameters) {
		List<T> result = new ArrayList<T>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			if(con!=null) {
				pst = con.prepareStatement(sql);
				setParameters(pst,parameters);
				resultSet = pst.executeQuery();
				while(resultSet.next()) {
					result.add(rowMapper.mapRow(resultSet));
				}
				return result; 
			}
		} catch (SQLException e) {
			return null;
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pst!=null) {
					pst.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				return null;
			}
		}
		return null;
	}

	public int save(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int id = 0;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql,pst.RETURN_GENERATED_KEYS);
			setParameters(pst, parameters);
			pst.executeUpdate();
			try {
				rs = pst.getGeneratedKeys();
			} catch (Exception e) {
				e.printStackTrace();
			}
			while(rs.next()) {
				id = rs.getInt(1);
			}
			con.commit();
			return id;
		} catch (SQLException e) {
			try {
				if(con!=null) {
					con.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pst!=null) {
					pst.close();
				}
				if(rs!=null) {
					rs.close();
				}	
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return id;
	}

	public boolean update(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement pst = null;
		boolean check = false;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			setParameters(pst, parameters);
			int read = pst.executeUpdate();
			if(read>0) {
				check = true;
			}
			con.commit();
			return check;
		} catch (SQLException e) {
			try {
				if(con!=null) {
					con.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pst!=null) {
					pst.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return check;
	}
	public int count(String sql, Object... parameters) {
		int count = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			if(con!=null) {
				pst = con.prepareStatement(sql);
				setParameters(pst,parameters);
				resultSet = pst.executeQuery();
				while(resultSet.next()) {
					count = resultSet.getInt(1);
					if(count!=0) {
						break;
					}
				}
				return count; 
			}
		} catch (SQLException e) {
			return 0;
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pst!=null) {
					pst.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				return 0;
			}
		}
		return 0;
	}
	public String email(String sql,Object... parameters) {
		String email = "";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			if(con!=null) {
				pst = con.prepareStatement(sql);
				setParameters(pst,parameters);
				resultSet = pst.executeQuery();
				while(resultSet.next()) {
					email = resultSet.getString(1);
					if(email.length()>0) {
						break;
					}
				}
				return email; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pst!=null) {
					pst.close();
				}
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return email;
	}
}
