import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends Levels
{

    /**
     * Constructor for objects of class Win.
     * 
     */
    public Win()
    {
        super(1, 4);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        object object = new object("zelda");
        addObject(object,292,98);
        addObject(theLink,298,332);
    }
}
