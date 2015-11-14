import greenfoot.*;

/**
 * Write a description of class object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class object extends Actor
{
    public String icon;
    public object(String inputIcon)
    {
        String fileName = "images/";
        fileName += inputIcon;
        fileName += ".png";
        fileName = fileName.toLowerCase();
        setImage(fileName);
        icon = inputIcon;
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
        if(Greenfoot.isKeyDown("e") && !getObjectsInRange(50, link.class).isEmpty())
        {
            interact();
        }
    }
    public void interact()
    {
        switch(icon)
        {
            case "bananas": 
                link.theLink.hasSword = true;
                this.removeSelf();
                Greenfoot.delay(10);
                World level1 = new Area1();
                Greenfoot.setWorld(level1);
                break;
            case "muffin":
                break;
            default:
                System.out.println("Something went wrong. The player attempted to interact with a misc. object not included in the list. The icon was " + icon + ".");
                break;
                          
        }
    }
}
