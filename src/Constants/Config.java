package Constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public final class Config {
	
	public static class FVInitial {
		public static final String textChoose = "���� ����� �����ϼ���";
		public static final String textSelect = "�α���(1), ȸ�����(2)";
		public static final String Login = "1";
		public static final String Hwewondeungrok = "2";
		public static final String InitialError = "<�߸� �Է��ϼ̽��ϴ�>\n=======================";
	}
	
	public static class FVLogin {
		public static final String textShow = "[���̵� ��й�ȣ�� �Է� �Ͻÿ�]";
		public static final String inputId = "[���̵�] : ";
		public static final String inputPassword = "[��й�ȣ] : ";
		public static final String LoginError ="<���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�>\n==========================";
	}
	
	public static class FVHwewonDeungrok {
		public static final String textShow = "[ȸ����� ȭ���Դϴ�.]";
		public static final String inputId = "[���̵�] : ";
		public static final String inputPassword = "[��й�ȣ] : ";
		public static final String inputName = "[�̸�] : ";
		public static final String inputAddress = "[�ּ�] : ";
		public static final String inputHwakgwa = "[�а�] : ";
		public static final String IdError = "<�̹� �����ϴ� ���̵��Դϴ�>\n=======================";
		public static final String PasswordError = "<�߸��� ��й�ȣ�� �Է��ϼ̽��ϴ�>\n=======================";
	}
	
	public static class FVMainFrame {
		public static final Point location = new Point(300, 0);
		public static final Dimension size = new Dimension(1000, 750);
		
	}
	
	public static class FVMainPanel {
		public static final Color background = Color.white;
	}
	
	public static class FVInitialFrame {
		public static final Dimension size = new Dimension(500,250);
		public static final Point location = new Point(500, 300);
	}
	
	public static class FVHwewonDeungrokFrame {
		public static final Dimension size = new Dimension(500,600);
		public static final Point location = new Point(500, 150);
	}
	
	public static class FVSugangsincheongPanel{
		public static final Dimension size = new Dimension(450, 300);
	}
	
	public static class FVGangjwagwaSelectionPanel {
		public static final Dimension size = new Dimension(450, 150);
	}
}
