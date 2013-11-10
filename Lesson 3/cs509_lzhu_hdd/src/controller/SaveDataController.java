package controller;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import model.DataPoint;
import model.DataSet;
import views.MainForm;

public class SaveDataController {

	DataSet data;
	JFileChooser fc;
	
	public SaveDataController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
		fc=mainForm.getFileChooser();
		//fc=new JFileChooser("src"+File.separator+"resources"+File.separator+"dataToBeLoadWithEmptyLine.txt");  
		//fc=new JFileChooser("C:\\Users\\lzhu\\Documents\\GitHub\\CS509\\Lesson 3\\cs509_lzhu_hdd\\src\\resources");  
		int returnVal = fc.showOpenDialog(mainForm);
		File file = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Save to: " + file.getName());
        } else {
        	 System.out.println("Save command cancelled by user.");
        }
		String filePath = file.getAbsolutePath();
		data.saveDataSetToFile(filePath); 
		
		return true;
	}
	
}
