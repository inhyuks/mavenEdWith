package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Image;
import kr.or.connect.reservation.dto.Product;

public interface ReservationService {
	public static final Integer LIMIT = 3;
	// 더보기 최대개수
	public List<Image> getImageByType(String type);
	// 원하는 타입의 이미지 가져오기

	public List<Product> getAllProduct(Integer start);
	// 전체 Product 가져오기
}
