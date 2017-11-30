package c.b.a.lab03;

/**
 * Created by Laki on 28.11.2017.
 */

public class Person {
    String name;
    String address;
    String phone;
    public Person(String name, Integer phone, String address) {
        this.name = name;
        this.address = address;
        this.phone = Integer.toString(phone);
    }
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }
}
