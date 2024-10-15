import greenfoot.*; 

/**
 * Banana jogada pelos macacos
 */
public class Banana extends Armadilhas
{
    public void act()
    {
        turn(10); //Gira a banana a cada act
        Edge(); //Deleta o objeto
        if (getWorld() == null) return; //Impede Exception
        Movement(); //Metodo do movimento da Banana
    }
    //Movimento da banana
    public void Movement()
    {
        setLocation(getX(), getY() + 2);
    }
}