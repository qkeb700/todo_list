package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
	final private static String DBURI = "jdbc:mysql://localhost:3306/mydb";
	final private static String DBUSER = "root";
	final private static String DBPWD = "sksdi1532";
	
	public TodoDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public int addTodo(TodoDto dto) {
		String query = "insert into todo(title, name, sequence) values(?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(DBURI, DBUSER, DBPWD);
				PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getName());
				pstmt.setInt(3, dto.getSequence());
				return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<TodoDto> getTodos(){
		String query = "select id, title, name, sequence, type, regdate from todo order by regdate asc";
		List<TodoDto> result = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DBURI, DBUSER, DBPWD);
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery()) {
			
			while(rs.next()) {
				TodoDto dto = new TodoDto();
				dto.setId(rs.getLong("id"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setSequence(rs.getInt("sequence"));
				dto.setType(rs.getString("type"));
				dto.setRegdate(rs.getString("regdate").substring(0, 10));
				result.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateTodo(TodoDto dto) {
		long id = dto.getId();
		String type = dto.getType();
		
		String query = "update todo set type = ? where id = ?";
		
		try (Connection conn = DriverManager.getConnection(DBURI, DBUSER, DBPWD);
				PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setString(1, type);
				pstmt.setLong(2, id);
				return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
