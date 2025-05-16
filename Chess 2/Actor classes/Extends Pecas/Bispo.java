import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bispo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bispo extends Pecas
{
    public Bispo(boolean green){
        super(green);
    }
    
    public void act()
    {
        super.Clicked();
    }
    
    public void Movement(){
        int posLine = mv.keyFinderX(getY());
        int posColumn = mv.keyFinderY(getX());
        //Diagonal superior esquerda
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn - increment, posLine - increment))break;
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn - increment), mv.linhas.get(posLine - increment));
        }
        //Diagonal superior direita
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn + increment, posLine - increment))break;
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + increment), mv.linhas.get(posLine - increment));
        }
        //Diagonal inferior esquerda
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn - increment, posLine + increment))break;
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn - increment), mv.linhas.get(posLine + increment));
        }
        //Diagonal inferior direita
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn + increment, posLine + increment))break;
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + increment), mv.linhas.get(posLine + increment));
        }
    }
}
