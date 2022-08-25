import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParenthesesChecker {

    public boolean checkParentheses(String string) {

        //convert string to list
        List<String> stringToList = new ArrayList<>(Arrays.asList(string.split("")));

        //create new lists to organise the parentheses and separate them from the rest of the string
        List<String> openingParentheses = new ArrayList<>();
        List<String> closingParentheses = new ArrayList<>();

        //iterate through list in search of parentheses and add them to separate list
        stringToList.forEach(character -> {
            if (character.equals("(") || character.equals("[") || character.equals("{") || character.equals("<")) {
                openingParentheses.add(character);
            }
        });

        return false;
    }
}
