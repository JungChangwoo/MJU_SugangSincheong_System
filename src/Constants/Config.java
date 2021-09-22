package Constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public final class Config {
	
	public static class FVInitial {
		public static final String textChoose = "다음 기능을 선택하세요";
		public static final String textSelect = "로그인(1), 회원등록(2)";
		public static final String Login = "1";
		public static final String Hwewondeungrok = "2";
		public static final String InitialError = "<잘못 입력하셨습니다>\n=======================";
	}
	
	public static class FVLogin {
		public static final String textShow = "[아이디 비밀번호를 입력 하시오]";
		public static final String inputId = "[아이디] : ";
		public static final String inputPassword = "[비밀번호] : ";
		public static final String LoginError ="<아이디와 비밀번호가 올바르지 않습니다>\n==========================";
	}
	
	public static class FVHwewonDeungrok {
		public static final String textShow = "[회원등록 화면입니다.]";
		public static final String inputId = "[아이디] : ";
		public static final String inputPassword = "[비밀번호] : ";
		public static final String inputName = "[이름] : ";
		public static final String inputAddress = "[주소] : ";
		public static final String inputHwakgwa = "[학과] : ";
		public static final String IdError = "<이미 존재하는 아이디입니다>\n=======================";
		public static final String PasswordError = "<잘못된 비밀번호를 입력하셨습니다>\n=======================";
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
