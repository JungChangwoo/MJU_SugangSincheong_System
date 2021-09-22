package TextView;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.Vector;

import Controller.CLecture;
import ValueObject.OHwewon;
import ValueObject.OLecture;

public class VMiridamgi {
	
	private Scanner scanner;
	private CLecture cLecture;

	public VMiridamgi(Scanner scanner) {
		this.scanner = scanner;
		this.cLecture = new CLecture();
	}
	
	public void show(String hwewonId) {
		String fileName = hwewonId+"M";
		System.out.println("[미리담기내역 화면입니다]");
		
		Vector<OLecture> lectures = cLecture.getAllUser(fileName);
		for(OLecture lecture : lectures) {
			System.out.println(lecture.getId()+" "+lecture.getName()+" "+lecture.getProfessor()+" "+lecture.getCredit()+" "+lecture.getTime());
		}
		
		String id = this.scanner.next();
		
		//만약 잘못된 강좌번호를 입력하면 다시
		boolean isGood = false;
		for(OLecture index : lectures) {
			if(index.getId().equals(id)) {
				isGood = true;
			}
		}
		if(isGood == false) {
			this.show(hwewonId);
		}
		
		for(OLecture index : lectures) {
			if(index.getId().equals(id)) {
				// 선택된 강의 확인
				System.out.println("[선택된 강의 확인]\n" + index.getId() + " " + index.getName() + " "
						+ index.getProfessor() + " " + index.getCredit() + " " + index.getTime());
				// 신청 or 삭제
				System.out.println("[다음 기능을 선택 하세요]");
				System.out.println("신청(1), 삭제(2)");

				String input = this.scanner.next();

				if (input.equals("1")) {
					// 중복이 있는지 확인
					Vector<OLecture> lecturesSincheong = cLecture.getAllUser(hwewonId+"S");
					for(OLecture lecture : lecturesSincheong) {
						//이미 수강신청한 강좌라면
						if(lecture.getId().equals(index.getId())) {
							System.out.println("@이미 수강신청을 한 강좌입니다@\n===================");
							this.show(hwewonId);
							return;
						}
//						//만약 이미 수강신청한 강좌와 시간대가 겹친다면
//						String lectureTime = lecture.getTime();
//						String startTime = lectureTime.split("~")[0];
//						String endTime = lectureTime.split("~")[1];
//						int realStartTime = Integer.parseInt(startTime.split(":")[0])*100+Integer.parseInt(startTime.split(":")[1]);
//						System.out.println(realStartTime);
//						int realEndTime =  Integer.parseInt(endTime.split(":")[0])*100+Integer.parseInt(endTime.split(":")[1]);
//						System.out.println(realEndTime);
					}
		
					// 정상적이라면
					this.cLecture.add(hwewonId+"S", index);
					this.cLecture.delete(hwewonId+"M", index);
					System.out.println(index.getId()+" "+index.getName()+"이 신청되었습니다.");
				} else if (input.equals("2")) {
					this.cLecture.delete(hwewonId+"M", index);
					System.out.println(index.getId()+" "+index.getName()+"이 삭제 되었습니다.");
				} else {
					System.out.println("잘못 입력하셨습니다.");
					this.show(hwewonId);
				}
				return;
			} 
		}
		
		
	}
	
	//미리담기에 추가
	public void add(String hwewonid, OLecture oLecture) {
		this.cLecture.add(hwewonid+"M", oLecture);
	}

}
