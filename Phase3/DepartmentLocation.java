package com.example.model;

public class DepartmentLocation {

	public int SID;
	public String DepartmentName;
	public String School;
	public String Building;
	
	public DepartmentLocation(int sID, String departmentName, String school, String building) {
		SID = sID;
		DepartmentName = departmentName;
		School = school;
		Building = building;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getSchool() {
		return School;
	}

	public void setSchool(String school) {
		School = school;
	}

	public String getBuilding() {
		return Building;
	}

	public void setBuilding(String building) {
		Building = building;
	}
	
}