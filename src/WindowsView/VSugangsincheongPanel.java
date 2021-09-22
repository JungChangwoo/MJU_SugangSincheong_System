package WindowsView;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Constants.Config.FVSugangsincheongPanel;
import ValueObject.OHwewon;
import ValueObject.OLecture;

public class VSugangsincheongPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	private VGangjwagwaSelectionPanel vGangjwagwaSelectionPanel;
	private VGangjwa vMiridamgi;
	private VGangjwa vSincheong;
	private OHwewon oHwewon;

	public VSugangsincheongPanel() {
		super();
		// attributes

		// components
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);

		this.vGangjwagwaSelectionPanel = new VGangjwagwaSelectionPanel();
		this.add(this.vGangjwagwaSelectionPanel);

		JPanel mirisincheongBtnPanel = new JPanel();
		LayoutManager layoutManager2 = new BoxLayout(mirisincheongBtnPanel, BoxLayout.Y_AXIS);
		mirisincheongBtnPanel.setLayout(layoutManager2);

		JButton miridamgiBtn = new JButton("�̸����");
		miridamgiBtn.setAlignmentY(CENTER_ALIGNMENT);
		mirisincheongBtnPanel.add(miridamgiBtn);

		JButton sincheongBtn = new JButton("������û");
		sincheongBtn.setAlignmentY(CENTER_ALIGNMENT);
		mirisincheongBtnPanel.add(sincheongBtn);

		this.add(mirisincheongBtnPanel);

		JPanel miriSincheong = new JPanel();
		layoutManager = new BoxLayout(miriSincheong, BoxLayout.Y_AXIS);
		miriSincheong.setLayout(layoutManager);

			JScrollPane pane;
			this.vMiridamgi = new VGangjwa();
			pane = new JScrollPane(this.vMiridamgi);
			pane.setPreferredSize(FVSugangsincheongPanel.size);
			miriSincheong.add(pane);
	
			JPanel miriControl = new JPanel();
			layoutManager = new BoxLayout(miriControl, BoxLayout.X_AXIS);
			miriControl.setLayout(layoutManager);
	
			JButton miriToSincheongBtn = new JButton("��û");
			miriToSincheongBtn.setAlignmentY(CENTER_ALIGNMENT);
			miriControl.add(miriToSincheongBtn);
	
			JButton deleteMiridamgiBtn = new JButton("����");
			deleteMiridamgiBtn.setAlignmentY(CENTER_ALIGNMENT);
			miriControl.add(deleteMiridamgiBtn);
	
			miriSincheong.add(miriControl);
	
			this.vSincheong = new VGangjwa();
			pane = new JScrollPane(this.vSincheong);
			pane.setPreferredSize(FVSugangsincheongPanel.size);
			miriSincheong.add(pane);

			JButton deleteSincheongBtn = new JButton("����");
			deleteSincheongBtn.setAlignmentX(CENTER_ALIGNMENT);
			miriSincheong.add(deleteSincheongBtn);

		this.add(miriSincheong);

		// �̸���� ��ư Ŭ����
		miridamgiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���Ͽ� ������ �̸���� �ϱ�
				vGangjwagwaSelectionPanel.miridamgi(oHwewon.getId());
				// �̸���� �ʱ�ȭ�� �ٽ� �ҷ�����
				vMiridamgi.initialize();
				vMiridamgi.addRowUser(oHwewon.getId() + "M");
			}
		});

		// ������û ��ư Ŭ����
		sincheongBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���Ͽ� ������ ������û �ϱ�
				vGangjwagwaSelectionPanel.sincheong(oHwewon.getId());
				// ������û �ʱ�ȭ�� �ٽ� �ҷ�����
				vSincheong.initialize();
				vSincheong.addRowUser(oHwewon.getId() + "S");
			}
		});

		// �̸���⿡�� ��û ��ư Ŭ����
		miriToSincheongBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ���Ͽ� ������ ������û �ϱ�
				OLecture oLecture = vMiridamgi.addSincheong(oHwewon.getId() + "S");
				if (oLecture != null) {
					// �̸���⿡�� ����
					vMiridamgi.delete(oHwewon.getId() + "M");
					vMiridamgi.initialize();
					vMiridamgi.addRowUser(oHwewon.getId() + "M");
					// ������û �ʱ�ȭ�� �ٽ� �ҷ�����
					vSincheong.initialize();
					vSincheong.addRowUser(oHwewon.getId() + "S");
					JOptionPane.showMessageDialog(null, oLecture.getName() + "���� ��û ���� ");
				}
			}
		});

		// �̸���⿡�� ���� ��ư Ŭ����
		deleteMiridamgiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �̸���⿡�� ����
				OLecture oLecture = vMiridamgi.delete(oHwewon.getId() + "M");
				if(oLecture != null) {
					vMiridamgi.initialize();
					vMiridamgi.addRowUser(oHwewon.getId() + "M");
					JOptionPane.showMessageDialog(null, oLecture.getName() + "���°� �����Ǿ����ϴ�! ");
				}
			}
		});
		//������û���� ���� ��ư Ŭ����
		deleteSincheongBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �̸���⿡�� ����
				OLecture oLecture = vSincheong.delete(oHwewon.getId() + "S");
				if(oLecture != null) {
					vSincheong.initialize();
					vSincheong.addRowUser(oHwewon.getId() + "S");	
					JOptionPane.showMessageDialog(null, oLecture.getName() + "���°� �����Ǿ����ϴ�! ");
				}
			}
		});
	}

	public void initialize(OHwewon oHwewon) {
		this.oHwewon = oHwewon;
		this.vGangjwagwaSelectionPanel.initialize();
		this.vGangjwagwaSelectionPanel.getData("root");
		this.vMiridamgi.initialize();
		this.vMiridamgi.addRowUser(oHwewon.getId() + "M");
		this.vSincheong.initialize();
		this.vSincheong.addRowUser(oHwewon.getId() + "S");

	}

}
