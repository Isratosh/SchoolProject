import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Area3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Area3 extends Levels
{

    /**
     * Constructor for objects of class Area3.
     * 
     */
    public Area3()
    {
        super(1, 3);
        prepare();
    }
    
    public void prepare()
    {
        addObject(theLink,297,325);
        enemy enemy = new enemy(5, "boss");
        addObject(enemy,298,82);
    }
}
