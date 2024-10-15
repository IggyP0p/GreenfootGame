import greenfoot.*;

public class Jbl
{
    public static GreenfootSound bulletSound = new GreenfootSound("bulletSound.mp3");
    public GreenfootSound explosion = new GreenfootSound("EXPLOOOOSION!.mp3");
    public static GreenfootSound menuST = new GreenfootSound("ST Menu.mp3");
    public static GreenfootSound praiaST = new GreenfootSound("ST PraiaCarry.mp3");
    public static GreenfootSound florestaST = new GreenfootSound("ST FlorestaAntiga.mp3");
    public static GreenfootSound laboratorioST = new GreenfootSound("ST LaboratorioSecreto.mp3");
    public static GreenfootSound dramaST = new GreenfootSound("ST Menance.mp3");
    public static GreenfootSound proxLevelST = new GreenfootSound("ST Joy.mp3");
    
    public static void volumeUp()
    {
        int i = menuST.getVolume();
        if(i>=0 && i<=99)
        {
            i+=50;
            menuST.setVolume(i);
        }
    }
    
    public static void volumeDown()
    {
        int i = menuST.getVolume();
        if(i>=1 && i<=100)
        {
            i-=50;
            menuST.setVolume(i);
        }
    }
}
