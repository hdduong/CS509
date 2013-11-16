package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import model.DataPoint;
import model.DataSet;
import model.Model;
import view.Main;

public class SaveDataController {

	Model model;
	
	public SaveDataController(Model m){
		this.model = m;
	}
	
	public boolean act(Main mainForm){

		JFileChooser save = new JFileChooser();
		
	 	if( save.showSaveDialog(mainForm) != JFileChooser.APPROVE_OPTION) {
	 		return false;
	 	}
		
		return saveToFile(save.getSelectedFile(), mainForm);
	}
	
	
	public boolean saveToFile(File saveFile, Main mainForm){
		try {
	        //This is where a real application would open the file.
            System.out.println("Save to: " + saveFile.getName());
            String filePath = saveFile.getAbsolutePath();
    		//model.getDataSet().saveDataSetToFile(filePath);
            PrintStream ps =new PrintStream(new File(filePath));
    		for (int i = 0; i < model.getDataSet().count(); i++) {
    				DataPoint dp = model.getDataSet().getDataPointAt(i);
    				ps.print(dp.getX()+","+dp.getY());
    				ps.println();
    		}
    		return true;

        } catch (IOException e) {
        	 e.printStackTrace();
        	 return false;
        }
        //return true;
	}
}
