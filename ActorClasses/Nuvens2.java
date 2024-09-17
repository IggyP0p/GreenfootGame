import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Nuvens2 extends Cenario
{
    int contagem = 0;
    public void act()
    {
        contagem++;
        movement();
    }
    
    public void movement()
    {
        if(contagem == 60)
        {
            setLocation(getX(), getY() - 20);
        } 
        if(contagem == 120)
        {
            setLocation(getX(), getY() - 20);
        } 
        if(contagem == 180)
        {
            setLocation(getX(), getY() + 20);
        } 
        if(contagem == 240)
        {
            setLocation(getX(), getY() + 20);
            contagem = 0;
        } 
    }
}