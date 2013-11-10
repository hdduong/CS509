package example;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class TopApplet extends JApplet {

	String myString;// = "Test";
	/**
	 * Create the applet.
	 */
	public TopApplet() {
		
		MySpecialPanel panel = new MySpecialPanel(myString);
		
		JScrollPane scrollPane = new JScrollPane();
		
		// AUTOMATICALLY GENERATED
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		
		JList list = new JList();
		list.setModel(new DefaultListModel());
		scrollPane.setViewportView(list);
		getContentPane().setLayout(groupLayout);

	}
}
