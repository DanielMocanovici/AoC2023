import java.io.File;
import java.util.Scanner;
import java.lang.Character;
import java.util.HashMap;
import java.util.Map;

class Day1 {
    public int lineNumberOne(String line) {
        int start = 0;
        int end = line.length() - 1;
        String sum = "";

        while (start <= end) {
            if (Character.isDigit(line.charAt(start))) {
                sum = sum + line.charAt(start);
                break; 
            }
            start++;
        }
        
        while (end >= 0) {
            if (Character.isDigit(line.charAt(end))) {
                sum = sum + line.charAt(end); 
                break;
            }
            end--;
        }

        return Integer.parseInt(sum);
    }

    public int lineNumberTwo(String line, HashMap<String, String> digitMap) {

        int start = 0;
        int end = line.length() - 1;
        String sum = "";

        while (start <= end) {
            if (Character.isDigit(line.charAt(start))) {
                sum = sum + line.charAt(start);
                break; 
            } else if (start <= end - 2 && digitMap.containsKey(line.substring(start, start+3))) {
                sum = sum + digitMap.get(line.substring(start, start+3));
                break;
            } else if (start <= end - 3 && digitMap.containsKey(line.substring(start, start+4))) {
                sum = sum + digitMap.get(line.substring(start, start+4));
                break;
            } else if (start <= end - 4 && digitMap.containsKey(line.substring(start, start+5))) {
                sum = sum + digitMap.get(line.substring(start, start+5));
                break;
            }
            start++;
        }

        while (0 <= end) {
            if (Character.isDigit(line.charAt(end))) {
                sum = sum + line.charAt(end);
                break; 
            } else if (end >= 2 && digitMap.containsKey(line.substring(end - 2, end+1))) {
                sum = sum + digitMap.get(line.substring(end-2, end+1));
                break;
            } else if (end >= 3 && digitMap.containsKey(line.substring(end - 3, end+1))) {
                sum = sum + digitMap.get(line.substring(end-3, end+1));
                break;
            } else if (4 <= end && digitMap.containsKey(line.substring(end-4, end+1))) {
                sum = sum + digitMap.get(line.substring(end-4, end+1));
                break;
            }    
            end--;
        }

        return Integer.parseInt(sum);
    }

    public static void main(String[] args) { 
        File file = new File("C:\\Users\\User\\Desktop\\MyGit\\AdventCodeCalendar\\Day1\\Day1.txt");
        HashMap<String, String> digitalMap = new HashMap<>();
        digitalMap.put("one", "1");
        digitalMap.put("two", "2");
        digitalMap.put("three", "3");
        digitalMap.put("four", "4");
        digitalMap.put("five", "5");
        digitalMap.put("six", "6");
        digitalMap.put("seven", "7");
        digitalMap.put("eight", "8");
        digitalMap.put("nine", "9");
        try {
            Day1 newInstance = new Day1();
            int sum = 0;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sum = sum + newInstance.lineNumberTwo(sc.nextLine(), digitalMap);
            }
            sc.close();
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }   
}