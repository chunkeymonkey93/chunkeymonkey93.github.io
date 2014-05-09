package com.example.model;

public class NodeDescription {
	
	public int SID;
	public String Name;
	public String Description;
	public int Type;
	
	public NodeDescription(int sID, String name, String description, int type) {
		SID = sID;
		Name = name;
		Description = description;
		Type = type;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}
	
}