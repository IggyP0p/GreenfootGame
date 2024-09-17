import java.util.ArrayList;
import java.util.List;

public class Areia2 extends Plataforma
{
    public Areia2()
    {
        this.speed = 0;
        this.vSpeed = 0;
    }
    
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
    
    public void Above(){
        if(reverse == false)
        {
            TorretaAbove = getIntersectingObjects(Torretas.class);
            for(int i=0; i<TorretaAbove.size(); i++)
            {
                if(contagem < distancia)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()+speed, TorretaAbove.get(i).getY()+vSpeed);
                }
                if(contagem == distancia)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()+speed,TorretaAbove.get(i).getY()+vSpeed);
                }
                if(contagem > distancia)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()-speed,TorretaAbove.get(i).getY()-vSpeed);
                }
                if(contagem == limiteContagem)
                {
                    TorretaAbove.get(i).setLocation(TorretaAbove.get(i).getX()+speed,TorretaAbove.get(i).getY()+vSpeed);
                }
            }
        }
    }
}