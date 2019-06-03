package kr.or.connect.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.springJDBC.dao.RoleDao;
import kr.or.connect.springJDBC.dto.Role;

public class JDBCTest {
	public static void main(String[] arg) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		Role role = new Role();
		role.setRoleId(500);
		role.setDescription("PROGRAMMER");
		
		/*int count = roleDao.insert(role);
		System.out.println(count + "건 입력하였습니다. ");*/
		
/*		int count = roleDao.update(role);
		System.out.println(count + "건 수정하였습니다. ");*/
		
		Role resuleRole = roleDao.selectOne(500);
		System.out.println(resuleRole);
	}
}
