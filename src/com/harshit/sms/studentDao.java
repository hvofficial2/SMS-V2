package com.harshit.sms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class studentDao {
	private DataSource dataSource;
	
	public studentDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Student> listStudent() {
		List<Student> students = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			String q = "select * from student";
			set = stmt.executeQuery(q);
			while(set.next()) {
				students.add(new Student(set.getInt(1), set.getString(2), set.getString(3),set.getString(4)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(set,stmt,con);
		}
		return students;
	}

	private void close(ResultSet set, Statement stmt, Connection con) {
		try {
			if(set!=null)
				set.close();
			if(stmt!=null)
				stmt.close();
			if(con!=null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addStudent(Student s) {
		Connection con=null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt=con.prepareStatement("insert into student (first_name,last_name,email) values(?,?,?)");
			pstmt.setString(1, s.getFirst_name());
			pstmt.setString(2, s.getLast_name());
			pstmt.setString(3, s.getEmail());
			pstmt.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(null, pstmt, con);
		}
	}

	
	public Student searchStudent(String id) {
		Student student = null;
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet set=null;
		try {
			con = dataSource.getConnection();
			pstmt=con.prepareStatement("select * from student where id=?");
			pstmt.setString(1,id);
			set=pstmt.executeQuery();
			if(set!=null) {
				set.next();
				student = new Student(set.getInt(1),set.getString(2), set.getString(3), set.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(null, pstmt, con);
		}
		return student;
	}
	
	public List<Student> searchStudents(String name) {
		List<Student> students = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		
		try {
			con = dataSource.getConnection();
			String s = "select * from student where (first_name=? OR last_name=?)";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1,name);
			pstmt.setString(2,name);
			set = pstmt.executeQuery();
			while(set.next()) {
				students.add(new Student(set.getInt(1),set.getString(2),
										 set.getString(3),set.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			close(set,pstmt,con);
		}
		return students;
	}

	public void updateStudent(Student student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = dataSource.getConnection();
			pstmt=con.prepareStatement("update student set first_name=?,"
					+ "last_name=?,email=? where id=?");
			pstmt.setString(1,student.getFirst_name());
			pstmt.setString(2,student.getLast_name());
			pstmt.setString(3,student.getEmail());
			pstmt.setInt(4,student.getId());
			pstmt.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			close(null, pstmt, con);
		}
	}

	public void deleteStudent(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = dataSource.getConnection();
			pstmt=con.prepareStatement("delete from student where id=?");
			pstmt.setInt(1,Integer.parseInt(id));
			pstmt.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			close(null, pstmt, con);
		}
	}
	
	
}
