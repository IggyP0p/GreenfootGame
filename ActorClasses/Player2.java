import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player2 extends Players
{
    public Player2()
    {
        inicioAnimacao(); //corre a animação dos personagens
    }

    
    public void act()
    { 
        horizontalMove();
        verticalMove();
        checkFall();
        save();
        death();
        shoot();
        reloadDelayCount++;
        inicioAnimacao();
        if (leader == null || leader.getX() < getX()) leader = this;
    }
    //METODO COM TODA A ANIMAÇÃO HORIZONTAL DO PERSONAGEM
    public void horizontalMove()
    {
        if(Greenfoot.isKeyDown("a"))
        {   
            moveLeft();
        } else if(Greenfoot.isKeyDown("d"))
        {
            moveRight();
        } else
        {
            GreenfootImage BaseImage = new GreenfootImage("VermelhoBase.png");
            if(turnLeft == true)
            {
                BaseImage.mirrorHorizontally();
                setImage(BaseImage);
                atirar = true;
            }
            if(turnRight == true)
            {
                setImage(BaseImage);
                atirar = true;
            }
        }
    }
    //METODO COM TODA A MOVIMENTAÇÃO VERTICAL DO PERSONAGEM  
    public void verticalMove()
    {
        if(onGround() && Greenfoot.isKeyDown("w"))
        {
            Jump();
        } 
        
        if(!onGround())
        {
            GreenfootImage Jump = new GreenfootImage("VermelhoPulo.png");
            if(turnRight == true)
            {
                setImage(Jump);
                atirar = false;
            }
            if(turnLeft == true)
            {
                Jump.mirrorHorizontally();
                setImage(Jump);
                atirar = false;
            }
        }
    }
    //METODO QUE CORRE OS VETORES DA ANIMAÇÃO DO PERSONAGEM
    public void inicioAnimacao()
    {
        for(int i=0; i<walkRight.length; i++)
        {
            walkRight[i]=new GreenfootImage("VermelhoPasso"+i+".png");
        }
        
        for(int i=0; i<walkLeft.length; i++)
        {
            walkLeft[i]=new GreenfootImage("VermelhoPasso"+i+".png");
        }
        
        for(int i=0; i<walkLeft.length; i++)
        {
            walkLeft[i].mirrorHorizontally();
        }
    }
    //METODO QUE DA TIRO
    public void shoot()
    {
        if(atirar == true)
        {
            if(Greenfoot.isKeyDown("space"))shootBullet();
        }
    }
}
