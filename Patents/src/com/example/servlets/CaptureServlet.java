package com.example.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptureServlet
 */
@WebServlet("/CaptureServlet")
public class CaptureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaptureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// python3 ~/Desktop/Face-Rekognition/compare.py
		//Process p;
		
		Files.deleteIfExists(Paths.get("/home/gulshir/Desktop/face_matched.txt"));
		Files.deleteIfExists(Paths.get("/home/gulshir/Desktop/face_no_match.txt"));
		Files.deleteIfExists(Paths.get("/home/gulshir/Desktop/face_not_detected.txt"));
		Files.deleteIfExists(Paths.get("/home/gulshir/Desktop/program_executed.txt"));
		
		
		//ProcessBuilder pg=new ProcessBuilder("/bin/sh","-c","ls >> /dev/pts/1");
		//ProcessBuilder ps=new ProcessBuilder("/bin/sh","-c","touch ~/Desktop/del.txt");
		//p=ps.start();
		//Process px=pg.start();
		
		ProcessBuilder pb=new ProcessBuilder("/bin/sh","-c","python3 /home/gulshir/Desktop/Face-Rekogn/compare.py >> /dev/pts/1");
		//ProcessBuilder ps=new ProcessBuilder("/bin/sh","-c","touch ~/Desktop/del.txt");
		//p=ps.start();
		Process p=pb.start();
		
		System.out.print("hi");
		//BufferedReader in=new BufferedReader(new InputStreamReader(p.getInputStream()));
		//String ret=new String(in.readLine().toString());
		PrintWriter out=response.getWriter();
		//out.println(ret);
		//PythonCaller.call();
		//out.print("dfor");
		
		try {
			TimeUnit.SECONDS.sleep(20);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File matched=new File("/home/gulshir/Desktop/face_matched.txt");
		File no_match=new File("/home/gulshir/Desktop/face_no_match.txt");
		File not_detected=new File("/home/gulshir/Desktop/face_not_detected.txt");
		/*out.print("<br><br><br><br><br><br><h1>Capturing image .");
		out.print(".");
		out.print(".");
		out.print(".");
		out.print(".");
		out.print(".");
		out.print(".");
		out.print(".");
		out.print("</h1>");*/
		
		if(matched.exists())
		{
			System.out.println("face match");
			
			request.getRequestDispatcher("match.jsp").forward(request, response);
			
			out.print("Face has a match");
		}
		if(no_match.exists())
		{
			
			request.getRequestDispatcher("no_match.jsp").forward(request, response);
			
			out.print("Face has a no match");
		}
		if(not_detected.exists())
		{
			request.getRequestDispatcher("no_match.jsp").forward(request, response);
			out.print("Face not detected");
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
