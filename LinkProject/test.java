import greenfoot.*;

/**
 * Write a description of class object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class object extends Actor
{
    public object(String icon)
    {
        String fileName = "images/";
        fileName += icon;
        fileName += ".png";
        fileName = fileName.toLowerCase();
        setImage(fileName);
    }
    public void removeSelf()
    {
        getWorld().removeObject(this);
    }
    /**
     * Act - do whatever the object wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
