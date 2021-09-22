package TextView;

import java.util.Scanner;

import Constants.Config.FVInitial;
import ValueObject.OHwewon;

public class VInitial {
	
	private Scanner scanner;
	
	private VHwewonDeungrok hwewondeungrok;
	private VLogin login;
	private VSugangsincheon vSugangsincheon;
	
	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.hwewondeungrok = new VHwewonDeungrok(this.scanner);
		this.login = new VLogin(this.scanner);
	}

	public void show() {
		System.out.println(FVInitial.textChoose);
		System.out.println(FVInitial.textSelect);
		
		String input = this.scanner.next();
		
		if(input.equals(FVInitial.Login)) {
			OHwewon oHwewon = this.login.show();
			if(oHwewon != null) {
				this.vSugangsincheon = new VSugangsincheon(this.scanner);
				this.vSugangsincheon.show(oHwewon);
			}
		} else if (input.equals(FVInitial.Hwewondeungrok)) {
			this.hwewondeungrok.show();
		} else {
			System.out.println(FVInitial.InitialError);
			this.show();
		}
	}
}
