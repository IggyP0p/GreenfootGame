import greenfoot.*;  

/*
 * Some ao ser tocado pelo personagem o fazendo cair na armadilha
 */
public class fakeTerra extends Plataforma
{
    public void act()
    {
        if(disappear() == true)getWorld().removeObject(this);
    }
    //retira objeto do mundo ao toque
    public boolean disappear()
    {
        if(getImage() == null)return false;
        Actor above = getOneObjectAtOffset(0, -36, Players.class);
        return above != null;
    }
}