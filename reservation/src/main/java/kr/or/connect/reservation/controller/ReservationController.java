package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.Image;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path="/mainpage")
	public String mainpage(@RequestParam(name="start", required=false, defaultValue="0") int start
			,Model model) {
		
		//슬라이드쇼 부분 이미지 정보 가져오기
		List<Image> imageList = reservationService.getImageByType("th");
		model.addAttribute("imageList",imageList);
		
		List<Product> productList = reservationService.getAllProduct(start);
		model.addAttribute("productList",productList);
		return "mainpage";
	}
}
