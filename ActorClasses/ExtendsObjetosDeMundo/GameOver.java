import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends ObjetosDeMundo
{
    BackGround bg = new BackGround(); //Classe que obscurece o fundo da tela
    Letters lt; //Classe das palavras que aparecem na tela
    Jbl sound = new Jbl(); //Objeto responsavel pelo som do jogo
    private int size=10; //Define o tamanho da faixa preta da tela de GameOver
    private int fimDeJogo=0; //Contador para dar Stop no greenfoot

    /*
     * Construtor inicializando Letters para que seja alterado depois nos metodos
     */
    public GameOver()
    {
        lt = new Letters("Game Over", 10);
        
        setImage(new GreenfootImage(600, size)); //Seta a imagem deste objeto para uma faixa preta
        getImage().setColor(new Color(0, 0, 0)); //Define a cor(RBG 000 = PRETO)
        getImage().drawRect(0, 0, 600, size); //Seta a imagem para um formato retangular
        getImage().fillRect(1, 1, 600, size); //Preenche o retangulo com preto criando essa imagem de faixa preta
    }

    /*
     * Metodo utilizado quando há um GameOver(A vida dos personagens chegou a 0)
     */
    public void lose()
    {
        if(size < 120)size += 1; //Contador para crescer a faixa preta
        setImage(new GreenfootImage(600, size)); //Seta a imagem deste objeto para uma faixa preta
        getImage().setColor(new Color(0, 0, 0)); //Define a cor(RBG 000 = PRETO)
        getImage().drawRect(0, 0, 600, size); //Seta a imagem para um formato retangular
        getImage().fillRect(1, 1, 600, size); //Preenche o retangulo com preto criando essa imagem de faixa preta
        if(lt.getWorld() != null)lt.gameOver(); //Metodo para crescer as letras de GameOver
        
        fimDeJogo++;
        if(fimDeJogo == 300)Greenfoot.stop(); //Para o jogo quando o contador chega a 300 ~ 6 segundos
        
        if(bg.getWorld() != null)return; //Para impedir que fique adicionando os objetos sem parar
        getWorld().addObject(bg, getX(), getY());
        getWorld().addObject(lt, getX(), getY());
    }

    /*
     * Tela de creditos após matar o boss final
     */
    public void victory()
    {
        if(lt.getWorld() != null)lt.victory(); //Metodo que seta a imagem de Letters
        if(lt.getWorld() != null)lt.setLocation(lt.getX(), lt.getY() - 1); //Move os creditos para cima
        
        sound.laboratorioST.stop();
        sound.proxLevelST.play();
        
        fimDeJogo++;
        if(fimDeJogo == 830)Greenfoot.stop(); //Para o jogo quando o contador chega a 830 ~ 16 segundos
        
        if(bg.getWorld() != null)return; //Para impedir que fique adicionando os objetos sem parar
        getWorld().addObject(bg, getX(), getY());
        lt = new Letters("Victory!", 24);
        getWorld().addObject(lt, getX(), getY() + 400);
    }
}