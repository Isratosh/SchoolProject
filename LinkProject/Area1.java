import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Area1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Area1 extends World
{

    /**
     * Constructor for objects of class Area1.
     * 
     */
    public Area1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        link link = new link(50);
        addObject(link,52,228);
        enemy enemy = new enemy();
        addObject(enemy,445,232);
    }
}
