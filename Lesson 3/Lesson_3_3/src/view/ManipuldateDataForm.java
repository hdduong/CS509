package view;


import javax.naming.InitialContext;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AddDataPointController;
import controller.DeleteDataPointController;
import controller.OpenDataPointDialogController;

import model.Model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.*;

public class ManipuldateDataForm extends JPanel {
	JTextField txtAddY;
    JTextField txtAddX;
    JList lstDataPoint;
    
   
	Model model;
	Main mainFrm; 
	
    public ManipuldateDataForm() {
    	super();
    	//init();
    }
    
	public ManipuldateDataForm(Model m, Main main) {
		
		this.model = m;
		this.mainFrm = main;
		init();
	}
	
	void init() {
		JScrollPane scrollPane = new JScrollPane();
		
		lstDataPoint = new JList();
		lstDataPoint.setModel(new DefaultListModel());
		scrollPane.setViewportView(lstDataPoint);
		
		JPanel panelAddDataPoint = new JPanel();
		panelAddDataPoint.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblAddY = new JLabel("y=");
		
		JLabel lblAddX = new JLabel("x=");
		
		txtAddY = new JTextField();
		txtAddY.setColumns(10);
		
		txtAddX = new JTextField();
		txtAddX.setColumns(10);
		
		JButton btnAddDataPoint = new JButton("Add");
		btnAddDataPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddDataPointController(ManipuldateDataForm.this.model).act(ManipuldateDataForm.this, ManipuldateDataForm.this.mainFrm);
			}
		});
		
		GroupLayout gl_panelAddDataPoint = new GroupLayout(panelAddDataPoint);
		gl_panelAddDataPoint.setHorizontalGroup(
			gl_panelAddDataPoint.createParallelGroup(Alignment.LEADING)
				.addGap(0, 283, Short.MAX_VALUE)
				.addGroup(gl_panelAddDataPoint.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAddDataPoint.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddY, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddX))
					.addGap(15)
					.addGroup(gl_panelAddDataPoint.createParallelGroup(Alignment.LEADING)
						.addComponent(txtAddY, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(txtAddX, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnAddDataPoint, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelAddDataPoint.setVerticalGroup(
			gl_panelAddDataPoint.createParallelGroup(Alignment.LEADING)
				.addGap(0, 89, Short.MAX_VALUE)
				.addGroup(gl_panelAddDataPoint.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAddDataPoint.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAddDataPoint, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panelAddDataPoint.createSequentialGroup()
							.addGroup(gl_panelAddDataPoint.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAddX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddX))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAddDataPoint.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAddY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddY))))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panelAddDataPoint.setLayout(gl_panelAddDataPoint);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DeleteDataPointController(ManipuldateDataForm.this.model).act(ManipuldateDataForm.this, ManipuldateDataForm.this.mainFrm);
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					new OpenDataPointDialogController(ManipuldateDataForm.this.model).act(ManipuldateDataForm.this, mainFrm);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(panelAddDataPoint, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelAddDataPoint, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		setLayout(groupLayout);

	}
	
	public JTextField getAddX(){
		return this.txtAddX;
	}
	
	public JTextField getAddY(){
		return this.txtAddY;
	}
	
	public JList getListDataPoint() {
		return lstDataPoint;
	}
	
}
