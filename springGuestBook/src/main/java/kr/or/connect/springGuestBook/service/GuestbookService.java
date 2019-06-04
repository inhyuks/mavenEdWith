package kr.or.connect.springGuestBook.service;

import java.util.List;

import kr.or.connect.springGuestBook.dto.GuestBook;

public interface GuestbookService {
	//한페이지내 최대 게시글수에대한 상수
	public static final Integer LIMIT = 5;
	//방명록목록 가져오기
	public List<GuestBook> getGuestbooks(Integer start);
	//방명록삭제
	public int deleteGuestbook(Long id, String ip);
	//방명록 추가
	public GuestBook addGuestbook(GuestBook guestbook, String ip);
	//방명록 전체개수
	public int getCCount();
}
