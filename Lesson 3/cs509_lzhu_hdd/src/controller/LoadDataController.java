package controller;

import java.io.File;

import javax.swing.*;

import model.DataPoint;
import model.DataSet;
import views.MainForm;

public class LoadDataController {
	
	DataSet data;
	
	public LoadDataController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
		//final JFileChooser fc=new JFileChooser("src"+File.separator+"resources"+File.separator+"dataToBeLoadWithEmptyLine.txt");  
		final JFileChooser fc=new JFileChooser("C:\\Users\\lzhu\\Documents\\GitHub\\CS509\\Lesson 3\\cs509_lzhu_hdd\\src\\resources");  
		int returnVal = fc.showOpenDialog(mainForm);
		File file = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName());
        } else {
        	 System.out.println("Open command cancelled by user.");
        }
		String filePath = file.getAbsolutePath();
		data.loadDataSetFromFile(filePath); 
		
		DefaultListModel list = (DefaultListModel)mainForm.getDataList().getModel();
		for(int i=0;i<data.set.size();i++){
			DataPoint dp =data.set.get(i);
			list.add(i, (dp.getX()+" , " +dp.getY())); 
		}
 
		return true;
	}

}
