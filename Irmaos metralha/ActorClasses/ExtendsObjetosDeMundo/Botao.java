import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;

public class Botao extends ObjetosDeMundo
{
    public List<Chain> portao = new ArrayList<Chain>(); //Pega as "Chain" para tira-las do mundo
    GreenfootImage[] pressed = new GreenfootImage[2]; //Imagem do botão pressionado
    public int rotation; //rotação do objeto para colocar em outras posições
    
    public Botao(int rotation)
    {
        inicioAnimacao(); //seta as arrays de animação
        rotation(rotation);
    }
    
    public void act()
    {
        animateBeingPressed();
        //blockChain();
        abreCaminho();
    }
    //Pega os objetos Chain por perto e os tira do mapa
    public void abreCaminho()
    {
        portao = getObjectsInRange(300, Chain.class);
        if(buttonPressed())
        {
            for(int i=0; i<portao.size(); i++)
            {
                World myWorld = getWorld();
                myWorld.removeObject(portao.get(i));
            }
        }
    }
    //Metodo antigo de retirar Chain
    public void blockChain()
    {
        if(buttonPressed())removeTouching(Chain.class);
    }
    //Booleano para saber se o personagem tocou no botão
    public boolean buttonPressed()
    {
        if(isTouching(Players.class))return true;
        return false;
    }
    //Roda o botão 
    public void rotation(int rotation)
    {
        this.setRotation(rotation);
    }
    //seta as imagens nas arrays
    public void inicioAnimacao()
    {
        pressed[0] = new GreenfootImage("botaoNovo.png");
        pressed[1] = new GreenfootImage("botaoNovo2.png");
    }
    //Anima o botão sendo pressionado
    public void animateBeingPressed()
    {
        if(isTouching(Players.class))setImage(pressed[1]);
    }
}
