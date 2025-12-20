package interview.asked;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ImmutableClass {

    private final int num;
    private final String str;
    private final HashMap<Integer, String> map;

    public ImmutableClass(int num, String str, Map<Integer, String> _map) {
        this.num = num;
        this.str = str;
        //
        HashMap<Integer, String> map = new HashMap<>();
        Integer key;
        Iterator<Integer> it = _map.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            map.put(key, map.get(key));
        }
        this.map = map;
    }

    public int getNum() {
        return num;
    }

    public String getStr() {
        return str;
    }

    public Map<Integer, String> getMap() {
        return (Map<Integer, String>) map.clone();
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "num=" + num +
                ", str='" + str + '\'' +
                ", map=" + map +
                '}';
    }

    public static void main(String[] args) {
        int num = 10;
        String str = "manish";
        Map<Integer, String> _map = new HashMap<>();
        _map.put(1, "A");
        _map.put(2, "B");
        _map.put(3, "C");

        ImmutableClass obj = new ImmutableClass(num, str, _map);
        // Printing initial fields of ImmutableClass obj
        System.out.println("Initial values : " + obj.toString());
        // change the local variable values
        num = 20;
        str = "nishant";
        _map.put(4, "D");
        _map.put(5, "E");

        System.out.println("Printing fields of ImmutableClass obj after update");
        System.out.println("Values after update : " + obj.toString());

        Map<Integer, String> map = obj.getMap();
        map.put(6, "F");
        System.out.println("after changing variable from getter methods:" + obj.getMap());
    }
}
