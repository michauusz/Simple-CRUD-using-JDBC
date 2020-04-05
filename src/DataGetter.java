import java.util.Scanner;

public class DataGetter {
    private static Scanner read = new Scanner(System.in);
    public static int getInt(){
        int value = read.nextInt();
        read.nextLine();
        return value;
    }
    public static String getString(){
        String text = read.nextLine();
        return text;
    }

}
