package ActorClasses.ExtendsObjetosDeMundo;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Intro extends MenuBotoes
{
    int contagem=0;
    int speed=1;
    
    public void act()
    {
        removeTouching(MenuBotoes.class);
        move();
        contagem++;
    }
    
    public void move()
    {
        setLocation(getX(), getY() - speed);
        if(contagem == 1150)speed = 2;
    }
}