package views;

import javax.swing.JApplet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import model.CurrentSystemState;

public class Main extends JApplet {
	MainForm panel;  
	
	  public void init() {
		     this.setSize(1000, 680);
		  }
	public MainForm getMainForm(){
		return this.panel;
	}
	  
	public Main() {
		
		CurrentSystemState systemState = new CurrentSystemState();
		panel=new MainForm(systemState);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
	
	
}

