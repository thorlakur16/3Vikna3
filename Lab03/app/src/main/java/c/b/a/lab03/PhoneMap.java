package c.b.a.lab03;

        import java.util.HashMap;
        import java.util.Map;

public final class PhoneMap {
    private static Map<String, Person> peep;
    private static void init() {
        if (peep == null) {
            synchronized (PhoneMap.class) {
                if (peep == null) {
                    peep = new HashMap<>();
                    peep.put("Guðmundur Rassgat", new Person("1111111", "Guðmundur Rassgat", "Rasshola 3"));
                    peep.put("Valdimar Rassgat", new Person("2222222", "Valdimar Rassgat", "Gullhamrar 25"));
                    peep.put("Magnea Rassgat", new Person("3333333", "Magnea Rassgat", "Prebentown 9"));
                    peep.put("Veronika Rassgat", new Person("4444444", "Veronika Rassgat", "Moldhaugar 1"));
                    peep.put("Julius Rassgat", new Person("5555555", "Julius Rassgat", "Sunnuhvol"));
                    peep.put("Pálína Rassgat", new Person("8453214", "Pálína Rassgat", "Rasshola 3"));
                }
            }
        }
    }

    public static Iterable<Map.Entry<String, Person>> getAllPhones() {
        init();
        return peep.entrySet();
    }

    public Person getPerson(String key){ return peep.get(key); }

    public void addPerson(Person per){
        peep.put(per.name, per);
    }
}