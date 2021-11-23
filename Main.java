import java.util.*;

class Main {
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();

    public static int maxEnemyHealth = 75;
    public static int enemyAttackDamage = 25;

    //Player Variables
    public static int health = 100;
    public static int attackDamage = 25;
    public static int numHealthPotions = 3;
    public static int healthPotionHealAmount = 30;
    public static int healthPotionDropChance = 33; 
    public static int playerLocation = 0;
    public static boolean dungeonKey = false;
    public static boolean dungeonSword = false;
    public static int trophies = 0;

 public static void main(String[] args)
 {  
   Scanner in = new Scanner(System.in);
    Random rand = new Random();

    System.out.println("\tDUNGEON MASTERS\n\n\tWelcome to the game!");
    System.out.println("\tHave you played before? y/n");
    String newUser = in.nextLine();
    //Determining whether to send user to tutorial or not
    if(newUser.equals("n")||newUser.equals("no"))
    {
      playerLocation = 0;      
    }

    else if(newUser.equals("y")||newUser.equals("yes"))
    {
      System.out.println("Welcome back!");
      playerLocation = 1;
    }

    else
    {
      System.out.println(">>Invalid Command<<");
    }

    //Gameplay Loop
    while(playerLocation < 8)
    {
      roomDescription(playerLocation);
      String playerInput = in.nextLine();

      switch(playerLocation)
      {
        //The Tutorial Level
        case 0:
          if(playerInput.contains("Fight")||playerInput.contains("fight"))
          {
            System.out.println("\t#This is a skeleton.#\n\t#The battle sequences are largely based on randomized attack for both.#\n\t#Some speak of a magical sword that enlightens even the darkest room lies in the dungeon...#");
            enemyBattle(0);
            System.out.println(">>Good luck in the dungeon! If you dare enter...<<");
            playerLocation ++;
          }

          else if(playerInput.contains("HP"))
          {
            if(numHealthPotions > 0) 
            {
              health += healthPotionHealAmount;
              numHealthPotions--;
              if(health > 100)
               {
                 health = 100;
               }
              System.out.println("\t> You drink a health potion healing " + healthPotionHealAmount 
                             + "\n\t> You now have " + health + " HP and " + numHealthPotions + " health potions left.\n");
            }
            else
            {
             System.out.println("You have no health potions!");
            }
          }

          else if(playerInput.contains("Cry")||playerInput.contains("cry"))
          {
            System.out.println("\t# You lay down and cry, wondering why you are here... #");
            System.out.println("\tThis is only the tutorial buddy get used to it");
          }

          else if(playerInput.contains("Exit")||playerInput.contains("exit"))
          {
             System.out.println("\tI hope you play again!");
             System.exit(0);
          }

          else
          {
            System.out.print(">>Invalid Command<<");
          }

          health = 100;
          break;
        
        //The Entrance
        case 1:
          if(playerInput.contains("Enter")||playerInput.contains("enter"))
          {
             System.out.println("\t#You look around and enter the dungeon#\n\t#This is going to be a long night...#\n");
             System.out.println("\t#You begin to hear a deep breathing from above#\n\t#A Lizard-Man appears!#");
             enemyBattle(1);
             trophies++;
             System.out.println("\t#The Lizard-Man dropped a trophy!#\n\t#Where has he hid the others?#");
             playerLocation++;
             
          }

          else if(playerInput.contains("Exit")||playerInput.contains("exit"))
          {
            System.out.println("\t#That was a smart choice#\n\tI hope you play again!");
            System.exit(0);
          }

          else
          {
            System.out.println(">>Invalid Command<<");
          }
          break;
        
        //The Hallway
        case 2:
          if(playerInput.contains("room 1")||playerInput.contains("Room 1"))
          {
            if(dungeonKey == true)
            {
              System.out.println("\t#You reach into your pocket and grab the key#\n\tThe door unlocks and you walk in#\n\t");
              playerLocation++;
              playerLocation++;
            }
            else
            {
              System.out.println("\t#The door is locked#\n\t#The handle is hot to the touch#");
            }
          }

          else if(playerInput.contains("room 2")||playerInput.contains("Room 2"))
          { 
            if(dungeonSword == true)
            {
              System.out.println("\t#You unsheath your sword, suddenly feeling calmer#\n\t#To your awe the statue begins to move#\n\t#The stone crumbles and reveals a knight!#\n\t#The stone knight lunges at you!#");
              enemyBattle(4);
              System.out.println("\t#The stone knight begins to crumble to pieces#\n\t#He mutters something about his master#\n\t#As his head crumbles he looks up at you, hopeless#\n\t#'Why?' he asks as he finally turns to dust#\n\t#You smile and venture on, bloodthirsty#");
              playerLocation++;
              playerLocation++;
              playerLocation++;
            }

            else
            {
              System.out.println("\t#The door is blocked by a large statue!#");
            }
          }

          else if(playerInput.contains("room 3")||playerInput.contains("Room 3"))
          {
            System.out.println("\t#You slowly open the door#\n\t#A warrior jumps out of the shadows!#");
            enemyBattle(2);
            System.out.println("\t#The warrior dropped a key!#");
            System.out.println("\t#The warrior dropped a trophy!#");
            dungeonKey = true;
            playerLocation++;
          }
          break;
        
        //Room 3
        case 3:
          if(playerInput.contains("Trophy")||playerInput.contains("trophy"))
          { 
            if(trophies < 2)
            {
            trophies++;
            System.out.println("\t#You pick the trophy from the shelf!#");
            }
            else
            {
              System.out.println("#\tYou have already taken this trophy#");
            }
          }
          
          else if(playerInput.contains("Exit")||playerInput.contains("exit"))
          { 
            if(trophies < 2)
            {
              System.out.println("\t#You should really take the trophy#");
            }

            else
            {
              playerLocation--;
            }
          }

          else
          {
            System.out.println(">>Invalid Commmand<<");
          }
          break;

        //Room 1
        case 4:
          enemyBattle(3);
          System.out.println("\t#You finish slaying the first monster#\n\t#You scowl at the second monster#\n\t#Although seemingly impossible the monster sheds a tear#\n\t#He howls in sadness and lunges at you for revenge#");
          enemyBattle(3);
          System.out.println("#The left one dropped a trophy!#");
          trophies++;
          System.out.println("\t#Having defeated the twins you lay tired#\n\t#Your vision becomes blurry facing the roof#\n\t#A man in a lab coat looks over you smiling#\n\t#You feel a pinch in your arm and fall fast asleep#\n\n\n\t#You wake up in a fountain with a sword in your hand#\n\t#You feel rejuvunated and ready to fight#\n\t#How strange...#");
          health = 100;
          dungeonSword = true;
          playerLocation--;
          playerLocation--;
          break;

        //Room 2
        case 5:
          if(playerInput.contains("Fight")||playerInput.contains("fight"))
          {
            enemyBattle(5);
            System.out.println("\t>>Mahir has been defeated<<\n\t#He falls to the ground and drops two trophies#");
            trophies++;
            trophies++;
            System.out.println("\t#You defeated the Dungeon#\n\t#You have gathered all 5 trophies!#\n\t#You are known far and wide for your deeds#\n\t#Are you the hero or the villain?#\n\n\tGAME OVER");
            System.exit(0);
          }

          else if(playerInput.contains("Run")||playerInput.contains("run"))
          {
            System.out.println("\t#You try to run but are stuck in place#\n\t#One of you will die tonight#");
          }
          break;
      }
    }
 }

