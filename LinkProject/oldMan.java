import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class oldMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class oldMan extends Actor
{
    public boolean completed = false;
    /**
     * Act - do whatever the oldMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public oldMan()
    {
        Start.theStart.showText("To start, press RUN and the space bar.\n\nCONTROLS\nMove - WASD\nInteract - E\nAttack - F", 200, 100);
    }
    public void act() 
    {
        if(!completed)
        {
            interact();
        }
    }
    private void interact()
    {
        if(/*link.theLink.getY() <= 260 && link.theLink.getX() <= 360 && link.theLink.getX() >= 230*/Greenfoot.isKeyDown("e"))
        {
            object speech = new object("speech"); //CHANGE THIS
            getWorld().addObject(speech, this.getX(), this.getY() - 100);
            completed = true;
            giveSword();
        }
        
    }
    public void giveSword()
    {
        Greenfoot.delay(75);
        object sword = new object("sword");
        getWorld().addObject(sword, this.getX(), this.getY() + 75);
    }
}
