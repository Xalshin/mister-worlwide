package coding.challenge.graph;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author mahea
 * A Bidirectional Graph (meaning that any relation works both ways)
 * This graph has a name (because, why not) and a list of nodes.
 * The nodes themselves bear the relationships.
 */
public class BiDirectionalGraph {
	private String name;
	
	private List<Node> nodeList;

	public BiDirectionalGraph(String name) {
		super();
		this.name = name;
		this.nodeList = new ArrayList<>();
	}
	
	/**
	 * 
	 * @param a A Node of the graph
	 * @param b A second node of the graph, with a relationship to the first one
	 * @param weight the weight of the relationship (here, travel time between two locations)
	 * 
	 * This function adds a relationship between two nodes of our graphs. If the nodes weren't already in the graph, they are added.
	 * As this is a bidirectional graph, the relationship is added on both nodes. 
	 */
	public void addRelationshipAtoB(final Node a,final Node b, final int weight) {
		Node existingNodeA;
		if(nodeList.contains(a)) {
			existingNodeA = nodeList.get(nodeList.indexOf(a));
		}else {
			this.nodeList.add(a);
			existingNodeA = a;
		}	
		existingNodeA.addOutNode(b, weight);
		
		Node existingNodeB;
		if(nodeList.contains(b)) {
			existingNodeB = nodeList.get(nodeList.indexOf(b));
		}else {
			
			this.nodeList.add(b);
			existingNodeB = b;
		}
		existingNodeB.addOutNode(a, weight);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getNodeList() {
		return nodeList;
	}

	public int getGraphSize() {
		return nodeList.size();
	}
	
}