  //Function to output description automatically with entrance to room
  public static void roomDescription(int roomNumber) 
  {   
    //Custom function to display room and the options for player.

    Scanner in = new Scanner(System.in);

     String[] description = new String [9];

    description[0] = "\tHEllO! WELCOME TO DUNGEON MASTER!\n\tThis is the tutorial. I shall be teaching you how to survive and the dangers you face in the Dungeon of Daggoroth.\n No... it is not spelt with an a, why would one ask such a question?.. Nevertheless, let's hop in shall we! ";
    description[1] = "\t#You're faced by the door to the dungeon#\n\t#You hear screams echo from inside and shudder#\n\t#You begin to rethink going in the dungeon...#";
    description[2] = "\t#You now face three different rooms#\n\t#You can feel a sinister aura coming from all three#";
    description[3]  = "\t#The room is cold and empty#\n\t#You see a lone trophy on a shelf#\n\t";
    description[4] = "\t#You enter the room to find two monsters#\n\t#Two green, large slime monsters face you#\n\t#They roar in unison and jump at you#";
    description[5] = "\t#You enter the third room to the sight of a man in a lab coat#\n\t#He whistles away carefree as he tinkers with viles#\n\t#You approach him slowly remembering him fuzzily#\n\n\n\tYou: You're that guy aren't you, the guy I saw when I was sleeping.\n\n\tLab Coat Guy: Yes yes, the names Mahir kid.\nMahir: You seem to be pretty strong if you're this far\n\n\tYou: Well, to be honest I didn't have much of a hard time you know...\n\tMahir: Ah, I see... Why are you here if I may ask?\nMahir: You have disturbed our peaceful home and killed my friends.\n\n\tYou: I don't really know how...\nI just started in here.\n\n\tMahir: How underwhelming...\nYour death is guaranteed!";
    String[] options = new String[9];
    options[0] = "Fight, Restore HP, Cry, Exit";
    options[1] = "Enter, Exit";
    options[2] = "Room 1, Room 2, Room 3";
    options[3] = "Take trophy, Exit room";
    options[4] = "Fight left one, Fight right one";
    options[5] = "Fight Mahir, Run,";

    System.out.println("-------------------------------------------------\n" + description[roomNumber] + "\n-------------------------------------------------");
    String message = String.format("\n\tWhat would you like to do? The options are: %s", options[roomNumber]);
    System.out.println(message);

  }

