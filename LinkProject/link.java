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
    public link(int health)
    {
        this.health = health;
        theLink = this;
        theLink.movementState = "notwalking";
        draw();
    }
    public void draw()
    {
        String fileName = FILE_IMAGE_LOCATION;
        facingDirection = "south"; //TEMPORARY
        fileName += "/" + facingDirection;
        fileName += "/" + movementState;
        fileName += "/link.png";
        fileName = fileName.toLowerCase();
        if(theLink.movementState == "walking") //DEBUG CODE
        {
            fileName = "link.png";
        }
        if(theLink.movementState == "notwalking")
        {
            fileName = "bananas.png";
        }
        //fileName = "link.png";
        theLink.setImage(fileName);
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
            theLink.facingDirection = "west";
            theLink.checking = true;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            theLink.setLocation(theLink.getX() - 5, theLink.getY());
            theLink.facingDirection = "east";
            theLink.checking = true;
        }
        if(theLink.checking == false)
        {
            theLink.movementState = "notwalking";
        }
    }
    public void stateCheck()
    {
        /*if(theLink.movementState == "walking" && !checking)
        {
            theLink.checking = true;
            startTime = System.currentTimeMillis();
            while(checkingTime < startTime + 1000)
            {
                checkingTime = System.currentTimeMillis();
            }
            theLink.movementState = "notwalking";
            startTime = System.currentTimeMillis();
            checkingTime = startTime;
            while(checkingTime < startTime + 1000)
            {
                checkingTime = System.currentTimeMillis();
            }
            theLink.checking = false;
            System.out.println("Debug: stateCheck loop complete.");
        }*/
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
        else
        {
            theLink.movementState = "notwalking";
        }
    }
    /**
     * Act - do whatever the Link wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movementCheck();
        stateCheck();
        draw();
    }    
}

