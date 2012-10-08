package hashing;

import java.util.*;


public class OpenHash<K, V> implements SimpleMap<K, V>{
	private ArrayList<LinkedList<Tuple<K, V>>> data; 
	private int hashTableSize;
	private int size;
	
	public OpenHash(){
		this.hashTableSize = 4;
		this.size = 0;
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
		
		void setSecond(V second){
			this.second = second;
		}
	}
	
	@Override
	public void put(K key, V value) {
		int position = hashTablePosition(key.hashCode()); 
		
		Iterator<Tuple<K, V>> it = data.get(position).iterator();
		while (it.hasNext()){
			Tuple<K, V> tuple = it.next();
			
			if (tuple.getFirst().equals(key)){
				tuple.setSecond(value);
				return;
			}
		}
		
		data.get(position).add(new Tuple<K, V>(key, value));
		size++;
	}
	
	private int  hashTablePosition(int hashCode){
		return Math.abs(hashCode % hashTableSize);
	}

	@Override
	public V get(K key) {
		int position = hashTablePosition(key.hashCode());
		
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
		int position = hashTablePosition(key.hashCode());
		
		Iterator<Tuple<K, V>> it = data.get(position).iterator();
		while (it.hasNext()){
			if (it.next().getFirst().equals(key)){
				it.remove();
			}
		}
	}



	@Override
	public Set<K> keySet() {
		Set<K> keys = new HashSet<K>();
		for (LinkedList<Tuple<K, V>> list : data){
			for (Tuple<K, V> tuple: list){
				keys.add(tuple.getFirst());
			}
		}
		
		return keys;
	}

	@Override
	public Collection<V> values() {
		Collection<V> values = new LinkedList<V>();
		for (LinkedList<Tuple<K, V>> list : data){
			for (Tuple<K, V> tuple: list){
				values.add(tuple.getSecond());
			}
		}
		
		return values;
	}

	@Override
	public int size() {
		return size;
	}
	

}
