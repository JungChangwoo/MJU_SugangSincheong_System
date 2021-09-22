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

		JButton miridamgiBtn = new JButton("미리담기");
		miridamgiBtn.setAlignmentY(CENTER_ALIGNMENT);
		mirisincheongBtnPanel.add(miridamgiBtn);

		JButton sincheongBtn = new JButton("수강신청");
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
	
			JButton miriToSincheongBtn = new JButton("신청");
			miriToSincheongBtn.setAlignmentY(CENTER_ALIGNMENT);
			miriControl.add(miriToSincheongBtn);
	
			JButton deleteMiridamgiBtn = new JButton("삭제");
			deleteMiridamgiBtn.setAlignmentY(CENTER_ALIGNMENT);
			miriControl.add(deleteMiridamgiBtn);
	
			miriSincheong.add(miriControl);
	
			this.vSincheong = new VGangjwa();
			pane = new JScrollPane(this.vSincheong);
			pane.setPreferredSize(FVSugangsincheongPanel.size);
			miriSincheong.add(pane);

			JButton deleteSincheongBtn = new JButton("삭제");
			deleteSincheongBtn.setAlignmentX(CENTER_ALIGNMENT);
			miriSincheong.add(deleteSincheongBtn);

		this.add(miriSincheong);

		// 미리담기 버튼 클릭시
		miridamgiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일에 실제로 미리담기 하기
				vGangjwagwaSelectionPanel.miridamgi(oHwewon.getId());
				// 미리담기 초기화후 다시 불러오기
				vMiridamgi.initialize();
				vMiridamgi.addRowUser(oHwewon.getId() + "M");
			}
		});

		// 수강신청 버튼 클릭시
		sincheongBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일에 실제로 수강신청 하기
				vGangjwagwaSelectionPanel.sincheong(oHwewon.getId());
				// 수강신청 초기화후 다시 불러오기
				vSincheong.initialize();
				vSincheong.addRowUser(oHwewon.getId() + "S");
			}
		});

		// 미리담기에서 신청 버튼 클릭시
		miriToSincheongBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 파일에 실제로 수강신청 하기
				OLecture oLecture = vMiridamgi.addSincheong(oHwewon.getId() + "S");
				if (oLecture != null) {
					// 미리담기에서 삭제
					vMiridamgi.delete(oHwewon.getId() + "M");
					vMiridamgi.initialize();
					vMiridamgi.addRowUser(oHwewon.getId() + "M");
					// 수강신청 초기화후 다시 불러오기
					vSincheong.initialize();
					vSincheong.addRowUser(oHwewon.getId() + "S");
					JOptionPane.showMessageDialog(null, oLecture.getName() + "강좌 신청 성공 ");
				}
			}
		});

		// 미리담기에서 삭제 버튼 클릭시
		deleteMiridamgiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 미리담기에서 삭제
				OLecture oLecture = vMiridamgi.delete(oHwewon.getId() + "M");
				if(oLecture != null) {
					vMiridamgi.initialize();
					vMiridamgi.addRowUser(oHwewon.getId() + "M");
					JOptionPane.showMessageDialog(null, oLecture.getName() + "강좌가 삭제되었습니다! ");
				}
			}
		});
		//수강신청에서 삭제 버튼 클릭시
		deleteSincheongBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 미리담기에서 삭제
				OLecture oLecture = vSincheong.delete(oHwewon.getId() + "S");
				if(oLecture != null) {
					vSincheong.initialize();
					vSincheong.addRowUser(oHwewon.getId() + "S");	
					JOptionPane.showMessageDialog(null, oLecture.getName() + "강좌가 삭제되었습니다! ");
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
