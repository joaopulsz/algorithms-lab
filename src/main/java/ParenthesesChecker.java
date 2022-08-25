import java.util.*;

public class ParenthesesChecker {

    public boolean checkParentheses(String string) {

        //convert string to list
        List<String> stringToList = new ArrayList<>(Arrays.asList(string.split("")));

        //create new lists to organise the parentheses and separate them from the rest of the string
        Stack<String> openingBrackets = new Stack<>();
        Queue<String> closingBrackets = new LinkedList<>();

        //iterate through list in search of parentheses and add them to their respective list
        stringToList.forEach(character -> {
            if (character.equals("(") || character.equals("[") || character.equals("{") || character.equals("<")) {
                openingBrackets.push(character);
            } else if (character.equals(")") || character.equals("]") || character.equals("}") || character.equals(">")) {
                closingBrackets.add(character);
            }
        });

        //in case they have equal number of items, check if openings match closings
        if (openingBrackets.size() == closingBrackets.size()) {
            for (int i = 0; i < openingBrackets.size(); i++) {
                if (openingBrackets.peek().equals(ParenthesesChecker.mirrorClosingBrackets(closingBrackets.peek()))) {
                    openingBrackets.pop();
                    closingBrackets.poll();
                } else return false;
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
