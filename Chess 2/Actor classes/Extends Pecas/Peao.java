import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Peao extends Pecas
{
    Mover mv = new Mover();
    public boolean firstMove = true;
    
    //Construtor da superclasse responsável por definir a cor e time da peça
    public Peao(boolean green){
        super(green);
    }
    
    public void act()
    {
        super.Clicked();
    }
    //Reescrita do metodo para o Peão pois a peça pula 2 casas na primeira jogada e mata pelas verticais
    public boolean checkPosition(int Column, int Line){
        //Garantees that the positions exists on the board
        if((Column < 1) || (Column > 8) || (Line < 1) || (Line > 8))return false;
        
        int position[] = mv.getPosition(Column, Line); // Transforma as posições de chaves para valores
        
        pecas = getWorld().getObjects(Pecas.class); // Pega todas as peças do tabuleiro
        
        for(int i=0; i<pecas.size(); i++){
            if((pecas.get(i).getX() == position[0]) && (pecas.get(i).getY() == position[1])){
                return false;
            }
        }
        
        return true;
    }
    //Tive que criar um metodo apenas para a Kill do peão infelizmente
    public void checkKill(int Column, int Line){
        //Garantees that the positions exists on the board
        if((Column < 1) || (Column > 8) || (Line < 1) || (Line > 8))return;
        
        int position[] = mv.getPosition(Column, Line); // Transforma as posições de chaves para valores
        
        pecas = getWorld().getObjects(Pecas.class); // Pega todas as peças do tabuleiro
        
        for(int i=0; i<pecas.size(); i++){
            //Kill da esquerda do Peão
            if((pecas.get(i).getX() == position[0] - 34) && (pecas.get(i).getY() == position[1])){
                if(this.green != pecas.get(i).green){
                    getWorld().addObject(new Kill(this), position[0] - 34, position[1]);
                    
                }
            }
            //Kill da direita do Peão
            if((pecas.get(i).getX() == position[0] + 34) && (pecas.get(i).getY() == position[1])){
                if((this.green != pecas.get(i).green)){
                    getWorld().addObject(new Kill(this), position[0] + 34, position[1]);
                    
                }
            }
        }
    }
    //Metodo responsável pelo movimento do peão
    public void Movement(){
        int posLine = mv.keyFinderX(getY()); //Pega a posição atual no tabuleiro
        int posColumn = mv.keyFinderY(getX()); //Pega a posição atual no tabuleiro
        
        //INFELIZMENTE FOI PRECISO FAZER IF DENTRO DE IF DENTRO DE IF
        if(super.green == true){ //Checa se a peça é verde para mover de baixo pra cima
            //Uma das regras especiais do Xadrez é o peão se movimentar 2 casas na primeira jogada
            if(firstMove == true){
                if((checkPosition(posColumn, posLine - 2)) && (checkPosition(posColumn, posLine - 1))){
                    getWorld().addObject(new Focus(this), mv.colunas.get(posColumn), mv.linhas.get(posLine - 2));
                }
            }
            
            if(checkPosition(posColumn, posLine - 1)){
                getWorld().addObject(new Focus(this), mv.colunas.get(posColumn), mv.linhas.get(posLine - 1));
            }
            
            checkKill(posColumn, posLine - 1);
        } else { //Caso não seja verde a peça se move de cima pra baixo
            //Uma das regras especiais do Xadrez é o peão se movimentar 2 casas na primeira jogada
            if(firstMove == true){
                if((checkPosition(posColumn, posLine + 2)) && (checkPosition(posColumn, posLine + 1))){
                    getWorld().addObject(new Focus(this), mv.colunas.get(posColumn), mv.linhas.get(posLine + 2));
                }
            }
            
            if(checkPosition(posColumn, posLine + 1)){
                getWorld().addObject(new Focus(this), mv.colunas.get(posColumn), mv.linhas.get(posLine + 1));
            }
            
            checkKill(posColumn, posLine + 1);
        }
    }
}
