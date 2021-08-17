package com.vo;

import lombok.Data;


public class BusArriveInfo {
	
	
	
/** 버스 정류장 이름 **/
String station;
/** 첫번째 버스 도착정보 **/
String firstarrive;
/** 첫번째 버스 번호판 **/
String firstnum;
/** 첫번째 버스 고유 아이디 **/
String firstid;
/** 두번째 버스 도착정보 **/
String secondarrive;
/** 두번째 버스 번호판 **/
String secondnum;
/** 두번째 버스 고유 아이디 **/
String secondid;

public BusArriveInfo() {
	// TODO Auto-generated constructor stub
}

public String getStation() {
	return station;
}


/** 버스 정류장 이름 **/
public void setStation(String station) {
	this.station = station;
}

public String getFirstarrive() {
	return firstarrive;
}

public void setFirstarrive(String firstarrive) {
	this.firstarrive = firstarrive;
}

public String getFirstnum() {
	return firstnum;
}

public void setFirstnum(String firstnum) {
	this.firstnum = firstnum;
}

public String getFirstid() {
	return firstid;
}

public void setFirstid(String firstid) {
	this.firstid = firstid;
}

public String getSecondarrive() {
	return secondarrive;
}

public void setSecondarrive(String secondarrive) {
	this.secondarrive = secondarrive;
}

public String getSecondnum() {
	return secondnum;
}

public void setSecondnum(String secondnum) {
	this.secondnum = secondnum;
}

public String getSecondid() {
	return secondid;
}

public void setSecondid(String secondid) {
	this.secondid = secondid;
}

public BusArriveInfo(String station, String firstarrive, String firstnum, String firstid, String secondarrive,
		String secondnum, String secondid) {
	super();
	this.station = station;
	this.firstarrive = firstarrive;
	this.firstnum = firstnum;
	this.firstid = firstid;
	this.secondarrive = secondarrive;
	this.secondnum = secondnum;
	this.secondid = secondid;
}

@Override
public String toString() {
	return "BusArriveInfo [station=" + station + ", firstarrive=" + firstarrive + ", firstnum=" + firstnum
			+ ", firstid=" + firstid + ", secondarrive=" + secondarrive + ", secondnum=" + secondnum + ", secondid="
			+ secondid + "]";
}


	
	
}
