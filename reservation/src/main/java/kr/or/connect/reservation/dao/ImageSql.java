package kr.or.connect.reservation.dao;

public class ImageSql {
	public static final String SELECT_IMAGE_BY_TYPE = "SELECT id,product_id,type,file_id FROM product_image WHERE type = :type";
}
