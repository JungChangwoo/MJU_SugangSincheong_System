package Controller;

import java.util.Vector;

import DataAccessObject.DLecture;
import ValueObject.OLecture;

public class CLecture {
	
	private DLecture dLecture;
	
	public CLecture() {
		this.dLecture = new DLecture();
	}

	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readAll(fileName);
		return lectures;
	}
	
	public Vector<OLecture> getAllUser(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readAllUser(fileName);
		return lectures;
	}

	public void add(String fileName, OLecture index) {
		this.dLecture.add(fileName, index);
	}

	public OLecture delete(String fileName, OLecture index) {
		Vector<OLecture> lectures = this.getAllUser(fileName);
		//벡터에서 index 지우기
		String id = index.getId();
		int i=0;
		for(OLecture oLecture : lectures) {
			if(oLecture.getId().equals(id)) {
				//벡터에서 제거
				lectures.remove(i);
				//파일에 다시 쓰기
				this.dLecture.write(fileName, lectures);
				return index;
			}
			i++;
		}
		return null;
	}

}
