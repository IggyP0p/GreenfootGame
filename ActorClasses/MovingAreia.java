import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class MovingAreia extends Plataforma
{
    public MovingAreia(int distancia, int speed, int vSpeed, boolean rev)
    {
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.speed = speed;
        this.vSpeed = vSpeed;
        this.reverse = rev;
    }
    
    public MovingAreia(int distancia, boolean rev)
    {
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.reverse = rev;
    }
    
    public void act()
    {
        contagem++;
        movementX();
        movementY();
        movementXrev();
        movementYrev();
        aboveRev();
        above();
        resetContagem();
        TorretaAbove();
        TorretaAboverev();
    }
}
