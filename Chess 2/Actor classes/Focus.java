import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Focus extends Actor
{
    Pecas peca;
    public int positionX;
    public int positionY;
    
    public Focus(Pecas invocador){
        this.peca = invocador;
        positionX = invocador.getX();
        positionY = invocador.getY();
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            peca.setLocation(getX(), getY());
            
            confirmMove();
            pawnSpecialMove();
        }
        
        delete();
    }
    
    public void confirmMove(){
        if(peca.green){
            peca.move = true;
        }
        else{
            peca.move = false;
        }
    }
    
    public void pawnSpecialMove(){
        if(peca.getClass().getName() == "Peao"){
            Peao pawn = (Peao)peca;
            pawn.firstMove = false;
        }
    }
    
    public void delete(){
        if((peca.getX() != positionX) || (peca.getY() != positionY)){
            getWorld().removeObject(this);
        }
    }
}
