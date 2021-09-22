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
		System.out.println("[책가방 화면입니다]");

		// 책가방 보기 or 수강신청 하기
		System.out.println("미리담기내역(1), 수강신청내역(2)");

		String input = this.scanner.next();

		if (input.equals("1")) {
			this.vMiridamgi.show(oHwewon.getId());
		} else if (input.equals("2")) {
			this.vSincheong.show(oHwewon.getId());
		} else {
			System.out.println("@잘못 입력하셨습니다.@\n===================");
			this.show(oHwewon);
		}
		
		
	}

}
