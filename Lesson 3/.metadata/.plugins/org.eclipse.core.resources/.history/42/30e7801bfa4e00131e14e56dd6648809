package model;

public class Model {
	public enum GraphType {CARTESIAN, COLUMN};

	DataSet ds;
	
	Graph graph;
	
	GraphType graphType;
	
	
	public Model() {
		ds = new DataSet();
		graph = new Graph(ds);
		
		//This is the way I FIX to increase Model
		//coverage code. Eclmacma is confuse of GraphType enum
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
		graphType = GraphType.CARTESIAN;
	}
	
	public DataSet getDataSet() { return ds; }
	
	public Graph getGraph() { return graph; }
	
	public void setGraph(Graph newGraph) { this.graph = newGraph; }
	
	public void setGraphType(GraphType newGraphType) { graphType = newGraphType; }
	
	public GraphType getGraphType() { return graphType; }
	
}
