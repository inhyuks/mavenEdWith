package kr.or.connet.jdbcexam;

import kr.or.connet.jdbcexam.dao.RoleDao;
import kr.or.connet.jdbcexam.dto.Role;

public class JDBCExam4 {
	public static void main(String[] arg) {
		int roleId = 500;
		String description = "CTO";
		Role role = new Role(roleId,description);
		RoleDao roleDao = new RoleDao();
		
		System.out.println(roleDao.deleteRole(role));
	}
}
