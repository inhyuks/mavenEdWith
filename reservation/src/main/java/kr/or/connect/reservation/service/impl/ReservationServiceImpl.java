package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ImageDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Image;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ImageDao imageDao;
	
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public List<Image> getImageByType(String type) {
		List<Image> list = imageDao.selectImageByType(type);
		return list;
	}

	@Override
	@Transactional
	public List<Product> getAllProduct(Integer start) {
		List<Product> list = productDao.selectAllProduct(start, ReservationService.LIMIT);
		return list;
	}

}
