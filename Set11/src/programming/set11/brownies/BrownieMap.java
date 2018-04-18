package programming.set11.brownies;

/**
 * Implementation of a HashMap.
 * 
 * @author lukas
 *
 * @param <K>
 *            Type of the keys.
 * @param <V>
 *            Type of the values.
 */
public class BrownieMap<K, V> {

	/* Private instance variables */
	private BrownieEntry<K, V>[] bucketArray;

	/**
	 * The capacity sets the length of the bucket array.
	 * 
	 * @param numberOfBuckets
	 *            bucket array length
	 * @throws IllegalArgumentException
	 *             if the number of buckets is smaller than one.
	 */
	public BrownieMap(int numberOfBuckets) {
		if (numberOfBuckets < 1) {
			throw new IllegalArgumentException();
		}
		bucketArray = new BrownieEntry[numberOfBuckets];
	}

	/**
	 * Put an item into the map.
	 * 
	 * @param key
	 *            the key of the item.
	 * @param value
	 *            the value of the item.
	 * @throws IllegalArgumentException
	 *             if the key or the value is {@code null}.
	 */
	public void put(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException();
		}
		int bucket = Math.abs(key.hashCode()) % bucketArray.length;
		BrownieEntry<K, V> entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			entry = new BrownieEntry<K, V>(key, value);
			entry.setLink(bucketArray[bucket]);
			bucketArray[bucket] = entry;
		} else {
			entry.setValue(value);
		}
	}

	/**
	 * Returns the value of a given key.
	 * 
	 * @param key
	 *            the key of the item.
	 * @return the value belonging to that key or {@code null} if no value is mapped
	 *         to that key.
	 * @throws IllegalArgumentException
	 *             if the key is {@code null}.
	 */
	public V get(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		int bucket = Math.abs(key.hashCode()) % bucketArray.length;
		BrownieEntry<K, V> entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			return null;
		} else {
			return entry.getValue();
		}
	}

	/**
	 * Removes one key and its value from the map. If the key does not exist in the
	 * map, nothing happens.
	 * 
	 * @param key
	 *            the key.
	 * @throws IllegalArgumentException
	 *             if the key is {@code null}.
	 */
	public void remove(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		int bucket = Math.abs(key.hashCode()) % bucketArray.length;
		if (bucketArray[bucket].getKey().equals(key)) {
			bucketArray[bucket] = bucketArray[bucket].getLink();
			return;
		}
		BrownieEntry<K, V> entry = bucketArray[bucket];
		while (entry.getLink() != null) {
			if (entry.getLink().getKey().equals(key)) {
				entry.setLink(entry.getLink().getLink());
				return;
			}
			entry = entry.getLink();
		}
	}

	/**
	 * Clears the entire map.
	 */
	public void clear() {
		bucketArray = new BrownieEntry[bucketArray.length];
	}

	/**
	 * Scans the entry chain looking for an entry that matches the specified key.
	 * 
	 * @param entry
	 *            Entry chain to search.
	 * @param key
	 *            Key to look for.
	 * @return The entry matching the key or {@code null} if no such entry exists.
	 */
	private BrownieEntry<K, V> findEntry(BrownieEntry<K, V> entry, K key) {
		while (entry != null) {
			if (entry.getKey().equals(key))
				return entry;
			entry = entry.getLink();
		}
		return null;
	}
}

/**
 * This class represents a pair of a key and a value, along with a reference to
 * the next HashEntry in the chain. The methods exported by the class consist
 * only of getters and setters.
 * 
 * @author lukas
 *
 * @param <K>
 *            Type of the keys.
 * @param <V>
 *            Type of the values.
 */
class BrownieEntry<K, V> {
	/**
	 * Creates a new HashEntry for the specified key/value pair.
	 * 
	 * @param key
	 *            Key of the entry.
	 * @param value
	 *            Value of the entry.
	 */
	public BrownieEntry(K key, V value) {
		entryKey = key;
		entryValue = value;
	}

	/**
	 * Getter for the key.
	 * 
	 * @return The key component of a HashEntry.
	 */
	public K getKey() {
		return entryKey;
	}

	/**
	 * Getter for the value.
	 * 
	 * @return The value component of a HashEntry.
	 */
	public V getValue() {
		return entryValue;
	}

	/**
	 * Setter for the value.
	 * 
	 * @param value
	 *            The new value of the entry.
	 */
	public void setValue(V value) {
		entryValue = value;
	}

	/**
	 * Getter for the link.
	 * 
	 * @return The next link in the entry chain.
	 */
	public BrownieEntry<K, V> getLink() {
		return entryLink;
	}

	/**
	 * Setter for the link.
	 * 
	 * @param nextEntry
	 *            The new link for the entry.
	 */
	public void setLink(BrownieEntry<K, V> nextEntry) {
		entryLink = nextEntry;
	}

	/* Private instance variables */
	private K entryKey; /* The key component for this HashEntry */
	private V entryValue; /* The value component for this HashEntry */
	private BrownieEntry<K, V> entryLink; /* The next entry in the chain */
}