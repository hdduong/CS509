package view;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import model.Model;
import model.Model.GraphType;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GraphPanel extends JPanel {

	Model model;
	
	public GraphPanel(Model m) {
		
		setBackground(Color.WHITE);
		setSize(640, 480);
		
		this.model = m;
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) {return;}
		
		if (model.getDataSet().count() == 0) {return; } // there is nothing to draw
		
		model.getGraph().draw(g);
	}
	

}
