import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Area2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Area2 extends Levels
{

    /**
     * Constructor for objects of class Area2.
     * 
     */
    public Area2()
    {
        super(3,2);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(theLink,66,228);
        enemy enemy = new enemy(2, "enemy");
        addObject(enemy,265,86);
        enemy enemy2 = new enemy(2, "enemy");
        addObject(enemy2,422,219);
        enemy enemy3 = new enemy(2, "enemy");
        addObject(enemy3,295,344);
    }
}
