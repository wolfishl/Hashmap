import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    @Test
    void get() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when

        //then
        assertNull(map.get("English1"));
    }

    @Test
    void put() {
        //given
        OurHashMap<String, String> map = new OurHashMap();

        //when
        map.put("English1", "Hello");
        map.put("English2", "Hi");
        map.put("English3", "Hey");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");
        map.put("Russian", "Privit");
        map.put("Chinese", "Ne How");
        map.put("Japanese", "Corniquiwa");

        //then
        assertEquals("Hello", map.get("English1"));
        assertEquals("Hi", map.get("English2"));
        assertEquals("Hey", map.get("English3"));
        assertEquals("Hola", map.get("Spanish"));
        assertEquals("Shalom", map.get("Hebrew"));
        assertEquals("Bonjour", map.get("French"));
        assertEquals("Privit", map.get("Russian"));
        assertEquals("Ne How", map.get("Chinese"));
        assertEquals("Corniquiwa", map.get("Japanese"));
    }

    @Test
    void putSameKeys() {
        //given
        OurHashMap<String, String> map = new OurHashMap();

        //when
        map.put("English1", "Hello");
        map.put("English1", "Hi");

        //then
        assertEquals("Hi", map.get("English1"));
    }

    @Test
    void isEmptyTrue() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when

        //then
        assertTrue(map.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English", "Hello");

        //then
        assertFalse(map.isEmpty());
    }

    @Test
    void size() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //then
        assertEquals(2, map.size());
    }

    @Test
    void sizeEmpty() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when

        //then
        assertEquals(0, map.size());
    }

    @Test
    void containsKeyTrue() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //then
        assertTrue(map.containsKey("English"));
    }

    @Test
    void containsKeyFalse() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //then
        assertFalse(map.containsKey("Spanish"));
    }

    @Test
    void containsValueTrue() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //then
        assertTrue(map.containsValue("Hello"));
    }

    @Test
    void containsValueFalse() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //then
        assertFalse(map.containsValue("Hola"));
    }

    @Test
    void remove() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("English", "Hello");
        map.put("French", "Bonjour");
        map.remove("English");

        //then
        assertFalse(map.containsKey("English"));
    }

    @Test
    void putAll() {
        //given
        HashMap<String, String> m = new HashMap<>();
        m.put("English", "Hello");
        m.put("French", "Bonjour");
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.putAll(m);

        //then
        assertTrue(map.containsKey("English"));
        assertEquals("Hello", map.get("English"));
        assertTrue(map.containsKey("French"));
        assertEquals("Bonjour", map.get("French"));
    }

    @Test
    void clear() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //when
        map.clear();

        //then
        assertTrue(map.isEmpty());
    }

    @Test
    void keySet() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //when
        Set<String> keys = map.keySet();

        //then
        assertTrue(keys.contains("English"));
        assertTrue(keys.contains("French"));
        assertTrue(keys.size() == map.size());
    }

    @Test
    void values() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        map.put("English", "Hello");
        map.put("French", "Bonjour");

        //when
        Collection values = map.values();

        //then
        assertTrue(values.contains("Hello"));
        assertTrue(values.contains("Bonjour"));
        assertTrue(values.size() == map.size());
    }
}