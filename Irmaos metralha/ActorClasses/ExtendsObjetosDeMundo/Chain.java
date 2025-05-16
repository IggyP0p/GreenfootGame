import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Chain extends ObjetosDeMundo
{
    private List<Players> jogadores = new ArrayList<Players>();
    public boolean blockSide;
    
    public Chain(boolean side)
    {
        this.blockSide = side; //if true bloqueia direita, false bloqueia esquerda
    }
    
    public void act()
    {
        bodyBlock();
    }
    //METODO QUE IMPEDE A PASSAGEM DOS PERSONAGENS
    public void bodyBlock()
    {
        jogadores = getIntersectingObjects(Players.class); //Poe na ArrayList jogadores que tocarem
        //Bloqueia empurrando para esquerda
        if(blockSide==false)
        {
            for(int i=0; i<jogadores.size(); i++)
            {
                jogadores.get(i).setLocation(jogadores.get(i).getX() - 3, jogadores.get(i).getY());
            }
        }
        //Bloqueia empurrando para direita
        if(blockSide==true){
            for(int i=0; i<jogadores.size(); i++)
            {
                jogadores.get(i).setLocation(jogadores.get(i).getX() + 3, jogadores.get(i).getY());
            }
        }
    }
}