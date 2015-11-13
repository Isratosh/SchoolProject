import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
import java.util.TimerTask;
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
    private Timer timer = new Timer();
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
        //fileName = "link.png";
        theLink.setImage(fileName);
    }
    public void movementCheck()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            theLink.setLocation(theLink.getX(), theLink.getY() - 5);
            theLink.movementState = "walking";
        }
        if(Greenfoot.isKeyDown("s"))
        {
            theLink.setLocation(theLink.getX(), theLink.getY() + 5);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            theLink.setLocation(theLink.getX() + 5, theLink.getY());
        }
        if(Greenfoot.isKeyDown("a"))
        {
            theLink.setLocation(theLink.getX() - 5, theLink.getY());
        }
    }
    public void stateCheck()
    {
        if(theLink.movementState == "walking")
        {
            theLink.timer.cancel(); //this will cancel the current task. if there is no active task, nothing happens
            theLink.timer = new Timer();

            TimerTask action = new TimerTask() 
            {
                public void run() {
                    theLink.movementState = "notwalking"; //as you said in the comments: abc is a static method
                    System.out.println("Task complete.");
                }

            };
            theLink.timer.schedule(action, 600); //this starts the task
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

