import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Fight

{
    static Scanner leeScan = new Scanner(System.in);
    static Hero player;
    public static boolean gameRunning;      //gameRunning loop
    public static int escapeChance = 35;    //escape chance %
    public static int round = 1;            //round tracker
    public static int act = 1;              //act tracker

    public Fight()
    {
        Attacks attacks = new Attacks();
        Formatting formatting = new Formatting();
        Story story = new Story(formatting);
    }

    public static void startGame()  //create player + name
    {
        System.out.println(Formatting.ANSI_BLUE + "Welcome to Arena.");
        System.out.println("Your battle begins....." + Formatting.ANSI_RESET);
        Formatting.printSeparator(30);
        Formatting.typeToContinue();
        Formatting.printSeparator(30);
        boolean nameSet = false;
        String name;
        do
        {
            System.out.println();
            System.out.println("What is your name: ");
            name = leeScan.nextLine();
            System.out.println();
            System.out.println("Your name is: " + name + ". Is this correct?");
            System.out.println("(1) = Yes");
            System.out.println("(2) = No, I want to change my name.");
            int input = leeScan.nextInt();
            if (input == 1)
            {
                nameSet = true;
            }
        } while (!nameSet);
        player = new Hero(name);
        Story.act1();
        gameRunning = true;
        runMainGameLoop();

    }

    public static void runMainGameLoop()    //start game loop
    {
        while (gameRunning)
        {
            Formatting.printMenu();
            int input = leeScan.nextInt();
            if (input == 1)
                continueJourney();
            else if (input == 2)
                player.displayCharInfo();
            else
                gameRunning = false;  //finishes the code/end the game.
        }
    }

    public static void continueJourney()    //check round + player.status reset
    {
        //check if round must be increased
        Fight.checkRound();
        //reset all status effects
        player.fullStatusReset();
        //check if game isn't in last round
        if (round == 5)
        {
            Fight.finalFight();
        } else
            encounterType();
    }

    public static void checkRound()     //change round depending on XP
    {
        if (player.getXP() >= 250 && act == 1)
        {
            act = 2;
            round = 1;
            player.level++;
            //add in power up for level 4
            Story.act2();
        } else if (player.getXP() >= 500 && act == 2)
        {
            act = 3;
            round = 1;
            player.level++; //level 5
            Story.act3();
        } else if (player.getXP() >= 750 && act == 3)
        {
            act = 4;
            round = 1;
            player.level++;
            //add in power up for level 6
            Story.act4();
        } else if (player.getXP() >= 1000 && act == 4)
        {
            act = 5;
            round = 1;
            player.level++; //level 7
        }
    }

    public static void encounterType()  //randomise encounter type
    {
        Random rnd = new Random();
        int rndEncounter = rnd.nextInt(6) + 1;
        switch (rndEncounter)
        {
            case 1, 2:
                Formatting.printHeading("Easy difficulty fight");
                battle(pickEnemyTier());
                break;
            case 3, 4:
                Formatting.printHeading("Medium difficulty fight");
                battle(pickEnemyTier());
                break;
            case 5:
                Formatting.printHeading("Hard difficulty fight");
                battle(pickEnemyTier());
                break;
            case 6:
                Formatting.printHeading("Shop.");
                System.out.println("Implement shop.");
                break;
        }
    }

    public static void finalFight()     //act 5 dragon fight
    {
        Story.act5();
        System.out.println("You have been restored to full health for this challenging fight.");
        player.restoreToMaxHealth();
        //shop();

        //make other fighters to help...?
    }

    public static int pickEnemyTier()
    {
        //pick a random tier to choose enemies from.
        Random rnd = new Random();
        int pickedEnemyTier = 1; //rnd.nextInt(1, (int) Math.round(player.challengeRating));
        return pickedEnemyTier;
    }

    public static Character createEnemy(int fightTier)    //create and return rnd enemy
    {
        if (fightTier == 1)
        {
            //Create array and add all monsters for that tier too it.
            ArrayList<Character> monsterTierArray = new ArrayList<>();
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            Random rnd = new Random();
            int rndEnemy = rnd.nextInt(monsterTierArray.size() - 1);
            Character enemy = monsterTierArray.get(rndEnemy);
            return enemy;
        }
        if (fightTier >= 2)
        {
            //Create array and add all monsters for that tier too it.
            ArrayList<Character> monsterTierArray = new ArrayList<>();
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            monsterTierArray.add(new OrcTest("Steven"));
            Random rnd = new Random();
            int rndEnemy = rnd.nextInt(monsterTierArray.size() - 1);
            Character enemy = monsterTierArray.get(rndEnemy);
            return enemy;


        }
        return null;
    }

    public static void battle(int fightTier)     //fight loop
    {
        /*
        Need to start a loop
        Have the player attack first always - firstly.
        Have the player fight enemy 1 then at the end of turn
        enemy 2 attacks player
        This continues until enemy 1 is dead
        Player then attacks enemy 2

        Then implement turn order.
         */
        ArrayList<Character> monsterArray = new ArrayList<>();
        double fightChallengeRating = 0;
        do
        {
            Character enemy = createEnemy(fightTier);
            monsterArray.add(enemy);
            fightChallengeRating += enemy.challengeRating;
        } while (fightChallengeRating < player.challengeRating);


        //main fight loop. runs until all monsters are dead.
        do
        {
            //runs through the player attacking each monster in turn.
            for (int i = 0; i < monsterArray.size(); i++)
            {
                if (player.isAlive())
                {
                    //loop that runs every round
                    do
                    {
                        //player attackPrep.
                        player.pickAndPrepAttack(player);

                        //enemy attackPrep if alive.
                        for (int j = 0; j < monsterArray.size(); j++)
                        {
                            if (monsterArray.get(j).isAlive())
                            {
                                monsterArray.get(j).pickAndPrepAttack(monsterArray.get(j));
                            }
                        }

                        //player attacks first alive enemy and postAttack effects.
                        for (int k = 0; k < monsterArray.size(); k++)
                        {
                            if (monsterArray.get(k).isAlive())
                            {
                                player.attack(monsterArray.get(k), player, 1);
                                player.postAttackEffects(player, monsterArray.get(k), 1);
                                break;
                            }
                        }

                        //all alive enemies attack the player and then postAttack effect.
                        for (int l = 0; l < monsterArray.size(); l++)
                        {
                            if (player.isAlive() && monsterArray.get(l).isAlive())
                            {
                                monsterArray.get(l).attack(player, monsterArray.get(i), 1);
                                monsterArray.get(l).postAttackEffects(monsterArray.get(l), player, 1);
                            }
                            if (player.isDead())
                            {
                                player.displayDeathSpeech();
                                gameRunning = false;
                                break;
                            }
                        }

                        //show health for player and alive enemies.
                        player.showHealth();
                        for (int m = 0; m < monsterArray.size(); m++)
                        {
                            if (monsterArray.get(m).isAlive())
                            {
                                monsterArray.get(m).showHealth();
                            }
                        }
                    } while (player.isAlive() && monsterArray.get(i).isAlive());
                } else break;
            }
        } while (player.isAlive());

        //what happens at the end?


    }

    public static Boolean turnOrder(Character enemy)
    {
        //store getsToAttackFirst in an array?
        //use initiative as deciding factor if 2 get to attack first.
        //create a numerical turn order?
        //use the rnd.initiative numbers directly.
        //2-d array with Character and initiative?
        //Be careful of who hero attacks.
        if (player.getsToAttackFirst())
        {
            player.attackFirstReset();
            enemy.attackFirstReset();
            return true;
        } else if (enemy.getsToAttackFirst())
        {
            enemy.attackFirstReset();
            player.attackFirstReset();
            return false;
        } else if (player.initiativeCheck() >= enemy.initiativeCheck())
            return true;
        else
            return false;
    }

    public static void stopMainGame()
    {
        if (player.isDead())
        {
            gameRunning = false;
        }
    }


}