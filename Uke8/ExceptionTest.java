class ExceptionTest {
    public static void main(String[] args) {
        String s = "";
        try {
            int i;
            s = "hei";
            Lenkeliste<String> l = new Lenkeliste<String>();
            System.out.println(l.forste.neste.verdi);

            //int i = 1/0;
            //int[] l = {1};
            //i = l[2];
            //i = Integer.parseInt(s);
            char c;
            c = s.charAt(5);
        } catch(ArithmeticException e) {
            System.out.println("Division by zero catched");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch(NumberFormatException e) {
            System.out.printf("Cannot format string \"%s\" to integer\n", s);
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("CharAt cannot give character at given index");
        } catch(NullPointerException e) {
            System.out.println("Program is broken :(");
        }
    }
}
