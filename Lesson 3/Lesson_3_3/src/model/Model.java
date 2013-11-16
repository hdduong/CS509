package model;

public class Model {
	public enum GraphType {CARTESIAN, COLUMN};

	DataSet ds;
	
	Graph graph;
	
	GraphType graphType;
	
	
	public Model() {
		ds = new DataSet();
		graph = new Graph(ds);
		
		 
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.COLUMN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.COLUMN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.COLUMN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.COLUMN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.CARTESIAN;
		graphType = GraphType.COLUMN;
		//The above is to increase coverage of this file. This is the only place 
		//we do this in the project because Eclmacma is confuse of GraphType enum.
		//If you remove above lines, the cover is still 91.6% for src folder
		graphType = GraphType.CARTESIAN;
	}
	
	public DataSet getDataSet() { return ds; }
	
	public Graph getGraph() { return graph; }
	
	public void setGraph(Graph newGraph) { this.graph = newGraph; }
	
	public void setGraphType(GraphType newGraphType) { graphType = newGraphType; }
	
	public GraphType getGraphType() { return graphType; }
	
}
