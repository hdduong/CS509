package views;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.*;

import model.CurrentSystemState;

public class MainForm extends JPanel {
	 JList  list;
	 JTextField XtoAddField, YtoAddField;
	 CurrentSystemState systemState; 
	 EditForm editDialog ;
	
	public MainForm(CurrentSystemState state) { 
		this.systemState = state;
	//	setTitle("DataVisualizer");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 590);
		editDialog = new EditForm(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 66, 146, 258);
		add(scrollPane);
		this.list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new DefaultListModel());
		
		JButton btnUploadData = new JButton("Load Data");
		btnUploadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(new LoadDataController(systemState.data)).act(MainForm.this);
			}
		});
		btnUploadData.setBounds(35, 11, 99, 29);
		
		JButton btnSaveDataTo = new JButton("Save data");
		btnSaveDataTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveDataController(systemState.data).act(MainForm.this);
			}
		});
		btnSaveDataTo.setBounds(154, 11, 105, 29);
	    setLayout(null);
		 
		add(btnUploadData);
		add(btnSaveDataTo);
		
		
		
		
		JLabel lblNewLabel = new JLabel("x=");
		lblNewLabel.setBounds(20, 454, 23, 16);
		add(lblNewLabel);
		
		XtoAddField = new JTextField();
		XtoAddField.setBounds(40, 454, 75, 18);
		add(XtoAddField);
		
		
		JLabel lblY = new JLabel("y=");
		lblY.setBounds(20, 484, 23, 16);
		add(lblY);
		
		YtoAddField = new JTextField();
		YtoAddField.setBounds(40, 484, 75, 18);
		add(YtoAddField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddDataPointController(systemState.data).act(MainForm.this);
			}
		});
		btnAdd.setBounds(142, 479, 66, 29);
		add(btnAdd);
		
		
		
		
		
		BufferedImage dataGraph = null;  
		try {
		//	System.out.println(System.getProperty("user.dir"));
			dataGraph = ImageIO.read(this.getClass().getResourceAsStream("cartesianExample.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblGraph = new JLabel(new ImageIcon(dataGraph));
		lblGraph.setBounds(474, 52, 392, 381);
		add(lblGraph);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteSelectedDataPointController(systemState.data).act(MainForm.this);
			}
		});
		btnDelete.setBounds(99, 385, 75, 29);
		add(btnDelete);
		
		JLabel lblAddNewData = new JLabel("Add New Data Pair");
		lblAddNewData.setBounds(20, 426, 127, 16);
		add(lblAddNewData);
		
		JLabel lblDisplayGraph = new JLabel("Display Graph: ");
		lblDisplayGraph.setBounds(257, 66, 85, 16);
		add(lblDisplayGraph);
		
		JCheckBox chckbxShwoTrendLine = new JCheckBox("Shwo Trend Line");
		chckbxShwoTrendLine.setBounds(257, 114, 184, 23);
		add(chckbxShwoTrendLine);
		
		JCheckBox chckbxShowEquation = new JCheckBox("Show Equation");
		chckbxShowEquation.setBounds(257, 151, 128, 23);
		add(chckbxShowEquation);
		
		JCheckBox chckbxShowHorizonalLine = new JCheckBox("Show Horizonal Line");
		chckbxShowHorizonalLine.setBounds(257, 188, 184, 23);
		add(chckbxShowHorizonalLine);
		
		JCheckBox chckbxShowXyAxes = new JCheckBox("Show XY Axes Values");
		chckbxShowXyAxes.setBounds(257, 226, 170, 23);
		add(chckbxShowXyAxes);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditSelectedDataPointController(systemState.data).act(MainForm.this);
			}
		});
		btnEdit.setBounds(11, 385, 75, 29);
		add(btnEdit);
		
		
		 
	}
	
	public JTextField getXToAdd(){
		return  XtoAddField ;
	}
	
	public JTextField getYToAdd(){
		return  YtoAddField ;
	}
	
	public JList getDataList(){
		return this.list;
	}
	public JDialog getEditDialog(){
		return this.editDialog;
	}
}