import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

import ActorClasses.ExtendsObjetosDeMundo.MenuBotoes;

public class Dificuldade extends MenuBotoes
{
    //Define imagens do botão
    public Dificuldade()
    {
        super.botao1 = new GreenfootImage("botaoDificuldade.png");
        super.botao2 = new GreenfootImage("botaoDificuldade2.png");
    }
    
    public void act()
    {
        mouseOn();
        click();
    }
    //Muda tela de menu
    public void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            menuRemover();
        }
    }
    //Utiliza o metodo MenuRemover para ir ao menu das dificuldades
    public void menuRemover()
    {
        List obj = getWorld().getObjects(ObjetosDeMundo.class);
        for(int i=0; i<obj.size(); i++)
        {
            if(obj.get(i).equals(this))i++;
            if(i<obj.size())getWorld().removeObject((Actor) obj.get(i));
        }
        
        escolherDificuldade();
        getWorld().removeObject(this);
    }
}