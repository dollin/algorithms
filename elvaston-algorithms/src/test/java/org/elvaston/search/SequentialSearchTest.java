package org.elvaston.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.elvaston.api.SymbolTable;
import org.junit.Test;

/**
 * Tests for the sequential searching algorithm implementation.
 */
public class SequentialSearchTest {

    @Test
    public void addOne() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.put("A", "Adam");
        assertEquals(1, st.size());
        assertEquals("Adam", st.get("A"));
        assertTrue(st.contains("A"));
        assertFalse(st.contains("B"));
    }

    @Test
    public void replaceDuplicateKey() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.put("A", "Adam");
        st.put("A", "Angela");
        assertEquals(1, st.size());
        assertEquals("Angela", st.get("A"));
    }

    @Test
    public void deleteFirstKey() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.put("A", "Adam");
        st.delete("A");
        assertEquals(0, st.size());
        assertNull(st.get("A"));
    }

    @Test
    public void deleteMiddleKey() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.put("A", "Adam");
        st.put("B", "Barry");
        st.put("C", "Charlie");
        st.delete("B");
        assertEquals(2, st.size());
        assertNull(st.get("B"));
        assertEquals("Charlie", st.get("C"));
    }

    @Test
    public void deleteMiddleKeyByPutNullValue() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.put("A", "Adam");
        st.put("B", "Barry");
        st.put("C", "Charlie");
        st.put("B", null);
        assertEquals(2, st.size());
        assertNull(st.get("B"));
        assertEquals("Charlie", st.get("C"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteNull() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void putNullKey() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.put(null, "not null");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNullKey() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.get(null);
    }

    @Test
    public void deleteIfEmptyIsNoop() {
        SymbolTable<String, String> st = new SequentialSearch<>();
        st.delete("");
    }
}
