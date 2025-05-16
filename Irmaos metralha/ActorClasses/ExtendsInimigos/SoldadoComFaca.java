import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoldadoComFaca extends Inimigos
{
    GreenfootImage[] walkRight = new GreenfootImage[16];
    GreenfootImage[] walkLeft = new GreenfootImage[16];
    int animationCounter=0;
    private int speed = 1;
    public boolean turnRight, turnLeft;
    public int distancia;
    public int limiteContagem;
    public int contagem;
    private LifeBar Life;
    //CONSTRUTOR PARA SOLDADO QUE VAI E VOLTA
    public SoldadoComFaca(int distancia, int speed)
    {
        inicioAnimacao();
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.turnRight = true;
        this.turnLeft = true;
        this.speed = speed;
        Life = new LifeBar(1, 50, 5);
    }
    //CONSTRUTOR PARA DEFINIR ESPECIFICAMENTE A DIREÇÃO DO SOLDADO
    public SoldadoComFaca(int distancia, boolean turnRight, boolean turnLeft, int speed)
    {
        inicioAnimacao();
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.turnRight = turnRight;
        this.turnLeft = turnLeft;
        this.speed = speed;
        Life = new LifeBar(1, 50, 5);
    }
    
    public void act()
    {
        if(turnRight == true && turnLeft == false)
        {
            movementRight();
        }
        
        if(turnLeft == true && turnRight == false)
        {
            movementLeft();
        }
        
        if(turnLeft == true && turnRight == true)
        {
            movementBoth();
            contagem++;
            resetContagem();
        }
        
        getWorld().addObject(Life, getX(), getY() - 40);
        damaged();
        destroyed();
        if (getWorld() == null) return;
    }
    //Identifica se sofreu dano
    public void damaged()
    {
        if(isTouching(Bullet.class))Life.hurt();
    }
    //Identifica se o Soldado esta morto
    public void destroyed()
    {
        if(Life.dead() == true)
        {
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(Life);
            getWorld().removeObject(this);
        }
    }
    //movimentação para direita
    public void movementRight()
    {
        moveRight();
        animateRunLeft();
        animationCounter++;        
    }
    //movimentação para esquerda
    public void movementLeft()
    {
        moveLeft();
        animateRunRight();
        animationCounter++;
    }
    //movimentação para esquerda e direita
    public void movementBoth()
    {
        if(contagem < distancia)
        {
            moveRight();
            animateRunLeft();
            animationCounter++;
        }
        if(contagem > distancia)
        {
            moveLeft();
            animateRunRight();
            animationCounter++;
        }
    }
    //Contagem que diz se o soldado chegou ao final de sua posição
    public void resetContagem(){if(contagem == limiteContagem)contagem=0;}
    //Coloca as imagens no array para animação
    public void inicioAnimacao()
    {
        walkRight[0] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[1] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[2] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[3] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[4] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[5] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[6] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[7] = new GreenfootImage("SoldadoComFaca.png");
        walkRight[8] = new GreenfootImage("SoldadoComFaca2.png");
        walkRight[9] = new GreenfootImage("SoldadoComFaca2.png");
        walkRight[10] = new GreenfootImage("SoldadoComFaca2.png");
        walkRight[11] = new GreenfootImage("SoldadoComFaca2.png");
        walkRight[12] = new GreenfootImage("SoldadoComFaca2.png");
        walkRight[13] = new GreenfootImage("SoldadoComFaca2.png");
        walkRight[14] = new GreenfootImage("SoldadoComFaca2.png");
        walkRight[15] = new GreenfootImage("SoldadoComFaca2.png");
        
        walkLeft[0] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[1] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[2] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[3] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[4] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[5] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[6] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[7] = new GreenfootImage("SoldadoComFaca.png");
        walkLeft[8] = new GreenfootImage("SoldadoComFaca2.png");
        walkLeft[9] = new GreenfootImage("SoldadoComFaca2.png");
        walkLeft[10] = new GreenfootImage("SoldadoComFaca2.png");
        walkLeft[11] = new GreenfootImage("SoldadoComFaca2.png");
        walkLeft[12] = new GreenfootImage("SoldadoComFaca2.png");
        walkLeft[13] = new GreenfootImage("SoldadoComFaca2.png");
        walkLeft[14] = new GreenfootImage("SoldadoComFaca2.png");
        walkLeft[15] = new GreenfootImage("SoldadoComFaca2.png");
        
        walkLeft[0].mirrorHorizontally();
        walkLeft[1].mirrorHorizontally();
        walkLeft[2].mirrorHorizontally();
        walkLeft[3].mirrorHorizontally();
        walkLeft[4].mirrorHorizontally();
        walkLeft[5].mirrorHorizontally();
        walkLeft[6].mirrorHorizontally();
        walkLeft[7].mirrorHorizontally();
        walkLeft[8].mirrorHorizontally();
        walkLeft[9].mirrorHorizontally();
        walkLeft[10].mirrorHorizontally();
        walkLeft[11].mirrorHorizontally();
        walkLeft[12].mirrorHorizontally();
        walkLeft[13].mirrorHorizontally();
        walkLeft[14].mirrorHorizontally();
        walkLeft[15].mirrorHorizontally();
    }
    //Desloca soldado para direita
    public void moveRight()
    {
        setLocation(getX() + speed, getY());
        this.Life.setLocation(getX(), getY() - 40);
    }
    //Desloca soldado para esquerda
    public void moveLeft()
    {
        setLocation(getX() - speed, getY());
        this.Life.setLocation(getX(), getY() - 40);
    }
    //Animação para direita
    public void animateRunRight()
    {
        setImage(walkRight[animationCounter % 16]);
    }
    //Animação para esquerda
    public void animateRunLeft()
    {
        setImage(walkLeft[animationCounter % 16]);
    }
}