import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }


    public void addMiscObject(String icon, int x, int y)
    {
        object miscObject = new object(icon);
        addObject(miscObject, x, y);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {

        link link = new link(50);
        addObject(link,296,314);
        oldMan oldman = new oldMan();
        addObject(oldman,301,174);
    }
}
