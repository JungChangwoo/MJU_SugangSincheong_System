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

	// �������� �͵�
	public VGangjwa() {
		super();
		// attributes(�Ӽ� ��ȭ)
		// ���ϼ���
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components(����)
		this.model = (DefaultTableModel) this.getModel();

		model.addColumn("���¸�");
		model.addColumn("�����");
		model.addColumn("����");
		model.addColumn("�ð�");
		// associations(����)
	}

	// �����ȿ� ���� �ʱ�ȭ(��ȭ) ��Ű�� ���� ��
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
		// �ߺ��� �ִ��� Ȯ��
		// �̸���� or ������û�� �ִ� ���µ�
		Vector<OLecture> lecturesMiridamgi = cLecture.getAllUser(fileName);
		// ���õ� ����
		OLecture oLecture = this.getSelectedLecture();

		for (OLecture lecture : lecturesMiridamgi) {
			// �̹� �̸������ ���¶��
			if (lecture.getId().equals(oLecture.getId())) {
				JOptionPane.showMessageDialog(null, lecture.getName() + "���´� �̹� �̸���⸦ �� �����Դϴ�");
				return null;
			}
		}
		this.cLecture.add(fileName, oLecture);
		return oLecture;
	}

	public OLecture addSincheong(String fileName) {
		// �ߺ��� �ִ��� Ȯ��
		// �̸���� or ������û�� �ִ� ���µ�
		Vector<OLecture> lecturesSincheong = cLecture.getAllUser(fileName);
		// ���õ� ����
		OLecture oLecture = this.getSelectedLecture();

		for (OLecture lecture : lecturesSincheong) {
			// �̹� ������û�� ���¶��
			if (lecture.getId().equals(oLecture.getId())) {
				JOptionPane.showMessageDialog(null, lecture.getName() + "���´� �̹� ������û�� �� �����Դϴ�");
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

		// ���õ� ����
		OLecture selectedLecture = this.getSelectedLecture();
		OLecture oLecture = this.cLecture.delete(fileName, selectedLecture);
		return oLecture;
	}

}
