import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIÇÃO: Essa é a super classe dos jogadores do jogo, possui todos os atributos e metodos que os jogadores utilizam
 * 
 * 
 *  
 * 
 */
public class Players extends Actor
{
    protected GreenfootSound bulletSound = new GreenfootSound("bulletSound.mp3"); //Som do tiro
    protected GreenfootSound explosion = new GreenfootSound("EXPLOOOOSION!.mp3"); //Som da explosão da morte
    protected GreenfootImage[] walkRight = new GreenfootImage[24]; //Vetor de sprites andando pra direita
    protected GreenfootImage[] walkLeft = new GreenfootImage[24]; //Vetor de sprites andando pra esquerda
    protected static List<Actor> checkPoints = new ArrayList<Actor>(); //Lista para salvar os checkPoints
    protected static Actor leader = null; //Decide qual dos jogadores faz o scrolling do mundo
    protected boolean atirar=false; //Impede que o player atire enquanto pula ou anda
    protected boolean turnRight, turnLeft; //Diz para qual lado o personagem esta virado
    protected int animationCounter=0; //Faz a contagem dos sprites
    protected int speed = 3; //Velocidade do personagem andando
    protected int vSpeed = 0; //Velocidade do personagem caindo
    protected int gravity = 1; //aceleração da queda
    protected int jumpStrength= -18; //Define o quão alto o personagem pula
    protected int gunReloadTime = 60; //O Tempo que demora para recarregar a arma
    protected int reloadDelayCount = 0; //Contador para recarregar arma
    protected int flagX, flagY; //Inteiros para setar a posição do personagem no respawn
    
    //ESSE METODO PEGA O CONTATO DO PERSONAGEM COM AS BANDEIRAS E SALVA NA LISTA DE BANDEIRAS
    public void save()
    {
        Actor touched= getOneIntersectingObject(Flag.class);
        if (touched != null)
        {
            checkPoints.add(touched);
        }
    }
    //METODO QUE IDENTIFICA O CONTATO DO PERSONAGEM COM OS INIMIGOS DO JOGO E O TELEPORTA PARA A ULTIMA BANDEIRA QUE FOI PEGA
    public void death()
    {
        if( isTouching(SoldadoComFaca.class) || isTouching(Armadilhas.class))
        {
            explosion.play();
            World myWorld = getWorld();
            myWorld.addObject(new Explosion(), getX(), getY());
            for(int i=0; i<checkPoints.size(); i++)
            {
                flagX = checkPoints.get(i).getX();
                flagY = checkPoints.get(i).getY();
            }
            setLocation(flagX, flagY);
        } 
    }
    //METODO QUE FAZ O PERSONAGEM ATIRAR
    public void shootBullet()
    {
        if (reloadDelayCount >= gunReloadTime && turnRight==true) {
            Bullet b = new Bullet(6);
            getWorld().addObject(b, getX() + 27, getY() - 10);
            reloadDelayCount = 0;
            bulletSound.play();
        }
        if (reloadDelayCount >= gunReloadTime && turnLeft==true) {
            Bullet b = new Bullet(-6);
            b.getImage().mirrorHorizontally();
            getWorld().addObject(b, getX() - 27, getY() - 10);
            reloadDelayCount = 0; 
            bulletSound.play();
        }
    }
    //METODO QUE FAZ O PERSONAGEM PULAR
    public void Jump()
    {
        vSpeed = jumpStrength;
        setLocation(getX(), getY() + vSpeed);
    }
    //METODO BOOLEANO QUE RECONHECE SE O PERSONAGEM ESTA EM CONTATO COM O CHÃO
    public boolean onGround()
    {
        if(getImage() == null)return false;
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 1, Plataforma.class);
        return under != null;
    }
    //METODO QUE FAZ O PERSONAGEM CAIR
    public void checkFall()
    {
        if(onGround()){
            vSpeed =0;
        } 
        else if(!onGround())
        {
            setLocation(getX(), getY() + vSpeed);
            vSpeed += gravity;
        }
        
        while(isTouching(Plataforma.class))setLocation(getX(), getY() - 1);
    }
    //METODO PARA SE MOVER PARA DIREITA
    public void moveRight()
    {
        setLocation(getX() + speed, getY());
        if(onGround())
            {
                animateRunRight();
                animationCounter++;
                turnLeft = false;
                turnRight = true;
                atirar = false;
            } 
    }
    //METODO PARA SE MOVER PARA ESQUERDA
    public void moveLeft()
    {
        setLocation(getX() - speed, getY());
        if(onGround())
            {
                animateRunLeft();
                animationCounter++;
                turnLeft = true;
                turnRight = false;
                atirar = false;
            } 
    }
    //METODO QUE CORRE O VETOR DE ANIMAÇÃO PARA DIREITA
    public void animateRunRight()
    {
        setImage(walkRight[animationCounter % 24]);
    }
    //METODO QUE CORRE O VETOR DE ANIMAÇÃO PARA ESQUERDA
    public void animateRunLeft()
    {
        setImage(walkLeft[animationCounter % 24]);
    }
}
