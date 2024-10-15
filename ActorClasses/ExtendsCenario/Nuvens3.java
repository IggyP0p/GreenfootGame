import greenfoot.*;

/**
 * As classes de Cenario são apenas ilustrativas, servem apenas para compor o Cenario
 * Não possuem qualquer aplicação(código) consigo. Salva exceção de Nuvens1, Nuvens2, Nuvens3 e Lua.
 */
public class Nuvens3 extends Cenario
{
    int contagem = 0;
    //Realiza contagem e se move de acordo com ela
    public void act()
    {
        contagem++;
        movement();
    }
    
    public void movement()
    {
        if(contagem == 60)
        {
            setLocation(getX(), getY() + 20);
        } 
        if(contagem == 120)
        {
            setLocation(getX(), getY() + 20);
        } 
        if(contagem == 180)
        {
            setLocation(getX(), getY() - 20);
        } 
        if(contagem == 240)
        {
            setLocation(getX(), getY() - 20);
            contagem = 0;
        } 
    }
}