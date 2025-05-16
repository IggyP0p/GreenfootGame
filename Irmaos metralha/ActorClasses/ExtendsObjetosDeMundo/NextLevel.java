import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * Classe responsavel por mudar a fase
 */
public class NextLevel extends ObjetosDeMundo
{
    int level;
    //Define para qual level mudar
    public NextLevel(int level)
    {
        this.level = level;
    }
    
    public void act()
    {
        if(level == 0)level1(); //Menu -> Fase 1
        if(level == 1)level2(); //Fase 1 -> Fase 2
        if(level == 2)level3(); //Fase 2 -> Fase 3
    }
    //Menu -> Fase 1
    public void level1()
    {
        if(isTouching(Letters.class))
        {
            Greenfoot.setWorld(new PraiaCarry());
        }
    }
    //Fase 1 -> Fase 2
    public void level2()
    {
        if(isTouching(Players.class))
        {
            Greenfoot.setWorld(new FlorestaAntiga());
        }
    }
    //Fase 2 -> Fase 3
    public void level3()
    {
        if(isTouching(Players.class))
        {
            Greenfoot.setWorld(new LaboratorioSecreto());
        }
    }
}