package TextView;

import java.util.Scanner;
import java.util.Vector;

import Controller.CIndex;
import Controller.CLecture;
import ValueObject.OIndex;
import ValueObject.OLecture;

public class VLecture {

	private Scanner scanner;
	private CLecture cLecture;

	public VLecture(Scanner scanner) {
		this.scanner = scanner;
		this.cLecture = new CLecture();
	}

	public OLecture show(String message, String fileName, String hwewonId) {
		System.out.println(message + "를 선택 하세요");
		Vector<OLecture> lectures = cLecture.getAll(fileName);
		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}

		String id = this.scanner.next();

		// 만약 잘못된 강좌번호를 입력하면 다시
		boolean isGood = false;
		for (OLecture index : lectures) {
			if (index.getId().equals(id)) {
				isGood = true;
			}
		}
		if (isGood == false) {
			return this.show(message, fileName, hwewonId);
		}

		for (OLecture index : lectures) {
			if (index.getId().equals(id)) {
				// 선택된 강의 확인
				System.out.println("[선택된 강의 확인]\n" + index.getId() + " " + index.getName() + " " + index.getProfessor()
						+ " " + index.getCredit() + " " + index.getTime());
				// 미리담기 or 수강신청
				System.out.println("[다음 기능을 선택 하세요]");
				System.out.println("미리담기(1), 수강신청(2)");

				String input = this.scanner.next();

				if (input.equals("1")) {
					// 중복이 있는지 확인
					Vector<OLecture> lecturesMiridamgi = cLecture.getAllUser(hwewonId + "M");
					for (OLecture lecture : lecturesMiridamgi) {
						// 이미 미리담기한 강좌라면
						if (lecture.getId().equals(index.getId())) {
							System.out.println("@이미 미리담기를 한 강좌입니다@\n===================");
							return this.show(message, fileName, hwewonId);
						}
					}
					this.cLecture.add(hwewonId + "M", index);
					System.out.println(index.getName() + " 미리담기 성공!");
					return this.show(message, fileName, hwewonId);
				} else if (input.equals("2")) {
					// 중복이 있는지 확인
					Vector<OLecture> lecturesSincheong = cLecture.getAllUser(hwewonId + "S");
					for (OLecture lecture : lecturesSincheong) {
						// 이미 미리담기한 강좌라면
						if (lecture.getId().equals(index.getId())) {
							System.out.println("@이미 수강신청을 한 강좌입니다@\n===================");
							return this.show(message, fileName, hwewonId);
						}
					}
					this.cLecture.add(hwewonId + "S", index);
					System.out.println(index.getName() + " 수강신청 성공!");
					return this.show(message, fileName, hwewonId);
				} else {
					System.out.println("잘못 입력하셨습니다.");
					this.show(message, fileName, hwewonId);
				}
				return index;
			}
		}
		return null;
	}

}
