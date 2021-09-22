package WindowsView;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.CLecture;
import ValueObject.OIndex;
import ValueObject.OLecture;

public class VGangjwa extends JTable {

	private static final long serialVersionUID = 1L;
	// associations
	private CLecture cLecture;
	private DefaultTableModel model;
	private Vector<OLecture> oLectures;

	// 고정적인 것들
	public VGangjwa() {
		super();
		// attributes(속성 변화)
		// 단일선택
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components(구조)
		this.model = (DefaultTableModel) this.getModel();

		model.addColumn("강좌명");
		model.addColumn("강사명");
		model.addColumn("학점");
		model.addColumn("시간");
		// associations(구조)
	}

	// 구조안에 값을 초기화(변화) 시키고 싶을 때
	public void initialize() {
		this.model.setNumRows(0);
	}

	public void addRow(String fileName) {
		this.cLecture = new CLecture();
		this.oLectures = this.cLecture.getAll(fileName);

		String[] row = new String[model.getColumnCount()];
		for (OLecture oLecture : oLectures) {
			row[0] = oLecture.getName();
			row[1] = oLecture.getProfessor();
			row[2] = oLecture.getCredit();
			row[3] = oLecture.getTime();
			model.addRow(row);
		}

		this.updateUI();

	}

	public void addRowUser(String fileName) {
		this.cLecture = new CLecture();
		this.oLectures = this.cLecture.getAllUser(fileName);

		String[] row = new String[model.getColumnCount()];
		for (OLecture oLecture : oLectures) {
			row[0] = oLecture.getName();
			row[1] = oLecture.getProfessor();
			row[2] = oLecture.getCredit();
			row[3] = oLecture.getTime();
			model.addRow(row);
		}

		this.updateUI();

	}

	public OLecture addMiridamgi(String fileName) {
		// 중복이 있는지 확인
		// 미리담기 or 수강신청에 있는 강좌들
		Vector<OLecture> lecturesMiridamgi = cLecture.getAllUser(fileName);
		// 선택된 강좌
		OLecture oLecture = this.getSelectedLecture();

		for (OLecture lecture : lecturesMiridamgi) {
			// 이미 미리담기한 강좌라면
			if (lecture.getId().equals(oLecture.getId())) {
				JOptionPane.showMessageDialog(null, lecture.getName() + "강좌는 이미 미리담기를 한 강좌입니다");
				return null;
			}
		}
		this.cLecture.add(fileName, oLecture);
		return oLecture;
	}

	public OLecture addSincheong(String fileName) {
		// 중복이 있는지 확인
		// 미리담기 or 수강신청에 있는 강좌들
		Vector<OLecture> lecturesSincheong = cLecture.getAllUser(fileName);
		// 선택된 강좌
		OLecture oLecture = this.getSelectedLecture();

		for (OLecture lecture : lecturesSincheong) {
			// 이미 수강신청한 강좌라면
			if (lecture.getId().equals(oLecture.getId())) {
				JOptionPane.showMessageDialog(null, lecture.getName() + "강좌는 이미 수강신청을 한 강좌입니다");
				return null;
			}
		}
		this.cLecture.add(fileName, oLecture);
		return oLecture;
	}

	public OLecture getSelectedLecture() {
		int row = this.getSelectedRow();
		String indexName = (String) this.model.getValueAt(row, 0);
		for (OLecture oLecture : this.oLectures) {
			if (oLecture.getName() == indexName) {
				return oLecture;
			}
		}
		return null;
	}

	public OLecture delete(String fileName) {

		// 선택된 강좌
		OLecture selectedLecture = this.getSelectedLecture();
		OLecture oLecture = this.cLecture.delete(fileName, selectedLecture);
		return oLecture;
	}

}
