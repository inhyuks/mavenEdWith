package kr.or.connect.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.springJDBC.dao.RoleDao;
import kr.or.connect.springJDBC.dto.Role;

public class SelectAllTest {
	public static void main(String[] arg) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		List<Role> list = roleDao.selectAll();
		
		for(Role role: list) {
			System.out.println(role);
		}
	}
}
