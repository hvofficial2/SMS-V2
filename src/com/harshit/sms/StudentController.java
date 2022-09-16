package com.harshit.sms;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {
	private studentDao StudentDao;
	
	@Resource(name="jdbc/web_student2")
	private DataSource dataSource;
	
	public void init() throws ServletException{
		try {
			StudentDao = new studentDao(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
 	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		doProcess(req,res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException,ServletException{
				doProcess(req,res);
			}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res)
					throws IOException,ServletException{
		String command = req.getParameter("command");
		if(command==null)
			command = "LIST";
		
		switch(command) {
		case "LIST": listStudents(req,res);
					 break;
		case "ADD": addStudent(req,res);
					 break;
		case "LOAD": loadStudent(req,res);
		 			break;
		case "UPDATE": updateStudent(req,res);
					break;
		case "DELETE": deleteStudent(req,res);
					break;
		case "SEARCH": searchStudents(req,res);
					break;
		default : listStudents(req,res);
		 			 break;
		}
	}
	
	private void searchStudents(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		if(!name.equalsIgnoreCase("") && !name.trim().equalsIgnoreCase("") && name!=null) {
			List<Student> students = StudentDao.searchStudents(name.trim());
			req.setAttribute("students", students);
			
			// Step-3 get Request dispatcher
			RequestDispatcher rd = req.getRequestDispatcher("student_view");
			
			// Step-4 Forward RD to JSP (View part)
				rd.forward(req, res);
			}
	}

	private void deleteStudent(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		StudentDao.deleteStudent(req.getParameter("id"));
		listStudents(req, res);
	}

	private void updateStudent(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Student student = new Student(Integer.parseInt(req.getParameter("id")),req.getParameter("first_name"),
				req.getParameter("last_name"),req.getParameter("email"));
		StudentDao.updateStudent(student);
		listStudents(req, res);
	}

	private void loadStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Student s = StudentDao.searchStudent(req.getParameter("id"));
		if(s!=null) {
			req.setAttribute("student", s);
			RequestDispatcher rd = req.getRequestDispatcher("UpdateStudent");
			rd.forward(req, res);
		}
		else {
			
		}
		
	}

	private void addStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Student s = new Student(req.getParameter("first_name"),req.getParameter("last_name"),
				req.getParameter("email"));
		StudentDao.addStudent(s);
		listStudents(req, res);
	}

	public void listStudents(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		List<Student> students = StudentDao.listStudent();
		if(students!=null) {
			req.setAttribute("students", students);
			RequestDispatcher rd = req.getRequestDispatcher("student_view");
			rd.forward(req, res);	
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("NewFile.html");
			rd.forward(req, res);
		}
	}
}
