package WindowsView;

import javax.swing.JPanel;

import Constants.Config.FVMainPanel;
import ValueObject.OHwewon;

public class VMainPanel extends JPanel{
	// attributes
	private static final long serialVersionUID = 1L;
	//components
	private VSugangsincheongPanel vSugangsincheongPanel;
	
	public VMainPanel() {
		super();
		// attributes
		this.setBackground(FVMainPanel.background);
//		this.setSize(1000, 700);;
		// components
		this.vSugangsincheongPanel = new VSugangsincheongPanel();
		this.add(this.vSugangsincheongPanel);
	}

	public void initialize(OHwewon oHwewon) {
		this.vSugangsincheongPanel.initialize(oHwewon);
	}


}
