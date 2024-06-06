package com.edubridge.moniter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.mini_project.dao.moniterDao;
import com.edubridge.mini_project.model.moniter;
import com.edubridge.mini_project.util.DBUtils;




public class moniterDaoImpl  implements moniterDao {
	static Connection con = DBUtils.getConnection();
	@Override
	public int addmoniter (moniter m) {
		String INSERT_QUERY = "insert into moniter(brand,model,price,color) values(?,?,?,?)";
		int status = 0;
	
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, m.getBrand());
			ps.setString(2, m.getModel());
			ps.setInt(3,   m.getPrice());
			ps.setString(4,  m.getColor());
			status = ps. executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public List<moniter> findmoniters() {
		// TODO Auto-generated method stub
		String SELECT_QUERY = "select * from moniter";
		List<moniter> moniterList = new ArrayList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				moniter m = new moniter();
				m.setId(rs.getInt("Id"));
				m.setBrand(rs.getString("brand"));
				m.setModel(rs.getString("model"));
				m.setPrice(rs.getInt("price"));
				m.setColor(rs.getString("color"));
				moniterList.add(m);
				
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return moniterList;
	}

	@Override
	public moniter findmoniterByName(String Brand) {
		// TODO Auto-generated method stub
		String SELECT_QUERY = "select * from moniter where brand = ?";
		
		moniter m = null;
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1,  Brand);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				m = new moniter();
				m.setId(rs.getInt("Id"));
				m.setBrand(rs.getString("brand"));
				m.setModel(rs.getString("model"));
				m.setPrice(rs.getInt("price"));
				m.setColor(rs.getString("color"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	public int updatemoniter(moniter m) {
		String UPDATE_QUERY = "update moniter set brand=?,model=?,price=?,color=? where id=?";
		int status = 0;
				
				try {
					PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
					ps.setString(1, m.getBrand());
					ps.setString(2, m.getModel());
					ps.setLong(3, m.getPrice());
					ps.setString(4, m.getColor());
					ps.setInt(5,  m.getId());
					
					status = ps. executeUpdate();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				return status;
			}
	
	@Override
	public int deletemoniterByName(String Brand) {
		String DELETE_QUERY = "delete from moniter where brand=?";
		int status=0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1, Brand);
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
}

	@Override
	public void deleteallmoniter() {
		// TODO Auto-generated method stub
		String DELETE_QUERY = "delete from moniter";
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}