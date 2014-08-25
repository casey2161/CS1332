import java.util.Map.Entry;

/**
 * MapEntry class that acts as the buckets for your hash table.
 * 
 * @author Julia Ting
 *
 */
public class MapEntry<K, V> implements Entry<K, V> {

	/**
	 * The key of the map entry.
	 */
	private K key;
	
	/**
	 * The value of the map entry.
	 */
	private V value;
	
	/**
	 * This flag determines whether or not the map entry has been
	 * removed from the table. True if it has been removed, false if it hasn't.
	 */
	private boolean removed;
	
	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
		removed = false;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V temp = this.value;
		this.value = value;
		return temp;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapEntry<K, V> other = (MapEntry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	/**
	 * Returns removed status.
	 * 
	 * @return the stored flag in the MapEntry that states if it has been
	 * removed or not.
	 */
	public boolean isRemoved() {
		return removed;
	}
	
	/**
	 * Sets the removed flag.
	 * 
	 * @param status
	 */
	public void setRemoved(boolean status) {
		this.removed = status;
	}
	
	/**
	 * toString for the MapEntry class, helpful for debugging/testing.
	 */
	public String toString() {
		return key + "-" + value;
	}

}
