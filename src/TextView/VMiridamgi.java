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
		System.out.println("[�̸���⳻�� ȭ���Դϴ�]");
		
		Vector<OLecture> lectures = cLecture.getAllUser(fileName);
		for(OLecture lecture : lectures) {
			System.out.println(lecture.getId()+" "+lecture.getName()+" "+lecture.getProfessor()+" "+lecture.getCredit()+" "+lecture.getTime());
		}
		
		String id = this.scanner.next();
		
		//���� �߸��� ���¹�ȣ�� �Է��ϸ� �ٽ�
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
				// ���õ� ���� Ȯ��
				System.out.println("[���õ� ���� Ȯ��]\n" + index.getId() + " " + index.getName() + " "
						+ index.getProfessor() + " " + index.getCredit() + " " + index.getTime());
				// ��û or ����
				System.out.println("[���� ����� ���� �ϼ���]");
				System.out.println("��û(1), ����(2)");

				String input = this.scanner.next();

				if (input.equals("1")) {
					// �ߺ��� �ִ��� Ȯ��
					Vector<OLecture> lecturesSincheong = cLecture.getAllUser(hwewonId+"S");
					for(OLecture lecture : lecturesSincheong) {
						//�̹� ������û�� ���¶��
						if(lecture.getId().equals(index.getId())) {
							System.out.println("@�̹� ������û�� �� �����Դϴ�@\n===================");
							this.show(hwewonId);
							return;
						}
//						//���� �̹� ������û�� ���¿� �ð��밡 ��ģ�ٸ�
//						String lectureTime = lecture.getTime();
//						String startTime = lectureTime.split("~")[0];
//						String endTime = lectureTime.split("~")[1];
//						int realStartTime = Integer.parseInt(startTime.split(":")[0])*100+Integer.parseInt(startTime.split(":")[1]);
//						System.out.println(realStartTime);
//						int realEndTime =  Integer.parseInt(endTime.split(":")[0])*100+Integer.parseInt(endTime.split(":")[1]);
//						System.out.println(realEndTime);
					}
		
					// �������̶��
					this.cLecture.add(hwewonId+"S", index);
					this.cLecture.delete(hwewonId+"M", index);
					System.out.println(index.getId()+" "+index.getName()+"�� ��û�Ǿ����ϴ�.");
				} else if (input.equals("2")) {
					this.cLecture.delete(hwewonId+"M", index);
					System.out.println(index.getId()+" "+index.getName()+"�� ���� �Ǿ����ϴ�.");
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					this.show(hwewonId);
				}
				return;
			} 
		}
		
		
	}
	
	//�̸���⿡ �߰�
	public void add(String hwewonid, OLecture oLecture) {
		this.cLecture.add(hwewonid+"M", oLecture);
	}

}
