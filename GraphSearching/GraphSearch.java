import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphSearch {

	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using General Graph Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 *
	 * The structure(struct) passed in is an empty structure may behave as a Stack or Queue and the
	 * correspondingly search function should execute DFS(Stack) or BFS(Queue) on the graph.
	 *
	 * @param start
	 * @param struct
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean generalGraphSearch(T start, Structure<T> struct, Map<T, List<T>> adjList, T goal) {
		struct.add(start);
		T current;
		while (!struct.isEmpty()) {
			current = struct.remove();
			if (current.equals(goal)) {
				return true;
			}
			List<T> adj = adjList.get(current);
			for (T item : adj) {
				struct.add(item);
			}
		}
		return false;
	}
	
	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using Breadth First Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean breadthFirstSearch(T start, Map<T, List<T>> adjList, T goal) {
		if (start == null || adjList == null || goal == null) {
			throw new IllegalArgumentException();
		}
		return generalGraphSearch(start, new StructureQueue<T>(), adjList, goal);
	}
	
	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using Depth First Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean depthFirstSearch(T start, Map<T, List<T>> adjList, T goal) {
		if (start == null || adjList == null || goal == null) {
			throw new IllegalArgumentException();
		}
		return generalGraphSearch(start, new StructureStack<T>(), adjList, goal);
	}
	
	/**
	 * Find the shortest distance between the start node and the goal node in the given a weighted graph
	 * in the form of an adjacency list where the edges only have positive weights
	 * Return the aforementioned shortest distance if there exists a path between the start and goal,-1
	 * otherwise.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 * There are no negative edge weights in the graph.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return the shortest distance between the start and the goal node
	 */
	public static <T> int djikstraShortestPathAlgorithm(T start, Map<T, List<Pair<T, Integer>>> adjList, T goal) {
		if (start == null || adjList == null || goal == null) {
			throw new IllegalArgumentException();
		}
		int ret = -1;
		
		StructureQueue<T> queue = new StructureQueue<T>();
		Map<T, Integer> distance = new HashMap<T, Integer>();
		
		queue.add(start);
		while (!queue.isEmpty()) {
			T current = queue.remove();
			if (!distance.containsKey(current)) {
				distance.put(current, Integer.MAX_VALUE);
			}
			List<Pair<T, Integer>> adj = adjList.get(current);
			for (Pair<T, Integer> item : adj) {
				queue.add(item.a);
			}
		}

		distance.put(start, 0);
		List<T> vertices = new ArrayList<T>();
		vertices.addAll(distance.keySet());
		while (!vertices.isEmpty()) {
			T current = vertices.get(getSmallest(vertices, distance));
			vertices.remove(current);
			if (current.equals(goal)) {
				return distance.get(current);
			}
			if (distance.get(current) == Integer.MAX_VALUE) {
				return -1;
			}
			for (Pair<T, Integer> vertex : adjList.get(current)) {
				int newDist = vertex.b + distance.get(current);
				if (newDist < distance.get(vertex.a)) {
					distance.put(vertex.a, newDist);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * This method helps find the vertex with the smallest distance in the list
	 * @param vertices the list of vertices unvisited
	 * @param distance a map holding the distance for vertices
	 * @return the vertex with the smallest distance
	 */
	private static <T> int getSmallest(List<T> vertices, Map<T, Integer> distance) {
		int min = Integer.MAX_VALUE;
		int minInd = -1;
		for (int i = 0; i < vertices.size(); i++) {
			if (distance.get(vertices.get(i)) < min) {
				minInd = i;
				min = distance.get(vertices.get(i));
			}
		}
		return minInd;
	}
	
}