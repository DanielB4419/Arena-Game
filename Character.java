import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public abstract class Character
{
    public static int characterCount;
    protected String name;
    protected String skill;
    protected String race;
    protected int level;
    protected double challengeRating;
    protected int health, strength, dodge, initiative,
            calcInitiative, xpToGive,armour,constitution;
    protected int blockChance;
    protected boolean stunned;
    protected boolean dodgeAttack;
    protected boolean blockAttack;
    protected boolean isPoisoned;
    protected int poisonCounter;
    protected int poisonAmount;
    protected boolean attackFirst;

    //Abstract methods
    public abstract boolean attack(Character enemy, Character user, int attackPicked);
    public abstract void displayVictorySpeech();
    public abstract void displayDeathSpeech();
    public abstract boolean preFightStatusCheck();
    public abstract int pickAndPrepAttack(Character user);
    public abstract void postAttackEffects(Character user, Character enemy, int attackPicked);
    public abstract void entranceSpeech();

    public Character()  //default constructor
    {
        //default status conditions
        this.level = 1;         //global level
        this.stunned = false;
        this.dodgeAttack = false;
        this.blockAttack = false;
        this.isPoisoned = false;
        this.poisonCounter = 0;
        this.poisonAmount = 0;
        this.attackFirst = false;
        this.blockChance = 10;  //global block chance
    }

    public int initiativeCheck()    //D20 + initiative.
    {
        Random rnd = new Random();
        int rndInitiative = rnd.nextInt(20)+1;
        int thatRoundInitiative = rndInitiative + initiative;
        return thatRoundInitiative;
    }
    public void displayInfo()
    {
        System.out.printf(Formatting.ANSI_BLUE + "Name: %s the %s %-20s%nHealth: %5d   " +
                        "Attack: %3d   Constitution: %3d.%n" + Formatting.ANSI_RESET
                ,name,race,skill,health,strength,constitution);
        Formatting.printSeparator(30);
    }
    public void showHealth()
    {
        if (health <= 0)
        {
            health = 0;
            System.out.printf(Formatting.ANSI_GREEN + "%-15s [%4d] health.%n"
                    + Formatting.ANSI_RESET , this.name, this.health);
        }
        else
        {
            System.out.printf(Formatting.ANSI_GREEN + "%-15s [%4d] health.%n"
                    + Formatting.ANSI_RESET , this.name, this.health);
        }
    }
    public int getHealth()
    {
        return health;
    }
    public boolean isDead()
    {
        if (this.health <= 0)
        {
            return true;
        } else
        {
            return false;
        }
    }
    public boolean isAlive()
    {
        if (this.health > 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public void receiveDamage(String userName, int damage, Character enemy)
    {
        this.health -= damage;
        System.out.printf("%s takes %d damage from %s.%n", enemy.name , damage, userName);
        if (this.health <= 0)
        {
            this.health = 0;
        }
    }

    public boolean didYouDodge()
    {
        Random rnd = new Random();
        int rndDodge = rnd.nextInt(100) +1;
        if (rndDodge < dodge || dodgeAttack)
        {
            System.out.printf("%s dodged the attack.%n", this.name);
            return true;        //You did dodge.
        }
        else
        {
            return false;       //You did not dodge.
        }
    }
    public boolean didYouBlock()
    {
        Random rnd = new Random();
        int rndBlock = rnd.nextInt(100)+1;
        if (rndBlock < blockChance || blockAttack)
        {
            System.out.printf("%s blocked the attack.%n", this.name);
            return true;        //You did block.
        }
        else
        {
            return false;       //You did not block.
        }
    }
    public boolean isStunned()
    {
        return stunned;
    }
    public boolean isBlocking()
    {
        return blockAttack;
    }
    public void isPoisoned(Character enemy, int poisonDamage)
    {
        System.out.printf("%s is poisoned. ", enemy.name);
        poisonAmount = poisonDamage;
        isPoisoned = true;
    }
    public boolean checkIfPoisoned()
    {
        return isPoisoned;
    }
    public void getStunned()
    {
        stunned = true;
    }
    public void setToDodge()
    {
        dodgeAttack = true;
    }
    public void setToBlock()
    {
        blockAttack = true;
    }

    public void fullStatusReset()
    {
        poisonReset();
        dodgeReset();
        blockReset();
        stunReset();
        initiativeReset();
    }
    public void poisonReset()
    {
        poisonCounter = 0;
        isPoisoned = false;
    }
    public void dodgeReset()
    {
        dodgeAttack = false;
    }
    public void blockReset()
    {
        blockAttack = false;
    }
    public void stunReset()
    {
        stunned = false;
    }
    public void initiativeReset()
    {
        this.initiative = calcInitiative;
    }
    public void showPic(String filename)
    {
        try
        {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
            System.out.println();

        } catch (FileNotFoundException e)
        {
            System.out.println("********* An error occurred.*********");
            e.printStackTrace();
        }
    }
    public void attackFirstReset()
    {
        attackFirst = false;
    }
    public void setAttackFirst()
    {
        attackFirst = true;
    }
    public boolean getsToAttackFirst()
    {
        return attackFirst;
    }
}
