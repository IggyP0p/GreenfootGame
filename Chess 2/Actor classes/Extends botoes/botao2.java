import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botao2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class botao2 extends botoes
{
    public botao2(){
        super.botao1 = new GreenfootImage("botao_2players.png");
        super.botao2 = new GreenfootImage("botao_2players_2.png");
    }
    
    public void act()
    {
        super.mouseOn();
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Board());
        }
    }
}
