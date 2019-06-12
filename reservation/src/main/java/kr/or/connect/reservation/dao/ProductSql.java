package kr.or.connect.reservation.dao;

public class ProductSql {
	public static final String SELECT_ALL_PRODUCT = "SELECT * FROM PRODUCT ORDER BY id DESC limit :start, :limit";
}
