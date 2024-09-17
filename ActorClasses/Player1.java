import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player1 extends Players
{
    public Player1()
    {
        inicioAnimacao(); //adiciona os sprites da animação dos personagens
    }
    
    public void act()
    { 
        horizontalMove(); //movimentação horizontal
        verticalMove(); //movimentação vertical
        checkFall(); //faz a queda do personagem
        save(); //Salva as flags numa lista
        death(); //mata e respawna o personagem
        shoot(); //atira
        reloadDelayCount++; //faz a contagem de recarregar a arma
        if (leader == null || leader.getX() < getX()) leader = this; //decide qual personagem faz o scrolling do mundo
    }
    //METODO QUE ADICIONA AS IMAGENS AOS VETORES DA ANIMAÇÃO DO PERSONAGEM
    public void inicioAnimacao()
    {
        for(int i=0; i<walkRight.length; i++)
        {
            walkRight[i]=new GreenfootImage("VerdePasso"+i+".png");
        }
        
        for(int i=0; i<walkLeft.length; i++)
        {
            walkLeft[i]=new GreenfootImage("VerdePasso"+i+".png");
        }
        
        for(int i=0; i<walkLeft.length; i++)
        {
            walkLeft[i].mirrorHorizontally();
        }
    }
    //METODO COM TODA A ANIMAÇÃO HORIZONTAL DO PERSONAGEM
    public void horizontalMove()
    {
        if(Greenfoot.isKeyDown("left"))
        {   
            moveLeft();
        } else if(Greenfoot.isKeyDown("right"))
        {
            moveRight();
        } else
        {
            GreenfootImage BaseImage = new GreenfootImage("VerdeBase.png");
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
        if(onGround() && Greenfoot.isKeyDown("up"))
        {
            Jump();
        } 
        
        if(!onGround())
        {
            GreenfootImage Jump = new GreenfootImage("VerdePulo.png");
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
    //METODO QUE DA TIRO
    public void shoot()
    {
        if(atirar == true)
        {
            if(Greenfoot.isKeyDown("m"))shootBullet();
        }
    }
}
