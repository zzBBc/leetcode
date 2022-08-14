class Solution {
    public boolean rotateString(String s, String goal) {
        char[] chars = s.toCharArray();

        int charsLength = chars.length;
        for (int i = 0; i < charsLength; i++) {
            int numberShift = i + 1;
            String newString = String.valueOf(chars, numberShift, charsLength - numberShift)
                    + String.valueOf(chars, 0, numberShift);
            if (newString.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}
