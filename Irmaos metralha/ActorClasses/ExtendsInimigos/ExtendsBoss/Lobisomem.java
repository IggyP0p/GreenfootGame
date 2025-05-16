import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lobisomem extends Boss
{
    private GreenfootImage[] moveRight = new GreenfootImage[2]; //Array de imagens do personagem se movendo pra direita
    private GreenfootImage[] moveLeft = new GreenfootImage[2]; //Array de imagens do personagem se movendo pra esquerda
    private LifeBar Life; //Objeto barra de vida
    private GameOver endGame = new GameOver(); //Tela de encerramento
    private int walkAnimation; 
    private int health=50, delayMove, deathAnimation, target = 1;
    private boolean rightSide, leftSide; //Identifica o lado em que esta virado o personagem
    
    
    public Lobisomem()
    {
        InicioAnimacao(); //Seta as imagens da animação
        Life = new LifeBar(50, 500, 26); //Objeto que cuida da vida do lobisomem
    }
    
    public void act()
    {
        if(endGame.getWorld() != null){endGame.victory(); return;} //Metodo para os creditos
        if(Life.dead() == true){death(); return;} //Aciona a morte do lobisomem
        
        hurt(); //Identifica o dano recebido
        localizar(); //Movimentação do lobisomem
        
        if(delayMove == 0)getWorld().addObject(Life, 300, 380); //Para impedir que adicione barra de vida sem parar
        if(delayMove % 55 == 0)walkAnimation++; //Faz a animação de andar rodar
        delayMove++;
    }
    //METODO QUE CALCULA O DANO RECEBIDO
    public void hurt()
    {
        if(isTouching(Bullet.class))Life.hurt(); //Conta o dano recebido
        
        //Identifica se a barra de vida chegou a 0
        if(Life.dead() == true)
        {
            getWorld().removeObject(Life);
            sound.laboratorioST.stop();
        }
    }
    //METODO DA ANIMAÇÃO DE MORTE E ENCERRAMENTO
    public void death()
    {
        setImage("Lobisomem3.png"); //Imagem de boca fechada
        
        deathAnimation++;
        //Adiciona aleatóriamente explosões no Lobisomem morto
        if(deathAnimation > 55 && deathAnimation < 400)
        {
            int x = Greenfoot.getRandomNumber(20);
            int y = Greenfoot.getRandomNumber(20);
            
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + x, getY() + y);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + x, getY() - y);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + y, getY() - x);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + y, getY() + x);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + y + x, getY() - y - x);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + y + y, getY() + x + x);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + y + x, getY() + y + x);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() + y + y, getY() - x - x);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() - x, getY() + y);
            if(deathAnimation % 45 == 0)getWorld().addObject(new Explosion(), getX() - x, getY() - y);
            if(deathAnimation % 30 == 0)getWorld().addObject(new Explosion(), getX() - y, getY() - x);
            if(deathAnimation % 30 == 0)getWorld().addObject(new Explosion(), getX() - y, getY() + x);
            if(deathAnimation % 30 == 0)getWorld().addObject(new Explosion(), getX() - y - x, getY() - y - x);
            if(deathAnimation % 20 == 0)getWorld().addObject(new Explosion(), getX() - y - y, getY() + x + x);
            if(deathAnimation % 20 == 0)getWorld().addObject(new Explosion(), getX() - y - x, getY() + y + x);
            if(deathAnimation % 20 == 0)getWorld().addObject(new Explosion(), getX() - y - y, getY() - x - x);
        }
        //Poe na tela a tela de creditos
        if(deathAnimation == 400)
        {
            getWorld().addObject(endGame, 300, 200);
        }
    }
    //DECIDE PARA QUAL LADO SE MOVIMENTAR
    public void localizar()
    {
        //Movimentação pra esquerda
        if(target % 2 == 0)
        {
            setImage("LobisomemBase.png");
            getImage().mirrorHorizontally();
            rightSide = false;
            leftSide = true;
            movement();
        }
        //Movimentação para direita
        if(target % 2 != 0)
        {
            setImage("LobisomemBase.png");
            rightSide = true;
            leftSide = false;
            movement();
        }
        if(isAtEdge())target++; //Muda o lado para o qual esta se movendo
    }
    //METODO DA MOVIMENTAÇÃO
    public void movement()
    {   
        //Velocidade e imagem do lobisomem
        if(rightSide == true)
        {
            setImage(moveRight[walkAnimation % 2]);
            setLocation(getX() - 4, getY());
        }
        else if(leftSide == true)
        {   
            setImage(moveLeft[walkAnimation % 2]);
            setLocation(getX() + 4, getY());
        }
    }
    //METODO RESPONSAVEL POR COLOCAR AS IMAGENS NAS ARRAYS
    public void InicioAnimacao()
    {   
        for(int i=0; i<moveRight.length; i++)
        {
            moveRight[i] = new GreenfootImage("LobisomemMV"+i+".png");
        }
        
        for(int i=0; i<moveLeft.length; i++)
        {
            moveLeft[i] = new GreenfootImage("LobisomemMV"+i+".png");
        }
        
        for(int i=0; i<moveLeft.length; i++)
        {
            moveLeft[i].mirrorHorizontally();
        }
    }
}
