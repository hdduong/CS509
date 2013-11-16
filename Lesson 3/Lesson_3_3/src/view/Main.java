package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.AddDataPointController;
import controller.EnableGraphController;
import controller.LoadDataController;
import controller.SaveDataController;

import model.CartesianPlot;
import model.ColumnGraph;
import model.DataPoint;
import model.Model;
import model.Model.GraphType;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main extends JFrame {

	JPanel contentPane;

	ManipuldateDataForm manipulateDataForm;
	
	Model model;
	
	GraphPanel graphPanel;
	
	JComboBox cboChooseGraph;

	GraphOptionPanel graphOptionPanel;
	
	public static void main(String[] args) {
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

	
	public Main() {
		this.model = new Model();
		manipulateDataForm = new ManipuldateDataForm(model,this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1309, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//JPanel graphPanel = new JPanel();
		graphPanel = new GraphPanel(this.model);
		
		cboChooseGraph = new JComboBox(); 
		cboChooseGraph.setModel(new DefaultComboBoxModel(new String[] {"Cartersian", "Column"}));
		
		JLabel lblChooseGraph = new JLabel("Pleae choose the graph:");
		
		graphOptionPanel = new GraphOptionPanel(this.model,this);
		
		JButton bntLoadData = new JButton("Load Data");
		bntLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoadDataController(Main.this.model).act(Main.this);
			}
		});
		
		JButton bntSaveData = new JButton("Save Data");
		bntSaveData.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new SaveDataController(Main.this.model).act(Main.this);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(bntLoadData, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(bntSaveData, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(manipulateDataForm, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(graphOptionPanel, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblChooseGraph)
							.addGap(18)
							.addComponent(cboChooseGraph, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChooseGraph)
								.addComponent(cboChooseGraph, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addComponent(bntSaveData, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(bntLoadData, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(graphOptionPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(manipulateDataForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		// Main always displays CARTERSIAN as the default option
		//model.setGraphType(GraphType.CARTERSIAN);
		//model.setGraphType(GraphType.COLUMN);
		
		//generateRandomPoint();		// Use for testing. Can remove after merging code.
		
/*		if(model.getGraphType() == GraphType.CARTERSIAN) {
			model.setGraph(new CartesianPlot(model.getDataSet(), (double)graphPanel.getWidth(), (double)graphPanel.getHeight() ) );
			graphPanel.repaint();
			
		}else if (model.getGraphType() == GraphType.COLUMN) {
			model.setGraph(new ColumnGraph(model.getDataSet(), (double)graphPanel.getWidth(), (double)graphPanel.getHeight() ) );
			graphPanel.repaint();
		}*/
		
		cboChooseGraph.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EnableGraphController(Main.this.model).process(Main.this, Main.this.graphOptionPanel);
			}
		});
		
	}
	
	
	public JComboBox getChoosenGraphComboBox() { return this.cboChooseGraph; }
	
	public GraphPanel getGraphPanel() {return this.graphPanel; }
	
	public GraphOptionPanel getGraphOptionPanel() {return this.graphOptionPanel; }
	
	public ManipuldateDataForm getManipuldateDataForm() {return this.manipulateDataForm;}
	
	public Model getModel() {return this.model; }
}
