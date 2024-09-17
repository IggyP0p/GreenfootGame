import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TorretaCima extends Torretas
{
    public void act()
    {
        Shoot();
        contagem++;
    }
    
    public void Shoot()
    {
        if(contagem >= 100)
        {
            Projetil p = new Projetil(false, false, true);
            getWorld().addObject(p, getX(), getY() - 30);
            contagem=0;
        }
    }
}
