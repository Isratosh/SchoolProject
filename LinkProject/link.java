import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Link here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class link extends Actor
{
    protected static final String FILE_IMAGE_LOCATION = "images/link/";
    public static link theLink;
    public int health;
    public boolean hasSword;
    public boolean hasBoomerang;
    public GreenfootImage icon; 
    public int bombs;
    public String facingDirection;
    public String movementState;
    private boolean checking;
    private int atime = 0;
    private int btime = 0;
    private int ctime = 0;
    private boolean attacking;
    public boolean invincible = false;
    public static int currentLevel = 0;
    public static object heart;
    public link(int startingHealth, String startingDirection)
    {
        this.health = startingHealth;
        this.facingDirection = startingDirection;
        theLink = this;
        theLink.movementState = "notwalking";
        theLink.attacking = false;
        Levels.theLink = this;
        draw();
        createHealth();
        Greenfoot.start();
        
    }
    public link()
    {
        this.health = 10;
        this.facingDirection = "north";
        theLink = this;
        theLink.movementState = "notwalking";
        theLink.attacking = false;
        Levels.theLink = this;
        draw();
        Greenfoot.start();
    }
    public void draw()
    {
        String fileName = FILE_IMAGE_LOCATION;
        fileName += "link";
        fileName += facingDirection;
        fileName += movementState;
        fileName += ".png";
        fileName = fileName.toLowerCase();
        theLink.setImage(fileName);
    }
    public void setHealth(int newHealth)
    {
        health = newHealth;
    }
    public static int getHealth()
    {
        return theLink.health;
    }
    public void createHealth()
    {
       heart = new object("heartfull");
       Start.theStart.addObject(heart, 575, 20);
       for(int i=555;i>475;i -= 20)
       {
           object heartFull = new object("heartfull");
           Start.theStart.addObject(heartFull, i, 20);
       }
    }
    public void decHealth()
    {
        --health;
        heart.shuffle();
    }
    public void movementCheck()
    {
        theLink.checking = false;
        if(Greenfoot.isKeyDown("w"))
        {
            theLink.setLocation(theLink.getX(), theLink.getY() - 5);
            theLink.facingDirection = "north";
            theLink.checking = true;
        }
        if(Greenfoot.isKeyDown("s"))
        {
            theLink.setLocation(theLink.getX(), theLink.getY() + 5);
            theLink.facingDirection = "south";
            theLink.checking = true;
        }
        if(Greenfoot.isKeyDown("d"))
        {
            theLink.setLocation(theLink.getX() + 5, theLink.getY());
            theLink.facingDirection = "east";
            theLink.checking = true;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            theLink.setLocation(theLink.getX() - 5, theLink.getY());
            theLink.facingDirection = "west";
            theLink.checking = true;
        }
        if(theLink.checking == false)
        {
            theLink.movementState = "notwalking";
        }
    }
    public void stateCheck()
    {
        if(theLink.checking)
        {
            atime = atime + 1;
            if (atime == 18)
            {
                atime = 0;
                theLink.movementState = "notwalking";
            }
            if (atime == 0)
            {
                theLink.movementState = "walking";
            }
            if (atime==6)
            {
                theLink.movementState = "notwalking";
            }
            if (atime==12)
            {
                theLink.movementState = "walking";
            }
        }
        else if(theLink.movementState == "attacking"){}
        else
        {
            theLink.movementState = "notwalking";
        }
    }
    public static void toNextLevel(int a)
    {
        World nextLevel = new Start();
        switch(a)
        {
            case 1:
                currentLevel = 1;
                nextLevel = new Area1();
                break;
            case 2:
                currentLevel = 2;
                nextLevel = new Area2();
                break;
            case 3:
                currentLevel = 3;
                nextLevel = new Area3();
                break;
            case 4:
                currentLevel = 4;
                nextLevel = new Win();
                break;
            default:
                System.out.println("Something went wrong. Attempted to move to next level of value \""+a+"\".");
                break;
        }
        
        Greenfoot.setWorld(nextLevel);
        object.buildHearts(theLink.health);
    }
    public static void toYouLose()
    {
        World levellose = new YouLose();
        Greenfoot.setWorld(levellose);
        Greenfoot.stop();
    }
    public void attack()
    {
        if(Greenfoot.isKeyDown("f"))
        {
            theLink.movementState = "attacking";
            enemy target = theLink.getOneIntersectingObject(enemy.class);
            if(target != null && theLink.attacking == false)
            {
                target.health -= 1;
                theLink.attacking = true;
                theLink.invincible = true;
            }
        }
    }
    public void incAttackVar()
    {
        if(theLink.attacking)
        {
            btime = btime + 1;
        }
        if(theLink.invincible)
        {
            ctime = ctime + 1;
        }
        if(theLink.ctime >= 30)
        {
            theLink.invincible = false;
            ctime = 0;
        }
        if(theLink.btime >= 16)
        {
            theLink.attacking = false;
            theLink.movementState = "notwalking";
            theLink.btime = 0;
        }
    }
    public void deathCheck()
    {
        if(health < 1)
        {
            Greenfoot.delay(20);
            toYouLose();
        }
    }
    
    
    /**
     * Act - do whatever the Link wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /*if(Greenfoot.isKeyDown("f"))
        {
            invincible = true;
        }
        else
        {
            invincible = false;
        }*/
        movementCheck();
        stateCheck();
        attack();
        incAttackVar();
        deathCheck();
        draw();
    }    
}

