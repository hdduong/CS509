package data.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import data.controller.EnterDataFormCancelController;
import data.controller.EnterDataFormOkController;

import java.awt.Color;

public class EnterDataForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton okButton;
	private JButton cancelButton;

	boolean wasCanceled = false;
	
	public boolean wasCanceled() { 
		return wasCanceled;
	}
	public void setCanceled(boolean b) {
		wasCanceled = b;
	}
	
	public JTextField getTextField () {
		return textField;
	}
	
	/**
	 * Create the dialog.
	 */
	public EnterDataForm() {
		setTitle("Enter New Value");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblEnterNewText = new JLabel("Enter New Text:");
		textField = new JTextField();
		textField.setColumns(10);
		{
			okButton = new JButton("OK");
			okButton.setActionCommand("OK");
			okButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					new EnterDataFormOkController().act(EnterDataForm.this);
				}
				
			});
			getRootPane().setDefaultButton(okButton);
		}
		{
			cancelButton = new JButton("Cancel");
			cancelButton.setActionCommand("Cancel");
			cancelButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					new EnterDataFormCancelController().act(EnterDataForm.this);
				}
				
			});
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterNewText)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(143)
							.addComponent(okButton)
							.addGap(71)
							.addComponent(cancelButton)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterNewText)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(okButton)
						.addComponent(cancelButton))
					.addGap(60))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		
		
	}

	

}
