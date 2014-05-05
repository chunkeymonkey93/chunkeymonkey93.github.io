import java.util.*;
import java.sql.*;

class DepartmentLocation {
	public int SID;
	public String DepartmentName;
	public String School;
	public String Building;
	
	DepartmentLocation(int sID, String departmentName, String school, String building) {
		SID = sID;
		DepartmentName = departmentName;
		School = school;
		Building = building;
	}
};

class Graph {
	public int SID;
	public int DID;
	
	Graph(int sID, int dID) {
		SID = sID;
		DID = dID;
	}
};

class NodeDescription {
	public int SID;
	public String Name;
	public String Description;
	public int Type;
	
	NodeDescription(int sID, String name, String description, int type) {
		SID = sID;
		Name = name;
		Description = description;
		Type = type;
	}
};

class NodeLayer {
	public int SID;
	public int ATM;
	public int Vending;
	public int RestRoom;
	public int PublicPhone;
	public int ComputerLab;
	public int WiFi;
	public int Security;
	public int BusStop;
	
	NodeLayer(int sID, int atm, int vending, int restRoom, int publicPhone, int computerLab, int wifi, int security, int busStop) {
		SID = sID;
		ATM = atm;
		Vending = vending;
		RestRoom = restRoom;
		PublicPhone = publicPhone;
		ComputerLab = computerLab;
		WiFi = wifi;
		Security = security;
		BusStop = busStop;
	}
};

class NodeLocation {
	public int SID;
	public int x;
	public int y;
	
	NodeLocation(int sID, int X, int Y) {
		SID = sID;
		x = X;
		y = Y;
	}
};

public class DataConnector {
	
	private static DataConnector instance = null;
	private static String url;
	private static Properties props = new Properties();
	private static Connection conn;
	
	private static NodeLocation[] location;
	private static Graph[] graph;
	private static NodeDescription[] description;
	private static NodeLayer[] layer;
	private static DepartmentLocation[] department;
	
	public static void main(String[] args) throws SQLException {
		if(instance == null) {
			instance = new DataConnector();
		}
	}
	
	public static DataConnector getInstance() {
		return instance;
	}
	
