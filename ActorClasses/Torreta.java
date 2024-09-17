import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Torreta extends Torretas
{
    public void act()
    {
        Shoot();
        contagem++;
        damaged();
        destroyed();
    }
    
    public void Shoot()
    {
        if(contagem == 150)
        {
            Projetil p = new Projetil(true, false, false);
            getWorld().addObject(p, getX() - 39, getY() - 23);
            contagem=0;
        }
    }
    
    public void damaged()
    {
        if(isTouching(Bullet.class))damage++;
    }
    
    public void destroyed()
    {
        if(damage == health)getWorld().removeObject(this);
    }
}
