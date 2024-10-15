import greenfoot.*; 

/*
 * Classe das armadilhas e projeteis pequenos dos inimigos.
 */
public class Armadilhas extends Inimigos
{
    //Deleta o objeto assim que chega a algum canto da tela
    public void Edge()
    {
        World myWorld = getWorld();
        if(isAtEdge())
        {
            myWorld.removeObject(this);
        }
    }
}