	public DataConnector() throws SQLException {
		
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

	public static void printPath(EuclideanGraph G, int s, int d) {
		Dijkstra dijkstra = new Dijkstra(G);
		//dijkstra.showPath(sourceID, destinationID); // inserted just to check if names were in correct order
		String[] values = dijkstra.getPath(s, d); // get an array of sid's in order of the shortest path
		
		int x = 0, y = 0;
		String next = " ";
		int end = 0;
		
		for (int index = Integer.parseInt(values[x]); x < values.length - 1; x++) {
			if (x != 0)
				index = Integer.parseInt(values[x]);
			while(y < description.length) {
				int start = description[y].SID;
		    	String name = description[y].Name;
		    	if (index == start) {
		    		y = 0;
		    		do {
			    		end = description[y].SID;
				    	String tempName = description[y].Name;
				    	if (x >= 0 && x < values.length - 2) {
				    		if (Integer.parseInt(values[x + 1]) == end)
				    			next = tempName;
				    	}
				    	else if (x == values.length - 2) {
				    		if (d == end)
				    			next = tempName;
				    	}
				    	y++;
			    	} while(y < description.length);
		    		System.out.print("from: " + name.trim() + "\t\t\tto: " + next.trim());
		    		Point begin = G.point(start);
		    		Point finish = G.point(end);
		    		System.out.println("\t\t\tDist: " + begin.distanceTo(finish) + "m");
		    	}
		    	y++;
			}
			y = 0;
		}
	}
	
	public static void getDirections() {
		String sourceID, destinationID, name = " ";
		int sid = 0, sID = 0, dID = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Starting Location (Building): ");
		sourceID = in.nextLine();
		
		int x = 0;
		
		do {
			while(x < description.length) {
				name = description[x].Name;
				sid = description[x].SID;
				if (name.trim().equals(sourceID.trim())) {
					name = sourceID;
					sID = sid;
					break;
				}
				x++;
			}
			if (name.trim().equals(sourceID.trim())) {
				break;
			}
			else {
				System.out.print("Enter Starting Location (Building): ");
				sourceID = in.nextLine();
				x = 0;
			}
		} while(!name.trim().equals(sourceID.trim()));
		
		System.out.print("Enter Destination Location (Building): ");
		destinationID = in.nextLine();
		
		x = 0;
		
		do {
			while(x < description.length) {
				name = description[x].Name;
				int did = description[x].SID;
				if (name.trim().equals(destinationID.trim())) {
					name = destinationID;
					dID = did;
					break;
				}
				x++;
			}
			if (name.trim().equals(destinationID.trim())) {
				break;
			}
			else {
				System.out.print("Enter Destination Location (Building): ");
				destinationID = in.nextLine();
				x = 0;
			}
		} while(!name.trim().equals(destinationID.trim()));
		
		in.close();
		
		System.out.println();
		
		EuclideanGraph G = new EuclideanGraph(location, graph);
		
		x = 0;
		String source = " ", destination = " ";
		
		while(x < description.length) {
			sid = description[x].SID;
			name = description[x].Name;
			if (sID == sid)
				source = name;
			else if (dID == sid)
				destination = name;
			x++;
		}
		
		System.out.println("\t\t\t\t\t\t\tBISON MAP");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Directions\nFROM: " + source + "TO: " + destination);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		
		printPath(G, sID, dID);
		
		System.out.println("=================================================================================================================================================");
		
		Point sP = G.point(sID);
		Point dP = G.point(dID);
		
		double distance = (sP.distanceTo(dP)) / 3;
		
		System.out.println("Total Distance: " + distance + "m");
		System.out.println("Time: " + (distance / 67.056) + " min");
		
		System.out.println();
	}
	
	public static void findCampusResources() {
		
		int user_option;
		String sourceID = " ", name = " ", finalSource = " ", finalDestination = " ";
		int sid = 0, x = 0, destinationID = 0, sID = 0, counter = 1, dID = 0;
		double distance = 0;
		
		do {
			System.out.println("1. ATM");
			System.out.println("2. Public Phone");
			System.out.println("3. WiFi Hot Spot");
			System.out.println("4. Security Phone/Guard Station");
			System.out.println("5. Vending Machine");
			System.out.println("6. Rest Room");
			System.out.println("7. Shuttle Bus Stop");
			System.out.println("8. Computer Lab");
			System.out.println("9. Previous Menu");
			System.out.println();
			
			do {
				System.out.print("Enter Resource (1 - 9): ");
				user_option = StdIn.readInt();
			} while(user_option < 1 || user_option > 9);
			
			switch (user_option) {
				case 1:
					counter = 1;
					
					Scanner in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					EuclideanGraph G = new EuclideanGraph(location, graph);
					Dijkstra dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].ATM > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					Point sP = G.point(sID);
					Point dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 2:
					counter = 1;
					
					in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					G = new EuclideanGraph(location, graph);
					dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].PublicPhone > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					sP = G.point(sID);
					dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 3:
					counter = 1;
					
					in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					G = new EuclideanGraph(location, graph);
					dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].WiFi > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					sP = G.point(sID);
					dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 4:
					counter = 1;
					
					in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					G = new EuclideanGraph(location, graph);
					dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].Security > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					sP = G.point(sID);
					dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 5:
					counter = 1;
					
