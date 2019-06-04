package kr.or.connect.springGuestBook.dao;

public class GuestDaoSqls {
	//limit >> 시작값,끝날값 설정하여 셀렉트하는것
	public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";

}
