// package programming.set11.brownies;
//
// public class BrownieMap2<K, V> {
//
// private int numberOfBuckets;
//
// /**
// * The capacity sets the length of the bucket array.
// *
// * @param numberOfBuckets
// * bucket array length
// * @throws IllegalArgumentException
// * if the number of buckets is smaller than one.
// */
// public BrownieMap2(int numberOfBuckets) {
// this.numberOfBuckets = numberOfBuckets;
// }
//
// /**
// * Put an item into the map.
// *
// * @param key
// * the key of the item.
// * @param value
// * the value of the item.
// * @throws IllegalArgumentException
// * if the key or the value is {@code null}.
// */
// public void put(K key, V value) {
// // Implement this!
// }
//
// /**
// * Returns the value of a given key.
// *
// * @param key
// * the key of the item.
// * @return the value belonging to that key or {@code null} if no value is
// mapped
// * to that key.
// * @throws IllegalArgumentException
// * if the key is {@code null}.
// */
// public V get(K key) {
// // Implement me!
// return null;
// }
//
// /**
// * Removes one key and its value from the map. If the key does not exist in
// the
// * map, nothing happens.
// *
// * @param key
// * the key.
// * @throws IllegalArgumentException
// * if the key is {@code null}.
// */
// public void remove(K key) {
// // Implement me!
// }
//
// /**
// * Clears the entire map.
// */
// public void clear() {
// // Implement me!
// }
// }
//
/// * Package-private class: HashEntry */
/// *
// * This class represents a pair of a key and a value, along with a reference
// to
// * the next HashEntry in the chain. The methods exported by the class consist
// * only of getters and setters.
// */
// class HashEntry {
// /* Creates a new HashEntry for the specified key/value pair */
// public HashEntry(String key, String value) {
// entryKey = key;
// entryValue = value;
// }
//
// /* Returns the key component of a HashEntry */
// public String getKey() {
// return entryKey;
// }
//
// /* Returns the value component of a HashEntry */
// public String getValue() {
// return entryValue;
// }
//
// /* Sets the value component of a HashEntry to a new value */
// public void setValue(String value) {
// entryValue = value;
// }
//
// /* Returns the next link in the entry chain */
// public HashEntry getLink() {
// return entryLink;
// }
//
// /* Sets the link to the next entry in the chain */
// public void setLink(HashEntry nextEntry) {
// entryLink = nextEntry;
// }
//
// /* Private instance variables */
// private String entryKey; /* The key component for this HashEntry */
// private String entryValue; /* The value component for this HashEntry */
// private HashEntry entryLink; /* The next entry in the chain */
// }
//
// class SimpleStringMap {
// /** Creates a new SimpleStringMap with no key/value pairs */
// public SimpleStringMap() {
// bucketArray = new HashEntry[N_BUCKETS];
// }
//
// /**
// * Sets the value associated with key. Any previous value for key is lost.
// *
// * @param key
// * The key used to refer to this value
// * @param value
// * The new value to be associated with key
// */
// public void put(String key, String value) {
// int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
// HashEntry entry = findEntry(bucketArray[bucket], key);
// if (entry == null) {
// entry = new HashEntry(key, value);
// entry.setLink(bucketArray[bucket]);
// bucketArray[bucket] = entry;
// } else {
// entry.setValue(value);
// }
// }
//
// /**
// * Retrieves the value associated with key, or null if no such value exists.
// *
// * @param key
// * The key used to look up the value
// * @return The value associated with key, or null if no such value exists
// */
// public String get(String key) {
// int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
// HashEntry entry = findEntry(bucketArray[bucket], key);
// if (entry == null) {
// return null;
// } else {
// return entry.getValue();
// }
// }
//
// /*
// * Scans the entry chain looking for an entry that matches the specified key.
// If
// * no such entry exists, findEntry returns null.
// */
// private HashEntry findEntry(HashEntry entry, String key) {
// while (entry != null) {
// if (entry.getKey().equals(key))
// return entry;
// entry = entry.getLink();
// }
// return null;
// }
//
// /* Private constants */
// private static final int N_BUCKETS = 7;
// /* Private instance variables */
// private HashEntry[] bucketArray;
// }