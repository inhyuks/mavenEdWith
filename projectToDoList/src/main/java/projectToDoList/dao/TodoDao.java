package projectToDoList.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import projectToDoList.dto.TodoDto;

public class TodoDao {

	private static String dburl = "jdbc:mysql://localhost:3306/edwith";
	private static String dbUser = "root";
	private static String dbpasswd = "1234";

	public int addTodo(TodoDto todoDto) {
		int addCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String sql = "insert into todo(title, name, sequence) values(?,?,?)";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, todoDto.getTitle());
			ps.setString(2, todoDto.getName());
			ps.setInt(3, todoDto.getSequence());
			addCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addCount;
	}

	public List<TodoDto> getTodos() {
		List<TodoDto> todos = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select * from todo";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				TodoDto todoDto = new TodoDto(rs.getLong("id"), rs.getString("name"), rs.getString("regdate"), rs.getInt("sequence"), rs.getString("title"), rs.getString("Type"));
				todos.add(todoDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return todos;
	}

	public int updateTodo(TodoDto todoDto) {
		int updateCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String newType = todoTypeChange(todoDto.getType());
		String sql = "UPDATE todo SET type = ? WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, newType);
			ps.setLong(2, todoDto.getId());
			updateCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}
	
	public String todoTypeChange(String type) {
		if(type.equals("todo")) {
			return "doing";
		}
		else if(type.equals("doing")) {
			return "done";
		}
		else return type;
	}
}
