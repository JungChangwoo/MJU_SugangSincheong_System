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
		System.out.println( oHwewon.getName() +"�� �α����� ȯ���մϴ�!");
		
		// å���� ���� or ������û �ϱ�
		System.out.println("[���� ����� ���� �ϼ���]");
		System.out.println("å����(1), ������û(2)");

		String input = this.scanner.next();

		if (input.equals("1")) {
			this.vBackpack.show(oHwewon);
		} else if (input.equals("2")) {
			while(true) {
				String campusFileName = this.vCampus.show("ķ�۽���", "root");
				if(campusFileName==null) continue;
				else {
					String collegeFileName = this.vCollege.show("������", campusFileName);
					if(collegeFileName==null) continue;
					else {
						String departmentFileName = this.vDepartment.show("�а���", collegeFileName);
						if(departmentFileName==null) continue;
						else {
							OLecture oLecture = this.vLecture.show("����", departmentFileName, oHwewon.getId());
							break;
						}
					}
				} 
			}
		} else {
			System.out.println("@�߸� �Է��ϼ̽��ϴ�@\n==========================");
			this.show(oHwewon);
		}


//		System.out.println("�ش� ������ �����ϴ�.");
	}

}
