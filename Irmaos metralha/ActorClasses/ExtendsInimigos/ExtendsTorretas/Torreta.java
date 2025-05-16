import greenfoot.*; 

public class Torreta extends Torretas
{
    private LifeBar Life; //Controla a vida da torreta
    
    public Torreta()
    {
        Life = new LifeBar(2, 50, 5);
    }
    
    public void act()
    {
        if(contagem == -1)getWorld().addObject(Life, getX(), getY() - 40); //if impedindo adicionar vários objetos
        Shoot(); 
        contagem++;
        damaged();
        destroyed();
    }
    //Metodo do tiro do projetil da torreta
    public void Shoot()
    {
        if(contagem == 130)
        {
            Projetil p = new Projetil(true, false, false);
            getWorld().addObject(p, getX() - 39, getY() - 23);
            contagem=0;
        }
    }
    //Metodo que reduz a vida da torreta ao sofrer dano
    public void damaged()
    {
        if(isTouching(Bullet.class))Life.hurt();
    }
    //Metodo que diz se a torreta foi destruida
    public void destroyed()
    {
        if(Life.dead() == true)
        {
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(Life);
            getWorld().removeObject(this);
        }
    }
}
