import java.io.IOException;

public class Calculator {
    private final StringBuilder s;
    private final String[] data = new String[]{"", "", ""};

    Calculator(StringBuilder s) {
        this.s = s;
    }

    private void pars() throws IOException {
        int dIndex = 0;

        for(int i = 0; i < this.s.length(); ++i) {
            char l = Character.toUpperCase(this.s.charAt(i));
            if (!Character.isDigit(l) && l != 'I' && l != 'V' && l != 'X') {
                if (l != '+' && l != '-' && l != '*' && l != '/') {
                    throw new IOException("Некорректные данные " + l + " в позиций " + (i + 1));
                }

                ++dIndex;
                if (dIndex >= 2) {
                    throw new IOException("Некорректные данные в строке " + this.s);
                }

                this.data[dIndex] = String.valueOf(l);
                ++dIndex;
            } else {
                String[] var10000 = this.data;
                var10000[dIndex] = var10000[dIndex] + l;
            }
        }

    }

    public Integer calculate(String a, String b, String oper) {
        int na = Integer.parseInt(a);
        int nb = Integer.parseInt(b);
        switch (oper) {
            case "+":
                return na + nb;
            case "-":
                return na - nb;
            case "*":
                return na * nb;
            case "/":
                return na / nb;
            default:
                return null;
        }
    }

    public String[] getArr() throws IOException {
        this.pars();
        return this.data;
    }
}
