import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/*
 * Inimigo Macaco da fase 2
 */
public class Masqueico extends Inimigos
{
    private int animationCounter=0; //Contador pra animação de jogar banana
    
    public void act()
    {
        animationCounter++;
        bananaAttack();
    }
    
    public void bananaAttack()
    {
        //seta imagem depois de jogar a banana e coloca o objeto banana no mundo
        if(animationCounter >= 150)
        {
            setImage("masqueico1.png");
            World myWorld = getWorld();
            myWorld.addObject(new Banana(), getX() + 11, getY() + 17);
            animationCounter = 0;
        }
        //seta imagem antes de jogar a banana
        if(animationCounter >= 50 && animationCounter < 150)
        {
            setImage("masqueico0.png");
        }
    }
    //Metodo utilizado para por os macacos corretamente nas arvores
    public int distX()
    {
        return this.getX(); //devolve a coordenada X dos macacos
    }
    //Metodo utilizado para por os macacos corretamente nas arvores
    public int distY()
    {
        return this.getY(); //devolve a coordenada Y dos macacos
    }
}