import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Projetil extends Armadilhas
{
    public int kill;
    public boolean hMove;
    public boolean vMove;
    public boolean arcMove;
    public int contagem=0;
    public int aceleration = 1;
    public int vSpeed =5;
    public int speed = Greenfoot.getRandomNumber(4);
    
    public Projetil(boolean hMove, boolean arcMove, boolean vMove)
    {
        this.hMove = hMove;
        this.vMove = vMove;
        this.arcMove = arcMove;
    }
    
    public void act()
    {
        ArcMove();
        vMove();
        horizontalMove();
        Edge();
        deleteBullet();
        if (getWorld() == null) return;
        KillTouch();
        contagem++;
    }
    
    public void vMove()
    {
        if(vMove == true)setLocation(getX(), getY() - 3);  
    }
    
    public void ArcMove()
    {    
        if(arcMove == true)
        {
            if(contagem <= 50)
            {
                setLocation(getX() - speed, getY() - vSpeed);
                if(contagem % 12 == 0)
                {
                    vSpeed = vSpeed - aceleration;
                }
            }
            if(contagem > 50)
            {
                setLocation(getX() - speed, getY() + vSpeed);
                if(contagem % 12 == 0)
                {
                    vSpeed = vSpeed + aceleration;
                }
            }
        }
    }
    
    public void horizontalMove()
    {
        if(hMove == true)move(-3);    
    }
    
    public void deleteBullet()
    {
        if(kill >= 1)getWorld().removeObject(this);kill=0;
    }
    
    public void KillTouch()
    {
        if(isTouching(Player2.class))kill++;
        if(isTouching(Player1.class))kill++;
    }
}
