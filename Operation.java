package Zero;

public class Operation {

    private static String oper;

    public void SetValue(String str) throws Exception {
        try {
            switch (str){
                case "+":
                    oper = "+";
                    break;
                case "-":
                    oper = "-";
                    break;
                case "*":
                    oper = "*";
                    break;
                case "/":
                    oper = "/";

                    break;
                default: throw new Exception("incorrect symbol");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
    public String GetValue(){
        return oper;
    }
    public static int sum(int x, int y){
        int result;
        return result=x+y;

    };
    public static int difference(int x, int y){
        int result;
        return result=x-y;
    };
    public static int multiplication(int x, int y){
        int result;
        return result=x*y;
    };
    public static int division(int x, int y) {
        int result;
        return result=x/y;
    };

}