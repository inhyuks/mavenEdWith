package kr.or.connet.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connet.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/edwith"; 
	private static String dbUser = "root";
	private static String dbpasswd = "1234";
	
	public int addRole(Role role) {
		int insertCount = 0;;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "INSERT INTO role (role_id, description) VALUES (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,role.getRoleId());
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return insertCount;
	}
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT role_id,description FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql); //쿼리를 ps에 담아주세요
			ps.setInt(1, roleId); // 1번째 물음표에 roleId값을 넣어주세요
			rs = ps.executeQuery(); // 쿼리를 날려주고 결과값을 rs에 담아주세요
			
			if(rs.next()) {
				String description = rs.getString(1); //순서로 가져올수도있고
				int id = rs.getInt("role_id"); //컬럼명으로 가져올수도있다
				role = new Role(id,description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
}
