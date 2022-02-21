import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryJUnitTestManual {

    private static ADTDictionary<String, Inventory> dict;



    @BeforeAll
    public static void setUp() {
        //dict = new ALDictionary<String, Inventory>(100);
        // dict = new LLDictionary<String, Inventory>(100);
        dict = new DLDictionary<String, Inventory>(100);
        read_from_text_file_database(dict);
    }

    @Test
    void testClear() {
        dict.clear();
        assertEquals(0, dict.size(), "clear failed, size is non-zero");
    }

    @Test
    void testInsert() {
        dict.clear();
        dict.insert("red", new Inventory("test_1", 10, 9.9f));
        dict.insert("blue", new Inventory("test_2", 1, 100));
        dict.insert("purple", new Inventory("test_3", 4, 4.0f));
        assertEquals(3, dict.size(), "insert failed, size is not as expected");
    }

    @Test
    void testRemove() {
        dict.clear();
        dict.insert("red", new Inventory("test_1", 10, 9.9f));
        dict.insert("blue", new Inventory("test_2", 1, 100));
        dict.insert("purple", new Inventory("test_3", 4, 4.0f));
        Inventory deleted_item = dict.remove("purple");
        assertEquals("test_3", deleted_item.name);
    }

    @Test
    void testRemoveAny(){
        dict.clear();
        dict.insert("red", new Inventory("test_1", 10, 9.9f));
        dict.insert("blue", new Inventory("test_2", 1, 100));
        dict.insert("purple", new Inventory("test_3", 4, 4.0f));
        assertEquals("test_1", dict.removeAny().name);
    }

    @Test
    void testfind()
    {
        dict.clear();
        dict.insert("red", new Inventory("test_1", 10, 9.9f));
        dict.insert("blue", new Inventory("test_2", 1, 100));
        dict.insert("purple", new Inventory("test_3", 4, 4.0f));
        assertEquals("test_1", dict.find("blue").name);
    }


    public static void read_from_text_file_database(ADTDictionary test_dict) {
        try {
            BufferedReader buff_reader = new BufferedReader(new FileReader("src/warehouse_data"));
            String line;
            while ((line = buff_reader.readLine()) != null) {
//                testing_dictionary.insert(key, info);
                String[] words = line.split("\\s+");
                Inventory record = new Inventory(words);
                test_dict.insert(record.getKey(), record);
            }
        } catch (IOException e) {
            System.out.println("could not read file");
        }
    }
}
