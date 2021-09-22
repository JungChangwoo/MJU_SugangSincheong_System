package WindowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.CIndex;
import Controller.CLecture;
import ValueObject.OIndex;
import ValueObject.OLecture;

public class VIndex extends JTable {

	private static final long serialVersionUID = 1L;
	// associations
	private CIndex cIndex;
	private DefaultTableModel model;

	Vector<OIndex> oIndices;

	// 고정적인 것들
	public VIndex() {
		super();
		// attributes(속성 변화)
		// 단일선택
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components(구조)
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("강좌명");
		// associations(구조)
	}

	// 구조안에 값을 초기화(변화) 시키고 싶을 때
	public void initialize() {
		this.model.setNumRows(0);
	}

	public void getData(String fileName) {
		this.cIndex = new CIndex();
		this.oIndices = this.cIndex.getAll(fileName);

		
		String[] row = new String[model.getColumnCount()];
		for (OIndex oIndex : oIndices) {
			row[0] = oIndex.getName();
			model.addRow(row);
		}
		// 첫번째 행 기본 선택으로
		this.setRowSelectionInterval(0, 0);
//		this.getSelectedRow()
		this.updateUI();
	}

	public String getSelectedIndex() {
		int row = this.getSelectedRow();
		String indexName = (String)this.model.getValueAt(row, 0);
		for(OIndex oIndex : this.oIndices) {
			if(oIndex.getName() == indexName) {
				return oIndex.getFileName();
			}
		}
		return null;
	}
}
