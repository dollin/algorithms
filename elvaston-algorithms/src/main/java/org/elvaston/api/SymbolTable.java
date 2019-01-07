package org.elvaston.api;

/**
 * SymbolTable interface used to associate KEY w/ VALUES using generics.
 * <p>
 * Generics.
 * We consider methods w/out specifying the types of keys and values being processed, using generics
 * </p>
 * <p>
 * Duplicate keys.
 * Only one value is associated with each key (no duplicate keys in a table). When a client puts a key-value pair into
 * a table already containing that key (and an associated value), the new value replaces the old one.
 * These conventions define the associative array abstraction, where you can think of a symbol table as being just
 * like an array, where keys are indices and values are array entries.
 * </p>
 * <p>
 * Null values.
 * No key can be associated with the value null. This convention is directly tied to our specification in the API
 * that get() should return null for keys not in the table. This convention has two (intended) consequences: -
 * First, we can test whether or not the symbol table defines a value associated with a given key by testing whether
 * get() returns null.
 * Second, we can use the operation of calling put() with null as its second (value) argument to implement deletion.
 * </p>
 * <p>
 * Deletion.
 * Deletion in symbol tables generally involves one of two strategies: -
 * Lazy deletion, where we associate keys in the table w/ null (put(key, null), then perhaps remove the keys later on
 * Eager deletion, where we remove the key from the table immediately.
 * </p>
 * <p>
 * Iterators.
 * The keys() method returns an {@code Iterable<K>} object for clients to use to iterate through the keys.
 * </p>
 * <p>
 * Key equality.
 * Java requires that all objects implement an equals() method and provides implementations both for standard types
 * such as Integer, Double, and String and for more complicated types such as Date, File and URL. For applications
 * involving these types of data, you can just use the built-in implementation. For example, if x and y are String
 * values, then x.equals(y) is true iff  x and y have the same length and are identical in each character position.
 * In practice, keys might be more complicated, as such, you need to override equals().
 * Java's convention is that equals() must implement an equivalence relation: -
 * Reflexive: x.equals(x) is true.
 * Symmetric: x.equals(y) is true if and only if y.equals(x) is true.
 * Transitive: if x.equals(y) and y.equals(z) are true, then so is x.equals(z).
 * Consistency: multiple invocations of x.equals(y) returns the same value, provided neither object is modified.
 * Not null: x.equals(null) returns false.
 * A best practice is to make Key types immutable, because consistency cannot otherwise be guaranteed.
 * </p>
 */
public interface SymbolTable<K, V> {

    void put(K key, V value);

    V get(K key);

    void delete(K key);

    boolean contains(K key);

    int size();

    Iterable<K> keys();
}
