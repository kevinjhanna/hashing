package hashing;

import java.util.*;


public class OpenHash<K, V> implements SimpleMap<K, V>{
	private ArrayList<LinkedList<Tuple<K, V>>> data; 
	private int hashTableSize;
	
	public OpenHash(){
		this.hashTableSize = 4;
		initializeData();
	}
	
	private void initializeData(){
		data =  new ArrayList<LinkedList<Tuple<K, V>>>();
		for(int i=0; i < hashTableSize; i++){
			data.add(new LinkedList<Tuple<K, V>>());
		}
	}
	
	private static class Tuple<K, V>{
		K first;
		V second;
		
		Tuple(K first, V second){
			this.first = first;
			this.second = second;
		}
		
		K getFirst(){
			return first;
		}
		
		V getSecond(){
			return second;
		}
	}
	
	@Override
	public void put(K key, V value) {
		int position = hashTablePosition(key.hashCode()); 
		
		data.get(position).add(new Tuple(key, value));
	}
	
	private int  hashTablePosition(int hashCode){
		return Math.abs(hashCode % hashTableSize);
	}

	@Override
	public V get(K key) {
		int position = hashTablePosition(key.hashCode());
		
		if (data.get(position) == null){
			return null;
		}
		
		Iterator<Tuple<K, V>> it = data.get(position).iterator();
		while (it.hasNext()){
			Tuple<K, V> tuple = it.next();
			if (tuple.getFirst().equals(key)){
				return tuple.getSecond();
			}
		}
		return null;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
