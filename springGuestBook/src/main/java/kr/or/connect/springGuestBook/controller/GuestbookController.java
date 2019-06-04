package kr.or.connect.springGuestBook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.springGuestBook.dto.GuestBook;
import kr.or.connect.springGuestBook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path = "/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			   ModelMap model) {
		//start로 시작하는 방명록개수구하기
		List<GuestBook> list = guestbookService.getGuestbooks(start);
		
		//전체페이지수 구하기
		int count = guestbookService.getCount();
		int pageCount = count / guestbookService.LIMIT;
		if(count % guestbookService.LIMIT > 0)
			pageCount++;
		
		// 페이지 수만큼 start의 값을 리스트로 저장
		// 예를 들면 페이지수가 3이면
		// 0, 5, 10 이렇게 저장된다.
		// list?start=0 , list?start=5, list?start=10 으로 링크가 걸린다.
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}
		
		model.addAttribute("list",list);
		model.addAttribute("pageStartList",pageStartList);
		model.addAttribute("count",count);
		return "list";
		
	}
	
	@PostMapping(path = "/write")
	public String write(@ModelAttribute GuestBook guestbook,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
}
