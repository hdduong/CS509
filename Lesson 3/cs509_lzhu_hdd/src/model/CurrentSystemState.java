package model;

import model.Graph.GRAPH_TYPE;

public class CurrentSystemState {
	 
	public DataSet data;
	public Graph graph;
	public GRAPH_TYPE currentGraphType;
	
	//initilize the system
	public CurrentSystemState(){
		data=new DataSet();
		graph = new CartesianPlot(data);
		currentGraphType = GRAPH_TYPE.CARTESIAN;
	}
	
	
//	public boolean refreshGraph(){
//		
//		
//	}
	
	
	public boolean switchGraph(){
		if(currentGraphType == GRAPH_TYPE.CARTESIAN){
			graph = new ColumnGraph(data);
		}
		else{
			graph = new CartesianPlot(data);
		}
		return true;
		
	}
}
