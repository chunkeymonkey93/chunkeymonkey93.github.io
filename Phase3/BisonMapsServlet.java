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

public class BisonMapsServlet extends HttpServlet {

	private static String url;
	private static Properties props = new Properties();
	private static Connection conn;
	
	private static NodeLocation[] location;
	private static Graph[] graph;
	private static NodeDescription[] description;
	private static NodeLayer[] layer;
	private static DepartmentLocation[] department;
	
	@Override
	public void init() {
		try {
			Class.forName("org.postgresql.Driver");
			url = "jdbc:postgresql://ec2-107-21-100-118.compute-1.amazonaws.com:5432/d7bp9c5tqq646h";
			props.setProperty("user", "mlgvzbujozfekm");
			props.setProperty("password", "1yUUMKUZULytknW1qrS98UU4R4");
			props.setProperty("ssl", "true");
			props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
			conn = DriverManager.getConnection(url, props);
			System.out.println("Connected to the database.");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		try {
			String query = "SELECT COUNT(*) FROM \"NodeLocation\"";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			String v = rs.getString(1);
			
			location = new NodeLocation[Integer.parseInt(v)];
			
			query = "SELECT * FROM \"NodeLocation\" ORDER BY \"SID\"";
			stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery(query);
			
			for (int x = 0; x < location.length; x++) {
				if (rs2.next()) {
					int sID = Integer.parseInt(rs2.getString("SID"));
					int X = Integer.parseInt(rs2.getString("X"));
					int Y = Integer.parseInt(rs2.getString("Y"));
					location[x] = new NodeLocation(sID, X, Y);
				}
			}
			
			String query2 = "SELECT COUNT(*) FROM \"Graph\"";
			Statement stmt2 = conn.createStatement();
			ResultSet rs3 = stmt2.executeQuery(query2);
			rs3.next();
			String v2 = rs3.getString(1);
			
			graph = new Graph[Integer.parseInt(v2)];
			
			query2 = "SELECT * FROM \"Graph\" ORDER BY \"SID\"";
			stmt2 = conn.createStatement();
			ResultSet rs4 = stmt2.executeQuery(query2);
			
			for (int x = 0; x < graph.length; x++) {
				if (rs4.next()) {
					int sID = Integer.parseInt(rs4.getString("SID"));
					int dID = Integer.parseInt(rs4.getString("DID"));
					graph[x] = new Graph(sID, dID);
				}
			}
			
			String query3 = "SELECT COUNT(*) FROM \"DepartmentLocation\"";
			Statement stmt3 = conn.createStatement();
			ResultSet rs5 = stmt3.executeQuery(query3);
			rs5.next();
			String v3 = rs5.getString(1);
			
			department = new DepartmentLocation[Integer.parseInt(v3)];
			
			query3 = "SELECT * FROM \"DepartmentLocation\" ORDER BY \"SID\"";
			stmt3 = conn.createStatement();
			ResultSet rs6 = stmt3.executeQuery(query3);
			
			for (int x = 0; x < department.length; x++) {
				if (rs6.next()) {
					int sID = Integer.parseInt(rs6.getString("SID"));
					String departmentName = rs6.getString("DepartmentName");
					String school = rs6.getString("School");
					String building = rs6.getString("Building");
					department[x] = new DepartmentLocation(sID, departmentName, school, building);
				}
			}
			
			String query4 = "SELECT COUNT(*) FROM \"NodeDescription\"";
			Statement stmt4 = conn.createStatement();
			ResultSet rs7 = stmt4.executeQuery(query4);
			rs7.next();
			String v4 = rs7.getString(1);
			
			description = new NodeDescription[Integer.parseInt(v4)];
			
			query4 = "SELECT * FROM \"NodeDescription\" ORDER BY \"SID\"";
			stmt4 = conn.createStatement();
			ResultSet rs8 = stmt4.executeQuery(query4);
			
			for (int x = 0; x < description.length; x++) {
				if (rs8.next()) {
					int sID = Integer.parseInt(rs8.getString("SID"));
					String name = rs8.getString("Name");
					String descript = rs8.getString("Description");
					int type = Integer.parseInt(rs8.getString("Type"));
					description[x] = new NodeDescription(sID, name, descript, type);
				}
			}
			
			String query5 = "SELECT COUNT(*) FROM \"NodeLayer\"";
			Statement stmt5 = conn.createStatement();
			ResultSet rs9 = stmt5.executeQuery(query5);
			rs9.next();
			String v5 = rs.getString(1);
			
			layer = new NodeLayer[Integer.parseInt(v5)];
			
			query5 = "SELECT * FROM \"NodeLayer\" ORDER BY \"SID\"";
			stmt5 = conn.createStatement();
			ResultSet rs10 = stmt5.executeQuery(query5);
			
			for (int x = 0; x < layer.length; x++) {
				if (rs10.next()) {
					int sID = Integer.parseInt(rs10.getString("SID"));
					int atm = Integer.parseInt(rs10.getString("ATM"));
					int vending = Integer.parseInt(rs10.getString("Vending"));
					int restRoom = Integer.parseInt(rs10.getString("RestRoom"));
					int publicPhone = Integer.parseInt(rs10.getString("PublicPhone"));
					int computerLab = Integer.parseInt(rs10.getString("ComputerLab"));
					int wifi = Integer.parseInt(rs10.getString("WiFi"));
					int security = Integer.parseInt(rs10.getString("Security"));
					int busStop = Integer.parseInt(rs10.getString("BusStop"));
					layer[x] = new NodeLayer(sID, atm, vending, restRoom, publicPhone, computerLab, wifi, security, busStop);
				}
			}
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		int counter = 0;
		for (int x = 0; x < description.length; x++) {
			if (description[x].Type == 0) {
				counter++;
			}
		}
		String[] buildingNames = new String[counter];
		for (int x = 0; x < counter; x++) {
			buildingNames[x] = description[x].Name;
		}
		List buildingNamesList = (List)session.getAttribute("buildingNamesList");
		if (buildingNamesList == null) { // does not exist
			//descriptions = new List(); // create the object
			buildingNamesList = Arrays.asList(buildingNames);
			session.setAttribute("buildingNames", buildingNamesList); // store the object in the session
		}
		List<NodeLocation> locations = (List<NodeLocation>)session.getAttribute("locations");
		if (locations == null) { // does not exist
			locations = new ArrayList<NodeLocation>(); // create the object
		}
		locations = Arrays.asList(location);
		session.setAttribute("locationList", locations); // store the object in the session
		List<Graph> graphs = (List<Graph>)session.getAttribute("graphs");
		if (graphs == null) { // does not exist
			graphs = new ArrayList<Graph>(); // create the object
		}
		graphs = Arrays.asList(graph);
		session.setAttribute("graphList", graphs); // store the object in the session
		List<NodeLayer> layers = (List<NodeLayer>)session.getAttribute("layer");
		if (layers == null) { // does not exist
			layers = new ArrayList<NodeLayer>(); // create the object
		}
		layers = Arrays.asList(layer);
		session.setAttribute("layerList", layers); // store the object in the session
		List<DepartmentLocation> departments = (List<DepartmentLocation>)session.getAttribute("departments");
		if (departments == null) { // does not exist
			departments = new ArrayList<DepartmentLocation>(); // create the object
		}
		departments = Arrays.asList(department);
		session.setAttribute("departmentList", departments); // store the object in the session
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
}