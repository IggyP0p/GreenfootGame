import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Jogar extends MenuBotoes
{
    Jbl sound = new Jbl(); //Objeto responsavel pelo controle do Som
    Letters lt = new Letters("prologo", 34); //Objeto responsavel por ser o prologo
    public static boolean pressed=false;

    /*
     * Contrutor setando as imagens de quando se passa o mouse pelo botão
     */
    public Jogar()
    {
        super.botao1 = new GreenfootImage("botaoJogar1.png");
        super.botao2 = new GreenfootImage("botaoJogar2.png");
    }
    
    public void act()
    {
        if(lt.getWorld() != null)lt.setLocation(lt.getX(), lt.getY() - 1); //Move o prologo para cima
        
        
        super.mouseOn(); //Metodo responsavel por mudar a imagem do botao
        click(); //Diz o que o botao faz
    }
    //Metodo Click
    public void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            sound.menuST.stop(); //Para a musica do Menu
            sound.praiaST.play(); //Inicia a musica da fase 1
            menuRemover(); //Remove todos os botão e o titulo do menu
            getWorld().addObject(lt, 300, 950); //adiciona prologo
            getWorld().addObject(new NextLevel(0), 300, -930); //Objeto que poe a fase 1
            lt.scene1(); //Seta o prologo
        }
    }
    //Sobreescrita metodo de remover botoes do Menu
    public void menuRemover()
    {
        List obj = getWorld().getObjects(ObjetosDeMundo.class);
        for(int i=0; i<obj.size(); i++)
        {
            if(obj.get(i).equals(this))i++; //Impede NullPointerException
            if(i<obj.size())getWorld().removeObject((Actor) obj.get(i)); //O if impede IndexOutOfBoundsException
        }

        setLocation(-100, -100); //Move o botao pra fora da tela, assim podendo subir o prologo
    }
}