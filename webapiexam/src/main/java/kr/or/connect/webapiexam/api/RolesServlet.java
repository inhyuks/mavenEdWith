package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connet.jdbcexam.dao.RoleDao;
import kr.or.connet.jdbcexam.dto.Role;

/**
 * Servlet implementation class RolesServlet
 */
@WebServlet("/roles")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		//application/json
		
		RoleDao dao = new RoleDao();
		
		List<Role> list = dao.getRoles();
		
		ObjectMapper objectMapper = new ObjectMapper();
		// JSON라이브러리가 제공해주는 객체 json 문자열로 바꾸거나 json문자열을 객체로 변환할수있음
		String json = objectMapper.writeValueAsString(list);
		//writeValueAsString 파라미터로 list를 넣어주면 json 문자열로 변환하여 리턴해줌
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

}
