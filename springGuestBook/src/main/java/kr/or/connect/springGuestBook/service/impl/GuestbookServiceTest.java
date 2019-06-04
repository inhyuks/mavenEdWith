package kr.or.connect.springGuestBook.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.springGuestBook.config.ApplicationConfig;
import kr.or.connect.springGuestBook.dto.GuestBook;
import kr.or.connect.springGuestBook.service.GuestbookService;

public class GuestbookServiceTest {
	public static void main(String[] arg) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);
		
		GuestBook guestbook = new GuestBook();
		guestbook.setName("김건모");
		guestbook.setContent("안녕하세요");
		guestbook.setRegdate(new Date());
		GuestBook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
	}
}
