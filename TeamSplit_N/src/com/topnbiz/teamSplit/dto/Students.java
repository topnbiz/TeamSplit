package com.topnbiz.teamSplit.dto;

public class Students {
	
	private int number;
	private String name;
	private int level;
	private int groupNo;
	
	public Students() {

	}
	
	public Students(int number, String name, int level, int groupNo) {
		this.number = number;
		this.name = name;
		this.level = level;
		this.groupNo = groupNo;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
}
