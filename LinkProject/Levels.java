import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{
    public static link theLink;
    public static int enemies;
    public static int currentLevel;

    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels(int a, int b)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        enemies = a;
        currentLevel = b;
    }
    public static link getLink()
    {
        return theLink;
    }
    public void addMiscObject(String icon, int x, int y)
    {
        object miscObject = new object(icon);
        addObject(miscObject, x, y);
    }
    public static void decEnemies()
    {
        --enemies;
        if(enemies == 0)
        {
            Greenfoot.delay(20);
            link.toNextLevel(theLink.currentLevel + 1);
        }
    }
    public void stopped()
    {

    }
    public void started()
    {

    }
}
