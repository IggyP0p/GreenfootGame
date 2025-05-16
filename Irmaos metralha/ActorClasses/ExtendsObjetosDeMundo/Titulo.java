import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Titulo extends ObjetosDeMundo
{
    Jogar jg = new Jogar();
    
    public void act()
    {
        if(jg.pressed == true)getWorld().removeObject(this); //remove titulo quando aperta em jogar
    }
}