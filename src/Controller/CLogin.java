package Controller;

import DataAccessObject.DHwewonDeungrok;
import ValueObject.OHwewon;
import ValueObject.OLogin;

public class CLogin {
	
	private DHwewonDeungrok dHwewonDeungrok;
	
	public CLogin() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}

	public OHwewon validation(OLogin oLogin) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		if(oHwewon != null) {
			if(oLogin.getPassword().equals(oHwewon.getPassword())){
				return oHwewon;
			}
		}
		return null;
	}

}
