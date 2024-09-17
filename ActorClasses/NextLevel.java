import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NextLevel extends Cenario
{
    int level;
    
    public NextLevel(int level)
    {
        this.level = level;
    }
    
    public void act()
    {
        if(level == 0)level1();
        if(level == 1)level2();
    }
    
    public void level1()
    {
        if(isTouching(Intro.class))
        {
            Greenfoot.setWorld(new PraiaCarry());
        }
    }
    
    public void level2()
    {
        if(isTouching(Players.class))
        {
            Greenfoot.setWorld(new FlorestaAntiga());
        }
    }
}