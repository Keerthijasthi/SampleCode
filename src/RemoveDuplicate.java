import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String[] names = {"John", "Jane", "Jack", "Jill", "Bob", "John", "Random"};
//        Hashset to delete the duplicates
        Set<String> nameSet = new HashSet<>();
        Collections.addAll(nameSet, names);

        // Display original names
        System.out.println("\n--- All original items ---");
        System.out.println(Arrays.toString(names));

        System.out.println("\n--- Items after removing duplicates ---");
        System.out.println(nameSet);
        //using  collection.sort(),Shuffle() and reverse()
        List<String> nameList = new ArrayList<>();
        Collections.addAll(nameList, names);
        Collections.sort(nameList);

        System.out.println("\n--- Items after sorting items ---");
        System.out.println(nameList);

        Collections.reverse(nameList);
        System.out.println(nameList);

        Collections.shuffle(nameList);
        System.out.println(nameList);
        //Auto sort names automatically (treeset)
        TreeSet<String> nameTreeSet = new TreeSet<>(nameList);
        System.out.println("nameTreeSet: " + nameTreeSet);

    }
}
