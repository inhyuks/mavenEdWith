package kr.or.connet.jdbcexam;

import kr.or.connet.jdbcexam.dao.RoleDao;
import kr.or.connet.jdbcexam.dto.Role;

public class JDBCExam2 {
	public static void main(String[] arg) {
		int roleId = 500;
		String description = "CTO";
		
		Role role =new Role(roleId,description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		
		System.out.println(insertCount);
	}
}
