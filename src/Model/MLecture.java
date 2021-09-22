package Model;

import java.io.FileWriter;
import java.util.Scanner;

import ValueObject.OLecture;


public class MLecture {

	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	
	public boolean read(Scanner sc) {
		if (sc.hasNext()) {
			this.id = sc.next();
			this.name = sc.next();
			this.professor= sc.next();
			this.credit= sc.next();
			this.time= sc.next();
			return true;
		}
		return false;
	}
	
	public void save(FileWriter fw, OLecture oLecture) {
		this.set(oLecture);

		// 파일에 저장하기
		try {
			// 쓰고 delimiter
			fw.write(id);
			fw.write(" ");
			fw.write(name);
			fw.write(" ");
			fw.write(professor);
			fw.write(" ");
			fw.write(credit);
			fw.write(" ");
			fw.write(time);
			fw.write("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void set(OLecture oLecture) {
		this.id = oLecture.getId();
		this.name = oLecture.getName();
		this.professor = oLecture.getProfessor();
		this.credit = oLecture.getCredit();
		this.time = oLecture.getTime();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
	
	
}
