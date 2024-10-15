import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

import ActorClasses.ExtendsObjetosDeMundo.MenuBotoes;

public class Facil extends MenuBotoes
{    
    //Define imagens do botão
    public Facil()
    {
        super.botao1 = new GreenfootImage("botaoFacil.png");
        super.botao2 = new GreenfootImage("botaoFacil2.png");
    }
    
    public void act()
    {
        mouseOn();
        click();
    }
    //torna o modo dificil off
    public void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            super.hard = false;
            menuRemover();
        }
    }
    //Utiliza o metodo MenuRemover para voltar ao menu inicial
    public void menuRemover()
    {
        List obj = getWorld().getObjects(ObjetosDeMundo.class);
        for(int i=0; i<obj.size(); i++)
        {
            if(obj.get(i).equals(this))i++;
            if(i<obj.size())getWorld().removeObject((Actor) obj.get(i));
        }
        
        voltar();
        getWorld().removeObject(this);
    }
}