import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kill extends Focus
{
    public Kill(Pecas invocador){
        super(invocador);

    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Actor enemy = getOneObjectAtOffset(0, 0, Pecas.class);
            getWorld().removeObject(enemy);
            
            peca.setLocation(getX(), getY());
            
            super.confirmMove();
            super.pawnSpecialMove();
        }
        
        super.delete();
    }
}
