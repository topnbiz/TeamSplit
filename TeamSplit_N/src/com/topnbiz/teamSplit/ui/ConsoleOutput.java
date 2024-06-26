package com.topnbiz.teamSplit.ui;

import java.util.Scanner;

public class ConsoleOutput {
	
	private Scanner scanner = new Scanner(System.in);

	public void mainTitle() {
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("▶ 수강생 팀구성(랜덤) 프로그램");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public void oneStepMenu() {
		
		System.out.println();
		System.out.println("1 : 수강생 팀구성(랜덤)");
		System.out.println("2 : 수강생 추첨(랜덤)");
		System.out.println("0 : 프로그램 종료");
		
	}
	
	public int twoStepMenu(int menuNum){
		
		int selectNum = 0;
		
		if (menuNum == 1) {
			
			System.out.println();
			System.out.println("【수강생 팀구성(랜덤)】");
			System.out.print("▶ 몇 팀으로 구성 하시겠습니까? : ");
			selectNum = scanner.nextInt();
		}
		else if (menuNum == 2) {
			
			System.out.println();
			System.out.println("【수강생 추첨(랜덤)】");
			System.out.print("▶ 몇 명을 추첨 하시겠습니까? : ");
			selectNum = scanner.nextInt();
		}

		//scan.close();
		return selectNum;
		
	}	
	
	public int selectMenu() {
		
		System.out.println();
		System.out.print("메뉴를 선택하세요! : ");
		int menuNumber = scanner.nextInt();
		
		if (menuNumber >= 0 && menuNumber <= 2) {
			scanner.nextLine();
			return menuNumber;
		}
		else {
			System.err.println("[오류] 잘못된 메뉴 입니다! --> " + menuNumber);
			System.out.println("");
			//menuLoop = false;
			return -1;
		}
	}
	
	public void programExit(){
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("▶ 프로그램이 종료 되었습니다.");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}	
	
	public void strPrint(String strValue, int numValue) {
		
		switch (numValue) {
		case 1: {
			
			System.out.println("\n");
			System.out.println("【현재 등록된 수강생 리스트】");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(strValue);
			System.out.println();
			break;
		}
		case 2: {
			
			break;
		}
		case 3: {
			
			System.out.println("\n");
			System.out.println("【수강생 팀구성(랜덤)이 완료 되었습니다.】");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(strValue);
			System.out.println();
			break;
		}	
		case 4: {
			
			System.out.println("\n");
			System.out.println("【수강생 추첨(랜덤)이 완료 되었습니다.】");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(strValue);
			System.out.println();
			break;
		}	
		default:
			System.out.println("\n");
			System.out.println("【오류 입니다】");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(strValue);
			System.out.println();
		}
	}
}
