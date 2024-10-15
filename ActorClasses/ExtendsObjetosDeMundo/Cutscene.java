import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * Metodo que poe um texto no mundo, feito para monologo do Cientista
 */
public class Cutscene extends ObjetosDeMundo
{
    private int duration; //Duração do texto
    //Cria uma imagem com o texto, fundo BRANCO e letras PRETAS
    public Cutscene(String dialogue, int size, int time)
    {
        setImage(new GreenfootImage(dialogue, size, Color.BLACK, Color.WHITE));
        duration=time;
    }
    //Decrementa duração ate tirar do mundo
    public void act()
    {
        if(duration > 0)
        {
            duration--;
            if(duration == 0)getWorld().removeObject(this);
        }
    }
}