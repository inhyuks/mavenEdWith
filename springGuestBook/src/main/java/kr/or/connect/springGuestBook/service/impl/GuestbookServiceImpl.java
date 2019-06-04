package kr.or.connect.springGuestBook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.springGuestBook.dao.GuestbookDao;
import kr.or.connect.springGuestBook.dao.LogDao;
import kr.or.connect.springGuestBook.dto.GuestBook;
import kr.or.connect.springGuestBook.dto.Log;
import kr.or.connect.springGuestBook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	//내부적으로 ReadOnly라는 형태로 커넥션적용
	@Transactional
	public List<GuestBook> getGuestbooks(Integer start) {
		List<GuestBook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return list;
	}// 목록가져오기

	@Override
	//readOnly 전체가 전부 성공해야 반영이됨 뒤에부분이 실패하면 초기화
	@Transactional(readOnly=false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
	}//방명록삭제

	@Override
	public GuestBook addGuestbook(GuestBook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);
		
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		return guestbook;
	}// 방명록 추가

	@Override
	@Transactional(readOnly = false)
	public int getCount() {
		return guestbookDao.selectCount();
	}// 방명록 전체개수
}
