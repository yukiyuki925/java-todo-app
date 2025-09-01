package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.TodoBean;
import model.TodoLogic;

/**
 * Servlet implementation class TodoUpdate
 */
@WebServlet("/TodoUpdate")
public class TodoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TodoLogic todoLogic = new TodoLogic();
		
		try {
			TodoBean todoBean = todoLogic.getUpdateTodo(Integer.parseInt(request.getParameter("id")));
			
			request.setAttribute("todoBean", todoBean);
			
			request.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(request, response);
			
		} catch (SQLException | NamingException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
