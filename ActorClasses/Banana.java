import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Banana extends Armadilhas
{
    public void act()
    {
        turn(10);
        Edge();
        if (getWorld() == null) return;
        Movement();
    }
    
    public void Movement()
    {
        setLocation(getX(), getY() + 2);
    }
}