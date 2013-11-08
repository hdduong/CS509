package heineman.view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import heineman.controller.*;
import heineman.model.*;

public class MainForm extends JPanel {
	JTextField wordField;
	JList wordList;

	Model model;
	
	public MainForm(Model model) {
		this.model = model;
		
		wordField = new JTextField();
		wordField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Word:");
		
		JButton addButton = new JButton("Add");
		
		// have controller handle this.
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddWordController(MainForm.this.model).act(MainForm.this);				
			}
			
		});
		
		JButton removeButton = new JButton("Remove");
		
		// have controller handle this.
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new RemoveWordController(MainForm.this.model).act(MainForm.this);				
			}
			
		});
		
		JScrollPane scrollingContainer = new JScrollPane();
		
		JLabel lblWordList = new JLabel("Word List:");
		
		JButton removeSelectedButton = new JButton("Remove Selected");

		// have controller handle this.
		removeSelectedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new RemoveSelectedController(MainForm.this.model).act(MainForm.this);				
			}
			
		});
		
		// AUTOMATICALLY GENERATED. DO NOT TOUCH!
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(wordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addButton)
							.addGap(84)
							.addComponent(removeButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWordList)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollingContainer, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(removeSelectedButton)))))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWordList)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollingContainer, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(removeSelectedButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(wordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addButton)
						.addComponent(removeButton))
					.addGap(54))
		);
		
		wordList = new JList();
		wordList.setModel(new DefaultListModel());
		scrollingContainer.setViewportView(wordList);
		setLayout(groupLayout);
	}
	
	// prepare these methods for testing
	public JTextField getWordField() { return wordField; }
	public JList getWordList () { return wordList; }
}
