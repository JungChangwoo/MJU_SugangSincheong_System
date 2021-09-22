package WindowsView;



import javax.swing.*;

import Constants.Config.FVMainFrame;
import ValueObject.OHwewon;


public class VMainFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 100L;
	
	// components
	private VMainPanel vMainPanel;
//	
	public VMainFrame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// attributes
		this.setLocation(FVMainFrame.location);
		this.setSize(FVMainFrame.size);
		// components
		this.vMainPanel = new VMainPanel();
		this.add(this.vMainPanel);
		this.setVisible(true);
	}
	
	public void initialize(OHwewon oHwewon) {
		// variable attributes
		
//		// components initialize
		this.vMainPanel.initialize(oHwewon);
		
	}

	public static void main(String[] args) {
		VMainFrame vMain = new VMainFrame();
	}


}
