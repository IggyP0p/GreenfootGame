import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;

public class Botao extends Cenario
{
    public List<Chain> portao = new ArrayList<Chain>();
    GreenfootImage[] pressed = new GreenfootImage[2];
    public int rotation;
    
    public Botao(int rotation)
    {
        inicioAnimacao();
        rotation(rotation);
    }
    
    public void act()
    {
        animateBeingPressed();
        //blockChain();
        abreCaminho();
    }

    public void abreCaminho()
    {
        portao = getObjectsInRange(300, Chain.class);
        if(buttonPressed())
        {
            for(int i=0; i<portao.size(); i++)
            {
                World myWorld = getWorld();
                myWorld.removeObject(portao.get(i));
            }
        }
    }
    
    public void blockChain()
    {
        if(buttonPressed())removeTouching(Chain.class);
    }
    
    public boolean buttonPressed()
    {
        if(isTouching(Players.class))return true;
        return false;
    }
    
    public void rotation(int rotation)
    {
        this.setRotation(rotation);
    }
    
    public void inicioAnimacao()
    {
        pressed[0] = new GreenfootImage("botaoNovo.png");
        pressed[1] = new GreenfootImage("botaoNovo2.png");
    }
    
    public void animateBeingPressed()
    {
        if(isTouching(Players.class))setImage(pressed[1]);
    }
}