import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rei here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rei extends Pecas
{
    public Rei(boolean green){
        super(green);
    }
    
    public void act()
    {
        super.Clicked();
    }
    
    public void Movement(){
        int posLine = mv.keyFinderX(getY());
        int posColumn = mv.keyFinderY(getX());
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(super.checkPosition(posColumn + (i - 1), posLine + (j - 1))){
                    getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + (i - 1)), mv.linhas.get(posLine + (j - 1)));
                }
            }
        }
    }
}
