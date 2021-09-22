package DataAccessObject;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Model.MHwewon;
import ValueObject.OHwewon;

public class DHwewonDeungrok {
	
	MHwewon mHwewon;

	public DHwewonDeungrok() {

	}

	public void save(OHwewon oHwewon) {
		try {
			File file = new File("hwewon");
			//file append го╠Б
			FileWriter fileWriter = new FileWriter(file, true);
			
			this.mHwewon = new MHwewon();
			this.mHwewon.save(fileWriter, oHwewon);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OHwewon read(String id) {
		try {
			File file = new File("hwewon");
			Scanner sc = new Scanner(file);
			
			MHwewon mHwewon = new MHwewon();
			while(mHwewon.read(sc)) {
				if(mHwewon.getId().equals(id)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					return oHwewon;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
