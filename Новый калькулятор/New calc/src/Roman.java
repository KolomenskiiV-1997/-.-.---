import java.io.IOException;
import java.util.TreeMap;

public class Roman {
    private final TreeMap<Integer, String> romanMap = new TreeMap();

    public Roman() {
        this.romanMap.put(100, "C");
        this.romanMap.put(90, "XC");
        this.romanMap.put(50, "L");
        this.romanMap.put(40, "XL");
        this.romanMap.put(10, "X");
        this.romanMap.put(9, "IX");
        this.romanMap.put(5, "V");
        this.romanMap.put(4, "IV");
        this.romanMap.put(1, "I");
    }

    public String arabicToRoman(int number) {
        if (number == 0) {
            return "0";
        } else {
            int l = (Integer)this.romanMap.floorKey(number);
            if (number == l) {
                return (String)this.romanMap.get(number);
            } else {
                String var10000 = (String)this.romanMap.get(l);
                return var10000 + this.arabicToRoman(number - l);
            }
        }
    }

    public int romanToArabic(String strRoman) throws IOException {
        int dec = 0;
        int lastNum = 0;

        for(int c = strRoman.length() - 1; c >= 0; --c) {
            switch (strRoman.charAt(c)) {
                case 'C':
                case 'c':
                    dec = lastNum > 100 ? dec - 100 : dec + 100;
                    lastNum = 100;
                    break;
                case 'I':
                case 'i':
                    dec = lastNum > 1 ? dec - 1 : dec + 1;
                    lastNum = 1;
                    break;
                case 'L':
                case 'l':
                    dec = lastNum > 50 ? dec - 50 : dec + 50;
                    lastNum = 50;
                    break;
                case 'V':
                case 'v':
                    dec = lastNum > 5 ? dec - 5 : dec + 5;
                    lastNum = 5;
                    break;
                case 'X':
                case 'x':
                    dec = lastNum > 10 ? dec - 10 : dec + 10;
                    lastNum = 10;
                    break;
                default:
                    throw new IOException("Некорректные данные в выражении " + strRoman);
            }
        }

        return dec;
    }
}
