package views;

import java.util.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class DataListTableModel  extends AbstractTableModel
{
    private List<String> columnNames = new ArrayList<String>();
    private ArrayList<ArrayList> data = new ArrayList<ArrayList>();

    public DataListTableModel() {
        //super(new String[]{"Select to delete", "x", "y"}, 0);     
    	columnNames.add("Delete?"); 
        columnNames.add("x");
        columnNames.add("y"); 
        populate();
    }

    public void populateTable(){   
    	addRow(1.0,4.0);
    	addRow(2.0,3.8);
    	addRow(3.0,7.0);
    	addRow(4.5,8.0);
    	addRow(5.0,6.0);
//    	this.addRow(new Object[]{false,1.0,4.0});
//    	this.addRow(new Object[]{false,2.0,3.8});
//    	this.addRow(new Object[]{false,3.0,7.0});
//    	this.addRow(new Object[]{false,4.5,8.0});
//    	this.addRow(new Object[]{false,5.0,6.0});
    	}
    
    public void addRow(double x, double y){  
    	
    //	this.addRow(new Object[]{false,x,y});
    	data.add(processRowData(x,y));
    	fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
    public void populate(){  
    		ArrayList rowData=processRowData(1.0,4.0);
    		data.add(rowData); 
    		rowData=processRowData(2.0,3.8);
    		data.add(rowData); 
    	    rowData=processRowData(3.0,7.0);
    		data.add(rowData); 
    		rowData=processRowData(4.5,8.0);
    		data.add(rowData); 
    		rowData=processRowData(5.0,6.0);
    		data.add(rowData);     	
    }
    
    public ArrayList  processRowData(double x, double y){
    	ArrayList  rowData=new ArrayList();
    	rowData.add(false);
    	rowData.add(x);
    	rowData.add(y);
    	return rowData;
    }
    
    public void addRow(ArrayList<Double> rowData)
    {   
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
    
    public int getColumnCount()
    {
        return columnNames.size();
    }

    public int getRowCount()
    {
        return data.size();
    }

    public String getColumnName(int col)
    {
        try
        {
            return columnNames.get(col);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public Object getValueAt(int row, int col)
    {
        return data.get(row).get(col);
    }
    
    
    @Override
    public void setValueAt(Object aValue, int row, int column) {
      if (aValue instanceof Boolean && column == 0) {
        System.out.println(aValue);
        ArrayList rowData = data.get(row);
        if(column==0)
        	rowData.set(0, (boolean)aValue);
        else
            rowData.set(column, (int)aValue);
        fireTableCellUpdated(row, column);
      }
    }
    
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return true;
    }


    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
    //	return getValueAt(0, columnIndex).getClass();
      Class clazz = String.class;
      switch (columnIndex) {
        case 0:
          clazz = Boolean.class;
          break;
        case 1:
            clazz = Integer.class;
            break;
        case 2:
          clazz = Integer.class;
          break;
      }
      return clazz;
    }
    
    public void setCellSelectionEnabled(boolean b) {
		this.setCellSelectionEnabled(b);
		
	}

    
}

