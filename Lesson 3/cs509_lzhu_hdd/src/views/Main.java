package views;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
 

import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
 

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("DataVisualizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnUploadData = new JButton("Load Data");
		btnUploadData.setBounds(11, 11, 121, 29);
		
		JButton btnSaveDataTo = new JButton("Save data");
		btnSaveDataTo.setBounds(138, 11, 144, 29);
		contentPane.setLayout(null);
		
		DataListTableModel model = new DataListTableModel();
		table = new JTable(model);
		table.setCellSelectionEnabled(true); 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 86, 154, 281);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		
		//DataListTable model = new DataListTable(); 
		
		contentPane.add(btnUploadData);
		contentPane.add(btnSaveDataTo);
		
		JFormattedTextField frmtdtxtfldX = new JFormattedTextField();
		frmtdtxtfldX.setBounds(40, 454, 75, 18);
		contentPane.add(frmtdtxtfldX);
		
		JLabel lblNewLabel = new JLabel("x=");
		lblNewLabel.setBounds(20, 454, 23, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblY = new JLabel("y=");
		lblY.setBounds(20, 484, 23, 16);
		contentPane.add(lblY);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(40, 484, 75, 18);
		contentPane.add(formattedTextField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(142, 479, 66, 29);
		contentPane.add(btnAdd);
		
		BufferedImage dataGraph = null;  
		try {
		//	System.out.println(System.getProperty("user.dir"));
			dataGraph = ImageIO.read(this.getClass().getResourceAsStream("cartesianExample.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblGraph = new JLabel(new ImageIcon(dataGraph));
		lblGraph.setBounds(412, 63, 392, 381);
		contentPane.add(lblGraph);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(99, 385, 75, 29);
		contentPane.add(btnDelete);
		
		JLabel lblAddNewData = new JLabel("Add New Data Pair");
		lblAddNewData.setBounds(20, 426, 127, 16);
		contentPane.add(lblAddNewData);
		
		JLabel lblDisplayGraph = new JLabel("Display Graph: ");
		lblDisplayGraph.setBounds(325, 16, 96, 16);
		contentPane.add(lblDisplayGraph);
		
		JCheckBox chckbxShwoTrendLine = new JCheckBox("Shwo Trend Line");
		chckbxShwoTrendLine.setBounds(203, 83, 184, 23);
		contentPane.add(chckbxShwoTrendLine);
		
		JCheckBox chckbxShowEquation = new JCheckBox("Show Equation");
		chckbxShowEquation.setBounds(203, 118, 128, 23);
		contentPane.add(chckbxShowEquation);
		
		JCheckBox chckbxShowHorizonalLine = new JCheckBox("Show Horizonal Line");
		chckbxShowHorizonalLine.setBounds(203, 153, 184, 23);
		contentPane.add(chckbxShowHorizonalLine);
		
		JCheckBox chckbxShowXyAxes = new JCheckBox("Show XY Axes Values");
		chckbxShowXyAxes.setBounds(203, 188, 170, 23);
		contentPane.add(chckbxShowXyAxes);
	}
}