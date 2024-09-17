import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Cenario
{
    private GreenfootImage[] act = new GreenfootImage[5]; 
    private int animationCounter=0;
    
    public Explosion()
    {
        inicioAnimacao();
    }
    
    public void act()
    {
        explooosion();
        animationCounter++;
    }
    
    public void inicioAnimacao()
    {
        /*
        act[0]=new GreenfootImage("killerqueen0.png");
        act[1]=new GreenfootImage("killerqueen0.png");
        act[2]=new GreenfootImage("killerqueen0.png");
        act[3]=new GreenfootImage("killerqueen1.png");
        act[4]=new GreenfootImage("killerqueen1.png");
        act[5]=new GreenfootImage("killerqueen1.png");
        act[6]=new GreenfootImage("killerqueen2.png");
        act[7]=new GreenfootImage("killerqueen2.png");
        act[8]=new GreenfootImage("killerqueen2.png");
        act[9]=new GreenfootImage("killerqueen3.png");
        act[10]=new GreenfootImage("killerqueen3.png");
        act[11]=new GreenfootImage("killerqueen3.png");
        act[12]=new GreenfootImage("killerqueen4.png");
        act[13]=new GreenfootImage("killerqueen4.png");
        act[14]=new GreenfootImage("killerqueen4.png");
        */
       
        for(int i=0; i<act.length; i++)
        {
            act[i] = new GreenfootImage("killerqueen"+i+".png");
        }
    }
    
    public void explooosion()
    {
        if(animationCounter != 0 && animationCounter % 5 == 0)
        {
            getWorld().removeObject(this);
        }
        setImage(act[animationCounter % 5]);
    }
}
