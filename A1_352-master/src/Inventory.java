import javax.lang.model.element.Element;

import java.security.Key;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Inventory {
    /** Data Members */
    String inventory_id;
    String name;
    String description;
    float unit_price;
    int quantity;
    float inventory_value;
    int reorder_level;
    int reorder_time_in_days;
    int reorder_quantity;
    boolean discontinued;

    Inventory(String[] words)
    {
        setInventory_id(words[0]);
        setName(words[1]);
        setDescription(words[2]);
        setUnit_price(parseFloat(words[3]));
        setQuantity(parseInt(words[4]));
        setInventory_value(parseFloat(words[5]));
        setReorder_level(parseInt(words[6]));
        setReorder_time_in_days(parseInt(words[7]));
        setReorder_quantity(parseInt(words[8]));
        if(words.length == 10)
        {
            setDiscontinued(words[9]);
        }else{
            setDiscontinued("false");
        }
    }

    public String getKey()
    {
        return getInventory_id();
    }


    public AList<Element> getValues()
    {
        AList values = new AList(10);
        values.insert(getName());
        values.insert(getDescription());
        values.insert(getUnit_price());
        values.insert(getQuantity());
        values.insert(getInventory_value());
        values.insert(getReorder_level());
        values.insert(getReorder_time_in_days());
        values.insert(getReorder_quantity());
        return values;
    }
    public int getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(int reorder_level) {
        this.reorder_level = reorder_level;
    }

    public int getReorder_time_in_days() {
        return reorder_time_in_days;
    }

    public void setReorder_time_in_days(int reorder_time_in_days) {
        this.reorder_time_in_days = reorder_time_in_days;
    }


    public String getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getInventory_value() {
        return inventory_value;
    }

    public void setInventory_value(float inventory_value) {
        this.inventory_value = inventory_value;
    }



    public int getReorder_quantity() {
        return reorder_quantity;
    }

    public void setReorder_quantity(int reorder_quantity) {
        this.reorder_quantity = reorder_quantity;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        if(discontinued.equalsIgnoreCase("yes"))
        {
            this.discontinued = true;
        }else{
            this.discontinued = false;
        }
    }



}
