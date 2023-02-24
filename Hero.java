import java.util.Random;

public class Hero extends Character
{
    //unique attributes to HERO
    private int potions;
    private int maxHealth;
    private int xpToGet;

    public Hero(String name)
    {
        super();
        this.name = name;
        this.race = "Mountain Dwarf";
        this.skill = "Battle-Master";

        //stats
        this.strength = 17;
        this.constitution = 17;
        this.initiative = 10;
        this.dodge = 10;
        this.armour = 20;
        this.level = 3;
        this.challengeRating = level - 2;//+equipment
        this.xpToGet = 0;
        //calculated attributes
        this.calcInitiative = initiative;
        this.health = (100 + this.constitution) + ((6 + this.constitution) * (this.level - 1));
        this.maxHealth = health;
        //unique to hero
        this.potions = 1;

    }

    @Override
    public boolean preFightStatusCheck()
    {
        if (checkIfPoisoned())
        {
            poisonCounter++;
            if (poisonCounter <= 3)
            {
                this.health -= poisonAmount;
                System.out.printf("%s takes %d poison damage.%n", this.name, poisonAmount);
            } else
            {
                poisonReset();
            }
        }
        if (isStunned())
        {
            System.out.printf("%s is stunned and cannot attack.%n", this.name);
            stunReset();            //Hero stunned status reset.
            return false;
        } else
            return true;
    }

    @Override
    public int pickAndPrepAttack(Character user)
    {
        if (preFightStatusCheck())
        {
            Random rnd = new Random();
            int whichAttack = rnd.nextInt(6) +1;
            return switch (whichAttack)
                    {
                        case 1, 2, 3:
                            Attacks.spearAttackPreFight();
                            yield whichAttack;
                        case 4, 5:
                            Attacks.shieldBashPreFight();
                            yield whichAttack;
                        case 6:
                            Attacks.doubleAttackPreFight();
                            yield whichAttack;
                        default:
                            yield 0;
                    };
        }
        return 0;
    }

    @Override
    public boolean attack(Character enemy, Character user, int attackPicked)
    {
        switch (attackPicked)
        {
            case 0:     //no attack
                return false;
            case 1, 2, 3:
                int damage1 = Attacks.spearAttack(user);
                if (!enemy.didYouDodge())
                {
                    if (!enemy.didYouBlock())
                    {
                        enemy.receiveDamage(this.name, damage1, enemy);
                        return true;
                    }
                    return false;
                }
                return false;
            case 4,5:
                int damage2 = Attacks.shieldBash(user);
                if (!enemy.didYouDodge())
                {
                    if (!enemy.didYouBlock())
                    {
                        enemy.receiveDamage(this.name, damage2, enemy);
                        return true;
                    }
                    return false;
                }
                return false;
            case 6:
                int damage3 = Attacks.doubleAttack(user);
                if (!enemy.didYouDodge())
                {
                    if (!enemy.didYouBlock())
                    {
                        enemy.receiveDamage(this.name, damage3, enemy);
                        return true;

                    }
                    return false;
                }
                return false;
            default:
                System.out.println("*** DEFAULT ERROR attack ***");
                return false;
        }
    }
    @Override
    public void postAttackEffects(Character user, Character enemy, int attackPicked)
    {
        enemy.dodgeReset();
        enemy.blockReset();
        switch (attackPicked)
        {
            case 0:
                break;
            case 1, 2, 3:
                Attacks.spearAttackPostFight(user, enemy);
                break;
            case 4,5:
                Attacks.shieldBashPostFight(user, enemy);
                break;
            case 6:
                Attacks.doubleAttackPostFight(user, enemy);
                break;
            default:
                System.out.println("*** DEFAULT ERROR post attack ***");
        }
    }

    public void postRoundEffects()
    {

    }

    @Override
    public void displayVictorySpeech()
    {
        System.out.printf("%s wins and shouts: Die you fool! %n", this.name);
    }

    @Override
    public void displayDeathSpeech()
    {
        Formatting.printSeparator(30);
        System.out.printf("With %s's last breath: Hero pain! %n", this.name);
    }

    @Override
    public void entranceSpeech()
    {
        System.out.printf("%s enters the arena.%n", this.name);
    }

    public void displayCharInfo()
    {
        Formatting.printHeading("Your Heroes Information.");
        System.out.printf("Your characters name is: %s the %s %s.%n", this.name, this.race, this.skill);
        System.out.println();
        System.out.printf("Your stats are:%n");
        System.out.printf("Health: %d     Strength: %d     Constitution: %d%n", this.health, this.strength, this.constitution);
        System.out.printf("Dodge chance: %d/100    Armour:   %d     Level: %d     Potions: %d %n", this.dodge, this.armour, this.level, this.potions);
        Formatting.printSeparator(30);
        Formatting.typeToContinue();
    }

    public int restoreToMaxHealth()
    {
        return maxHealth;
    }

    public void drinkPotion()
    {
        if (potions > 0)
        {
            this.health = maxHealth;
            this.potions--;
            System.out.printf("You take a potion restoring you to full health: %d. %n", health);
            System.out.printf("You have %d potions left. %n", this.potions);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=");
        } else
        {
            System.out.println("You don't have any potions left!");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=");
        }
    }

    public void showVictoryPic()
    {
        //showPic("Victory.txt");
    }

    public int getXP()
    {
        return xpToGet;
    }

    public void setHeroXP(int enemyXP)
    {
        this.xpToGet += enemyXP;
        System.out.printf("You earned %d XP and now have %d XP.%n", enemyXP, this.xpToGet);
        Formatting.printSeparator(30);
    }


}
