package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.AddDataPointController;

import model.CartesianPlot;
import model.ColumnGraph;
import model.DataPoint;
import model.Model;
import model.Model.GraphType;

public class Main extends JFrame {

	JPanel contentPane;

	ManipuldateDataForm manipulateDataForm;
	
	Model model;
	
	GraphPanel graphPanel;
	

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
		manipulateDataForm = new ManipuldateDataForm(model);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1246, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//JPanel graphPanel = new JPanel();
		graphPanel = new GraphPanel(this.model);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(manipulateDataForm, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
					.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(manipulateDataForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
							.addGap(74))))
		);
		contentPane.setLayout(gl_contentPane);
		
		model.setGraphType(GraphType.CARTERSIAN);
		//model.setGraphType(GraphType.COLUMN);
		
		generateRandomPoint();		// Use for testing. Can remove after merging code.
		
		if(model.getGraphType() == GraphType.CARTERSIAN) {
			
			model.setGraph(new CartesianPlot(model.getDataSet(), (double)graphPanel.getWidth(), (double)graphPanel.getHeight() ) );
			//model.setGraph(new CartesianPlot(model.getDataSet(), (double)640.0, (double)480.0 ) );
			graphPanel.repaint();
			
		}else if (model.getGraphType() == GraphType.COLUMN) {
			model.setGraph(new ColumnGraph(model.getDataSet(), (double)graphPanel.getWidth(), (double)graphPanel.getHeight() ) );
			graphPanel.repaint();
		}
		
		
		
	}
	
	//**
	// random dataPoint
	//
	public void generateRandomPoint() {
		double randMinX = -10;
		double randMaxX = 10;
		double randMinY = -20;
		double randMaxY = 20;
		int numPoints = 2048;
		
		// Min + (Math.random() * ((Max - Min) + 1))
		
		for (int i = 0; i < numPoints; i++) {
			double randX  = randMinX + (Math.random() * ( (randMaxX - randMinX)+ 1) );
			double randY  = randMinY + (Math.random() * ( (randMaxY - randMinY)+ 1) );
			
			DataPoint dataPoint = new DataPoint(randX, randY);
			
			//model.getDataSet().addDataPoint(dataPoint);
			JTextField addX = manipulateDataForm.getAddX();
			addX.setText(String.valueOf(randX));
			
			JTextField addY = manipulateDataForm.getAddY();
			addY.setText(String.valueOf(randY));
			
			
			AddDataPointController adc = new AddDataPointController(model);
			adc.act(manipulateDataForm);
			
		}
	}
}
