package com.dheeraj.learning.datastructures.map;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Requirement
 *  Need a map to put and get values.
 * Design
 *  Storage
 *      Fixed size array to store values starting with size 8.
 *      If full create a double sized array.
 *
 *  Put
 *      Hash the key value to identify the index.
 *      If Collision move to next until a empty/an equal key object found.
 *      If no empty block create a new array with double size, dump existing into new one (using rehashing technique).
 *  Get
 *      Hash the key value to identify the index.
 *      Compare with equals method for the object in that index.
 *
 *
 *Collision Resolution techniques:
 * 1.Separate chaining
 * 2.Open Addressing
 *  a. Linear probing  //Current map implements this.
 *  b. Quadratic probing
 *  c. Double hashing
 *
 *
 * @param <Key>
 * @param <Value>
 */
public class CustomHashMapOwnSeparateChaining<Key, Value> {
    Logger logger = Logger.getLogger(CustomHashMapOwnSeparateChaining.class.toString());
    int currentStorageSize = 8;
    @SuppressWarnings("unchecked")
    Entry<Key,Value>[] objectArray = new Entry[currentStorageSize];
    int numOfElements = 0;

    public int put(Key key, Value value) {
        if(numOfElements > currentStorageSize)
            reHashing();
        int hash = getHash(key);
        Entry<Key, Value> newEntry = new Entry<>(key, value);
        if(objectArray[hash] == null) {
            objectArray[hash] = newEntry;
        } else {
            logger.info("Collision for Entry : " + newEntry + "at hash : " + hash);
            Entry<Key, Value> entry = objectArray[hash];
            Entry<Key, Value> lastEntry = entry;
            while(lastEntry.next!=null && !lastEntry.key.equals(newEntry.key)) {
                lastEntry = lastEntry.next;
            }
            newEntry.next = lastEntry.next;
            lastEntry.next = newEntry;
        }
        numOfElements++;
        return 1;
    }

    public Value get(Key key) {
        int hash = getHash(key);
        if(objectArray[hash] == null) {
            return null;
        } else {
            Entry<Key, Value> entry = objectArray[hash];
            while(entry!=null && !entry.key.equals(key)) {
                entry = entry.next;
            }
            return entry==null?null:entry.value;
        }
    }

    /**
     * Remove and mark the node as deleted.
     *
     * @param key
     * @return
     */
    public int remove(Key key) {
        int index = getHash(key);
        Entry<Key, Value> entry  = objectArray[index];
        Entry<Key, Value> firstEntry = entry;
        if(firstEntry != null && firstEntry.key.equals(key)) {
            objectArray[index] = firstEntry.next;
            return 1;
        }
        Entry<Key, Value> previousEntry = firstEntry;
        while(firstEntry!=null && !firstEntry.key.equals(key)) {
            previousEntry=firstEntry;
            firstEntry = firstEntry.next;
        }
        if(firstEntry == null) {
            logger.info("Element not found "+key);
            return 0;
        }
        previousEntry.next = firstEntry.next;

        return 1;
    }

    private void reHashing() {
        numOfElements=0;
        int oldStorageSize = currentStorageSize;
        currentStorageSize = currentStorageSize*2;
        Entry<Key, Value>[] oldObjectArray = objectArray;
        objectArray = new Entry[currentStorageSize];
        for(int currentPointer=0;currentPointer<oldStorageSize;currentPointer++) {
            Entry<Key, Value> tempEntry = oldObjectArray[currentPointer];
            while(tempEntry!=null) {
                put(tempEntry.key, tempEntry.value);
                tempEntry = tempEntry.next;
            }
        }
    }

    private int getHash(Key key) {
        return Math.abs(key.toString().hashCode() % currentStorageSize);
    }

    class Entry<Key, Value> {
        Key key;
        Value value;
        Entry<Key, Value> next;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
            next=null;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CustomHashMapOwn{" +
                "objectArray=" + Arrays.toString(objectArray) +
                '}';
    }
}
