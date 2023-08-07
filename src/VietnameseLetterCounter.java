import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VietnameseLetterCounter {

    private static Map<Character, String> vietnameseToLatinMap = new HashMap<>();

    static {
        vietnameseToLatinMap.put('ă', "aw");
        vietnameseToLatinMap.put('â', "aa");
        vietnameseToLatinMap.put('đ', "dd");
        vietnameseToLatinMap.put('ê', "ee");
        vietnameseToLatinMap.put('ô', "oo");
        vietnameseToLatinMap.put('ơ', "ow");
        vietnameseToLatinMap.put('ư', "w");
    }

    public static int countVietnameseLetters(String input) {
        int count = 0;
        int len = input.length();

        for (int i = 0; i < len; i+=2) {
            for (int j = i + 1; j <= len; j++) {
                String sub = input.substring(i, j);
                if (vietnameseToLatinMap.containsValue(sub)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi chữ cái latin: ");
        String input = scanner.nextLine();

        int result = countVietnameseLetters(input);
        System.out.println("Số lượng chữ cái Tiếng Việt có thể tạo thành trong chuỗi là: " + result);
    }
}
