import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;
class Iteration {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(java.util.Arrays.asList("Red", "Blue", "Red", "Yellow", "Yellow"));
        System.out.print("\n");
        for (int i = 0; i < list.size(); i += 1) {
            System.out.println(list.get(i));
        }
        System.out.print("\n");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.print("\n");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.print("\n");
        HashSet<String> set = new HashSet<>(list);
        System.out.printf("Number of elements in set: %d\n", set.size());
        System.out.print("Set: " + set);
        System.out.print("\n");
    }
}
