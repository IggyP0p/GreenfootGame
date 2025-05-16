import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cavalo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cavalo extends Pecas
{
    public Cavalo(boolean green){
        super(green);
    }
    
    public void act()
    {
        super.Clicked();
    }
    
    public void Movement(){
        int posLine = mv.keyFinderX(getY());
        int posColumn = mv.keyFinderY(getX());
        
        //O L da direita, superior e inferior respectivamente
        if(super.checkPosition(posColumn + 2, posLine - 1))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + 2), mv.linhas.get(posLine - 1));
        if(super.checkPosition(posColumn + 2, posLine + 1))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + 2), mv.linhas.get(posLine + 1));
        
        //O L da esquerda, superior e inferior respectivamente
        if(super.checkPosition(posColumn - 2, posLine - 1))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn - 2), mv.linhas.get(posLine - 1));
        if(super.checkPosition(posColumn - 2, posLine + 1))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn - 2), mv.linhas.get(posLine + 1));
        
        //O L de cima, direita e esquerda, respectivamente
        if(super.checkPosition(posColumn + 1, posLine - 2))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + 1), mv.linhas.get(posLine - 2));
        if(super.checkPosition(posColumn - 1, posLine - 2))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn - 1), mv.linhas.get(posLine - 2));
        
        //O L de baixo, direita e esquerda, respectivamente
        if(super.checkPosition(posColumn + 1, posLine + 2))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn + 1), mv.linhas.get(posLine + 2));
        if(super.checkPosition(posColumn - 1, posLine + 2))getWorld().addObject(new Focus(this), mv.colunas.get(posColumn - 1), mv.linhas.get(posLine + 2));
        
    }
}
