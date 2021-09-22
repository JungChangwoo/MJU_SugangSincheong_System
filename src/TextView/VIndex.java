package TextView;

import java.util.Scanner;
import java.util.Vector;

import Controller.CIndex;
import ValueObject.OIndex;

public class VIndex {
	
	private Scanner scanner;
	
	private CIndex cIndex;

	public VIndex(Scanner scanner) {
		this.scanner = scanner;
		this.cIndex = new CIndex();
	}

	public String show(String name, String fileName) {
		System.out.println("�Ҽ� "+name+"�� ���� �ϼ���");
		Vector<OIndex> indices = cIndex.getAll(fileName);
		for(OIndex index : indices) {
			System.out.println(index.getId()+" "+index.getName());
		}
		String id = this.scanner.next();
		for(OIndex index : indices) {
			if(index.getId().equals(id)) {
				return index.getFileName();
			}
		}
		return null;
	}

}
