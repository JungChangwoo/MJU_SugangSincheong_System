package WindowsView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Constants.Config.FVGangjwagwaSelectionPanel;
import ValueObject.OIndex;
import ValueObject.OLecture;


public class VGangjwagwaSelectionPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vHwakgwa;
	private VGangjwa vGangjwa;


	public VGangjwagwaSelectionPanel() {
			super();
			// attributes
			LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
			this.setLayout(layoutManager);
			// components
			JScrollPane scrollPane;
			this.vCampus = new VIndex();
			scrollPane = new JScrollPane(this.vCampus);
			scrollPane.setPreferredSize(FVGangjwagwaSelectionPanel.size);
			this.add(scrollPane);
			
			JButton campusBtn = new JButton("ķ�۽� ����");
			campusBtn.setAlignmentX(CENTER_ALIGNMENT);
			this.add(campusBtn);
			
			this.vCollege = new VIndex();
			scrollPane = new JScrollPane(this.vCollege);
			scrollPane.setPreferredSize(FVGangjwagwaSelectionPanel.size);
			this.add(scrollPane);
			
			JButton collegeBtn = new JButton("���� ����");
			collegeBtn.setAlignmentX(CENTER_ALIGNMENT);
			this.add(collegeBtn);
			
			this.vHwakgwa = new VIndex();
			scrollPane = new JScrollPane(this.vHwakgwa);
			scrollPane.setPreferredSize(FVGangjwagwaSelectionPanel.size);
			this.add(scrollPane);
			
			JButton hwakgwaBtn = new JButton("�а� ����");
			hwakgwaBtn.setAlignmentX(CENTER_ALIGNMENT);
			this.add(hwakgwaBtn);
			
			this.vGangjwa = new VGangjwa();
			scrollPane = new JScrollPane(this.vGangjwa);
			scrollPane.setPreferredSize(FVGangjwagwaSelectionPanel.size);
			this.add(scrollPane);
			
			//ķ�۽� ��ư Ŭ����
			campusBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String fileName = vCampus.getSelectedIndex();
					vCollege.initialize();
					vCollege.getData(fileName);
				}
			});
			
			//���� ��ư Ŭ����
			collegeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String fileName = vCollege.getSelectedIndex();
					vHwakgwa.initialize();
					vHwakgwa.getData(fileName);
				}
			});
			
			//�а� ��ư Ŭ����
			hwakgwaBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String fileName = vHwakgwa.getSelectedIndex();
					vGangjwa.initialize();
					vGangjwa.addRow(fileName);
				}
			});
			
		}

	public void initialize() {
		this.vCampus.initialize();
		
		this.vCollege.initialize();
		
		this.vHwakgwa.initialize();
		
		this.vGangjwa.initialize();
		
	}

	public void getData(String fileName) {
		OIndex oIndex;
		this.vCampus.getData(fileName);
//		this.vCollege.getData("yongin");
//		this.vHwakgwa.getData(fileName);
//		OLecture oLecture = this.vGangjwa.addRow(oIndex.getFileName());
//		return oLecture;
	}

	public void miridamgi(String hwewonId) {
		OLecture oLecture = this.vGangjwa.addMiridamgi(hwewonId+"M");
		if(oLecture != null) {
			JOptionPane.showMessageDialog(null, oLecture.getName()+"���� �̸���� ���� ");
		}
	}
	
	public void sincheong(String hwewonId) {
		OLecture oLecture = this.vGangjwa.addSincheong(hwewonId+"S");
		if(oLecture != null) {
			JOptionPane.showMessageDialog(null, oLecture.getName()+"���� ��û ���� ");
		}
	}
}
