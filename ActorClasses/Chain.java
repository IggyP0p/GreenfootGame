import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Chain extends Cenario
{
    
    public void act()
    {
        bodyBlock();
    }
    
    public void bodyBlock()
    {
        Actor p = getOneIntersectingObject(Players.class);
        if(p != null)p.setLocation(p.getX() - 3, p.getY());
    }
}