  //Function for battle sequences
  public static void enemyBattle(int enemyNumber)
  { 
    String[] enemies = {"Skeleton", "Lizard-Man", "Warrior", "Sludge Twin", "Stone Knight", "Mahir"};
    boolean running = true;

    GAME:
    while(running) 
    {
      System.out.println("-----------------------------");

      int enemyHealth = rand.nextInt(maxEnemyHealth);
      String enemy = enemies[enemyNumber];
      if("Mahir" == enemy)
      {
        enemyHealth = 80;
      }
      
      System.out.println("\t# " + enemy + " has appeared! #\n");

      while(enemyHealth > 0)
      {
        System.out.println("\tYour HP: " + health);
        System.out.println("\tThe " + enemy + "'s HP: " + enemyHealth);
        System.out.println("\n\tWhat would you like to do?");
        System.out.println("\t1. [A]ttack(Normal) ");
        System.out.println("\t2. [D]rink health potion");

        if(dungeonSword == true)
        {
          System.out.println("\t*NEW* 3. [S]word attack");
        }

        String input = in.nextLine();
        switch(input) 
        {
          case "A":
            int damageDealt = rand.nextInt(attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);

            enemyHealth -= damageDealt;
            health-= damageTaken;

            System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
            System.out.println("\tThe " + enemy + " retaliates and deals " + damageTaken + "!!");

            if(health < 1) 
            {
              System.out.println("\t#The world goes dark around you...#\n\t>>GAME OVER<<");
              System.exit(0);
              break;
            }
            break;
          
          case "D":
            if(numHealthPotions > 0)
            {
              health += healthPotionHealAmount;
              numHealthPotions--;
                 if(health > 100)
               {
                 health = 100;
               }
              System.out.println("\t> You drink a health potion healing " + healthPotionHealAmount 
               + "\n\t> You now have " + health + " HP and " + numHealthPotions + " health potions left.\n");
            }

            else
            {
              System.out.println("You have no health potions!");
            }
            break;
          
          case "S":
            if(dungeonSword == true)
            {
              damageDealt = 30;
              damageTaken = rand.nextInt(enemyAttackDamage);

              enemyHealth -= damageDealt;
              health-= damageTaken;

              System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
              System.out.println("\tThe " + enemy + " retaliates and deals " + damageTaken + "!!");
            }
            else
            {
              System.out.println("ERROR");
            }
            break;

          case "BLUE":
            healthPotionHealAmount = 100;
            health = 1000;
            System.out.println("\t##HELLO BLUE##\n\t##GOD MODE ACTIVATED##");
            break;

          default:
            System.out.println("\t<<Invalid Command>>");


        }
      }

      System.out.println("-------------------------------------------------");
      System.out.println(" # " + enemy + " was defeated! # ");
      System.out.println(" # You have " + health + " HP left. #");
      if(rand.nextInt(100) > healthPotionDropChance) 
      {
        System.out.println(" # The enemy dropped a health potion! #");
        numHealthPotions++;
        System.out.println(" # You now have " + numHealthPotions + " health potion(s)! #");
        System.out.println("-------------------------------------------------");

      }
      break;
    }


   }
 }