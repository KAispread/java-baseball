package baseball.domain.input;

import baseball.controller.GameFlag;
import baseball.controller.Rule;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ConsoleInputReader {
    public static List<Integer> getUserNumberList() {
        String userInputNumber = Console.readLine();
        return convertToIntegerList(userInputNumber);
    }

    public static GameFlag getUserOpinion() {
        return GameFlag.START;
    }

    public static List<Integer> convertToIntegerList(final String numberString) {
        validateLength(numberString);
        validateString(numberString);

        List<Integer> integerList = new ArrayList<>();
        char[] numberChars = numberString.toCharArray();
        for (char numberChar : numberChars) {
            integerList.add(convertCharToInteger(numberChar));
        }
        return integerList;
    }

    public static Integer convertCharToInteger(final char numberChar) {
        return numberChar - '0';
    }

    public static void validateLength(final String userInputNumber) {
        if (userInputNumber.length() != Rule.LENGTH.getValue()) {
            throw new IllegalArgumentException("This string's length must be 3");
        }
    }

    public static void validateString(final String userInputNumber) {
        if (!Pattern.matches("^[1-9]*$", userInputNumber)) {
            throw new IllegalArgumentException("This string can only contains number");
        }
    }

}
