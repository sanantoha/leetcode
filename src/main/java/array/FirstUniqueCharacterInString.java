package array;

public class FirstUniqueCharacterInString {

    public static int firstUniqChar(String s) {
        return -1;
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2018/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); //0

        System.out.println(firstUniqChar("loveleetcode")); //2

        System.out.println(firstUniqChar("aabb")); // -1
    }
}
