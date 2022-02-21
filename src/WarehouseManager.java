/**
 * Samuel Lopez-Ferrada
 * Student ID : 40112861
 * Computer Engineering
 * Data Structures and Algorithms 352 -Teacher : Yan Liu
 * Assignment 1
 *
 *
 *
 */







import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WarehouseManager {

    // Data Members :
    ADTDictionary<String, Inventory> list;
    private float total_warehouse_value;

    static Scanner keyboard_input = new Scanner(System.in);
    static String input;

    //Constructors :
    WarehouseManager()
    {
        this.list = null;
        this.total_warehouse_value = 0;
    }

    /**
     * this constructor instantiates a list of Array, LL, DL type
     * with a parametrized form of <String,Inventory>. Value is set
     * to zero since, we have not added any objects yet, the list is empty
     * @param list is a generic type of list, this is built to keep
     *             flexibility in the implementation
     */
    WarehouseManager(ADTDictionary<String, Inventory> list)
    {
        this.list = list;
        total_warehouse_value = 0;
    }

    //Class Functions :
    public Inventory find()
    {
        //Testing find function :
        System.out.println("\n\n======= Testing FIND function ======");
        System.out.println("Please insert a specific key to find an item (ex: IN0001 to IN0024)");
        input = keyboard_input.next();
        Inventory item_found = list.find(input);
        System.out.println("item found " + item_found);
        return item_found;
    }

    public void insert() {
        //Testing insert
        System.out.println("\n\n======= Testing INSERT function =======");
        System.out.println("Inserting test case, please enter a name");
        String name_of_test_case;
        name_of_test_case = keyboard_input.next();
        System.out.println("Please enter a key for the item");
        String key_of_test_case = keyboard_input.next();
        System.out.println("Enter the amount of units");
        int quantity = keyboard_input.nextInt();
        System.out.println("Enter a price for the item");
        float price = keyboard_input.nextFloat();
        Inventory to_be_added = new Inventory(name_of_test_case, quantity, price);
        list.insert(key_of_test_case, to_be_added);
        System.out.println(this);
        System.out.println(this.length());
        System.out.println("Updated Inventory value  = " + this.get_total_warehouse_value());

        int old_size = list.size();
        System.out.println(old_size + "<" + "size");
        if(old_size < list.size())
        {
            this.total_warehouse_value += to_be_added.getInventory_value();
        }
    }

    public void insert(String key,Inventory record)
    {
        int old_size = list.size();
        list.insert(key, record);
        if (old_size < list.size()) {
            this.total_warehouse_value += record.getInventory_value();
        }
    }


    public Inventory remove() {
        //Testing remove function :
        System.out.println("\n\n======= Testing REMOVE function =======");
        System.out.println("Please insert a specific key to remove (ex : IN0001 to IN0024)");
        System.out.println("if the key can't be found, it will result in a null return");
        String key = keyboard_input.next();
        Inventory item_deleted = list.remove(key);
        System.out.println("item deleted : " + item_deleted);
        System.out.println(this);
        System.out.println("Updated Inventory value  = " + this.get_total_warehouse_value());

        Inventory deleted_item = list.remove(key);
        if(deleted_item != null){
            total_warehouse_value -= deleted_item.inventory_value;
        }
        return deleted_item;
    }

    public void removeAny()
    {

        System.out.println("\n\n======= Testing REMOVEANY function =======");
        System.out.println("removing any");
        Inventory any_item_deleted = list.removeAny();
        System.out.println(this);
        System.out.println("item deleted : " + any_item_deleted);
        System.out.println("Updated Inventory value  = " + this.get_total_warehouse_value());

        Inventory deleted_item = list.removeAny();
        total_warehouse_value -= deleted_item.inventory_value;
    }

    public void clear() {

        //Testing clear function :
        System.out.println("\n\n ======= Testing CLEAR function =======");
        list.clear();
        System.out.println(this);
        System.out.println("Database length = " + this.length());
    }

    public int length(){
        return list.size();
    }


    public float get_total_warehouse_value() {
        return total_warehouse_value;
    }

    @Override
    public String toString()
    {
        return list.toString();
    }

    public void move_cursor()
    {
        input = "";
        while(!input.equalsIgnoreCase("Q"))
        {
            System.out.println("P - Previous \t N - Next \t Q - Quit ");
            input = keyboard_input.next();
            if (input.equalsIgnoreCase("P")) {
                list.previous();
                System.out.println(list.getCurrent());
            } else if (input.equalsIgnoreCase("N")) {
                list.next();
                System.out.println(list.getCurrent());
            }
        }
    }

    public void automatic_test() {

    }

    public void start_menu()
    {
        String input = "";
        while(!input.equalsIgnoreCase("Q"))
        {
            System.out.println("Menu of warehouse manager");
            System.out.println("1 - Remove any");
            System.out.println("2 - Find");
            System.out.println("3 - Insert");
            System.out.println("4 - Remove");
            System.out.println("5 - Move cursor");
            System.out.println("6 - Print warehouse");
            System.out.println("7 - Total value");
            System.out.println("8 - Test automatically each function");
            System.out.println("Q - Quit");
            input = keyboard_input.next();
            if (input.equalsIgnoreCase("1")) {
                this.removeAny();
            } else if (input.equals("2")) {
                this.find();
            } else if (input.equals("3")) {
                this.insert();
            } else if (input.equals("4")) {
                this.remove();
            } else if (input.equals("5")) {
                this.move_cursor();
            }else if(input.equals("6"))
            {
                System.out.println(this);
            }else if(input.equals("7"))
            {
                System.out.println(this.get_total_warehouse_value());
            }else if(input.equals("8"))
            {
                this.automatic_test();
            }
        }
    }


    //Start of main :
    public static void main(String[] args){

        //ALDictionary<String, Inventory> array_test = new ALDictionary<>(100);
        //WarehouseManager inventory_records_container = new WarehouseManager(array_test);

        //DLDictionary<String,Inventory> dl_test = new DLDictionary<>(100);
        //WarehouseManager inventory_records_container = new WarehouseManager(dl_test);

        LLDictionary<String, Inventory> ll_test = new LLDictionary<>(100);
        WarehouseManager inventory_records_container = new WarehouseManager(ll_test);

        //Reading from a database text file included in the project named "warehouse_data"
        try {
            BufferedReader buff_reader = new BufferedReader(new FileReader("src/warehouse_data"));
            String line;
            while ((line = buff_reader.readLine()) != null) {
//                testing_dictionary.insert(key, info);
                String[] words = line.split("\\s+");
                Inventory record = new Inventory(words);
                inventory_records_container.insert(record.getKey(), record);
            }
        } catch (IOException e) {
            System.out.println("could not read file");
        }

        System.out.println("At this point the database has been initialized with the corresponding .txt file");

        //Entering menu :
        inventory_records_container.start_menu();
    }
}
