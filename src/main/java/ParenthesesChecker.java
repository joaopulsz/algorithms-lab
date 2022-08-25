import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParenthesesChecker {

    public boolean checkParentheses(String string) {

        //convert string to list
        List<String> stringToList = new ArrayList<>(Arrays.asList(string.split("")));

        //create new lists to organise the parentheses and separate them from the rest of the string
        List<String> openingBrackets = new ArrayList<>();
        List<String> closingBrackets = new ArrayList<>();

        //iterate through list in search of parentheses and add them to their own lists
        stringToList.forEach(character -> {
            if (character.equals("(") || character.equals("[") || character.equals("{") || character.equals("<")) {
                openingBrackets.add(character);
            } else if (character.equals(")") || character.equals("]") || character.equals("}") || character.equals(">")) {
                closingBrackets.add(character);
            }
        });

        if (closingBrackets.size() > 0) {
            Collections.reverse(closingBrackets);
        }

        //in case they have equal number of items, check if openings match closings
        if (openingBrackets.size() == closingBrackets.size()) {
            for (int i = 0; i < openingBrackets.size(); i++) {
                if (!openingBrackets.get(i).equals(ParenthesesChecker.mirrorClosingBrackets(closingBrackets.get(i)))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private static String mirrorClosingBrackets(String bracket) {
        switch (bracket) {
            case ")": return "(";
            case "]": return "[";
            case "}": return "{";
            case ">": return "<";
        }
        return "";
    }
}
