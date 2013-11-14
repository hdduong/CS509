package controller;

import java.lang.*;
import view.ManipuldateDataForm;
import model.DataPoint;
import model.Model;
import javax.swing.DefaultListModel;

public class AddDataPointController {
	Model model;
	
	public AddDataPointController(Model m) {
		this.model = m;
	}
	
	public boolean act(ManipuldateDataForm manForm) {
		String xValueStr = manForm.getAddX().getText();
		String yValueStr = manForm.getAddY().getText();
		manForm.getAddX().setText("");
		manForm.getAddY().setText("");
		
		if ( (xValueStr == null) || (yValueStr == null)) { return false;}
		
		//System.out.println(xValueStr + " "  + yValueStr);
		
		// assume that all the input values are properly format
		double xValue = Double.parseDouble(xValueStr);
		double yValue = Double.parseDouble(yValueStr);
		
		//System.out.println(xValue + " "  +  yValue);
		
		DataPoint dPoint = new DataPoint(xValue,yValue);
		
		//System.out.println(dPoint.getX() + " " + dPoint.getY());
		
		int index = model.getDataSet().addDataPoint(dPoint);
		String lstDataPoint = dPoint.toString();
		
		DefaultListModel  list =  (DefaultListModel)manForm.getListDataPoint().getModel();
		list.add(index, lstDataPoint);
		
		return true;
	}
}
