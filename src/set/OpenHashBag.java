package set;

import hashing.OpenHash;
import hashing.SimpleMap;

public class OpenHashBag<T> implements Bag<T> {
	private SimpleMap<T, Integer> values = new OpenHash<T, Integer>();

	@Override
	public void add(T value) {
		Integer occurences = values.get(value);
		if (occurences == null){
			values.put(value, 1);
		} else {
			values.put(value, occurences + 1);
		}
	}

	@Override
	public int occurencesOf(T value) {
		Integer occurences =  values.get(value);
		if (occurences == null){
			return 0;
		}
		return occurences;
	}

	@Override
	public void remove(T value) {
		if (values.get(value) != null){
			values.remove(value);
		}
	}

}
