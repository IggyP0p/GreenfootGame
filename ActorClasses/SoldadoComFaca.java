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
    
    public SoldadoComFaca(int distancia, int speed)
    {
        inicioAnimacao();
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.turnRight = true;
        this.turnLeft = true;
        this.speed = speed;
    }
    
    public SoldadoComFaca(int distancia, boolean turnRight, boolean turnLeft, int speed)
    {
        inicioAnimacao();
        this.distancia = distancia;
        this.limiteContagem = distancia*2;
        this.turnRight = turnRight;
        this.turnLeft = turnLeft;
        this.speed = speed;
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
        
        if (getWorld() == null) return;
    }
    
    public void movementRight()
    {
        moveRight();
        animateRunLeft();
        animationCounter++;
    }
    
    public void movementLeft()
    {
        moveLeft();
        animateRunRight();
        animationCounter++;
    }
    
    public void movementBoth()
    {
        if(contagem < distancia)
        {
            setLocation(getX() + speed, getY());
            animateRunLeft();
            animationCounter++;
        }
        if(contagem > distancia)
        {
            setLocation(getX() - speed, getY());
            animateRunRight();
            animationCounter++;
        }
    }
    
    public void resetContagem(){if(contagem == limiteContagem)contagem=0;}
    
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
    
    public void moveRight()
    {
        setLocation(getX() + speed, getY());
    }
    
    public void moveLeft()
    {
        setLocation(getX() - speed, getY());
    }
    
    public void animateRunRight()
    {
        setImage(walkRight[animationCounter % 16]);
    }
    
    public void animateRunLeft()
    {
        setImage(walkLeft[animationCounter % 16]);
    }
}