import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Areia2 extends Plataforma
{
    //Areia parada
    public Areia2()
    {
        this.speed = 0;
        this.vSpeed = 0;
    }
    //Areia que se movimenta
    public Areia2(int speed)
    {
        this.reverse = false;
        this.speed = 2;
        this.vSpeed = 0;
        this.distancia = 160;
        this.limiteContagem = distancia*2;
    }
    
    public void act()
    {
        if(speed == 0)return;
        TorretaAbove();
        Above();
        resetContagem();
        movementX();
        contagem++;
    }
    //Reescrita do metodo above para funcionar com várias torretas pequenas
    public void Above(){
        if(reverse == false)
        {
            TorretaAbove = getIntersectingObjects(Torretas.class);
            for(int i=0; i<TorretaAbove.size(); i++)
            {
                //vai para direita
                if(contagem < distancia)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()+speed, TorretaAbove.get(i).getY()+vSpeed);
                }
                //Corrige movimentação
                if(contagem == distancia)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()+speed,TorretaAbove.get(i).getY()+vSpeed);
                }
                //vai para esquerda
                if(contagem > distancia)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()-speed,TorretaAbove.get(i).getY()-vSpeed);
                }
                //Corrige movimentação
                if(contagem == limiteContagem)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()+speed,TorretaAbove.get(i).getY()+vSpeed);
                }
            }
        }
    }
}