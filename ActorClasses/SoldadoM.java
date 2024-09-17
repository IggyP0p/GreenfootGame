import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoldadoM extends Inimigos
{
    public int contagem=0;
    public int health=3;
    public int damage=0;
    
    public void act()
    {
        Shoot();
        contagem++;
        damaged();
        destroyed();
    }
    
    public void Shoot()
    {
        if(contagem == 80)
        {
            Projetil p = new Projetil(false, true, false);
            getWorld().addObject(p, getX() - 20, getY() - 40);
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
