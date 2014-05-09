package com.example.model;

public class NodeLayer {

	public int SID;
	public int ATM;
	public int Vending;
	public int RestRoom;
	public int PublicPhone;
	public int ComputerLab;
	public int WiFi;
	public int Security;
	public int BusStop;
	
	public NodeLayer(int sID, int atm, int vending, int restRoom, int publicPhone, int computerLab, int wifi, int security, int busStop) {
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

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public int getATM() {
		return ATM;
	}

	public void setATM(int aTM) {
		ATM = aTM;
	}

	public int getVending() {
		return Vending;
	}

	public void setVending(int vending) {
		Vending = vending;
	}

	public int getRestRoom() {
		return RestRoom;
	}

	public void setRestRoom(int restRoom) {
		RestRoom = restRoom;
	}

	public int getPublicPhone() {
		return PublicPhone;
	}

	public void setPublicPhone(int publicPhone) {
		PublicPhone = publicPhone;
	}

	public int getComputerLab() {
		return ComputerLab;
	}

	public void setComputerLab(int computerLab) {
		ComputerLab = computerLab;
	}

	public int getWiFi() {
		return WiFi;
	}

	public void setWiFi(int wiFi) {
		WiFi = wiFi;
	}

	public int getSecurity() {
		return Security;
	}

	public void setSecurity(int security) {
		Security = security;
	}

	public int getBusStop() {
		return BusStop;
	}

	public void setBusStop(int busStop) {
		BusStop = busStop;
	}
	
}