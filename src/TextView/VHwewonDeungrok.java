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
		// 회원등록 화면임을 알려줌
		System.out.println(FVHwewonDeungrok.textShow);
		OHwewon oHwewon = new OHwewon();
		OIdOverlap oIdOverlap = new OIdOverlap();
		
		// 학번 입력
		System.out.print(FVHwewonDeungrok.inputId);
		String id = scanner.next();
		oHwewon.setId(id);
		oIdOverlap.setId(id);
		// id 중복 검사
		Boolean isOverlap = this.cHwewondeungrok.idValidation(oIdOverlap);
		if(isOverlap) {
			System.out.println(FVHwewonDeungrok.IdError);
			this.show();
		}
		
		// 비밀번호 입력
		System.out.print(FVHwewonDeungrok.inputPassword);
		String password = scanner.next();
		if(password.length() < 6) {
			System.out.println(FVHwewonDeungrok.PasswordError);
			this.show();
		}
		oHwewon.setPassword(password);
		
		//개행문자 제거
		scanner.nextLine();
		// 이름 입력
		System.out.print(FVHwewonDeungrok.inputName);
		String name = scanner.nextLine();
		oHwewon.setName(name);
		
		// 주소 입력
		System.out.print(FVHwewonDeungrok.inputAddress);
		String address = scanner.nextLine();
		oHwewon.setAddress(address);
		
		// 학과 입력
		System.out.print(FVHwewonDeungrok.inputHwakgwa);
		String hwakgwa = scanner.nextLine();
		oHwewon.setHwakgwa(hwakgwa);
		
		this.cHwewondeungrok.saveHwewon(oHwewon);
		
	}

}
