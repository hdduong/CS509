package sample;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public class Example extends JApplet {
	Base panel;
	
	/**
	 * Create the applet.
	 */
	public Example() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				panel.setDrawer(new CircleDrawer());
				repaint();
			}
			
			public void mouseReleased(MouseEvent me) {
				panel.setDrawer(new SquareDrawer());
				repaint();
			}
		});
		
		panel = new Base(null);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
