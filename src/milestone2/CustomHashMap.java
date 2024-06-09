package milestone2;
class CustomHashMap {
    private class Entry {
        char key;
        String value;
        Entry next;

        public Entry(char key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry[] table;
    private int capacity;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    private int hash(char key) {
        return key % capacity;
    }

    public void put(char key, String value) {
        int hash = hash(key);
        Entry newEntry = new Entry(key, value);
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry current = table[hash];
            while (current.next != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key == key) {
                current.value = value;
            } else {
                current.next = newEntry;
            }
        }
    }

    public String get(char key) {
        int hash = hash(key);
        Entry current = table[hash];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null; // return null if key is not found
    }

    public boolean containsKey(char key) {
        return get(key) != null;
    }

    public char[] keys() {
        java.util.ArrayList<Character> keys = new java.util.ArrayList<>();
        for (Entry entry : table) {
            Entry current = entry;
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        char[] keysArray = new char[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            keysArray[i] = keys.get(i);
        }
        return keysArray;
    }
}
