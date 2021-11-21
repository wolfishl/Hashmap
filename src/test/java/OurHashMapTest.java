import org.junit.jupiter.api.Test;

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
}