import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class botoes extends Actor
{
    GreenfootImage botao1; //botao base
    GreenfootImage botao2; //botao após o mouse passar por cima
    
    public void mouseOn()
    {
        if(Greenfoot.mouseMoved(this))setImage(botao2);
        if(!Greenfoot.mouseMoved(this) && Greenfoot.mouseMoved(null))
        {
            setImage(botao1);
        }
    }
}
