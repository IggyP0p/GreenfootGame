import greenfoot.*; 
import java.util.List;

/*
 * Superclasse dos botoes do menu
 */
public abstract class MenuBotoes extends ObjetosDeMundo
{
    GreenfootImage botao1; //botao base
    GreenfootImage botao2; //botao após o mouse passar por cima
    public static boolean hard; //Define a dificuldade do jogo
    
    public abstract void click();
    //Para retornar ao menu inicial
    public void voltar()
    {
        getWorld().addObject(new Titulo(), 300, 200);
        getWorld().addObject(new Jogar(), 300, 250);
        //getWorld().addObject(new Som(), 300, 350);
        getWorld().addObject(new Dificuldade(), 300, 300);
    }
    //Remove os objetos de tela para um outro menu
    public void menuRemover()
    {
        List obj = getWorld().getObjects(ObjetosDeMundo.class);
        for(int i=0; i<obj.size(); i++)
        {
            if(obj.get(i).equals(this))i++; //Impede NullPointerException
            if(i<obj.size())getWorld().removeObject((Actor) obj.get(i)); //O if impede IndexOutOfBoundsException
        }

        getWorld().removeObject(this); //Remove o ultimo botao da tela
    }
    //Menu da Dificuldade
    public void escolherDificuldade()
    {
        getWorld().addObject(new Dificil(), 300, 100);
        getWorld().addObject(new Facil(), 300, 150);
    }
    //Metodo que troca a imagem do botao caso o mouse passe por cima
    public void mouseOn()
    {
        if(Greenfoot.mouseMoved(this))setImage(botao2);
        if(!Greenfoot.mouseMoved(this) && Greenfoot.mouseMoved(null))
        {
            setImage(botao1);
        }
    }
}