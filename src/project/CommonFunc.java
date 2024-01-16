package project;

public class CommonFunc {
    public boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
