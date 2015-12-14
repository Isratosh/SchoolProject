import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{
    public static Start theStart;
    public boolean prepared = false;
    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        theStart = this;
        
        prepare();
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {

        
        oldMan oldman = new oldMan();
        addObject(oldman,301,174);
    }
    public void manualPrepare()
    {
        link link = new link(10, "north");
        addObject(link,296,314);
        showText(null, 200, 100);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space") && !prepared)
        {
            prepared = true;
            manualPrepare();
        }
    }
}
