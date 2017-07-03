package Sorting;

import Graphs.Edge;
import Graphs.Graph;
import Graphs.Vertex;
import List.LinkedPositionalList;
import List.PositionalList;
import Map.ProbeHashMap;
import Stack.LinkedStack;

public class TopologicalSort {
	public static <V,E> PositionalList<Vertex<V>> topologicalSort(Graph<V,E> g){
		
		// list of vertices placed in topological order
		PositionalList<Vertex<V>> topo = new LinkedPositionalList<>();
		
		// container of vertices that have no remaining constraints
		LinkedStack<Vertex<V>> ready = new LinkedStack<>();
		
		// map keeping track of remaining in-degree for each vertex
		ProbeHashMap<Vertex<V>, Integer> inCount = new ProbeHashMap<>();
		
		for(Vertex<V> u : g.vertices()){
			inCount.put(u, g.inDegree(u));			// initialize with actual in-degree
			if(inCount.get(u) == 0){				// if u has no incoming edges
				ready.push(u);						// it is free of constraints
			}
		}
		
		while(!ready.isEmpty()){
			Vertex<V> u = ready.pop();
			topo.addLast(u);
			for(Edge<E> e : g.outgoingEdges(u)){     // consider all outgoing neighbors of u
				Vertex<V> v = g.opposite(u, e);
				inCount.put(v, inCount.get(v) - 1); // v has one less constraint without u
				if(inCount.get(v) == 0){
					ready.push(v);
				}
			}
		}
		
		return topo;
	}
}
