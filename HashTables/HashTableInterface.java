import java.util.Collection;
import java.util.Set;

/**
 * Interface for your own lil dandy Hash Table! This hash table will
 * handle collisions with linear probing. Entries will be stored in
 * this hash table utilizing the Entry<K, V> class with entries that 
 * store keys of type K and values of type V.
 * 
 * REMINDER: If null is entered as a parameter, be sure to throw 
 * an IllegalArgumentException.
 * 
 * DO NOT ALTER THIS FILE.
 * 
 * @author Julia Ting
 *
 */
public interface HashTableInterface<K, V> {

	/**
	 * Add the key value pair in the form of a MapEntry<K, V>. If the key
	 * already exists in the table then override the current value with the
	 * new value. Don't forget to regrow the table at the appropriate time.
	 * 
	 * Throw an IllegalArgumentException if input is null.
	 * 
	 * @param key The key of this entry in the hash table.
	 * @param value The value that you would like to add to the hash table.
	 * @return the value that previously corresponded to the specified key
	 * if it existed, null if it did not have one.
	 */
	public V put(K key, V value);
	
	/**
	 * Searches through the hash table to find the value corresponding
	 * to the specified key. 
	 * 
	 * Throw an IllegalArgumentException if input is null.
	 * 
	 * @param key The Key of the entry that you are looking to retrieve.
	 * @return the value of the entry indicated by the key, null if not
	 * in the table.
	 */
	public V get(K key);
	
	/**
	 * Remove the MapEntry specified by the key from the hash table.
	 * 
 	 * Throw an IllegalArgumentException if input is null.
	 * 
	 * @param key The key of the entry that you are looking to remove.
	 * @return the value that corresponds with the removed key.
	 */
	public V remove(K key);
	
	/**
	 * Determine whether the hash table contains the specified value.
	 * 
	 * Throw an IllegalArgumentException if input is null.
	 * 
	 * @param value The value that you are looking for.
	 * @return true if the value is in the hash table, false if not.
	 */
	public boolean contains(V value);
	
	/**
	 * Determine whether the hash table contains the specified key.
	 * 
	 * Throw an IllegalArgumentException if input is null.
	 * 
	 * @param key The key that you are looking for.
	 * @return true if the key is in the hash table, false if not.
	 */
	public boolean containsKey(K key);
	
	/**
	 * Return the unique set of keys in the hash table. If there are no keys
	 * return an empty set. You may use java.util.HashSet. 
	 * 
	 * @return the set of unique keys for the hash table.
	 */
	public Set<K> keySet();
	
	/**
	 * Return all the values in the hash table. If there are no values return
	 * an empty collection (you may use java.util.ArrayList or LinkedList).
	 * 
	 * @return a collection of all the values in the hash table.
	 */
	public Collection<V> values();
	
	/**
	 * Returns the set of distinct map entries. If there are no entries 
	 * return an empty set. You may use java.util.HashSet.
	 * 
	 * @return set of all the entries in the hash table.
	 */
	public Set<MapEntry<K, V>> entrySet();
	
	/**
	 * Return the number of elements in the hash table.
	 * 
	 * @return the number of elements in the hash table.
	 */
	public int size();
	
	/**
	 * Return if the hash table is empty or not.
	 * 
	 * @return true if the hash table is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Clear all entries in the hash table. This method should also reset
	 * the backing array to the initial capacity. 
	 */
	public void clear();
	
	
}
