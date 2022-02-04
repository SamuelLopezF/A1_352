import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WarehouseManager {


    public static void main(String[] args) throws FileNotFoundException {

        ALDictionary<String, String> array_based_manager = new ALDictionary<>(100);
        try {
            BufferedReader buff_reader = new BufferedReader(new FileReader("A1_352-master/src/warehouse_data"));
            String line;
            while((line = buff_reader.readLine()) != null)
            {
                System.out.println(line);
                String key = line.substring(0,6);
                String info = line.substring(7,14);
                array_based_manager.insert(key, info);
            }
            }catch (IOException e)
            {
                System.out.println("could not read file");
            }
        System.out.println(array_based_manager.search("IN0012"));
        System.out.println(array_based_manager.find("IN0012"));
        array_based_manager.toString();
    }
}
