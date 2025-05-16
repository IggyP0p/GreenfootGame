import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    public void prepare(){
        addObject(new botao1(), getWidth()/2, getHeight()/2);
        addObject(new botao2(), getWidth()/2, getHeight()/2 + 60);
    }
}
