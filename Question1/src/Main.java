import java.util.*;
//time O(mn) m is the maximum length of string n is length of arr
//space O(n)
public class Main {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        ArrayList<ArrayList<String>> res = groupAnagrams(arr);
        System.out.println(res);
    }

    private static ArrayList<ArrayList<String>> groupAnagrams(String[] arr){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String anagram = String.valueOf(chars);
            if(!map.containsKey(anagram)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(anagram, list);
            }else{
                ArrayList<String> list = map.get(anagram);
                list.add(str);
                map.put(anagram, list);
            }
        }

        for (ArrayList<String> list: map.values()) {
            res.add(list);
        }

        return res;

    }
}