package com.example.servlets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PythonCaller {
	public static void call()
	{
		 try{
			 	Process q=Runtime.getRuntime().exec("python3 /home/gulshir/eclipse-workspace/Patents/src/com/example/servlets" + 
			 			"/compare.py");
			 	
		        ProcessBuilder pb=new ProcessBuilder("/bin/sh","-c","/usr/bin/python3 /home/gulshir/Desktop/Face-Rekogn/ex1.py");
		        ProcessBuilder ps=new ProcessBuilder("/bin/sh","-c","touch wolo.txt");
		        Process process=pb.start(); 
		        Process p=ps.start();
		        InputStream is = process.getInputStream();
		        InputStreamReader isr = new InputStreamReader(is);
		        BufferedReader br = new BufferedReader(isr);
		        String line;

		        //System.out.printf("Output of running %s is:", Arrays.toString(br));
		        System.out.println("vvi");
		        while ((line = br.readLine()) != null) {
		          System.out.println(line);
		        }
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
	}

}
