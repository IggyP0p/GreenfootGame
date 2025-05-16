import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/*
 * Coloca o jogo no modo dificil ao ser clicado
 */
public class Dificil extends MenuBotoes
{
    //Define imagens do botão
    public Dificil()
    {
        super.botao1 = new GreenfootImage("botaoDificil.png");
        super.botao2 = new GreenfootImage("botaoDificil2.png");
    }
    
    public void act()
    {
        mouseOn();
        click();
    }
    //torna o modo dificil on
    public void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            super.hard = true;
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
