package TextView;

import java.util.Scanner;

import ValueObject.OHwewon;
import ValueObject.OLecture;

public class VSugangsincheon {

	private Scanner scanner;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	private VBackpack vBackpack;

	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.vBackpack = new VBackpack(this.scanner);
	}

	public void show(OHwewon oHwewon) {
		System.out.println( oHwewon.getName() +"님 로그인을 환영합니다!");
		
		// 책가방 보기 or 수강신청 하기
		System.out.println("[다음 기능을 선택 하세요]");
		System.out.println("책가방(1), 수강신청(2)");

		String input = this.scanner.next();

		if (input.equals("1")) {
			this.vBackpack.show(oHwewon);
		} else if (input.equals("2")) {
			while(true) {
				String campusFileName = this.vCampus.show("캠퍼스를", "root");
				if(campusFileName==null) continue;
				else {
					String collegeFileName = this.vCollege.show("대학을", campusFileName);
					if(collegeFileName==null) continue;
					else {
						String departmentFileName = this.vDepartment.show("학과를", collegeFileName);
						if(departmentFileName==null) continue;
						else {
							OLecture oLecture = this.vLecture.show("강의", departmentFileName, oHwewon.getId());
							break;
						}
					}
				} 
			}
		} else {
			System.out.println("@잘못 입력하셨습니다@\n==========================");
			this.show(oHwewon);
		}


//		System.out.println("해당 파일이 없습니다.");
	}

}
