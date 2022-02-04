import javax.lang.model.element.Element;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;

public class WarehouseManager {


    public static void main(String[] args) throws FileNotFoundException {

        ALDictionary<String, String> testing_dictionary = new ALDictionary<>(100);
        ALDictionary<String, Inventory> array_test = new ALDictionary<>(100);

        try {
            BufferedReader buff_reader = new BufferedReader(new FileReader("src/warehouse_data"));
            String line;
            while((line = buff_reader.readLine()) != null)
            {
                String key = line.substring(0,6);
                String infor = line.substring(7);
//                testing_dictionary.insert(key, info);
                String words[] = line.split("\\s");
                Inventory record = new Inventory(words);
                array_test.insert(record.getKey(), record);
            }
        }catch (IOException e)
            {
                System.out.println("could not read file");
            }
        System.out.println(array_test.toString());

//        System.out.println(testing_dictionary.search("IN0012"));
//        System.out.println(testing_dictionary.find("IN0012"));
//        String removed_item = testing_dictionary.removeCurrent();
//        System.out.println(removed_item);
//        testing_dictionary.insert("testing", "some value");
//        System.out.println(testing_dictionary.toString());



    }
}
