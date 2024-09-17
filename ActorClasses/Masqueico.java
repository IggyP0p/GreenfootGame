import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Masqueico extends Inimigos
{
    private int animationCounter=0;
    
    public void act()
    {
        animationCounter++;
        bananaAttack();
    }
    
    public void bananaAttack()
    {
        if(animationCounter >= 150)
        {
            setImage("masqueico1.png");
            World myWorld = getWorld();
            myWorld.addObject(new Banana(), getX() + 11, getY() + 17);
            animationCounter = 0;
        }
        
        if(animationCounter >= 50 && animationCounter < 150)
        {
            setImage("masqueico0.png");
        }
    }
    
    public int distX()
    {
        return this.getX();
    }
    
    public int distY()
    {
        return this.getY();
    }
}