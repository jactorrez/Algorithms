package Sorting;
import PriorityQueue.Entry;

/* Implementation of the Entry interface to use for testing */
public class TestEntry<K,V> implements Entry<K,V> {
	private K key;
	private V value;
	
	public TestEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return value;
	}
}
