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
    //Movimento da bala
    public void movement()
    {
        move(speed);
    }
    //Ao tocar a ponta do mundo some
    public void Edge()
    {
        World myWorld = getWorld();
        if(isAtEdge())
        {
            myWorld.removeObject(this);
        }
    }
    //some ao tocar um inimigo
    public void deleteBullet()
    {
        if(kill >= 1)getWorld().removeObject(this);kill=0;
    }
    //Diz se tocou um inimigo
    public void KillTouch()
    {
        if(isTouching(Inimigos.class))
        {
            kill++;
        }
    }
}