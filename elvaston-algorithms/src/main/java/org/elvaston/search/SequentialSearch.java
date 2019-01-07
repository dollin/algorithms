package org.elvaston.search;

import org.elvaston.api.SymbolTable;

/**
 * SequentialSearch.
 * Sequential search for an unordered linked list. We implement a symbol table with a linked list of nodes that contain
 * keys and values. To implement get(), we scan through the list, using equals() to compare the search key with the
 * key in each node in the list.
 * If we find the match, we return the associated value; if not, we return null.
 * To implement put(), we also scan through the list, using equals() to compare the client key with the key
 * in each node in the list. If we find the match, we update the value associated with that key to be the value given
 * in the second argument; if not, we create a new node with the given key and value and insert it at the beginning.
 * <p>
 * Proposition #1.
 * Unsuccessful search and insert in an (unordered) linked-list symbol table both use N compares,
 * and successful search uses N compares in the worst case.
 * In particular, inserting N keys into an initially empty linked-list symbol table uses ~N^2/2 compares.
 * </p>
 */
public class SequentialSearch<K, V> implements SymbolTable<K, V> {

    private int size = 0;

    class Node {
        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Node next;
        K key;
        V value;
    }

    private Node root;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("cannot add a null key");
        }
        if (value == null) {
            delete(key);
        } else {
            Node node = nodeWith(key);
            if (node != null) {
                node.value = value;
            } else {
                root = new Node(key, value, root);
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("cannot get a null key");
        }
        Node node = nodeWith(key);
        return node != null ? node.value : null;
    }

    @Override
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("cannot delete a null key");
        }

        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            size--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    private Node nodeWith(K key) {
        for (Node node = root; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }
}
