package kr.or.connet.jdbcexam;

import kr.or.connet.jdbcexam.dao.RoleDao;
import kr.or.connet.jdbcexam.dto.Role;

public class JDBCExam1 {
	public static void main(String[] arg) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}
}
