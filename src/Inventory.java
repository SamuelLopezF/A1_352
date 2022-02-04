import javax.lang.model.element.Element;

import java.security.Key;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Inventory {
    /** Data Members */
    String inventory_id;
    String name;
    String description;
    String unit_price;
    String quantity;
    String inventory_value;
    String reorder_level;
    String reorder_time_in_days;
    String reorder_quantity;
    String discontinued;

    Inventory(String[] words)
    {
        setInventory_id(words[0]);
        setName(words[1]);
        setDescription(words[2]);
        setUnit_price(words[3]);
        setQuantity(words[4]);
        setInventory_value(words[5]);
        setReorder_level(words[6]);
        setReorder_time_in_days(words[7]);
        setReorder_quantity(words[8]);
        if (words.length == 10) {
            setDiscontinued("yes");
        } else {
            setDiscontinued("no");
        }

    }

    public String getKey()
    {
        return getInventory_id();
    }


    public AList<String> getValues()
    {
        AList<String> values = new AList<>(10);
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

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getInventory_value() {
        return inventory_value;
    }

    public void setInventory_value(String inventory_value) {
        this.inventory_value = inventory_value;
    }

    public String getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(String reorder_level) {
        this.reorder_level = reorder_level;
    }

    public String getReorder_time_in_days() {
        return reorder_time_in_days;
    }

    public void setReorder_time_in_days(String reorder_time_in_days) {
        this.reorder_time_in_days = reorder_time_in_days;
    }

    public String getReorder_quantity() {
        return reorder_quantity;
    }

    public void setReorder_quantity(String reorder_quantity) {
        this.reorder_quantity = reorder_quantity;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

}
