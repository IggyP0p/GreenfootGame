import greenfoot.*;

public class SoldadoM extends Inimigos
{
    public int contagem=-1;
    private LifeBar Life;
    
    public SoldadoM()
    {
        Life = new LifeBar(3, 50, 5);
    }
    
    public void act()
    {
        if(contagem == -1)getWorld().addObject(Life, getX(), getY() - 40);
        Shoot();
        contagem++;
        damaged();
        destroyed();
    }
    //Metodo que da o tiro
    public void Shoot()
    {
        if(contagem == 80)
        {
            Projetil p = new Projetil(false, true, false);
            getWorld().addObject(p, getX() - 20, getY() - 40);
            contagem=0;
        }
    }
    //Identifica se sofreu dano
    public void damaged()
    {
        if(isTouching(Bullet.class))Life.hurt();
    }
    //Identifica se a lifebar chegou a 0
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