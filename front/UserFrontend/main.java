import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String word = "Amazone";
        String a = word.toLowerCase();
        String b = word.toUpperCase();
        String c = b.substring(0, 1) + a.substring(1);
        System.out.println(a + b + c);
    }
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<Character, String>();
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
           Character key = pattern.charAt(i);
           if (map.containsKey(key)) {
            System.out.println(map.get(key));
            System.out.println(arr[i]);
            if (!map.get(key).equals(arr[i])) {
                return false;
            }
           } else if (map.containsValue(arr[i])) {
            return false;
           } else {
            map.put(pattern.charAt(i), arr[i]);
           }
           System.out.println(map);
        }
        return true;
    }
    public boolean detectCapitalUse(String word) {
        String a = word.toLowerCase();
        String b = word.toUpperCase();
        String c = a.replace(a.charAt(0), b.charAt(0));
        return (word.equals(a) || word.equals(b) || word.equals(c));
    }
}
