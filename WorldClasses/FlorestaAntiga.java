import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlorestaAntiga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlorestaAntiga extends World
{
    public static final int WIDE = 600;
    public static final int HIGH = 400;
    Scroller scroller;
    Players p1;
    Players p2;
    
    public FlorestaAntiga()
    {    
        super(WIDE, HIGH, 1, false); //Configurações do mundo
        GreenfootImage bg = new GreenfootImage("Fase da Floresta.png"); //Imagem de fundo
        prepare(); //Metodo que adiciona todos os objetos do mapa
        
        int bgWide = bg.getWidth(); //Tamanho horizontal da Imagem de fundo
        int bgHigh = bg.getHeight();//Tamanho vertical da Imagem de fundo
        scroller = new Scroller(this, bg, 5000, 400); //Instanciando a classe do rolamento
        p1 = new Player1(); //Instanciando player 1
        p2 = new Player2(); //Instanciando player 2
        addObject(p2, 170, 300); //Colocando eles no mundo
        addObject(p1, 110, 300); //Colocando eles no mundo
     
        //addObject(p2, 2700, 300); //POSIÇÃO DE TESTE
        //addObject(p2, 4700, 300); //POSIÇÃO DE TESTE
        //addObject(p2, 5800, 300); //POSIÇÃO DE TESTE
        
        Players.leader = null;
    }
    
    public void act()
    {
        if (Players.leader == null) return; //Impede que o NullPointException ocorra
        scroller.scroll(Players.leader.getX()-getWidth()/2, 0); //ponto do mapa onde ocorre o rolamento
    }
    
    public void prepare()
    {
        addObject(new Terra1(), 300, 366);
        addObject(new Terra1(), 900, 366);
        addObject(new Terra1(), 1500, 366);
        addObject(new Terra1(), 2100, 366);
        addObject(new Terra1(), 2700, 366);
        addObject(new Terra1(), 3300, 366);
        addObject(new Terra1(), 3900, 366);
        addObject(new Terra1(), 4500, 366);
        addObject(new Terra1(), 5100, 366);
        addObject(new Flag(), 140, 300);
        
        addObject(new Masqueico(), 300, 104);
        
        addObject(new Masqueico(), 253 + 600, 116);
        
        addObject(new Masqueico(), 371 + 600, 109);
        
        addObject(new Masqueico(), 84 + 1200, 145);
        
        addObject(new Masqueico(), 300 + 1200, 104);
        
        addObject(new Masqueico(), 535 + 1200, 144);
        
        addObject(new Masqueico(), 253 + 1800, 116);
        
        addObject(new Masqueico(), 371 + 1800, 109);
        
        addObject(new Masqueico(), 253 + 2400, 116);
        
        addObject(new Masqueico(), 535 + 2400, 144);
        
        addObject(new Masqueico(), 84 + 3600, 145);
        addObject(new Masqueico(), 300 + 3600, 104);
        addObject(new Masqueico(), 535 + 3600, 144);
        
        addObject(new Masqueico(), 300 + 4200, 104 + 4200);
    }
}
