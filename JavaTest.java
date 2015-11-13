import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Link here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class link extends Actor
{
    protected static final String FILE_IMAGE_LOCATION = "images/link";
    public int health;
    public boolean hasSword;
    public boolean hasBoomerang;
    public GreenfootImage icon; 
    public int bombs;
    public String facingDirection;
    public String movementState;
    public link(int health)
    {
        this.health = health;
        draw();
    }
    public void draw()
    {
        String fileName = FILE_IMAGE_LOCATION;
        facingDirection = "south"; //TEMPORARY
        movementState = "notwalking";
        fileName += "/" + facingDirection;
        fileName += "/" + movementState;
        fileName += "/link.png";
        fileName = fileName.toLowerCase();
        //fileName = "link.png";
        setImage(fileName);
        System.out.println(fileName); //DEBUG
    }
    /**
     * Act - do whatever the Link wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}

