import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class MovingAreia extends Plataforma
{
    //Define especificamente a movimentação horizontal e vertical
    public MovingAreia(int distancia, int speed, int vSpeed, boolean rev)
    {
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.speed = speed;
        this.vSpeed = vSpeed;
        this.reverse = rev;
    }
    //Se mexe de um lado pra outro
    //@param rev define o inicio do movimento, false == direita esquerda, true == esquerda direita
    public MovingAreia(int distancia, boolean rev)
    {
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.reverse = rev;
    }
    
    public void act()
    {
        contagem++;
        movementX(); //movimenta horizontalmente, direita esquerda
        movementY(); //movimenta verticalmente, direita esquerda
        movementXrev(); //movimenta horizontalmente, esquerda direita
        movementYrev(); //movimenta verticalmente, esquerda direita
        aboveRev(); //Detecta personagens acima, esquerda direita
        above(); //Detecta personagens acima, direita esquerda
        resetContagem(); //muda a direção do movimento baseado na contagem
        TorretaAbove(); //Detecta torretas acima, direita esquerda
        TorretaAboverev(); //Detecta torretas acima, esquerda direita
    }
}