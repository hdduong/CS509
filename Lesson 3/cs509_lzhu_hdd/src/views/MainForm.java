package views;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBoxMenuItem;

public class MainForm extends JPanel {
   
	private JTable table;
	
	
	public MainForm() {
	//	setTitle("DataVisualizer");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 590);
		 
		 setBorder(new EmptyBorder(5, 5, 5, 5));
		 
		
		JButton btnUploadData = new JButton("Load Data");
		btnUploadData.setBounds(11, 11, 99, 29);
		
		JButton btnSaveDataTo = new JButton("Save data");
		btnSaveDataTo.setBounds(120, 11, 105, 29);
	    setLayout(null);
		
		DataListTableModel model = new DataListTableModel();
		table = new JTable(model);
		table.setCellSelectionEnabled(true); 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 66, 163, 281);
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		
		//DataListTable model = new DataListTable(); 
		
		add(btnUploadData);
		add(btnSaveDataTo);
		
		JFormattedTextField frmtdtxtfldX = new JFormattedTextField();
		frmtdtxtfldX.setBounds(40, 454, 75, 18);
		add(frmtdtxtfldX);
		
		JLabel lblNewLabel = new JLabel("x=");
		lblNewLabel.setBounds(20, 454, 23, 16);
		add(lblNewLabel);
		
		JLabel lblY = new JLabel("y=");
		lblY.setBounds(20, 484, 23, 16);
		add(lblY);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(40, 484, 75, 18);
		add(formattedTextField);
		
		JButton btnAdd = new JButton("Add");
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
		btnDelete.setBounds(99, 385, 75, 29);
		add(btnDelete);
		
		JLabel lblAddNewData = new JLabel("Add New Data Pair");
		lblAddNewData.setBounds(20, 426, 127, 16);
		add(lblAddNewData);
		
		JLabel lblDisplayGraph = new JLabel("Display Graph: ");
		lblDisplayGraph.setBounds(203, 66, 85, 16);
		add(lblDisplayGraph);
		
		JCheckBox chckbxShwoTrendLine = new JCheckBox("Shwo Trend Line");
		chckbxShwoTrendLine.setBounds(203, 114, 184, 23);
		add(chckbxShwoTrendLine);
		
		JCheckBox chckbxShowEquation = new JCheckBox("Show Equation");
		chckbxShowEquation.setBounds(203, 151, 128, 23);
		add(chckbxShowEquation);
		
		JCheckBox chckbxShowHorizonalLine = new JCheckBox("Show Horizonal Line");
		chckbxShowHorizonalLine.setBounds(203, 188, 184, 23);
		add(chckbxShowHorizonalLine);
		
		JCheckBox chckbxShowXyAxes = new JCheckBox("Show XY Axes Values");
		chckbxShowXyAxes.setBounds(203, 226, 170, 23);
		add(chckbxShowXyAxes);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(11, 385, 75, 29);
		add(btnEdit);
	
	}
}
