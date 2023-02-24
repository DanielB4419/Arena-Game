import java.util.Scanner;

public class Formatting
{

    static Scanner leeScan = new Scanner(System.in);

    //Separates print lines.
    public static void printSeparator(int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }
    //Print a title separated by ----
    public static void printHeading(String title)
    {
        System.out.println();
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    //Enter to continue.
    public static void typeToContinue()
    {
        System.out.println("Press enter to continue.");
        leeScan.nextLine();
    }
    //Clears the console.Kinda not really
    public static void clearScreen()
    {
        for (int i = 0; i <= 40; i++)
        {
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void printMenu()
    {
        //Formatting.printHeading("Round: " + Fight.round);
        System.out.println("Choose an action: ");
        System.out.println("(1) Continue on your journey.");
        System.out.println("(2) Display character information.");
        System.out.println("(3) Exit Game.");
    }
    public static int inFightOptions()
    {
        Formatting.printSeparator(30);
        System.out.println("Choose an action: ");
        Formatting.printSeparator(30);
        System.out.println("(1) Fight!");
        System.out.println("(2) Use a potion.");
        System.out.println("(3) Try to run away (35% chance)");
        int option = leeScan.nextInt();
        return option;
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED     = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW  = "\u001B[33m";
    public static final String ANSI_BLUE  = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /*
    BLACK	\u001B[30m	BLACK_BACKGROUND	\u001B[40m
    RED	    \u001B[31m	RED_BACKGROUND	\u001B[41m
    GREEN	\u001B[32m	GREEN_BACKGROUND	\u001B[42m
    YELLOW	\u001B[33m	YELLOW_BACKGROUND	\u001B[43m
    BLUE	\u001B[34m	BLUE_BACKGROUND	\u001B[44m
    PURPLE	\u001B[35m	PURPLE_BACKGROUND	\u001B[45m
    CYAN	\u001B[36m	CYAN_BACKGROUND	\u001B[46m
    WHITE	\u001B[37m	WHITE_BACKGROUND	\u001B[47m*/
}
