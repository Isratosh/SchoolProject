import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
    public int health;
    public String icon;
    private boolean attacked;
    private int atime = 0;
    private int btime = 0;
    private boolean moveState = true;
    private boolean boss = false;
    public enemy(int startingHealth, String startingIcon)
    {
        this.health = startingHealth;
        this.icon = startingIcon;
        if(startingIcon == "boss"){boss = true;}
        setImage("images/" + icon + ".png");
    }
    public void healthCheck()
    {
        if(health < 1)
        {
            die();
            Levels.decEnemies();
        }
    }
    public void die()
    {
        getWorld().removeObject(this);
    }
    public void damageCheck()
    {
        link target = getOneIntersectingObject(link.class);
        if(target != null && !attacked && !link.theLink.invincible)
        {
            target.decHealth();
            attacked = true;
        }
    }
    public void incAtime()
    {
        if(attacked == true)
        {
            atime = atime + 1;
        }
        if(atime >= 45)
        {
            attacked = false;
            atime = 0;
        }
    }
    public void movement()
    {
        int a = Greenfoot.getRandomNumber(4);
        if(btime >=30)
        {
            switch(a)
            {
                case 0:
                    setLocation(getX()+30,getY());
                    
                    break;
                case 1:
                    setLocation(getX()-30,getY());
                    break;
                case 2:
                    setLocation(getX(),getY()+30);
                    break;
                case 3:
                    setLocation(getX(),getY()-30);
                    break;
                default:
                    System.out.println("Enemy attempted to move in a wrong direction. Attempted direction was: "+a);
            }
            if(moveState == false && !boss)
            {
                setImage("enemywalking.png");
                moveState = true;
            }
            else if(moveState == true && !boss)
            {
                setImage("enemy.png");
                moveState = false;
            }
            btime = 0;
        }
        else
        {
            ++btime;
        }
    }
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        healthCheck();
        incAtime();
        if(!attacked)
        {
            damageCheck();
        }
        movement();
    }
}
