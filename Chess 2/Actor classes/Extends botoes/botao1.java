import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botao1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class botao1 extends botoes
{
    public botao1(){
        super.botao1 = new GreenfootImage("botao_1player.png");
        super.botao2 = new GreenfootImage("botao_1player_2.png");
    }
    
    public void act()
    {
        super.mouseOn();
    }
}
