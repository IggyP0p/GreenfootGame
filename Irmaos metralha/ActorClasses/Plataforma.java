import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/*
 * Superclasse das plataformas do jogo
 */
public class Plataforma extends Actor
{
    public List<Players> playerAbove = new ArrayList<Players>(); //ArrayList de Players
    public List<Torretas> TorretaAbove = new ArrayList<Torretas>(); //ArrayList de Torretas
    public int vSpeed=0; 
    public int speed=3;
    public int distancia;
    public int limiteContagem = 100;
    public int contagem;
    public boolean reverse; //Define para qual lado começa o movimento da plataforma
    //Movimenta a plataforma pra cima e pra baixo. Iniciando de baixo pra cima
    public void movementY()
    {
        if(reverse == false)
        {
            if(contagem < distancia)setLocation(getX(), getY() + vSpeed);
            if(contagem > distancia)setLocation(getX(), getY() - vSpeed);
        }
    }
    //Movimenta plataforma de um lado pro outro. Iniciando da Direita pra esquerda
    public void movementX()
    {
        if(reverse == false)
        {
            if(contagem < distancia)setLocation(getX() + speed, getY());
            if(contagem > distancia)setLocation(getX() - speed, getY());
        }
    }
    //Reconhece se um jogador esta acima da plataforma e o move junto
    public void above()
    {
        if(reverse == false)
        {
            playerAbove = getObjectsInRange(100, Players.class);
            for(int i=0; i<playerAbove.size(); i++)
            {
                if(contagem < distancia)
                {
                    playerAbove.get(i).setLocation(playerAbove.get(i).getX()+speed, playerAbove.get(i).getY()+vSpeed);
                }
                if(contagem > distancia)
                {
                    playerAbove.get(i).setLocation(playerAbove.get(i).getX()-speed, playerAbove.get(i).getY()-vSpeed);
                }
            }
        }
    }
    //Movimenta a plataforma pra cima e pra baixo. Iniciando de cima pra baixo
    public void movementYrev()
    {
        if(reverse == true)
        {
            if(contagem > distancia)setLocation(getX(), getY() + vSpeed);
            if(contagem < distancia)setLocation(getX(), getY() - vSpeed);
        }
    }
    //Movimenta plataforma de um lado pro outro. Iniciando da Direita pra esquerda
    public void movementXrev()
    {
        if(reverse == true)
        {
        if(contagem > distancia)setLocation(getX() + speed, getY());
        if(contagem < distancia)setLocation(getX() - speed, getY());
        }
    }
    //Reconhece se um jogador esta acima da plataforma e o move junto
    public void aboveRev()
    {
        if(reverse == true)
        {
            playerAbove = getObjectsInRange(100, Players.class);
            for(int i=0; i<playerAbove.size(); i++)
            {
                if(contagem > distancia)
                {
                    playerAbove.get(i).setLocation(playerAbove.get(i).getX()+speed, playerAbove.get(i).getY()+vSpeed);
                }
                if(contagem < distancia)
                {
                    playerAbove.get(i).setLocation(playerAbove.get(i).getX()-speed, playerAbove.get(i).getY()-vSpeed);
                }
            }
        }
    }
    //Reconhece se uma torreta esta acima da plataforma e a move junto
    public void TorretaAboverev()
    {
        if(reverse == true)
        {
            Actor p = getOneIntersectingObject(Torreta.class);
            if(p != null && contagem > distancia)p.setLocation(p.getX()+speed, p.getY()+vSpeed);
            if(p != null && contagem < distancia)p.setLocation(p.getX()-speed, p.getY()-vSpeed);
        }
    }
    //Reconhece se uma torreta esta acima da plataforma e a move junto
    public void TorretaAbove()
    {
        if(reverse == false)
        {
            Actor p = getOneIntersectingObject(Torreta.class);
            if(p != null && contagem < distancia)p.setLocation(p.getX()+speed, p.getY()+vSpeed);
            if(p != null && contagem > distancia)p.setLocation(p.getX()-speed, p.getY()-vSpeed);
        }
    }
    //Reseta o movimento da plataforma
    public void resetContagem(){if(contagem == limiteContagem)contagem=0;}
}