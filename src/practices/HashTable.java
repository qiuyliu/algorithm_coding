package practices;


import java.lang.reflect.Array;
import java.util.Arrays;

class MyHashMap<K, V> {

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    //    static final variable are global constants
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int SCALE_FACTOR = 10;

    private Node<K, V>[] array;
    private int size;
    private float loadFactor;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("cap can not be <= 0");
        }
        this.array = new Node[cap];
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    private int hash(K key) {
//        return the hash# of the key
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0X7FFFFFFF; // guarantee non-negative
    }
    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
        return v1 == v2 || v1 != null && v1.equals(v2);
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> node : array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private boolean equalsKey(K k1, K k2) {
//        if (k1 == null && k2 == null) {
//            return true;
//        }
//        if (k1 == null || k2 == null) {
//            return false;
//        }
//        return k1.equals(k2);
        return k1 == k2 || k1 != null && k1.equals(k2);
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

//    insert/update value
//    if the key exists, return the old value
//    if not, return null
    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;

        while (node != null) {
            if (equalsKey(node.key, key)) {
                V result = node.value;
                node.value = value;
                return result;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;
        if (needRehash()) {
            rehashing();
        }
        return null;
    }

    private void rehashing() {
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) (new Node[array.length * SCALE_FACTOR]);
        for (Node<K, V> node : array) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = getIndex(next.key);
                node.next = array[index];
                array[index] = node;
                node = next;
            }
        }
    }

    private boolean needRehash() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    public V remove(K key) {
       int index = getIndex(key);
       Node<K, V> node = array[index];
       Node<K, V> pre = null;
       while (node != null) {
           if (equalsKey(node.key, key)) {
               if (pre != null) {
                   pre.next = node.next;
               } else {
                   array[index] = node.next;
               }
               size--;
               return node.value;
           }
           pre = node;
           node = node.next;
       }
       return null;
    }

}




