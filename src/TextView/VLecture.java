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
		System.out.println(message + "�� ���� �ϼ���");
		Vector<OLecture> lectures = cLecture.getAll(fileName);
		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}

		String id = this.scanner.next();

		// ���� �߸��� ���¹�ȣ�� �Է��ϸ� �ٽ�
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
				// ���õ� ���� Ȯ��
				System.out.println("[���õ� ���� Ȯ��]\n" + index.getId() + " " + index.getName() + " " + index.getProfessor()
						+ " " + index.getCredit() + " " + index.getTime());
				// �̸���� or ������û
				System.out.println("[���� ����� ���� �ϼ���]");
				System.out.println("�̸����(1), ������û(2)");

				String input = this.scanner.next();

				if (input.equals("1")) {
					// �ߺ��� �ִ��� Ȯ��
					Vector<OLecture> lecturesMiridamgi = cLecture.getAllUser(hwewonId + "M");
					for (OLecture lecture : lecturesMiridamgi) {
						// �̹� �̸������ ���¶��
						if (lecture.getId().equals(index.getId())) {
							System.out.println("@�̹� �̸���⸦ �� �����Դϴ�@\n===================");
							return this.show(message, fileName, hwewonId);
						}
					}
					this.cLecture.add(hwewonId + "M", index);
					System.out.println(index.getName() + " �̸���� ����!");
					return this.show(message, fileName, hwewonId);
				} else if (input.equals("2")) {
					// �ߺ��� �ִ��� Ȯ��
					Vector<OLecture> lecturesSincheong = cLecture.getAllUser(hwewonId + "S");
					for (OLecture lecture : lecturesSincheong) {
						// �̹� �̸������ ���¶��
						if (lecture.getId().equals(index.getId())) {
							System.out.println("@�̹� ������û�� �� �����Դϴ�@\n===================");
							return this.show(message, fileName, hwewonId);
						}
					}
					this.cLecture.add(hwewonId + "S", index);
					System.out.println(index.getName() + " ������û ����!");
					return this.show(message, fileName, hwewonId);
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					this.show(message, fileName, hwewonId);
				}
				return index;
			}
		}
		return null;
	}

}
