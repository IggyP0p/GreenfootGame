import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Torre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torre extends Pecas
{
    public Torre(boolean green){
        super(green);
    }
    
    public void act()
    {
        super.Clicked();
    }
    
    public void Movement(){
        int posLine = mv.keyFinderX(getY());
        int posColumn = mv.keyFinderY(getX());
        //Coluna cima
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn, posLine - increment)){
                //super.checkKill(posColumn, posLine - increment);
                break;
            }
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn), mv.linhas.get(posLine - increment));
        }
        //Coluna baixo
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn, posLine + increment))break;
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn), mv.linhas.get(posLine + increment));
        }
        //Lado direito
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn - increment, posLine))break;
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn - increment), mv.linhas.get(posLine));
        }
        //Lado direito
        for(int increment = 1; increment < 9; increment++){
            if(!super.checkPosition(posColumn + increment, posLine))break;
            getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + increment), mv.linhas.get(posLine));
        }
        
        
    }
}
