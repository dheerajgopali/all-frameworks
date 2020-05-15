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
public class CustomHashMapOwnLinearProbing<Key, Value> {
    Logger logger = Logger.getLogger(CustomHashMapOwnLinearProbing.class.toString());
    int currentStorageSize = 8;
    Object[] objectArray = new Object[currentStorageSize];
    int[] deletedArray = new int[currentStorageSize];

    public int put(Key key, Value value) {
        int hash = getHash(key);
        Entry entry = new Entry<Key,Value>(key, value);
        if(objectArray[hash] == null) {
            objectArray[hash] = entry;
            deletedArray[hash] = 0;
        } else {
            logger.info("Collision for Entry : " + entry + "at hash : " + hash);
            int emptySlot = findEmptySlot(hash, key);
            if(emptySlot == -1) {
                //Create a new array with double the size.
                //Dump the content by rehashing content.
                logger.info("Increasing the size of map from "+currentStorageSize+" to "+currentStorageSize*2);
                reHashing();
                put(key, value);
            } else {
                objectArray[emptySlot] = entry;
                deletedArray[emptySlot] = 0;
            }
        }
        return 1;
    }

    public Value get(Key key) {
        int hash = getHash(key);
        if(deletedArray[hash] == 0 && objectArray[hash] == null) {
            return null;
        } else {
            return findValue(key, hash);
        }
    }

    /**
     * Remove and mark the node as deleted.
     *
     * @param key
     * @return
     */
    public int remove(Key key) {
        int startIndex = getHash(key);
        int index = findIndex(key, startIndex);
        if(index != -1) {
            objectArray[index] = null;
            deletedArray[index] = 1;
            return 1;
        }
        return 0;
    }

    private int findIndex(Key key, int startIndex) {
        //Check forward from hash to end of the array

        for(int currentPointer = startIndex;currentPointer < currentStorageSize ; currentPointer++) {
            if(deletedArray[currentPointer] == 1)
                continue;
            Entry<Key, Value> entry = ((Entry<Key, Value>)objectArray[currentPointer]);
            if(entry == null) {
                return -1;
            } else if(key.equals(entry.key)) {
                return currentPointer;
            }
        }

        //Check from start of the array till hash
        for(int currentPointer = 0;currentPointer < startIndex ; currentPointer++) {
            if(deletedArray[currentPointer] == 1)
                continue;
            Entry<Key, Value> entry = ((Entry<Key, Value>)objectArray[currentPointer]);
            if(entry == null) {
                return -1;
            } else if(key.equals(entry.key)) {
                return currentPointer;
            }
        }

        return -1;
    }

    private void reHashing() {
        int oldStorageSize = currentStorageSize;
        currentStorageSize = currentStorageSize*2;
        Object oldObjectArray[] = objectArray;
        objectArray = new Object[currentStorageSize];
        deletedArray = new int[currentStorageSize];
        for(int currentPointer=0;currentPointer<oldStorageSize;currentPointer++) {
            Entry<Key, Value> tempEntry = ((Entry<Key, Value>)oldObjectArray[currentPointer]);
            if(tempEntry != null) {
                put(tempEntry.key, tempEntry.value);
            }
        }
    }

    private int getHash(Key key) {
        return Math.abs(key.toString().hashCode() % currentStorageSize);
    }

    private int findEmptySlot(int hash, Key key) {
        //Check forward from hash to end of the array

        for(int currentPointer = hash;currentPointer < currentStorageSize ; currentPointer++) {
            Entry<Key, Value> tempEntry = ((Entry<Key, Value>)objectArray[currentPointer]);
            if(tempEntry != null && key.equals(tempEntry.key)) {
                return currentPointer;
            } else if(tempEntry == null)
                return currentPointer;
        }

        //Check from start of the array till hash
        for(int currentPointer = 0;currentPointer < hash ; currentPointer++) {
            Entry<Key, Value> tempEntry = ((Entry<Key, Value>)objectArray[currentPointer]);
            if(tempEntry != null && key.equals(tempEntry.key)) {
                return currentPointer;
            } else if(tempEntry == null)
                return currentPointer;
        }

        return -1;
    }



    private Value findValue(Key key, int hash) {
        //Check forward from hash to end of the array

        for(int currentPointer = hash;currentPointer < currentStorageSize ; currentPointer++) {
            if(deletedArray[currentPointer] == 1)
                continue;
            Entry<Key, Value> entry = ((Entry<Key, Value>)objectArray[currentPointer]);
            if(entry == null) {
                return null;
            } else if(key.equals(entry.key)) {
                return entry.value;
            }
        }

        //Check from start of the array till hash
        for(int currentPointer = 0;currentPointer < hash ; currentPointer++) {
            if(deletedArray[currentPointer] == 1)
                continue;
            Entry<Key, Value> entry = ((Entry<Key, Value>)objectArray[currentPointer]);
            if(entry == null) {
                return null;
            } else if(key.equals(entry.key)) {
                return entry.value;
            }
        }

        return null;
    }

    class Entry<Key, Value> {
        Key key;
        Value value;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
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
