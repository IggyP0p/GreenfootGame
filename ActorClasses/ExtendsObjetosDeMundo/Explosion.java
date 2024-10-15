import greenfoot.*; 

public class Explosion extends ObjetosDeMundo
{
    private GreenfootImage[] act = new GreenfootImage[5]; //Imagens da explosão
    private int animationCounter=0; //corre a array da explosão
    public Jbl sound; //som da explosão
    
    public Explosion()
    {
        inicioAnimacao();
        sound = new Jbl();
        sound.explosion.play();
    }
    //Explode e some
    public void act()
    {
        explooosion();
        animationCounter++;
    }
    //seta a array de animação
    public void inicioAnimacao()
    {   
        for(int i=0; i<act.length; i++)
        {
            act[i] = new GreenfootImage("killerqueen"+i+".png");
        }
    }
    //Metodo que seta a imagem da explosão e tira do mundo
    public void explooosion()
    {
        if(animationCounter != 0 && animationCounter % 5 == 0)
        {
            getWorld().removeObject(this);
        }
        setImage(act[animationCounter % 5]);
    }
}