/*
CSE 17
Sam Sausville
sps222
Program Description: Create a data structure similar to a hashtable that instead uses links and nodes
Program #6
 */

public class Prog6 {

    public static void main(String[] args){
        Bashtable<Integer> t = new Bashtable<>();
        t.put("YA", 1);
        t.put("Y", 2);
        t.remove("YA");
        System.out.println(t.get("YAS"));
        System.out.println(t.get("Y"));
       t.put("LEHIGH", 20);
        t.put("LEMON", 50);
        t.put("YEETS", 101);
        t.put("YEET", 8);
        t.put("LEEDS", 100);
        System.out.println( t.get("LEHIGH"));
        System.out.println(t.get("LEMON"));
        System.out.println(t.get("LEEDS"));
        t.remove("LEEDS");
        System.out.println(t.get("LEEDS"));

        Bashtable<String> s = new Bashtable<>();
        s.put("YEET", "YODLE");
        System.out.println(s.get("YEET"));
        Bashtable<Object> p = new Bashtable<>();
        p.put("HI", null);
        System.out.println(p.get("HI"));

    }
}
