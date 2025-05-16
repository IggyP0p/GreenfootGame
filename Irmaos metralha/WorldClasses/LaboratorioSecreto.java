import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LaboratorioSecreto extends World
{
    public static final int WIDE = 600;
    public static final int HIGH = 400;
    Jbl sound = new Jbl();
    MenuBotoes mb;
    Scroller scroller;
    Players p1;
    Players p2;
    
    public LaboratorioSecreto()
    {    
        super(WIDE, HIGH, 1, false); //Configurações do mundo
        GreenfootImage bg = new GreenfootImage("Fase do Laboratorio.png"); //Imagem de fundo
        prepare(); //Metodo que adiciona todos os objetos do mapa
        
        int bgWide = bg.getWidth(); //Tamanho horizontal da Imagem de fundo
        int bgHigh = bg.getHeight();//Tamanho vertical da Imagem de fundo
        scroller = new Scroller(this, bg, 2400, 400); //Instanciando a classe do rolamento
        
        if(mb.hard == true)
        {
            p1 = new Player1(3); //Instanciando player 1 hard mode
            p2 = new Player2(3); //Instanciando player 2 hard mode
        } else
        {
            p1 = new Player1(); //Instanciando player 1 easy mode
            p2 = new Player2(); //Instanciando player 2 easy mode
        }
        
        addObject(p2, 170, 310); //Colocando eles no mundo
        addObject(p1, 110, 310); //Colocando eles no mundo
     
        //addObject(p2, 1500, 300); //POSIÇÃO DE TESTE
        
        Players.leader = null;
        
        sound.florestaST.stop();
        sound.dramaST.play();
    }
    
    public void act()
    {
        if (Players.leader == null) return; //Impede que o NullPointException ocorra
        //scroller.scroll(Players.leader.getX()-getWidth()/2, 0); //ponto do mapa onde ocorre o rolamento
        scroller.stopScroll();
        arena();
    }
    
    public void started()
    {
        sound.florestaST.stop();
        sound.dramaST.play();
    }
    
    public void arena()
    {
        if(scroller.getScrolledX() == 1799)
        {
            addObject(new Chain(true), -8, 200);
            addObject(new Chain(false), 608, 200);
        }
    }
    
    public void prepare()
    {
        addObject(new Chain(true), -8, 200);
        
        addObject(new Piso(), 300, 371);
        addObject(new Piso(), 900, 371);
        addObject(new Piso(), 1500, 371);
        addObject(new Piso(), 2100, 371);
        
        addObject(new Mesa1(), 300, 284);
        addObject(new Mesa4(), 200, 284);
        //addObject(new Mesa3(), 100, 291);
        //addObject(new Mesa1(), 500, 284);
        addObject(new Mesa2(), 700, 284);
        //addObject(new Mesa4(), 600, 284);
        addObject(new Mesa1(), 1000, 284);
        //addObject(new Mesa2(), 1200, 284);
        addObject(new Mesa3(), 1400, 291);
        addObject(new Mesa4(), 1700, 284);
        //addObject(new Mesa2(), 2000, 284);
        addObject(new Mesa3(), 2100, 291);
        addObject(new Estante1(), 400, 276);
        addObject(new Estante2(), 800, 276);
        //addObject(new Estante1(), 900, 276);
        addObject(new Estante2(), 1100, 276);
        //addObject(new Estante2(), 1300, 276);
        addObject(new Estante1(), 1500, 276);
        addObject(new Estante2(), 1600, 276);
        //addObject(new Estante1(), 1800, 276);
        //addObject(new Estante1(), 1900, 276);
        addObject(new Estante1(), 2200, 276);
        //addObject(new Estante2(), 2300, 276);
        
        addObject(new Lua(), 300, 200);
        
        addObject(new Cientista(), 2270, 290);
        
        addObject(new NuvensNoite(), 300, 200);
        addObject(new NuvensNoite(), 900, 200);
        addObject(new NuvensNoite(), 1500, 200);
        addObject(new NuvensNoite(), 2100, 200);
    }
}
