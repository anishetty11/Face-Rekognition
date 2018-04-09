package com.example.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println(request.getParameter("username"));
		
		FileWriter file=new FileWriter(new File("/home/gulshir/Desktop/uploadfile.txt"));
		//file.write("enlj");
		file.write(request.getParameter("username")+"\n");
		file.write(request.getParameter("phone")+"\n");
		file.write(request.getParameter("email")+"\n");
		file.write(request.getParameter("disease")+"\n");
		file.write(request.getParameter("details")+"\n");
		file.close();
		
		//ProcessBuilder pg=new ProcessBuilder("/bin/sh","-c","echo \"Uploading\" >> /dev/pts/1");
		//ProcessBuilder ps=new ProcessBuilder("/bin/sh","-c","touch ~/Desktop/del.txt");
		//p=ps.start();
		//Process px=pg.start();
		
		ProcessBuilder b=new ProcessBuilder("/bin/sh","-c","python3 /home/gulshir/Desktop/Face-Rekogn/small.py");// > /dev/pts/1  2>&1");
		//ProcessBuilder ps=new ProcessBuilder("/bin/sh","-c","touch ~/Desktop/del.txt");
		//p=ps.start();
		Process p=b.start();
		System.out.println("hoh");
		
		request.getRequestDispatcher("uploaded.jsp").include(request, response);
		//request.getRequestDispatcher("CaptureServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
