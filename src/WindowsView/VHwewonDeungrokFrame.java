package WindowsView;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Constants.Config.FVHwewonDeungrok;
import Constants.Config.FVHwewonDeungrokFrame;
import Controller.CHwewonDeungrok;
import ValueObject.OHwewon;
import ValueObject.OIdOverlap;

public class VHwewonDeungrokFrame extends JFrame {
	
	private static final long serialVersionUID = 100L;
	
	private CHwewonDeungrok cHwewonDeungrok;
	
	public VHwewonDeungrokFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// attributes
		this.setLocation(FVHwewonDeungrokFrame.location);
		this.setSize(FVHwewonDeungrokFrame.size);
		
		this.cHwewonDeungrok = new CHwewonDeungrok();
		// components
		JPanel p = new JPanel();
		p.setLayout(null);
		
		Label idLabel = new Label("아이디 : ");
		idLabel.setBounds(30, 30, 50, 30);
		p.add(idLabel);
		Label passwordLabel = new Label("비밀번호 : ");
		passwordLabel.setBounds(30, 90, 50, 30);
		p.add(passwordLabel);
		Label nameLabel = new Label("이름 : ");
		nameLabel.setBounds(30, 150, 50, 30);
		p.add(nameLabel);
		Label addressLabel = new Label("주소 : ");
		addressLabel.setBounds(30, 210, 50, 30);
		p.add(addressLabel);
		Label hwakgwaLabel = new Label("학과 : ");
		hwakgwaLabel.setBounds(30, 270, 50, 30);
		p.add(hwakgwaLabel);
		
		TextField idTextField = new TextField();
		idTextField.setBounds(120, 30, 200, 30);
		p.add(idTextField);
		TextField passwordTextField = new TextField();
		passwordTextField.setEchoChar('*');
		passwordTextField.setBounds(120, 90, 200, 30);
		p.add(passwordTextField);
		TextField nameTextField = new TextField();
		nameTextField.setBounds(120, 150, 200, 30);
		p.add(nameTextField);
		TextField addressTextField = new TextField();
		addressTextField.setBounds(120, 210, 200, 30);
		p.add(addressTextField);
		TextField hwakgwaTextField = new TextField();
		hwakgwaTextField.setBounds(120, 270, 200, 30);
		p.add(hwakgwaTextField);
		
		JButton hwewonDeungrokBtn = new JButton("가입");
		hwewonDeungrokBtn.setBounds(80, 330, 100, 30);
		p.add(hwewonDeungrokBtn);
		JButton cancleBtn = new JButton("취소");
		cancleBtn.setBounds(200, 330, 100, 30);
		p.add(cancleBtn);
		
		this.add(p);
		this.setVisible(true);
		
		hwewonDeungrokBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OHwewon oHwewon = new OHwewon();
				OIdOverlap oIdOverlap = new OIdOverlap();
				
				String id = idTextField.getText();
				oHwewon.setId(id);
				oIdOverlap.setId(id);
				
				String password = passwordTextField.getText();
				oHwewon.setPassword(password);
				
				String name = nameTextField.getText();
				oHwewon.setName(name);
				
				String address = addressTextField.getText();
				oHwewon.setAddress(address);
				
				String hwakgwa = hwakgwaTextField.getText();
				oHwewon.setHwakgwa(hwakgwa);
				
				// id 중복 검사
				Boolean isOverlap = cHwewonDeungrok.idValidation(oIdOverlap);
				if(isOverlap) {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다");
				}
				else {
					cHwewonDeungrok.saveHwewon(oHwewon);
					JOptionPane.showMessageDialog(null, "회원가입이 되었습니다");
					dispose();
				}
			}
		});
		
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	
	private void initialize() {
		// TODO Auto-generated method stub
		
	}

}
