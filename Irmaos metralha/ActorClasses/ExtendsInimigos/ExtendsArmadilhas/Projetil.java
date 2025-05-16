import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * Projetil lançado pelos SoldadosM e Torretas
 */
public class Projetil extends Armadilhas
{
    public int kill; //contador de abates
    public boolean hMove; //Define movimentação para torreta
    public boolean vMove; //Define movimentação para torreta pequena
    public boolean arcMove; //Define movimentação para o SoldadoM
    public int contagem=0; //contagem para criar movimento de arco(SoldadoM)
    public int aceleration = 1; //Faz o movimento de arco menos brusco
    public int vSpeed =5; //Velocidade vertical
    public int speed = Greenfoot.getRandomNumber(4); //Define a força do projetil do soldadoM
    
    public Projetil(boolean hMove, boolean arcMove, boolean vMove)
    {
        this.hMove = hMove; //true if objeto Torreta
        this.vMove = vMove; //true if objeto Torreta pequena
        this.arcMove = arcMove; //true if objeto SoldadoM
    }
    
    public void act()
    {
        ArcMove(); //objeto SoldadoM
        vMove(); //objeto Torreta pequena
        horizontalMove(); //objeto Torreta
        Edge(); //deleta objeto
        deleteBullet(); //retira projetil do mundo
        if (getWorld() == null) return; //Impede Exception
        KillTouch(); //Condição para deletar o projetil
        contagem++;
    }
    //movimento da torreta pequena
    public void vMove()
    {
        if(vMove == true)setLocation(getX(), getY() - 3);  
    }
    //movimento de arco do SoldadoM
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
    //movimento da torreta
    public void horizontalMove()
    {
        if(hMove == true)move(-3);    
    }
    //retira projetil do mundo caso acerte inimigos
    public void deleteBullet()
    {
        if(kill >= 1)getWorld().removeObject(this);kill=0;
    }
    //Condição para deletar o projetil
    public void KillTouch()
    {
        if(isTouching(Players.class))kill++;
    }
}