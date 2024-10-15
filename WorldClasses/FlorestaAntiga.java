import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlorestaAntiga extends World
{
    public static final int WIDE = 600;
    public static final int HIGH = 400;
    Jbl sound = new Jbl();
    MenuBotoes mb;
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
        
        if(mb.hard == true)
        {
            p1 = new Player1(3); //Instanciando player 1 hard mode
            p2 = new Player2(3); //Instanciando player 2 hard mode
        } else
        {
            p1 = new Player1(); //Instanciando player 1 easy mode
            p2 = new Player2(); //Instanciando player 2 easy mode
        }
        
        addObject(p2, 170, 300); //Colocando eles no mundo
        addObject(p1, 110, 300); //Colocando eles no mundo
     
        //addObject(p2, 2700, 300); //POSIÇÃO DE TESTE
        //addObject(p2, 4700, 300); //POSIÇÃO DE TESTE
        addObject(new Fase2Endgame2(), 4900, 200);
        Players.leader = null;
        
        sound.praiaST.stop();
        sound.florestaST.play();
    }
    
    public void act()
    {
        if (Players.leader == null) return; //Impede que o NullPointException ocorra
        scroller.scroll(Players.leader.getX()-getWidth()/2, 0); //ponto do mapa onde ocorre o rolamento
    }
    
    public void prepare()
    {
        addObject(new Chain(true), -8, 200);
        
        addObject(new Flag(), 140, 300); //CHECKPOINT 1
        
        addObject(new Terra1(), 300, 366); // 600 628
        
        addObject(new stakes(), 628, 376); //ESTACA NUMERO 1
        addObject(new fakeTerra(), 628, 366);
        
        addObject(new Terra1(), 956, 366); // 1256 1284 1612
        
        addObject(new stakes(), 1284, 376); //ESTACA NUMERO 2
        addObject(new fakeTerra(), 1284, 366);
        
        addObject(new Terra1(), 1612, 366); //1912 1940 2268
        
        addObject(new stakes(), 1940, 376); //ESTACA NUMERO 3
        addObject(new fakeTerra(), 1940, 366);
        
        addObject(new Terra1(), 2268, 366); // 2568 2596 2924
        
        addObject(new Flag(), 2500, 300); //CHECKPOINT 2
        
        addObject(new stakes(), 2596, 376); //ESTACA NUMERO 4
        addObject(new fakeTerra(), 2596, 366);
        
        addObject(new Terra1(), 2924, 366); //3224 3252 3280 3580
        
        addObject(new stakes(), 3252, 376); //ESTACA NUMERO 5
        addObject(new fakeTerra(), 3252, 366);
        
        addObject(new Terra1(), 3580, 366); // 3880 3908 3936 3964 3992 4292
        
        addObject(new stakes(), 3908, 376); //ESTACA NUMERO 6
        addObject(new fakeTerra(), 3908, 366);
        
        addObject(new stakes(), 3954, 376); //ESTACA NUMERO 7
        addObject(new fakeTerra(), 3954, 366);
        
        addObject(new Terra1(), 4282, 366); //4592
        
        addObject(new Terra1(), 4882, 366); 
        
        //Macacos
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
        
        addObject(new Masqueico(), 300 + 4200, 104);
        
        addObject(new Fase2Endgame1(), 4900, 200);
        addObject(new NextLevel(2), 4960, 300);
    }
}