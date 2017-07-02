package Search;

import java.util.Set;

import Graphs.Edge;
import Graphs.Graph;
import Graphs.Vertex;
import List.PositionalList;
import List.LinkedPositionalList;
import Map.Map;
 
public class DFS {
	
	/* Performs depth-first search of Graph g starting at Vertex u */
	public static <V,E> void DFSearch(Graph<V,E> g, Vertex <V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest){
		known.add(u);							// u has been visited
		for(Edge<E> e : g.outgoingEdges(u)){	// for every outgoing edge from u
			Vertex<V> v = g.opposite(u, e);
			if(!known.contains(v)){
				forest.put(v, e);				// e is the tree edge that discovered v
				DFSearch(g, v, known, forest);  // recursively explore from v 
			}
		}
	}
	
	/* Returns an ordered list of edges comprising the directed path from u to v */
	public <V,E> PositionalList<Edge<E>> constructPath(Graph<V,E> g, Vertex<V> u, Vertex<V> v, Map<Vertex<V>, Edge<E>> forest){
		
		PositionalList<Edge<E>> path = new LinkedPositionalList();
		
		boolean wasDiscovered = (forest.get(v) != null);
		if(wasDiscovered){
			while(v != u){
				// construct path from back to front
				Edge<E> edge = forest.get(v);
				path.addFirst(edge);
				v = g.opposite(v, edge);
			}	
		}
		return path;
	}
	
	/* Performs breadth-first search of Graph g starting at Vertex u */
	public static <V,E> void BFS(Graph<V,E> g, Vertex<V> s, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest){
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
						nextLevel.addLast(v);	// v will be further considred in next pass
					}
				}
				level = nextLevel;		     	// relabel 'next' level to become the current
			}	
		}
	}
}
