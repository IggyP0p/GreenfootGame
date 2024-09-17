import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Armadilhas extends Inimigos
{
    public void Edge()
    {
        World myWorld = getWorld();
        if(isAtEdge())
        {
            myWorld.removeObject(this);
        }
    }
}
