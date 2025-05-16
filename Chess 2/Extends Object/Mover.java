import java.util.HashMap;
import java.util.Map;

/**
 * Mover is a class created to make chess pieces work
 * 
 * CowboyIggy (Greenfoot) 
 * @1.0 (15/05/2025)
 */

/*
     * Posições no Board de Xadrez: Coluna = X; Linha = Y.
     * | AAA | 181 | 215 | 249 | 283 | 317 | 351 | 385 | 419 |
     * | 082 |
     * | 114 |
     * | 147 |
     * | 181 |
     * | 215 | 
     * | 249 | 
     * | 283 |
     * | 316 |
      */
     
public class Mover  
{
    public Map<Integer,Integer> linhas = new HashMap<Integer,Integer>();
    public Map<Integer,Integer> colunas = new HashMap<Integer,Integer>();

    public Mover()
    {
        //Inicializando as linhas do tabuleiro
        linhas.put(1, 82);  //32
        linhas.put(2, 114); //33
        linhas.put(3, 147); //34
        linhas.put(4, 181); //34
        linhas.put(5, 215); //34
        linhas.put(6, 249); //34
        linhas.put(7, 283); //33
        linhas.put(8, 316);
        
        //Inicializando as colunas do tabuleiro
        colunas.put(1, 181); //34
        colunas.put(2, 215); 
        colunas.put(3, 249); 
        colunas.put(4, 283);
        colunas.put(5, 317);
        colunas.put(6, 351);
        colunas.put(7, 385);
        colunas.put(8, 419);
    }
    
    /* At the beggining of the game the pieces will use these methods so they will know
     * what are their position.
     * 
     */
    public int keyFinderX(int posX){
        int key=0;
        
        for(Map.Entry<Integer, Integer> entry : linhas.entrySet()){
            if(entry.getValue() == posX){
                key = entry.getKey();
            }
        }
        
        return key;
    }
    public int keyFinderY(int posY){
        int key=0;
        
        for(Map.Entry<Integer, Integer> entry : colunas.entrySet()){
            if(entry.getValue() == posY){
                key = entry.getKey();
            }
        }
        
        return key;
    }
    
    /*The pieces will give their actual position to the Mover Class, 
     *the positions are the keys of the Hashmap (Board)
     * 
     * 
     *@posX
     *@posY
     */
    public int[] getPosition(int posX, int posY){
        int column = colunas.get(posX);
        int line = linhas.get(posY);
        
        return new int[] { column, line};
    }
}