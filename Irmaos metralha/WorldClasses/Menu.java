import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{   
    private Jbl sound = new Jbl();
    int count=20;
    
    public Menu()
    {    
        super(600, 400, 1, false);
        Jbl sound = new Jbl();
        
        addObject(new Nuvens1(), 300, 200);
        addObject(new Nuvens2(), 300, 200);
        addObject(new Nuvens3(), 300, 200);
        addObject(new Titulo(), 300, 200);
        addObject(new Jogar(), 300, 250);
        //addObject(new Som(), 300, 350);
        addObject(new Dificuldade(), 300, 300);
    }
    
    public void started()
    {
        sound.menuST.play();
    }
    
    public void stopped()
    {
        sound.menuST.stop();
        sound.praiaST.stop();
    }
}