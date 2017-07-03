package Search;

import Graphs.Graph;
import Graphs.Vertex;

/** Graph must be implemented using an adjacency matrix to calculate its transitive closure **/

public class TransitiveClosure {
	/* Converts graph g into its transitive closure */
	public static <V,E> void transitiveClosure(Graph<V,E> g){
		for(Vertex<V> k : g.vertices()){
			for(Vertex<V> i : g.vertices()){
				// verify that edge (i,k) exists in the partial closure
				if(i != k && g.getEdge(i,k) != null){
					for(Vertex<V> j : g.vertices()){
						// verify that edge (k,j) exists in the partial closure 
						if(i != j && j != k && g.getEdge(k,j) != null){
							// if (i,j) not yet included, add it to the closure
							if(g.getEdge(i,j) == null){
								g.insertEdge(i, j, null);
							}
						}
					}
				}
			}
		}
	}
}
