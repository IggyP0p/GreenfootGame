import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jogar extends MenuBotoes
{
    GreenfootImage botao1 = new GreenfootImage("botaoJogar1.png");
    GreenfootImage botao2 = new GreenfootImage("botaoJogar2.png");
    GreenfootSound bgMusic = new GreenfootSound("PraiaCarry SoundTrack.mp3");
    public GreenfootSound menuSound = new GreenfootSound("Menu Theme.mp3");
    
    public void act()
    {
        mouseOn();
        click();
        if (getWorld() != null) menuSound.play();
    }
    
    public void mouseOn()
    {
        if(Greenfoot.mouseMoved(this))setImage(botao2);
        if(!Greenfoot.mouseMoved(this) && Greenfoot.mouseMoved(null))
        {
            setImage(botao1);
        }
    }
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            World myWorld = getWorld();
            myWorld.addObject(new Intro(), 300, 1078);
            menuSound.stop();
            bgMusic.play();
            getWorld().removeObject(this);
        }
    }
}