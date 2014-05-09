package com.example.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.example.model.DepartmentLocation;
import com.example.model.NodeDescription;
import com.example.model.NodeLayer;
import com.example.model.Graph;
import com.example.model.NodeLocation;

public class ResourceFinderServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException
	{
		doGet(request, response);
	}
			
			
	public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		//int start = Integer.parseInt(getInitParameter("select"));
		//int end = Integer.parseInt(getInitParameter("select2"));
		//if (start == -999 || end == -999) {
		//	request.getRequestDispatcher("/directions.jsp").forward(request, response);
		//}
		HttpSession session = request.getSession();
		request.getRequestDispatcher("/resourcesOutput.jsp").forward(request, response);
	}
	
}