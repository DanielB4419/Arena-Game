public class Story
{

    Formatting formatting;


    public Story(Formatting formattingStuff)
    {
        formatting = formattingStuff;

    }
    public static void act1()
    {
        Formatting.printHeading("Act 1. This is not the shire.");
        System.out.println("You are in the jungle which is alive with enemies.");
        Formatting.typeToContinue();
        Formatting.printSeparator(30);
    }
    public static void act2()
    {
        Formatting.printHeading("Act 2. Time to give up.");
        System.out.println("You are in the desert which is alive with more enemies.");
        Formatting.typeToContinue();
    }
    public static void act3()
    {
        Formatting.printHeading("Act 3. Forget you ever started this journey.");
        System.out.println("You are in the mountains which is alive with more and more enemies.");

        Formatting.typeToContinue();
    }
    public static void act4()
    {
        Formatting.printHeading("Act 4. It's not too late to go home.");
        System.out.println("You are in the goblin city which is alive with so many enemies.");
        Formatting.typeToContinue();
    }
    public static void act5()
    {
        Formatting.printHeading("Act 5. Dragon's Lair!");
        System.out.println("Congratulations - you have reached the Dragon's lair. Prepare to die!");
        Formatting.typeToContinue();
    }

}
