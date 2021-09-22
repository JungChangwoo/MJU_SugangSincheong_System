package TextView;

import java.util.Scanner;

import Constants.Config.FVHwewonDeungrok;
import Controller.CHwewonDeungrok;
import ValueObject.OHwewon;
import ValueObject.OIdOverlap;

public class VHwewonDeungrok {
	
	private Scanner scanner;

	private CHwewonDeungrok cHwewondeungrok;

	public VHwewonDeungrok(Scanner scanner) {
		this.scanner = scanner;
		this.cHwewondeungrok = new CHwewonDeungrok();
	}

	public void show() {
		// ȸ����� ȭ������ �˷���
		System.out.println(FVHwewonDeungrok.textShow);
		OHwewon oHwewon = new OHwewon();
		OIdOverlap oIdOverlap = new OIdOverlap();
		
		// �й� �Է�
		System.out.print(FVHwewonDeungrok.inputId);
		String id = scanner.next();
		oHwewon.setId(id);
		oIdOverlap.setId(id);
		// id �ߺ� �˻�
		Boolean isOverlap = this.cHwewondeungrok.idValidation(oIdOverlap);
		if(isOverlap) {
			System.out.println(FVHwewonDeungrok.IdError);
			this.show();
		}
		
		// ��й�ȣ �Է�
		System.out.print(FVHwewonDeungrok.inputPassword);
		String password = scanner.next();
		if(password.length() < 6) {
			System.out.println(FVHwewonDeungrok.PasswordError);
			this.show();
		}
		oHwewon.setPassword(password);
		
		//���๮�� ����
		scanner.nextLine();
		// �̸� �Է�
		System.out.print(FVHwewonDeungrok.inputName);
		String name = scanner.nextLine();
		oHwewon.setName(name);
		
		// �ּ� �Է�
		System.out.print(FVHwewonDeungrok.inputAddress);
		String address = scanner.nextLine();
		oHwewon.setAddress(address);
		
		// �а� �Է�
		System.out.print(FVHwewonDeungrok.inputHwakgwa);
		String hwakgwa = scanner.nextLine();
		oHwewon.setHwakgwa(hwakgwa);
		
		this.cHwewondeungrok.saveHwewon(oHwewon);
		
	}

}
