import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomStringList {
    public String[] list;
    public CustomStringList(String[] array) {
        this.list = array;
    }
    public boolean check(String str) {
        for (String el : list) {
            if (el.equals(str)) {
                return true;
            }
        }
        return false;
    }
    public boolean check(String[] strArray) {
        for (String str : strArray) {
            boolean found = false;
            for (int j = 0; j < list.length; j++) {
                if (str.equals(list[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
    public String longestWord() {
        String longest = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() > longest.length()) {
                longest = list[i];
            }
        }
        return longest;
    }
    public void add(String str) {
        String[] newList = new String[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[list.length] = str;
        this.list = newList;
    }
    public void addIfNotExists(String str) {
        boolean found = false;
        for (String el : list) {
            if (el.equals(str)) {
                found = true;
                break;
            }
        }
        if (!found) {
            String[] newList = new String[list.length + 1];
            System.arraycopy(list, 0, newList, 0, list.length);
            newList[list.length] = str;
            this.list = newList;
        } else {
            System.out.println("String " + str + " already exist");
        }
    }
    public static void main(String[] args) {
        String[] list =  {"hello", "word", "birthday"};
        String[] strArray = {"hello", "word", "birthday"};
        CustomStringList customList = new CustomStringList(list);

        System.out.println(customList.check("hello"));
        System.out.println(customList.check("name"));
        System.out.println(customList.longestWord());
        System.out.println(customList.check(strArray));
        customList.add("Hello");
        System.out.println(Arrays.toString(customList.list));
        customList.addIfNotExists("word");
        System.out.println(Arrays.toString(customList.list));
    }
}
