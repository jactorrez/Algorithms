package Search;

import java.util.Set;

import Graphs.Edge;
import Graphs.Graph;
import Graphs.Vertex;
import Map.Map;

public class DFS {
	
	public static <V,E> void DFS(Graph<V,E> g, Vertex <V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest){
		known.add(u);		// u has been visited
		for(Edge<E> e : g.outgoingEdges(u)){
			Vertex<V> v = g.opposite(u, e);
			if(!known.contains(v)){
				forest.put(v, e);
				DFS(g, v, known, forest);
			}
		}
	}
}
