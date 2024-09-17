import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Players
{
    private int kill;
    
    public Bullet(int i)
    {
        speed = i;
    }
    
    public void act()
    {
        movement();
        Edge();
        deleteBullet();
        if (getWorld() == null) return;
        KillTouch();
    }
    
    public void movement()
    {
        move(speed);
    }
    
    public void Edge()
    {
        World myWorld = getWorld();
        if(isAtEdge())
        {
            myWorld.removeObject(this);
        }
    }
    
    public void deleteBullet()
    {
        if(kill >= 1)getWorld().removeObject(this);kill=0;
    }
    
    public void KillTouch()
    {
        if(isTouching(Inimigos.class))
        {
            removeTouching(SoldadoComFaca.class);
            kill++;
        }
    }
}
