import java.util.*;
import java.sql.Array;

public class OurHashMap<K, V> implements Map<K, V> {

    private final int SIZE = 1024;

    class Entry<K,V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Entry> values[] = new List[SIZE];

    @Override
    public int size() {
        int count = 0;
        for (List<Entry> list : values)
        {
            if (list != null)
            {
                count += list.size();
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        for (List<Entry> list : values)
        {
            if (list != null && !list.isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        V value = this.get(key);
        return value != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<Entry> list : values)
        {
            if (list == null)
            {
                continue;
            }
            for (Entry entry : list)
            {
                if(entry.value == (V)value)
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if(list == null){
            return null;
        }
        for (Entry entry : list)
        {
            if (entry.key.equals(key))
            {
                return (V) entry.value;
            }
        }
        return null;
    }


    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        if (list == null)
        {
            list = new ArrayList<Entry>();
            values[index] = list;
        }
        for (Entry<K,V> entry : (List<Entry<K,V>>)list)
        {
            if (entry.key.equals(key))
            {
                V saved = entry.value;
                entry.value = value;
                return saved;
            }
        }

        Entry entry = new Entry(key,value);
        list.add(entry);
        return null;
    }

    @Override
    public V remove(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if(list == null){
            return null;
        }
        for (Entry entry : list)
        {
            if (entry.key.equals(key))
            {
                V value = (V) entry.value;
                list.remove(entry);
                return value;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map m) {
        Set<K> allKeys = m.keySet();
        for (K key : allKeys)
        {
            V value = (V)m.get(key);
            this.put(key, value);
        }
    }

    @Override
    public void clear() {
        values = new List[SIZE];
    }

    @Override
    public Set keySet() {
        HashSet<K> keys = new HashSet<>();
        for (List<Entry> list : values)
        {
            if (list != null)
            {
                for (Entry entry : list)
                {
                    keys.add((K)entry.key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection values() {
        List<V> allValues = new ArrayList<>();
        for (List<Entry> list : values)
        {
            if (list != null)
            {
                for (Entry entry : list)
                {
                    allValues.add((V)entry.value);
                }
            }
        }
        return allValues;
    }

    @Override
    public Set<java.util.Map.Entry<K,V>> entrySet() {
        return null;
    }
}
