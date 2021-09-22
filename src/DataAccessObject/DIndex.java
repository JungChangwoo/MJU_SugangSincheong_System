package DataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import Model.MIndex;
import ValueObject.OIndex;

public class DIndex {
	
	private static final String PATHNAME = "lectureInfo/";
	MIndex mIndex;
	
	public DIndex() {
		
	}

	public Vector<OIndex> readAll(String fileName) {
		
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			File file = new File(PATHNAME+fileName);
			Scanner sc = new Scanner(file);
			this.mIndex = new MIndex();
			while(this.mIndex.read(sc)) {
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indices;
	}
}
