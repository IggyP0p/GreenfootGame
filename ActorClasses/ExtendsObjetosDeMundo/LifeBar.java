import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LifeBar extends ObjetosDeMundo
{
    private final int wide, height;
    private int health, damage, newLife;
    public static int greenLife, redLife;
    
    //CONSTRUTOR DOS INIMIGOS
    public LifeBar(int health, int wide, int height)
    {
        setImage(new GreenfootImage(wide, height));
        this.newLife = wide;
        this.wide = wide;
        this.height = height;
        this.health = health;
        damage = wide/health;

        getImage().setColor(new Color(255, 0, 0));
        
        getImage().drawRect(0, 0, wide, height);
        
        getImage().fillRect(1, 1, wide, height);
    }
    //CONSTRUTOR DOS JOGADORES HARDMODE
    public LifeBar(int vida)
    {
        this.newLife = vida;
        this.wide = 0;
        this.height = 0;
        this.health = 0;
        damage = 1;
    }
    //CONSTRUTOR DOS JOGADORES EASYMODE
    public LifeBar()
    {
        this.newLife = -1;
        this.wide = 0;
        this.height = 0;
        this.health = 0;
        damage = 0;
    }
    
    public void damaged()
    {
        newLife--;
    }
    //METODO QUE CONTABILIZA O DANO
    public void hurt()
    {
        newLife = newLife - damage;
        if(newLife <= 0)return;
        GreenfootImage img = new GreenfootImage(wide, height);
        img.setColor(new Color(255, 0, 0));
        img.drawRect(0, 0, newLife, height);
        img.fillRect(1, 1, newLife - 2, height - 2);
        setImage(img);
    }
    //DIZ SE O PERSONAGEM/INIMIGO ESTA MORTO
    public boolean dead()
    {
        if(newLife <= 0)return true;
        return false;
    }
    
    public int calcLife()
    {
        return this.newLife += 1;
    }
}