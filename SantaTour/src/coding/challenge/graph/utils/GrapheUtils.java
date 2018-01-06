package coding.challenge.graph.utils;


import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import coding.challenge.graph.BiDirectionalGraph;
import coding.challenge.graph.Node;
import coding.challenge.graph.path.Path;

public class GrapheUtils {


	public static Optional<Path> getFastestRoute(BiDirectionalGraph parentGraph) {
		Optional<Path> shortestFromAnywhere = Optional.empty();
		for(Node start : parentGraph.getNodeList()) {
			Optional<Path> shortestFromStart = Optional.empty();
			Path startPath =  new Path();
			startPath.addStartingNodeToPath(start);
			for(Entry<Node, Integer> weightedSon : start.getOutNodes().entrySet()) {
				Optional<Path> path = computeShortestCompletePath(weightedSon, startPath, parentGraph.getGraphSize());
				if(!shortestFromStart.isPresent() || (path.isPresent() && shortestFromStart.get().getTotalPathWeight() >  path.get().getTotalPathWeight())){
					shortestFromStart = path;
				}
			}
			
			if(!shortestFromAnywhere.isPresent() || (shortestFromStart.isPresent() && shortestFromAnywhere.get().getTotalPathWeight() >  shortestFromStart.get().getTotalPathWeight())){
				shortestFromAnywhere = shortestFromStart;
			}
		}
		
		return shortestFromAnywhere;
		
	}

	private static Optional<Path> computeShortestCompletePath(
			Entry<Node, Integer> weightedFather, Path currentPath, int parentGraphSize) {
		Path currentRoutePath =  currentPath.copyPath();
		currentRoutePath.addNodeAndWeightToPath(weightedFather);
		List<Entry<Node, Integer>> nonPassedNodes = weightedFather.getKey().getOutNodes().entrySet().stream().filter(entry -> !currentRoutePath.isNodeInPath(entry.getKey())).collect(Collectors.toList());

		
		// The path is not a complete path
		if(nonPassedNodes.isEmpty()) {
			return currentRoutePath.getOrderedPath().size() < parentGraphSize ? Optional.empty() : Optional.of(currentRoutePath) ;
		}
		Optional<Path> shortest = Optional.empty();
		for(Entry<Node,Integer> weightedSon : nonPassedNodes) {
			Optional<Path> path = computeShortestCompletePath(weightedSon, currentRoutePath, parentGraphSize);
			if(!shortest.isPresent() || (path.isPresent() && shortest.get().getTotalPathWeight() >  path.get().getTotalPathWeight())){
				shortest = path;
			}
		}
		return shortest;
	}
}