					in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					G = new EuclideanGraph(location, graph);
					dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].Vending > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					sP = G.point(sID);
					dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 6:
					counter = 1;
					
					in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					G = new EuclideanGraph(location, graph);
					dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].RestRoom > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					sP = G.point(sID);
					dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 7:
					counter = 1;
					
					in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					G = new EuclideanGraph(location, graph);
					dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].BusStop > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					sP = G.point(sID);
					dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 8:
					counter = 1;
					
					in = new Scanner(System.in);
					System.out.print("Enter Starting Location (Building): ");
					sourceID = in.nextLine();
					do {
						while(x < description.length) {
							name = description[x].Name;
							sid = description[x].SID;
							if (name.trim().equals(sourceID.trim())) {
								name = sourceID;
								sID = sid;
								break;
							}
							x++;
						}
						if (name.trim().equals(sourceID.trim())) {
							break;
						}
						else {
							System.out.print("Enter Starting Location (Building): ");
							sourceID = in.nextLine();
							x = 0;
						}
					} while(!name.trim().equals(sourceID.trim()));
					
					finalSource = name;
					
					System.out.println();
					
					G = new EuclideanGraph(location, graph);
					dijkstra = new Dijkstra(G);
					
					for (int y = 0; y < layer.length; y++) {
						if (layer[y].ComputerLab > 0) {
							sid = layer[y].SID;
							destinationID = sid;
							if (counter == 1) {
								distance = dijkstra.distance(sID, destinationID);
								dID = destinationID;
							}
							else if (counter > 1) {
								if (distance > dijkstra.distance(sID, destinationID)) {
									distance = dijkstra.distance(sID, destinationID);
									dID = destinationID;
								}
							}
						}
						
						counter++;
					}
					
					for (int y = 0; y < description.length; y++) {
						sid = description[y].SID;
						name = description[y].Name;
						if (sID == sid)
							finalSource = name;
						if (dID == sid)
							finalDestination = name;
					}
					
					System.out.println("\t\t\t\t\t\t\tBISON MAP");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Directions\nFROM: " + finalSource + "TO: " + finalDestination);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
					
					printPath(G, sID, dID);
					
					System.out.println("=================================================================================================================================================");
					
					sP = G.point(sID);
					dP = G.point(dID);
					
					distance = (sP.distanceTo(dP)) / 3;
					
					System.out.println("Total Distance: " + distance + "m");
					System.out.println("Time: " + (distance / 67.056) + " min");
					
					System.out.println();
					
					break;
				case 9:
				default:
					break;
			}
		} while(user_option != 9);
		
		System.out.println();
	}
	
	public static void displayBuildings() throws SQLException {

		System.out.println("Building Name\t\t\t\t\t\t\t\t\tX\t\tY");
		
		for (int z = 0; description[z].Type == 0; z++) {
			String name = description[z].Name;
			int x = location[z].x;
			int y = location[z].y;
			System.out.println(name + x + '\t' + y);
		}
		
		System.out.println();
	}
	
	public static void displayResources() {
		
		System.out.println("Resource\t\t\tBuilding");
		
		@SuppressWarnings("unused")
		int counter = 0, tempCounter = 0, sid = 0;
		String name = " ";
		
		for (int y = 0; y < layer.length; y++) {
			if (layer[y].ATM > 0) {
				sid = layer[y].SID;
				
				while (sid != tempCounter) {
					tempCounter++;
				}
				
				name = description[tempCounter].Name;
				
				System.out.println("ATM\t\t\t\t" + name);
				counter++;
			}
		}
		
		for (int y = 0; y < layer.length; y++) {
			if (layer[y].Vending > 0) {
				sid = layer[y].SID;
				
				while (sid != tempCounter) {
					tempCounter++;
				}
				
				name = description[tempCounter].Name;
				
				System.out.println("Vending Machine\t\t\t" + name);
				counter++;
			}
		}

		for (int y = 0; y < layer.length; y++) {
			if (layer[y].RestRoom > 0) {
				sid = layer[y].SID;
				
				while (sid != tempCounter) {
					tempCounter++;
				}
				
				name = description[tempCounter].Name;
				
				System.out.println("Rest Room\t\t\t" + name);
				counter++;
			}
		}
		
		for (int y = 0; y < layer.length; y++) {
			if (layer[y].PublicPhone > 0) {
				sid = layer[y].SID;
				
				while (sid != tempCounter) {
					tempCounter++;
				}
				
				name = description[tempCounter].Name;
				
				System.out.println("Public Phone\t\t\t" + name);
				counter++;
			}
		}
		
		for (int y = 0; y < layer.length; y++) {
			if (layer[y].ComputerLab > 0) {
				sid = layer[y].SID;
				
				while (sid != tempCounter) {
					tempCounter++;
				}
				
				name = description[tempCounter].Name;
				
				System.out.println("Computer Lab\t\t\t" + name);
				counter++;
			}
		}
		
		System.out.println("WiFi\t\t\t\tWiFi available everywhere through HOWARD (sometimes)");
		
		for (int y = 0; y < layer.length; y++) {
			if (layer[y].Security > 0) {
				sid = layer[y].SID;
				
				while (sid != tempCounter) {
					tempCounter++;
				}
				
				name = description[tempCounter].Name;
				
				System.out.println("Security Phone\t\t\t" + name);
				counter++;
			}
		}
		
		for (int y = 0; y < layer.length; y++) {
			if (layer[y].BusStop > 0) {
				sid = layer[y].SID;
				
				while (sid != tempCounter) {
					tempCounter++;
				}
				
				name = description[tempCounter].Name;
				
				System.out.println("Shuttle Stop\t\t\t" + name);
				counter++;
			}
		}
		
		System.out.println();
	}
	
	public static void showDepartments() {
		
		System.out.println("Department\t\t\t\t\t\t\t\t\tBuilding"); // Heading
		
		for (int x = 0; x < department.length; x++) { // Loop through all of the departments in the array
			System.out.println(department[x].DepartmentName + department[x].Building); // Print name and building
		}
		
		System.out.println(); // Extra line for display purposes
	}
	
}