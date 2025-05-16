import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Board extends World
{
    Rei kingGreen = new Rei(true);
    Rei kingBlue = new Rei(false);
    
    public Board()
    {    
        super(600, 400, 1);
        
        prepare(); //Posiciona todas as peças no jogo
    }
    
    /*
     * Posições no Board de Xadrez: 
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
    public void prepare(){
        //Lado azul do board
        addObject(new Peao(false), 181, 114);
        addObject(new Peao(false), 215, 114);
        addObject(new Peao(false), 249, 114);
        addObject(new Peao(false), 283, 114);
        addObject(new Peao(false), 317, 114);
        addObject(new Peao(false), 351, 114);
        addObject(new Peao(false), 385, 114);
        addObject(new Peao(false), 419, 114);
        
        addObject(new Torre(false), 181, 82);
        addObject(new Torre(false), 419, 82);
        
        addObject(new Bispo(false), 215, 82);
        addObject(new Bispo(false), 385, 82);
        
        addObject(new Cavalo(false), 249, 82);
        addObject(new Cavalo(false), 351, 82);
        
        addObject(new Rainha(false), 317, 82);
        addObject(kingBlue, 283, 82);
        
        
        //Lado verde do board
        addObject(new Peao(true), 181, 283);
        addObject(new Peao(true), 215, 283);
        addObject(new Peao(true), 249, 283);
        addObject(new Peao(true), 283, 283);
        addObject(new Peao(true), 317, 283);
        addObject(new Peao(true), 351, 283);
        addObject(new Peao(true), 385, 283);
        addObject(new Peao(true), 419, 283);
        
        addObject(new Torre(true), 181, 316);
        addObject(new Torre(true), 419, 316);
        
        addObject(new Bispo(true), 215, 316);
        addObject(new Bispo(true), 385, 316);
        
        addObject(new Cavalo(true), 249, 316);
        addObject(new Cavalo(true), 351, 316);
        
        addObject(new Rainha(true), 317, 316);
        addObject(kingGreen, 283, 316);
    }
}
