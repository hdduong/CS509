package model;

public class Model {
	public enum GraphType {CARTERSIAN, COLUMN};
	
	DataSet ds;
	
	Graph graph;
	
	GraphType graphType;
	
	
	public Model() {
		ds = new DataSet();
		graph = new Graph(ds);
	}
	
	public DataSet getDataSet() {
		return ds;
	}
	
	public Graph getGraph() {
		return graph;
	}
	
	public void setGraph(Graph newGraph) {
		this.graph = newGraph;
	}
	
	public void setGraphType(GraphType newGraphType) {
		graphType = newGraphType;
	}
	
	public GraphType getGraphType() {
		return graphType;
	}
	
}
