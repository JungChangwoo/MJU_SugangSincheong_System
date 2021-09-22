package WindowsView;


import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Constants.Config.FVInitialFrame;
import Controller.CLogin;
import ValueObject.OHwewon;
import ValueObject.OLogin;



public class VLoginFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 100L;
	
	// components
	private CLogin cLogin;
	
	public VLoginFrame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// attributes
		this.cLogin = new CLogin();
		this.setLocation(FVInitialFrame.location);
		this.setSize(FVInitialFrame.size);
		// components
		JPanel p = new JPanel();
		p.setLayout(null);
		
		Label idLabel = new Label("아이디 : ");
		idLabel.setBounds(30, 30, 50, 30);
		p.add(idLabel);
		Label passwordLabel = new Label("비밀번호 : ");
		passwordLabel.setBounds(30, 90, 50, 30);
		p.add(passwordLabel);
		TextField idTextField = new TextField();
		idTextField.setBounds(120, 30, 200, 30);
		p.add(idTextField);
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setBounds(120, 90, 200, 30);
		p.add(passwordTextField);
		JButton hwewonDeungrokBtn = new JButton("회원가입");
		hwewonDeungrokBtn.setBounds(350, 30, 100, 30);
		p.add(hwewonDeungrokBtn);
		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(350, 90, 100, 30);
		p.add(loginBtn);
		
		this.add(p);
		
		//회원가입 버튼 클릭시
		hwewonDeungrokBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VHwewonDeungrokFrame vHwewonDeungrokFrame = new VHwewonDeungrokFrame();
			}
		});
		//로그인 버튼 클릭시
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OLogin oLogin = new OLogin();

				// 아이디 
				String id = idTextField.getText();
				oLogin.setId(id);

				// 비밀번호 
				String password = String.valueOf(passwordTextField.getPassword());
				oLogin.setPassword(password);

				OHwewon oHwewon = cLogin.validation(oLogin);
				if(oHwewon != null) {
					JOptionPane.showMessageDialog(null, oHwewon.getName()+"님 로그인을 환영합니다!");
					VMainFrame vMainFrame = new VMainFrame();
					vMainFrame.initialize(oHwewon);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다!");
				}
				
			}
			
		});
	}
	
	public void initialize() {
		// variable attributes
		
//		// components
		
	}

	public static void main(String[] args) {
		VLoginFrame vLoginFrame = new VLoginFrame();
		vLoginFrame.setVisible(true);
	}


}
