package kr.or.connet.jdbcexam;

import kr.or.connet.jdbcexam.dao.RoleDao;
import kr.or.connet.jdbcexam.dto.Role;

public class JDBCExam5 {
	public static void main(String[] arg) {
		int roleId =500,newRoleId =900;
		String description = "CTO" , newDescription = "CAO";
		Role role = new Role(roleId,description);
		Role newRole = new Role(newRoleId,newDescription);
		
		RoleDao dao = new RoleDao();
		
		System.out.println(dao.updateRole(role, newRole));
	}
}
