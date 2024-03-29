package controller;

import java.io.File;

import javax.swing.*;

import model.DataPoint;
import model.DataSet;
import views.MainForm;

public class LoadDataController {
	
	DataSet data;
	JFileChooser fc;
	
	public LoadDataController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
	 	fc=mainForm.getFileChooser();
		// fc=new JFileChooser("C:\\Users\\lzhu\\Documents\\GitHub\\CS509\\Lesson 3\\cs509_lzhu_hdd\\src\\resources");  
		int returnVal = fc.showOpenDialog(mainForm); 
	   //System.out.print("returnval:"+returnVal);
		return operation(returnVal,mainForm);
		
	}
	
	
	public boolean operation(int returnVal, MainForm mainForm){
		fc=mainForm.getFileChooser();
		File file = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile(); 
            System.out.println("Opening: " + file.getName());
            String filePath = file.getAbsolutePath();
    		data.loadDataSetFromFile(filePath); 
    		
    		DefaultListModel list = (DefaultListModel)mainForm.getDataList().getModel();
    		for(int i=0;i<data.set.size();i++){
    			DataPoint dp =data.set.get(i);
    			list.add(i, (dp.getX()+" , " +dp.getY())); 
    		}
     
    	    return true;
        } else {
        	 System.out.println("Open command cancelled by user.");
        	 return false;
        }
		
	}
	

}
