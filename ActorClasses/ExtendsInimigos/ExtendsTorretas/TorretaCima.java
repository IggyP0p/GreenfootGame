import greenfoot.*; 

/*
 * Classe de torreta que atira para cima após cada 2 segundos.
 */
public class TorretaCima extends Torretas
{
    public void act()
    {
        Shoot();
        contagem++;
    }
    //metodo de tiro
    public void Shoot()
    {
        if(contagem >= 100)
        {
            Projetil p = new Projetil(false, false, true);
            getWorld().addObject(p, getX(), getY() - 30);
            contagem=0;
        }
    }
}