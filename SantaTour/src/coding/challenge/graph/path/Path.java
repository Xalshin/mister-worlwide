package coding.challenge.graph.path;

import java.util.LinkedHashSet;
import java.util.Map.Entry;

import java.util.Set;

import coding.challenge.graph.Node;

public class Path {
	
	private Set<Node> orderedPath;
	private int totalPathWeight;
	
	public boolean isNodeInPath(Node node) {
		return orderedPath.contains(node);
	}
	
	public Path copyPath() {
		Path copy = new Path();
		copy.getOrderedPath().addAll(this.orderedPath);
		copy.setTotalPathWeight(this.totalPathWeight);
		
		return copy;
	}
	
	public Path() {
		super();
		this.orderedPath = new LinkedHashSet<>();
		this.totalPathWeight = 0;
	}

	public int getTotalPathWeight() {
		return totalPathWeight;
	}
	public void setTotalPathWeight(int totalPathWeight) {
		this.totalPathWeight = totalPathWeight;
	}
	
	public Set<Node> getOrderedPath() {
		return orderedPath;
	}

	public void addNodeAndWeightToPath(Entry<Node, Integer> weightedFather) {
		this.orderedPath.add(weightedFather.getKey());
		this.setTotalPathWeight(this.getTotalPathWeight() + weightedFather.getValue());
	}

	public void addStartingNodeToPath(Node start) {
		this.orderedPath.add(start);
	}

	@Override
	public String toString() {
		return "Path [orderedPath=" + orderedPath + ", totalPathWeight=" + totalPathWeight + "]";
	}
	
	
	
}
