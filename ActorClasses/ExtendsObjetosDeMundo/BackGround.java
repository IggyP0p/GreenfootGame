import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BackGround extends ObjetosDeMundo
{
    private int color = 0;

    /*
     * Cria um fundo preto transparente
     */
    public BackGround()
    {
        setImage(new GreenfootImage(600, 400));
        
        getImage().setColor(new Color(0, 0, 0));
        
        getImage().drawRect(0, 0, 600, 400);
        
        getImage().fillRect(1, 1, 600, 400);
        
        getImage().setTransparency(0);
    }
    //Diminui a trasparência
    public void act()
    {
        if(color != 255)color+=3;
        getImage().setTransparency(color);
    }
}