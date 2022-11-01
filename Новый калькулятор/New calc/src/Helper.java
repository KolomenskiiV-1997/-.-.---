public final class Helper {
    private Helper() {
    }

    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        } else {
            char[] chars = s.toCharArray();

            for(int i = 0; i < chars.length; ++i) {
                char c = chars[i];
                if (i != 0 && c == '-' || !Character.isDigit(c) && c != '-' || chars.length == 1 && c == '-') {
                    return false;
                }
            }

            return true;
        }
    }
}
