package com.topnbiz.teamSplit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.topnbiz.teamSplit.dto.Students;
import com.topnbiz.teamSplit.ui.ConsoleOutput;

public class MainService {
	
	private StudentsService studentsService = new StudentsService();
	private ConsoleOutput consoleOutput = new ConsoleOutput();
	private boolean menuLoop = true;

	ArrayList<Students> students = new ArrayList<Students>();
	ArrayList<Students> studentsGroup = new ArrayList<Students>();
	
	public void mainMenu() {
		
		int inputNumber = 0;
		int groupNum = 0;
		int peopleNum = 0;
		
		consoleOutput.mainTitle();
		studentsService.setStudents(students);
		
		while (menuLoop) {
			
			consoleOutput.oneStepMenu();
			inputNumber = consoleOutput.selectMenu();
			
			//System.out.println(inputNumber);
			
			switch (inputNumber) {
			
			case 1:
				
				this.viewStudents();
				groupNum = consoleOutput.twoStepMenu(inputNumber);
				studentsService.studentInfoArrShuffle(groupNum, students, studentsGroup);
				this.setGroupArr(groupNum);
				break;
			case 2:
				
				this.viewStudents();
				peopleNum = consoleOutput.twoStepMenu(inputNumber);
				this.setInfoDraw(studentsService.studentInfoDraw(peopleNum));
				break;
			case 0:
				
				consoleOutput.programExit();
				return;
			default:

			}
		}
	}
	
	public void viewStudents() {
		
		// 출력
		String strPrint = "";
		for (int i = 0; i < students.size(); i++) {
			strPrint = strPrint 
					+ students.get(i).getNumber() + ". " 
					+ students.get(i).getName() + "\n";
		}
		// 출력 메서드 호출
		consoleOutput.strPrint(strPrint, 1);
	}
	
	//그룹별 출력
	public void setGroupArr(int groupNum){
		
		// 출력
		String strPrint = "";		
		for (int j = 1; j <= groupNum; j++) {
			strPrint = strPrint + j + "팀\t\t";
		}
		strPrint = strPrint + "\n";
		int j = 1;
		for (int i = 0; i < studentsGroup.size(); i++) {
			strPrint = strPrint + studentsGroup.get(i).getNumber() + ". " + studentsGroup.get(i).getName();
			strPrint = strPrint + "\t";
			j += 1; 
			if (j == groupNum + 1) {
				strPrint = strPrint + "\n";
				j = 1;
			}
			
		}
		// 출력 메서드 호출	
		consoleOutput.strPrint(strPrint, 3);
	} 	
	
	public void setInfoDraw(Set<Integer> set){
		
		List<Integer> list = new ArrayList<>(set);
        
        // 출력
 		String strPrint = "";
 		for (int i = 0; i < list.size(); i++) {
 			strPrint = strPrint + this.getArrayValue((int)list.get(i)) + "\n";
 		}
 		// 출력 메서드 호출
 		consoleOutput.strPrint(strPrint, 4);
	}
	
	public String getArrayValue(int numValue) {
		
		return students.get(numValue).getNumber() + ". " + students.get(numValue).getName();
	}
}
