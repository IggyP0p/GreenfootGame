import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Plataforma extends Actor
{
    public List<Players> playerAbove = new ArrayList<Players>();
    public List<Torretas> TorretaAbove = new ArrayList<Torretas>();
    public int vSpeed=0;
    public int speed=3;
    public int distancia;
    public int limiteContagem = 100;
    public int contagem;
    public boolean reverse;
    
    public void movementY()
    {
        if(reverse == false)
        {
            if(contagem < distancia)setLocation(getX(), getY() + vSpeed);
            if(contagem > distancia)setLocation(getX(), getY() - vSpeed);
        }
    }
    
    public void movementX()
    {
        if(reverse == false)
        {
            if(contagem < distancia)setLocation(getX() + speed, getY());
            if(contagem > distancia)setLocation(getX() - speed, getY());
        }
    }
    
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
    
    public void movementYrev()
    {
        if(reverse == true)
        {
            if(contagem > distancia)setLocation(getX(), getY() + vSpeed);
            if(contagem < distancia)setLocation(getX(), getY() - vSpeed);
        }
    }
    
    public void movementXrev()
    {
        if(reverse == true)
        {
        if(contagem > distancia)setLocation(getX() + speed, getY());
        if(contagem < distancia)setLocation(getX() - speed, getY());
        }
    }
    
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
    
    public void TorretaAboverev()
    {
        if(reverse == true)
        {
            Actor p = getOneIntersectingObject(Torreta.class);
            if(p != null && contagem > distancia)p.setLocation(p.getX()+speed, p.getY()+vSpeed);
            if(p != null && contagem < distancia)p.setLocation(p.getX()-speed, p.getY()-vSpeed);
        }
    }
    
    public void TorretaAbove()
    {
        if(reverse == false)
        {
            Actor p = getOneIntersectingObject(Torreta.class);
            if(p != null && contagem < distancia)p.setLocation(p.getX()+speed, p.getY()+vSpeed);
            if(p != null && contagem > distancia)p.setLocation(p.getX()-speed, p.getY()-vSpeed);
        }
    }
    
    public void resetContagem(){if(contagem == limiteContagem)contagem=0;}
}