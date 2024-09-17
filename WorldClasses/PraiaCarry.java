import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PraiaCarry extends World
{
    public static final int WIDE = 600; //Tamanho horizontal da tela visivel
    public static final int HIGH = 400; //Tamanho vertical da tela visivel
    Scroller scroller; //Ator que faz o rolamento do mundo
    Players p1; //Jogador 1
    Players p2; //Jogador 2
    
    public PraiaCarry()
    {    
        super(WIDE, HIGH, 1, false); //Configurações do mundo
        GreenfootImage bg = new GreenfootImage("Fase da Praia2.png"); //Imagem de fundo
        int bgWide = bg.getWidth(); //Tamanho horizontal da Imagem de fundo
        int bgHigh = bg.getHeight();//Tamanho vertical da Imagem de fundo
        scroller = new Scroller(this, bg, 8500, 400); //Instanciando a classe do rolamento
        p1 = new Player1(); //Instanciando player 1
        p2 = new Player2(); //Instanciando player 2
        addObject(p2, 170, 300); //Colocando eles no mundo
        addObject(p1, 110, 300); //Colocando eles no mundo
     
        //addObject(p2, 2700, 300); //POSIÇÃO DE TESTE
        //addObject(p2, 4700, 300); //POSIÇÃO DE TESTE
        //addObject(p2, 5800, 300); //POSIÇÃO DE TESTE
        
        prepare(); //Metodo que adiciona todos os objetos do mapa
        Players.leader = null;
    }
    
    public void act()
    {
        if (Players.leader == null) return; //Impede que o NullPointException ocorra
        scroller.scroll(Players.leader.getX()-getWidth()/2, 0); //ponto do mapa onde ocorre o rolamento
    }
    
    public void prepare()
    {
        for(int x=0; x<8; x++)
        {
            addObject(new Areia1(), x * 80 + 40, 566);
        }
        
        
        //COQUEIROS
        addObject(new Coqueiro(), 34, 274);
        addObject(new Coqueiro(), 375, 281);
        addObject(new Coqueiro(), 630, 288);
        addObject(new Coqueiro(), 950, 274);
        addObject(new Coqueiro(), 1050, 281);
        addObject(new Coqueiro(), 1270, 288);
        addObject(new Coqueiro(), 1450, 295);
        addObject(new Coqueiro(), 1880, 275);
        addObject(new Coqueiro(), 2600, 288);
        addObject(new Coqueiro(), 2840, 274);
        addObject(new Coqueiro(), 2999, 281);
        addObject(new Coqueiro(), 4710, 281);
        addObject(new Coqueiro(), 4900, 288);
        addObject(new Coqueiro(), 5150, 281);
        addObject(new Coqueiro(), 5600, 288);
        
        addObject(new Flag(), 140, 300);
        addObject(new SoldadoComFaca(100, false, true, 1), 640, 300);
        for(int x=0; x<8; x++)
        {
            addObject(new Areia1(), x * 80 + 40, 366);
        }
        //distância total = 640
        addObject(new Areia2(), 680, 383);
        addObject(new Areia1(), 760, 366);
        addObject(new Areia2(), 840, 383);
        addObject(new Areia1(), 920, 366);
        addObject(new Areia2(), 1000, 383);
        addObject(new Areia1(), 1080, 366);
        
        addObject(new Spike(), 680, 356);
        addObject(new Spike(), 840, 356);
        addObject(new Spike(), 1000, 356);
        
        for(int x=0; x<6; x++)
        {
            addObject(new Areia1(), x * 80 + 1160, 366);
        }
        addObject(new SoldadoComFaca(150, 3), 1040, 300);
        addObject(new SoldadoComFaca(150, 3), 1080, 300);
        
        //distância total = 1640
        addObject(new Flag(), 1585, 300);
        addObject(new Areia3(), 1720, 366);
        addObject(new Areia3(), 1880, 326);
        
        addObject(new MovingAreia(125, 2, 0, false), 2040, 326);
        
        addObject(new Areia3(), 2440, 366);
        addObject(new Torreta(), 2440, 313);
        
        for(int x=0; x<6; x++)
        {
            addObject(new Areia1(), x * 80 + 2600, 366);
        }
        
        for(int x=0; x<12; x++)
        {
            addObject(new Spike(), x * 80 + 1640, 390);
        }
        
        addObject(new Flag(), 2700, 300);
        addObject(new SoldadoM(), 3000, 300);
        
        for(int x=0; x<16; x++)
        {
            addObject(new Spike(), x * 80 + 3080, 390);
        }
        
        addObject(new MovingAreia(100, 0, 2, true), 3160, 300);
        addObject(new Caixa(), 3460, 80);
        
        addObject(new MovingAreia(200, 3, 0, false), 3360, 300);
        addObject(new Botao(-90), 3500, 80);
        addObject(new Chain(), 3500, HIGH/2);
        
        for(int x=0; x<8; x++)
        {
            addObject(new Areia1(), x * 80 + 4060, 366);
        }
        
        addObject(new Chain(), 4400, HIGH/2);
        
        addObject(new Botao(-90), 4600, 250);
        //addObject(new Botao(120), 4500, 210);
        addObject(new Caixa(), 4560, 250);
        
        for(int x=0; x<16; x++)
        {
            addObject(new Areia1(), x * 80 + 4700, 366);
        }
        
        //distância total => 5180
        addObject(new Flag(), 4700, 300);
        addObject(new SoldadoM(), 5150, 300);
        addObject(new Torreta(), 5230, 300);
        
        addObject(new SoldadoM(), 5550, 300);
        addObject(new Torreta(), 5650, 300);
        
        addObject(new Flag(), 5900, 300);
        for(int x=0; x<10; x++)
        {
            addObject(new Spike(), x * 80 + 5980, 390);
        }
        
        addObject(new Areia3(), 6060, 350);
        addObject(new Areia3(), 6220, 350);
        addObject(new Areia3(), 6380, 350);
        
        addObject(new SoldadoM(), 6380, 300);
        
        addObject(new MovingAreia(100, 0, 2, true), 6580, 350);
        
        addObject(new Areia2(5), 6780, 390);
        addObject(new TorretaCima(), 6755, 345);
        addObject(new TorretaCima(), 6780, 345);
        addObject(new TorretaCima(), 6805, 345);
        
        addObject(new Areia2(5), 6980, 390);
        addObject(new TorretaCima(), 6955, 345);
        addObject(new TorretaCima(), 6980, 345);
        addObject(new TorretaCima(), 7005, 345);
        
        addObject(new Areia2(5), 7280, 390);
        addObject(new TorretaCima(), 7255, 345);
        addObject(new TorretaCima(), 7280, 345);
        addObject(new TorretaCima(), 7305, 345);
        
        addObject(new Areia2(5), 7480, 390);
        addObject(new TorretaCima(), 7455, 345);
        addObject(new TorretaCima(), 7480, 345);
        addObject(new TorretaCima(), 7505, 345);
        
        for(int x=0; x<14; x++)
        {
            addObject(new Areia3(), x * 80 + 6780, 200);
        }
        
        for(int x=0; x<8; x++)
        {
            addObject(new Areia1(), x * 80 + 8000, 366);
        }
        
        addObject(new Fase1Endgame(), 8400, HIGH/2);
        addObject(new NextLevel(1), 8400, 300);
    }
}
