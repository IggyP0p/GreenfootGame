import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Som extends MenuBotoes
{
    GreenfootImage botao1 = new GreenfootImage("botaoSom1.png");
    GreenfootImage botao2 = new GreenfootImage("botaoSom2.png");
    public void act()
    {
        mouseOn();
        click();
    }
    
    public void mouseOn()
    {
        if(Greenfoot.mouseMoved(this))setImage(botao2);
        if(!Greenfoot.mouseMoved(this) && Greenfoot.mouseMoved(null))
        {
            setImage(botao1);
        }
    }
    
    public void click()
    {
        //if(Greenfoot.mouseClicked(this)));
    }
}
