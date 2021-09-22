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
		System.out.println("[������û���� ȭ���Դϴ�]");

		Vector<OLecture> lectures = cLecture.getAllUser(fileName);
		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}
		
		String id = this.scanner.next();
		// �߸��� ���� ����
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
				// ���õ� ���� Ȯ��
				System.out.println("[���õ� ���� Ȯ��]\n" + index.getId() + " " + index.getName() + " " + index.getProfessor()
						+ " " + index.getCredit() + " " + index.getTime());
				// ��û or ����
				System.out.println("[�ش� ���Ǹ� �����Ͻðڽ��ϱ�?]");
				System.out.println("��(1), �ƴϿ�(2)");

				String input = this.scanner.next();

				if (input.equals("1")) {
					this.cLecture.delete(hwewonId +"S", index);
					System.out.println(index.getId()+" "+index.getName()+"�� �����Ǿ����ϴ�.");
				} else if (input.equals("2")) {
					this.show(hwewonId);
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					this.show(hwewonId);
				}
				return;
			}
		}

	}

	// ������û�� �߰�
	public void add(String hwewonId, OLecture oLecture) {
		this.cLecture.add(hwewonId + "S", oLecture);
	}

}
