import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    public Menu()
    {    
        super(600, 400, 1, false); 
        
        addObject(new Nuvens1(), 300, 200);
        addObject(new Nuvens2(), 300, 200);
        addObject(new Nuvens3(), 300, 200);
        addObject(new Titulo(), 300, 200);
        addObject(new Jogar(), 300, 250);
        addObject(new Som(), 300, 300);
        addObject(new NextLevel(0), 300, -1696);
    }
}
