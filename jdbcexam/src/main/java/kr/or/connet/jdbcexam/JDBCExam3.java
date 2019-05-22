package kr.or.connet.jdbcexam;

import java.util.List;

import kr.or.connet.jdbcexam.dao.RoleDao;
import kr.or.connet.jdbcexam.dto.Role;

public class JDBCExam3 {
	public static void main(String[] arg) {
		
		RoleDao dao = new RoleDao();
		
		List<Role> list = dao.getRoles();
		
		for(Role role : list) {
			System.out.println(role);
		}
		
	}
}
