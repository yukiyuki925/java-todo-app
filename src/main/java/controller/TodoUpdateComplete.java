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
 * Servlet implementation class TodoUpdateComplete
 */
@WebServlet("/TodoUpdateComplete")
public class TodoUpdateComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoUpdateComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//todoロジックの作成
		TodoLogic todoLogic = new TodoLogic();
		
		//フォームの値を取得
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String DueDate = request.getParameter("due_date");
		String id = request.getParameter("id");
		
		//インスタンスを作る
		TodoBean todoBean = new TodoBean();
		todoBean.setTitle(title);
		todoBean.setDescription(description);
		todoBean.setDue_date(java.sql.Date.valueOf(DueDate));
		todoBean.setId(Integer.parseInt(id));
		
		try {
			//更新を実行
			todoLogic.updateTodo(todoBean);
			//TodoIndexへリダイレクト
			response.sendRedirect("TodoIndex");
			
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

}
