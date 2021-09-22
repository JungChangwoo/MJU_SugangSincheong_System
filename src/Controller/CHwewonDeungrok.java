package Controller;

import DataAccessObject.DHwewonDeungrok;
import ValueObject.OHwewon;
import ValueObject.OIdOverlap;

public class CHwewonDeungrok {
	
	private DHwewonDeungrok dHwewonDeungrok;

	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}

	public void saveHwewon(OHwewon oHwewon) {
		this.dHwewonDeungrok.save(oHwewon);
	}
	
	public OHwewon readHwewon(String id) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(id);
		return oHwewon;
	}
	
	public Boolean idValidation(OIdOverlap oIdOverlap) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(oIdOverlap.getId());
		//중복 있음
		if(oHwewon != null) {
			return true;
		}
		return false;
	}

}
