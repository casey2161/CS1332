import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement the hash table interface here.
 * 
 * @author Casey Barnette
 * @author Julia Ting
 * 
 */
public class HashTable<K, V> implements HashTableInterface<K, V> {

	/**
	 * DO NOT CHANGE THIS NUMBER.
	 * 
	 * This is the constant determining max load factor, or when you will
	 * have to regrow the table.
	 */
	private static final double MAX_LOAD_FACTOR = .71;
	
	/**
	 * DO NOT CHANGE THIS NUMBER.
	 * 
	 * This is the constant determining what size you will initialize your
	 * table array to.
	 */
	private static final int INITIAL_CAPACITY = 11;
	
	/**
	 * The number of entries in the table.
	 */
	private int size;
	
	/**
	 * The backing array of your hash table.
	 */
	private MapEntry<K, V>[] table;
	
	/**
	 * Initialize the backing array to the initial capacity and the size
	 * to the appropriate starting size.
	 */
	public HashTable() {
		table = (MapEntry<K, V>[]) new MapEntry[INITIAL_CAPACITY];
	}
	
	@Override
	public V put(K key, V value) {
	    
	    if (key == null || value == null) {
	        throw new IllegalArgumentException();
	    }
	    
	    V retVal = null;
	    
        double loadFactor = (size + 1) / ((double) table.length);
		if (loadFactor > MAX_LOAD_FACTOR) {
		    regrow();
		}
		MapEntry<K, V> entry = new MapEntry<K, V>(key, value);
		int hash = Math.abs(key.hashCode());
		if (table[hash % table.length] != null && !table[hash % table.length].isRemoved()) {
		    int counter = 0;
            while (table[(hash + counter) % table.length] != null 
                    && !table[(hash + counter) % table.length].getKey().equals(key)) {
                counter++;
            }
            table[(hash + counter) % table.length] = entry;
            if (counter > 0) {
                size++;
            }
		} else {
		    MapEntry<K, V> prev = table[hash % table.length];
		    if (prev != null) {
		        retVal = prev.getValue();
		    }
		    table[hash % table.length] = entry;
		    size++;
		}
		return retVal;
	}
	
	private void regrow() {
	    MapEntry<K, V>[] temp = (MapEntry<K, V>[]) new MapEntry[table.length * 2 + 1];
	    for (int i = 0; i < table.length; i++) {
	        MapEntry<K, V> entry = table[i];
	        if (entry != null && !entry.isRemoved()) {
	            int hash = Math.abs(entry.getKey().hashCode());
	            if (temp[hash % temp.length] == null) {
	                temp[hash % temp.length] = entry;
	            } else {
	                int j = 0;
	                while (temp[(hash + j) % temp.length] != null) {
	                    j++;
	                }
	                temp[(hash + j) % temp.length] = entry;
	            }
	        }
	    }
	    table = temp;
	}

	@Override
	public V get(K key) {
		if (key == null) {
		    throw new IllegalArgumentException();
		}
		if (!this.containsKey(key)) {
		    return null;
		}
		int hash = Math.abs(key.hashCode());
		int counter = 0;
		boolean done = table[hash % table.length] != null 
                && table[hash % table.length].getKey().equals(key);
        while (!done && counter < table.length) {
            counter++;
            if (table[(hash + counter) % table.length] != null 
                    && table[(hash + counter) % table.length].getKey().equals(key)) {
                done = true;
            }
        }
        if (table[(hash + counter) % table.length] != null 
                && table[(hash + counter) % table.length].getKey().equals(key)) {
            return table[(hash + counter) % table.length].getValue();
        }
		return null;
	}

	@Override
	public V remove(K key) {
	    if (key == null) {
            throw new IllegalArgumentException();
        }
        if (!this.containsKey(key)) {
            return null;
        }
        V value = null;
        int hash = Math.abs(key.hashCode());
        int counter = 0;
        boolean done = table[hash % table.length] != null 
                && table[hash % table.length].getKey().equals(key);
        while (!done && counter < table.length) {
            counter++;
            if (table[(hash + counter) % table.length] != null 
                    && table[(hash + counter) % table.length].getKey().equals(key)) {
                done = true;
            }
        }
        if (table[(hash + counter) % table.length] != null 
                && table[(hash + counter) % table.length].getKey().equals(key)
                && !table[(hash + counter) % table.length].isRemoved()) {
            value = table[(hash + counter) % table.length].getValue();
            table[(hash + counter) % table.length].setRemoved(true);
            size--;
        }
        
        return value;
	}

	@Override
	public boolean contains(V value) {
	    if (value == null) {
	        throw new IllegalArgumentException();
	    }
		for (int i = 0; i < table.length; i++) {
		    if (table[i] != null && table[i].getValue().equals(value)) {
		        return true;
		    }
		}
		return false;
	}

	@Override
	public boolean containsKey(K key) {
	    if (key == null) {
            throw new IllegalArgumentException();
        }
		int hash = Math.abs(key.hashCode());
		int counter = 0;
		boolean done = table[hash % table.length] != null 
                && table[hash % table.length].getKey().equals(key);
        while (!done && counter < table.length) {
            if (table[(hash + counter + 1) % table.length] != null 
                    && table[(hash + counter + 1) % table.length].getKey().equals(key)) {
                done = true;
            }
            counter++;
        }
        if (table[(hash + counter) % table.length] != null 
                && table[(hash + counter) % table.length].getKey().equals(key)) {
            return true;
        }
        return false;	
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < table.length; i++) {
		    if (table[i] != null && !table[i].isRemoved()) {
		        set.add(table[i].getKey());
		    }
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Collection<V> list = new ArrayList<V>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                list.add(table[i].getValue());
            }
        }
        return list;
	}

	@Override
	public Set<MapEntry<K, V>> entrySet() {
	    Set<MapEntry<K, V>> set = new HashSet<MapEntry<K, V>>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isRemoved()) {
                set.add(table[i]);
            }
        }
        return set;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
		table = (MapEntry<K, V>[]) new MapEntry[INITIAL_CAPACITY];
	}

}
