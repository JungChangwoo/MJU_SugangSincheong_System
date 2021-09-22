package TextView;

import java.util.Scanner;
import ValueObject.OHwewon;

public class VBackpack {

	private Scanner scanner;
	private VMiridamgi vMiridamgi;
	private VSincheong vSincheong;

	public VBackpack(Scanner scanner) {
		this.scanner = scanner;
		this.vMiridamgi = new VMiridamgi(scanner);
		this.vSincheong = new VSincheong(scanner);
	}

	public void show(OHwewon oHwewon) {
		System.out.println("[å���� ȭ���Դϴ�]");

		// å���� ���� or ������û �ϱ�
		System.out.println("�̸���⳻��(1), ������û����(2)");

		String input = this.scanner.next();

		if (input.equals("1")) {
			this.vMiridamgi.show(oHwewon.getId());
		} else if (input.equals("2")) {
			this.vSincheong.show(oHwewon.getId());
		} else {
			System.out.println("@�߸� �Է��ϼ̽��ϴ�.@\n===================");
			this.show(oHwewon);
		}
		
		
	}

}
