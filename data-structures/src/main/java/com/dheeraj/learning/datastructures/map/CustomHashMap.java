package com.dheeraj.learning.datastructures.map;

/**
 *
 * http://codecramp.com/how-to-implement-your-own-hashmap/
 *
 * Bonus Tips
 * In Java 8, to improve the performance of HashMap, put() method’s implementation has been updated to use a Red Black Tree if there are more than 8 Entries in the same bucket.
 * Having more than one Entry in a bucket is called Hash Collision and the Linked list approach to contain Entries with same hash values in the same bucket is called chaining.
 *
 * Note : Rehashing is not implemeented in this example. Capacity is constant here.
 * http://javabypatel.blogspot.com/2015/10/what-is-load-factor-and-rehashing-in-hashmap.html
 */
public class CustomHashMap<K, V> {
    @SuppressWarnings("unchecked")
    private Entry<K, V>[] buckets = new Entry[8];

    public void put(K key, V value) {
        Entry<K, V> entryToAdd = new Entry<>(key, value);
        int targetBucket = findBucket(key);
        Entry<K, V> currentEntry = buckets[targetBucket];
        // If bucket is empty
        if (currentEntry == null) {
            buckets[targetBucket] = entryToAdd;
        } else { // If bucket is not empty, add your entry at the end.
            Entry<K, V> previous = null;
            while (currentEntry != null) {
                if (currentEntry.key.equals(key)) { // Same key found -- Overwrite it.
                    entryToAdd.next = currentEntry.next; // Ensure that the old links are intact
                    if(previous == null) { // The very first item in the bucket is duplicate
                        currentEntry = entryToAdd;
                    } else {
                        previous.next = entryToAdd;  // Overwrite somewhere in the middle
                    }
                    return;
                }
                previous = currentEntry;
                currentEntry = currentEntry.next;
            }
            previous.next = entryToAdd;
        }
    }

    public V get(K key) {
        int targetBucket = findBucket(key);
        if (buckets[targetBucket] == null) { // If bucket is empty.
            return null;
        } else {
            Entry<K, V> entry = buckets[targetBucket];
            while (entry != null) {
                if (entry.key.equals(key)) { // Find the matching Entry by provided key.
                    return entry.value;
                }
                entry = entry.next;
            }
            return null; // returns null if key is not found.
        }
    }

    public Entry<K, V> remove(K key) {
        int targetBucket = findBucket(key);
        if (buckets[targetBucket] == null) {
            return null;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> entryToRemove = null;
            Entry<K, V> currentEntry = buckets[targetBucket];
            while (currentEntry != null) {
                if (currentEntry.key.equals(key)) { // Same key found -- Remove it.
                    entryToRemove = new Entry<K, V>(currentEntry.key, currentEntry.value);
                    if (previous == null) { // Entry is the very first node. So, just overwrite it with the second Entry.
                        buckets[targetBucket] = buckets[targetBucket].next;
                        return entryToRemove;
                    } else { // Entry is either in the middle or at end.
                        previous.next = currentEntry.next; // Update the references. If the Entry is the last node previous.next will become null.
                        return entryToRemove;
                    }
                }
                previous = currentEntry;
                currentEntry = currentEntry.next;
            }
        }
        return null;
    }

    /**
     * Finds the appropriate bucket for the given key.
     *
     * @param key - the key for which bucket needs to be found.
     * @return the location of the bucket.
     */
    public int findBucket(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void printMap() {
        for(int i=0; i< buckets.length; i++) {
            Entry<K, V> current = buckets[i];
            while (current != null) {
                System.out.print(current);
                current = current.next;
            }
            System.out.println();
        }
    }
}


class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        String appender = " --> ";
        if (next == null) {
            appender = " --> NULL";
        }
        return (key+", " + value) + appender;
    }
}