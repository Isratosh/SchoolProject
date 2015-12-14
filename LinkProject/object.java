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
    public boolean half;
    public object(String inputIcon)
    {
        String fileName = "images/";
        fileName += inputIcon;
        fileName += ".png";
        fileName = fileName.toLowerCase();
        setImage(fileName);
        icon = inputIcon;
        
    }
    public object(String inputIcon, String inputExtension)
    {
        String fileName = "images/";
        fileName += inputIcon;
        fileName += inputExtension;
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
        if(icon == "zelda")
        {
            link.theLink.getWorld().showText("You won!", 100, 100);
            Greenfoot.stop();
        }
    }
    public void interact()
    {
        switch(icon)
        {
            case "sword": 
                link.theLink.hasSword = true;
                this.removeSelf();
                Greenfoot.delay(10);
                link.toNextLevel(1);
                break;
            case "muffin":
                break;
            default:
                System.out.println("Something went wrong. The player attempted to interact with a misc. object not included in the list. The icon was " + icon + ".");
                break;
                          
        }
    }
    public void setIcon(String inputIcon)
    {
        icon = inputIcon;
        setImage(inputIcon);
    }
    public void shuffle()
    {
        if(half)
        {
            object nextHeart = getOneObjectAtOffset(-20, 0, object.class);
            if(nextHeart != null)
            {
                link.heart = nextHeart;
                half = false;
                this.setImage("heartempty.png");
            }
            else
            {
                if(link.theLink.health != 0)
                {
                    System.out.println("Attempted to move to next heart, but getObject returned null and Link's health was not at 0. At the time of error, Link's health is: " + link.theLink.health);
                }
            }
        }
        else
        {
            link.heart.setImage("hearthalf.png");
            half = true;
        }
    }
    public static void buildHearts(int h)
    {
        object heart1 = new object("heartempty");
        object heart2 = new object("heartempty");
        object heart3 = new object("heartempty");
        object heart4 = new object("heartempty");
        object heart5 = new object("heartempty");
        link.theLink.getWorld().addObject(heart1, 495, 20);
        link.theLink.getWorld().addObject(heart2, 515, 20);
        link.theLink.getWorld().addObject(heart3, 535, 20);
        link.theLink.getWorld().addObject(heart4, 555, 20);
        link.theLink.getWorld().addObject(heart5, 575, 20);
        //System.out.println("Passed argument for health H is currently: "+h);
        switch(h)
        {
            case 1:
                heart1.setIcon("hearthalf.png");
                link.theLink.heart = heart1;
                heart1.half = true;
                //System.out.println("Case 1");
                break;
            case 2:
                heart1.setIcon("heartfull.png");
                link.theLink.heart = heart1;
                //System.out.println("Case 2");
                break;
            case 3:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("hearthalf.png");
                link.theLink.heart = heart2;
                heart2.half = true;
                //System.out.println("Case 3");
                break;
            case 4:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("heartfull.png");
                link.theLink.heart = heart2;
                //System.out.println("Case 4");
                break;
            case 5:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("heartfull.png");
                heart3.setIcon("hearthalf.png");
                link.theLink.heart = heart3;
                heart3.half = true;
                //System.out.println("Case 5");
                break;
            case 6:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("heartfull.png");
                heart3.setIcon("heartfull.png");
                link.theLink.heart = heart3;
                //.out.println("Case 6");
                break;
            case 7:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("heartfull.png");
                heart3.setIcon("heartfull.png");
                heart4.setIcon("hearthalf.png");
                link.theLink.heart = heart4;
                heart4.half = true;
                //System.out.println("Case 7");
                break;
            case 8:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("heartfull.png");
                heart3.setIcon("heartfull.png");
                heart4.setIcon("heartfull.png");
                link.theLink.heart = heart4;
                //System.out.println("Case 8");
                break;
            case 9:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("heartfull.png");
                heart3.setIcon("heartfull.png");
                heart4.setIcon("heartfull.png");
                heart5.setIcon("hearthalf.png");
                link.theLink.heart = heart5;
                heart4.half = true;
                //System.out.println("Case 9");
                break;
            case 10:
                heart1.setIcon("heartfull.png");
                heart2.setIcon("heartfull.png");
                heart3.setIcon("heartfull.png");
                heart4.setIcon("heartfull.png");
                heart5.setIcon("heartfull.png");
                link.theLink.heart = heart5;
                //System.out.println("Case 10");
                break;
        }
    }
}
