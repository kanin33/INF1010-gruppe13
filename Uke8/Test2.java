import java.util.*;
import java.io.*;
class Test2 {
    public static void main(String[] args) {
        try{
            //int i = 1/0;
            //
            //int[] intarray = {1};
            //int i = intarray[3];
            String s = "hei";
            File f = new File("fef");
            Scanner sc = new Scanner(f);
            //int i = Integer.parseInt(s);
            //char c = s.charAt(4);
            s = null;
            System.out.println(s.toString());
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        } catch (NumberFormatException e) {
            System.out.println("Hei is not a number");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Index 4 is out of bounds");
        } catch (NullPointerException e) {
            System.out.println("The string is null");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
