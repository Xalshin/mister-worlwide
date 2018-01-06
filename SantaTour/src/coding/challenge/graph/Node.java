package coding.challenge.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author mahea
 * A Simple node of our graph.
 * It has a name (the name of the location it represents here) and a map of node representing its direct descendants, and the weight of their relationship
 * (here, the travel time between that location and the other one).
 *
 */
public class Node {
	private  String name;
	private Map<Node, Integer> outNodes;
	
	public Node(final String name) {
		this.name = name;
		this.outNodes = new HashMap<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Map<Node, Integer> getOutNodes(){
		return this.outNodes;
	}
	
	public void addOutNode(final String name, final int weight) {
		Node son = new Node(name);
		this.outNodes.put(son, Integer.valueOf(weight));
	}
	
	public void addOutNode(final Node son, final int weight) {
		this.outNodes.put(son, Integer.valueOf(weight));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	 * The nodes are identified by their names here.
	 * Luckily, in our test, no different cities can have the same name.
	 * In reality, we should have to identify them with an unique property.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}

}
