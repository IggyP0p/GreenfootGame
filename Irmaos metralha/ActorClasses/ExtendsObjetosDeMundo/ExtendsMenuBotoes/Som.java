import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/*
 * Classe para menu de som
 */
public class Som extends MenuBotoes
{   
    public Som()
    {
        super.botao1 = new GreenfootImage("botaoSom1.png");
        super.botao2 = new GreenfootImage("botaoSom2.png");
    }
    
    public void act()
    {
        mouseOn();
        click();
    }
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            
        }
    }
}