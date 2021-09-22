package TextView;


import java.util.Scanner;

import Constants.Config.FVLogin;
import Controller.CLogin;
import ValueObject.OHwewon;
import ValueObject.OLogin;

public class VLogin {

	Scanner scanner;

	private CLogin cLogin;

	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.cLogin = new CLogin();
	}

	public OHwewon show() {
		// ȸ����� ȭ������ �˷���
		System.out.println(FVLogin.textShow);
		
		OLogin oLogin = new OLogin();

		// ���̵� �Է�
		System.out.print(FVLogin.inputId);
		String id = scanner.next();
		oLogin.setId(id);

		// ��й�ȣ �Է�
		System.out.print(FVLogin.inputPassword);
		String password = scanner.next();
		oLogin.setPassword(password);


		OHwewon oHwewon = this.cLogin.validation(oLogin);
		if(oHwewon != null) {
			return  oHwewon;
		} else {
			System.out.println(FVLogin.LoginError);
			return this.show();
		}
	}

}
