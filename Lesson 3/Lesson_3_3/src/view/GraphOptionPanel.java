package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Model;

import controller.UpdateBGHorizontalLine;
import controller.UpdateCartesianEquation;
import controller.UpdateCartesianTrendLine;
import controller.UpdateXYLabel;

public class GraphOptionPanel extends JPanel {

	JCheckBox chckbxShowTrendLine;
	JCheckBox chckbxShowBackgroundHorizonal;
	JCheckBox chckbxShowXyLabels;
	JCheckBox chckbxShowEquation;
	
	Model model;
	Main frmMain;
	
	public GraphOptionPanel() {}
	
	public GraphOptionPanel(Model m, Main main) {
		
		this.model = m;
		this.frmMain = main;
		 
		setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblGraphOption = new JLabel("Graph Option:");
		
		chckbxShowTrendLine = new JCheckBox("Show  Trend Line");
		chckbxShowTrendLine.setSelected(true);
		chckbxShowTrendLine.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new UpdateCartesianTrendLine(model).process(GraphOptionPanel.this.model, GraphOptionPanel.this.frmMain);
			}
		});
		
		chckbxShowBackgroundHorizonal = new JCheckBox("Show Background \r\nHorizontal Line");
		chckbxShowBackgroundHorizonal.setSelected(true);
		chckbxShowBackgroundHorizonal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new UpdateBGHorizontalLine(GraphOptionPanel.this.model).process(GraphOptionPanel.this.frmMain);
			}
		});
		
		chckbxShowXyLabels = new JCheckBox("Show XY Labels");
		chckbxShowXyLabels.setSelected(true);
		chckbxShowXyLabels.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new UpdateXYLabel(GraphOptionPanel.this.model).process(GraphOptionPanel.this.frmMain);
			}
		});
		
		chckbxShowEquation = new JCheckBox("Show Equation");
		chckbxShowEquation.setSelected(true);
		chckbxShowEquation.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				new UpdateCartesianEquation(GraphOptionPanel.this.model).process(GraphOptionPanel.this.frmMain);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxShowBackgroundHorizonal, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxShowXyLabels)
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblGraphOption, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(175, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxShowTrendLine)
					.addContainerGap(120, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxShowEquation)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblGraphOption)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxShowBackgroundHorizonal, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxShowXyLabels)
					.addGap(18)
					.addComponent(chckbxShowTrendLine)
					.addGap(17)
					.addComponent(chckbxShowEquation)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
	
	public JCheckBox getShowTrendLine() { return this.chckbxShowTrendLine;}
	public JCheckBox getShowBackgroundHorizonal() {return this.chckbxShowBackgroundHorizonal;}
	public JCheckBox getShowXYLabels() { return this.chckbxShowXyLabels;}
	public JCheckBox getShowEquation() { return this.chckbxShowEquation;}
	
	
}
