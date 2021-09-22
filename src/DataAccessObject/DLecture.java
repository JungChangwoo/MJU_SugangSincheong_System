package DataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import Model.MLecture;

import ValueObject.OLecture;

public class DLecture {
	
	private static final String PATHNAME = "lectureInfo/";
	private static final String USERPATHNAME = "user/";
	MLecture mLecture;

	public Vector<OLecture> readAll(String fileName) {
		Vector<OLecture> indices = new Vector<OLecture>();
		try {
			File file = new File(PATHNAME+fileName);
			Scanner sc = new Scanner(file);
			this.mLecture = new MLecture();
			while(this.mLecture.read(sc)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				indices.add(oLecture);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indices;
	}
	
	public Vector<OLecture> readAllUser(String fileName) {
		Vector<OLecture> indices = new Vector<OLecture>();
		try {
			File file = new File(USERPATHNAME+fileName);
			Scanner sc = new Scanner(file);
			this.mLecture = new MLecture();
			while(this.mLecture.read(sc)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				indices.add(oLecture);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indices;
	}

	public void add(String filename, OLecture oLecture) {
		try {
			File file = new File(USERPATHNAME+filename);
			//file append го╠Б
			FileWriter fileWriter = new FileWriter(file, true);
			
			this.mLecture = new MLecture();
			mLecture.save(fileWriter, oLecture);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String fileName, Vector<OLecture> lectures) {
		try {
			File file = new File(USERPATHNAME+fileName);
			
			FileWriter fileWriter = new FileWriter(file, false);
			
			this.mLecture = new MLecture();
			for(OLecture oLecture : lectures) {
				mLecture.save(fileWriter, oLecture);
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
