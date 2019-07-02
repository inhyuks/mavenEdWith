package kr.or.connect.springGuestBook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.or.connect.springGuestBook.dto.GuestBook;
import kr.or.connect.springGuestBook.service.GuestbookService;

@Api(tags = {"1.Guestbook"})
@RestController
@RequestMapping(path = "/guestbooks")
public class GuestbookAPIController {
	@Autowired
	GuestbookService guestbookService;
	
    @ApiOperation(value = "방명록조회", notes = "방명록전체조회")
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start){
		
		List<GuestBook> list = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount =count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT );
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		return map;
	}
    @ApiOperation(value = "방명록작성", notes = "방명록입력")
	@PostMapping
	public GuestBook write(@RequestBody GuestBook guestbook,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		//id 가입력된 guestbook이 반환됨
		
		GuestBook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
		return resultGuestbook;
		
	}
    @ApiOperation(value = "방명록삭제", notes = "방명록삭제")
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id,
			HttpServletRequest request){
		String clientIp = request.getRemoteAddr();
		
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("successs", deleteCount > 0 ? "true" : "false");
	}
	
}
