import greenfoot.*;

/**
 * CLASS: Scroller (extends Object)
 * AUTHOR: danpost(greenfoot.org username)
 * DATE: November 11, 2016
 * 
 * DESCRIPTION: Metodo responsável pelo scrolling(rolamento) do mundo
 */
public class Scroller  
{
    private World world; //Janela qual enxergamos o mundo
    private GreenfootImage scrollImage; // A imagem total
    private int scrolledX, scrolledY; // Distâncias totais do rolamento
    private int wide, high; // dimensões da imagem total
    Cientista cientista; //Objeto cientista para dar true no talk
    Jbl sound = new Jbl(); //Objeto responsavel pelo controle do som

    public Scroller(World viewWorld, GreenfootImage image, int wide, int high)
    {
        this.wide = wide;
        this.high = high;
        world = viewWorld;
        //Cria a imagem onde o rolamento será performado
        if(image != null)
        {
            scrollImage = new GreenfootImage(wide * world.getCellSize(), high * world.getCellSize());
            for(int x=0; x < wide * world.getCellSize(); x += image.getWidth())
            {
                for(int y=0; y<high*world.getCellSize(); y+=image.getHeight())
                {
                    scrollImage.drawImage(image, x, y);    
                }
            }
        }
        scroll(0,0);
    }
    //Metodo que performa o scrolling
    //dsx se refere a distância que moverá tudo horizontalmente
    //dsy se refere a distância que moverá tudo verticalmente
    public void scroll(int dsx, int dsy)
    {
        //calcula o limite de rolamento
        int maxX = wide - world.getWidth();
        int maxY = high - world.getHeight();
        //Aplica limites as distâncias que sofrem rolamento
        if(scrolledX + dsx < 0) dsx = -scrolledX;
        if(scrolledX + dsx >= maxX) dsx = maxX - scrolledX;
        if(scrolledY + dsy < 0) dsy = -scrolledY;
        if(scrolledY + dsy >= maxY) dsy = maxY - scrolledY;
        //atualiza a distância total rolada
        scrolledX += dsx;
        scrolledY += dsy;
        //rola a imagem de fundo para trás
        if(scrollImage != null)
        {
            world.getBackground().drawImage(scrollImage,-scrolledX*world.getCellSize(),-scrolledY*world.getCellSize());
        }
        //Ajusta a posição de todos os objetos 
        for(Object obj: world.getObjects(null))
        {
            Actor actor = (Actor) obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
        }
    }
    //Para o mundo quando chega ao cientista
    public void stopScroll()
    {
        int maxX = wide - world.getWidth();        
        if(scrolledX == maxX)
        {
            scroll(0,0);
            cientista.talk=true;
        }
        else
        {
            scroll(Players.leader.getX()-world.getWidth()/2, 0);
        }
    }
    //Metodo get para a distância horizontal total que foi rolada
    public int getScrolledX()
    {
        return scrolledX;
    }
    //Metodo get para a distância vertical total que foi rolada
    public int getScrolledY()
    {
        return scrolledY;
    }
}
