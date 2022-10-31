package com.wds.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wds.beans.Student;

/**
 * Servlet implementation class SortServlet
 */
@WebServlet("/sort.do")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Student [] students =  null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		students = (Student[])session.getAttribute("studentTable");
		//doGet(request, response);
	}

}
