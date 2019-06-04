package kr.or.connect.springGuestBook.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.springGuestBook.config.ApplicationConfig;
import kr.or.connect.springGuestBook.dto.GuestBook;
import kr.or.connect.springGuestBook.dto.Log;

public class GuestbookDaoTest {
	public static void main(String[] arg) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		
/*		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
		GuestBook guestbook = new GuestBook();
		guestbook.setName("강경미");
		guestbook.setContent("반갑습니다. 여러분.");
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		System.out.println("id : " + id);*/
		
		LogDao logDao = ac.getBean(LogDao.class);
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
	}
}
