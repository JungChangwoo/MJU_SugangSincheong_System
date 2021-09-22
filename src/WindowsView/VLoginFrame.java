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
		
		Label idLabel = new Label("���̵� : ");
		idLabel.setBounds(30, 30, 50, 30);
		p.add(idLabel);
		Label passwordLabel = new Label("��й�ȣ : ");
		passwordLabel.setBounds(30, 90, 50, 30);
		p.add(passwordLabel);
		TextField idTextField = new TextField();
		idTextField.setBounds(120, 30, 200, 30);
		p.add(idTextField);
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setBounds(120, 90, 200, 30);
		p.add(passwordTextField);
		JButton hwewonDeungrokBtn = new JButton("ȸ������");
		hwewonDeungrokBtn.setBounds(350, 30, 100, 30);
		p.add(hwewonDeungrokBtn);
		JButton loginBtn = new JButton("�α���");
		loginBtn.setBounds(350, 90, 100, 30);
		p.add(loginBtn);
		
		this.add(p);
		
		//ȸ������ ��ư Ŭ����
		hwewonDeungrokBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VHwewonDeungrokFrame vHwewonDeungrokFrame = new VHwewonDeungrokFrame();
			}
		});
		//�α��� ��ư Ŭ����
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OLogin oLogin = new OLogin();

				// ���̵� 
				String id = idTextField.getText();
				oLogin.setId(id);

				// ��й�ȣ 
				String password = String.valueOf(passwordTextField.getPassword());
				oLogin.setPassword(password);

				OHwewon oHwewon = cLogin.validation(oLogin);
				if(oHwewon != null) {
					JOptionPane.showMessageDialog(null, oHwewon.getName()+"�� �α����� ȯ���մϴ�!");
					VMainFrame vMainFrame = new VMainFrame();
					vMainFrame.initialize(oHwewon);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�!");
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
