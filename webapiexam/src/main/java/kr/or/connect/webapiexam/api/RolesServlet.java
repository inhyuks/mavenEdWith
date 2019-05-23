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
		// JSON���̺귯���� �������ִ� ��ü json ���ڿ��� �ٲٰų� json���ڿ��� ��ü�� ��ȯ�Ҽ�����
		String json = objectMapper.writeValueAsString(list);
		//writeValueAsString �Ķ���ͷ� list�� �־��ָ� json ���ڿ��� ��ȯ�Ͽ� ��������
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

}
