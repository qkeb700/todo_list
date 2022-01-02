

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.TodoDao;
import todo.TodoDto;

/**
 * Servlet implementation class TodoTypeServlet
 */
@WebServlet("/TodoTypeServlet")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TodoDao todoDao = null;
    public TodoTypeServlet() {
        super();
        todoDao = new TodoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDto todoDto = new TodoDto();
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		
		if(type.equals("TODO")) {
			type = "DOING";
		} else {
			type ="DONE";
		}
		
		todoDto.setId(id);
		todoDto.setType(type);
		todoDao.updateTodo(todoDto);
		
		PrintWriter out = response.getWriter();
		out.print("success");
		out.close();
		
		//ajax로 요청
		
		//response.sendRedirect("./MainServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
