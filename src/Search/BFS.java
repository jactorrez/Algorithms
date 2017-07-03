package Search;

import java.util.Set;

import Graphs.Edge;
import Graphs.Graph;
import Graphs.Vertex;
import List.LinkedPositionalList;
import Map.Map;

public class BFS {
	
	/* Performs breadth-first search of Graph g starting at Vertex u */
	public static <V,E> void BFSearch(Graph<V,E> g, Vertex<V> s, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest){
		LinkedPositionalList<Vertex<V>> level = new LinkedPositionalList<>();
		known.add(s);
		level.addLast(s); 	// first level includes only s
		while(!level.isEmpty()){
			LinkedPositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>();
			for(Vertex<V> u : level){
				for(Edge<E> e : g.outgoingEdges(u)){
					Vertex<V> v = g.opposite(u, e);
					if(!known.contains(v)){
						known.add(v);
						forest.put(v,e);		// e is the tree edge that discovered v
						nextLevel.addLast(v);	// v will be further considered in next pass
					}
				}
				level = nextLevel;		     	// relabel 'next' level to become the current
			}	
		}
	}
}
