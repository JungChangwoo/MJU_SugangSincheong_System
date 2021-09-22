package TextView;

import java.util.Scanner;
import java.util.Vector;

import Controller.CLecture;
import ValueObject.OHwewon;
import ValueObject.OLecture;

public class VSincheong {

	Scanner scanner;
	CLecture cLecture;

	public VSincheong(Scanner scanner) {
		this.scanner = scanner;
		this.cLecture = new CLecture();
	}

	public void show(String hwewonId) {
		String fileName = hwewonId + "S";
		System.out.println("[수강신청내역 화면입니다]");

		Vector<OLecture> lectures = cLecture.getAllUser(fileName);
		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}
		
		String id = this.scanner.next();
		// 잘못된 강좌 선택
		boolean isGood = false;
		for(OLecture index : lectures) {
			if(index.getId().equals(id)) {
				isGood = true;
			}
		}
		if(isGood == false) {
			this.show(hwewonId);
		}

		for (OLecture index : lectures) {
			if (index.getId().equals(id)) {
				// 선택된 강의 확인
				System.out.println("[선택된 강의 확인]\n" + index.getId() + " " + index.getName() + " " + index.getProfessor()
						+ " " + index.getCredit() + " " + index.getTime());
				// 신청 or 삭제
				System.out.println("[해당 강의를 삭제하시겠습니까?]");
				System.out.println("예(1), 아니오(2)");

				String input = this.scanner.next();

				if (input.equals("1")) {
					this.cLecture.delete(hwewonId +"S", index);
					System.out.println(index.getId()+" "+index.getName()+"이 삭제되었습니다.");
				} else if (input.equals("2")) {
					this.show(hwewonId);
				} else {
					System.out.println("잘못 입력하셨습니다.");
					this.show(hwewonId);
				}
				return;
			}
		}

	}

	// 수강신청에 추가
	public void add(String hwewonId, OLecture oLecture) {
		this.cLecture.add(hwewonId + "S", oLecture);
	}

}
