package data.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;

import data.controller.ChangeValueController;
import data.model.Model;

public class DataWindow extends JApplet {
	private JTextField textField;

	// might as well create here because we are the main window.
	Model model = new Model();
	
	public JTextField getTextField() {
		return textField;
	}
	
	public Model getModel() {
		return model;
	}
	
	/**
	 * Create the applet.
	 */
	public DataWindow() {
		
		JButton btnChangeValue = new JButton("Change Value");
		btnChangeValue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ChangeValueController(model).act(DataWindow.this);
			}
			
		});
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		// AUTO LAYOUT. DON'T CHANGE THIS
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField, Alignment.LEADING)
						.addComponent(btnChangeValue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(321, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(btnChangeValue)
					.addGap(30)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
