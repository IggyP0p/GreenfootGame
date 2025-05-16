import java.util.List;
import java.util.ArrayList;

public abstract class Pecas extends Actor
{
    private List<Focus> focuses = new ArrayList<Focus>();
    public List<Pecas> pecas = new ArrayList<Pecas>();
    private String className = getClass().getName().toString();
    protected boolean green;
    Mover mv = new Mover();
    public static boolean move = false; //Responde se uma peça se moveu, false = turno verde, true = turno azul
    protected static Pecas piece;
    
    public Pecas(boolean green){
        this.green = green;

        if (!green)setImage(className + "_azul.png");
    }
    
    //Rotina para cancelar o movimento e faze-lo se movimentar
    public void  Clicked(){        
        if((move == false) && (Greenfoot.mouseClicked(this)) && (this.green == true)){
            if(piece!=null)piece.Cancel();
            
            piece = this;
            piece.Movement();
            
        } else if((move == true) && (Greenfoot.mouseClicked(this)) && (this.green == false)){
            if(piece!=null)piece.Cancel();
            
            piece = this;
            piece.Movement();
            
        }      
    }
    
    protected void Cancel(){
        focuses = getWorld().getObjects(Focus.class);
            
        for(int i=0; i< focuses.size(); i++){
            getWorld().removeObject(focuses.get(i));
        }
    }
    
    protected boolean checkPosition(int Column, int Line){
        //Garantees that the positions exists on the board
        if((Column < 1) || (Column > 8) || (Line < 1) || (Line > 8))return false;
        
        int position[] = mv.getPosition(Column, Line);
        pecas = getWorld().getObjects(Pecas.class);
        
        for(int i=0; i<pecas.size(); i++){
            if((pecas.get(i).getX() == position[0]) && (pecas.get(i).getY() == position[1])){
                if(this.green != pecas.get(i).green){
                    getWorld().addObject(new Kill(this), position[0], position[1]);
                    
                }
                
                return false;
            }
        }
        
        return true;
    }
    
    abstract void Movement();
}
