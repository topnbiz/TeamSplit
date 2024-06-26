package com.topnbiz.teamSplit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import com.topnbiz.teamSplit.dto.Students;

public class StudentsService {

	public void setStudents(ArrayList<Students> students) {
		
		students.add(new Students(1, "국하현", 1, 0));
		students.add(new Students(2, "김민재", 0, 0));
		students.add(new Students(3, "김보근", 0, 0));
		students.add(new Students(4, "김유경", 1, 0));
		students.add(new Students(5, "김진우", 0, 0));
		students.add(new Students(6, "송승은", 0, 0));
		students.add(new Students(7, "이상현", 0, 0));
		students.add(new Students(8, "조무연", 0, 0));
		students.add(new Students(9, "조병철", 0, 0));
	}
	
	//수강생 배열을 Copy(clone)후 Shuffle, Sort
	public void studentInfoArrShuffle(int groupNum, ArrayList<Students> students, ArrayList<Students> studentsGroup) {
		
		@SuppressWarnings("unchecked")
		ArrayList<Students> copyStudents = (ArrayList<Students>) students.clone(); //배열(students) 복사(clone)
		
		Collections.shuffle(copyStudents); //배열(copyStudents) shuffle
		//Collections.sort(copyStudents, new StudentLevelComparator().reversed()); //배열(copyOfStudents) 정렬(Sort)
		Collections.sort(copyStudents, new StudentLevelComparator()); //배열(copyOfStudents) 정렬(Sort)
		
		int j = 1;
		for (int i = 0; i < copyStudents.size(); i++) {
			studentsGroup.add(new Students(copyStudents.get(i).getNumber(), copyStudents.get(i).getName(), copyStudents.get(i).getLevel(), j));
			j += 1; 
			if (j == groupNum+1) {
				j = 1;
			}
		}
	}
	
	//메뉴2 특정인원 추첨
	public Set<Integer> studentInfoDraw(int peopleNum) {
		
		Set<Integer> set = new HashSet<>();

        while (set.size() < peopleNum) {
            Double d = Math.random() * 9;
            set.add(d.intValue());
        }

        return set;
	}		
	
	//StudentLevelComparator 클래스는 Comparator 인터페이스를 구현(implements)하고
	//compare() 메서드를 오버라이드
	//Student 객체의 level 인스턴스 변수를 이용해 기본 내림차순으로 설정
	//현재 상태에서 오름차순으로 정렬을 원할시 아래 내용대로 설정을 하거나
	//65째줄 StudentLevelComparator().reversed() 사용하여 변경 가능
	class StudentLevelComparator implements Comparator<Students> {    
		@Override    
		public int compare(Students s1, Students s2) {        
			if (s1.getLevel() > s2.getLevel()) {     
				return -1; //오름차순(양수), 내림차순(음수)
			} else if (s1.getLevel() < s2.getLevel()) {
				return 1; //오름차순(음수), 내림차순(양수)    
			}        
			return 0;    
		}
	}	
}
