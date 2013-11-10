package heineman.view;

import javax.swing.JApplet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import heineman.model.*;

public class Main extends JApplet {

	Model model = new Model();
	MainForm panel;
	
	public Model getModel() {
		return model;
	}
	
	public MainForm getMainForm() {
		return panel;
	}
	
	public Main() {
		
		panel = new MainForm(model);
		
		// AUTOMATICALLY GENERATED. DO NOT TOUCH!
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
