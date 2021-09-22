package TextView;

import java.util.Scanner;

public class VMain {
	
	//��ĳ��
	private Scanner scanner;
	
	//�ʱ�ȭ��
	private VInitial  initial;
	
	public VMain(Scanner scanner) {
		this.scanner = scanner;
		this.initial = new VInitial(this.scanner);
	}
	
	public void run() {
		this.initial.show();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		VMain main = new VMain(scanner);
		main.run();
		
		scanner.close();
	}

}
