package Model;

import java.io.FileWriter;
import java.util.Scanner;

import ValueObject.OHwewon;

public class MHwewon {

	private String id;
	private String password;
	private String name;
	private String address;
	private String hwakgwa;

	// ���Ͽ� ����
	public void save(FileWriter fw, OHwewon oHwewon) {

		this.set(oHwewon);

		// ���Ͽ� �����ϱ�
		try {
			// ���� delimiter
			fw.write(id);
			fw.write("\n");
			fw.write(password);
			fw.write("\n");
			fw.write(name);
			fw.write("\n");
			fw.write(address);
			fw.write("\n");
			fw.write(hwakgwa);
			fw.write("\n");

			System.out.println("======ȸ����Ͽ� �����Ͽ����ϴ�=====");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� �б�
	public boolean read(Scanner sc) {
		if (sc.hasNext()) {
			this.id = sc.next();
			this.password = sc.next();
			sc.nextLine();
			this.name = sc.nextLine();
			this.address = sc.nextLine();
			this.hwakgwa = sc.nextLine();
			return true;
		}
		return false;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHwakgwa() {
		return hwakgwa;
	}

	public void setHwakgwa(String hwakgwa) {
		this.hwakgwa = hwakgwa;
	}

	private void set(OHwewon oHwewon) {
		this.id = oHwewon.getId();
		this.password = oHwewon.getPassword();
		this.name = oHwewon.getName();
		this.address = oHwewon.getAddress();
		this.hwakgwa = oHwewon.getHwakgwa();
	}

}
