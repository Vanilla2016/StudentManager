package com.wds.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.wds.beans.Student;
import com.wds.util.FileItemProcessor;
/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet(urlPatterns="/fileupload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<FileItem> items=null;
	FileItemProcessor itemProcessor;
	Student [] students =  null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
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
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// Parse the request
			items = upload.parseRequest(request);
		} catch (FileUploadException fup) {
			System.out.println("Error processing file " +fup.getMessage());
		}
		
		if(items!=null) {
				for (FileItem item : items) {
						itemProcessor = new FileItemProcessor();
						try {
							students = itemProcessor.processFileToBeans(item);
						} catch (Exception e) {
							request.setAttribute("errorMessage", "Error Processing the File. PLease ensure File is of correct format.");
							request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
									request, response);
							break;
						}
						
						request.setAttribute("successMessage", "File Processed. Student details are below. ");
						request.setAttribute("studentTable", students);
						request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
								request, response);
				}
			} else {
				request.setAttribute("errorMessage", "Error Accessing or Processing the File");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
						request, response);
		}
	}
}
