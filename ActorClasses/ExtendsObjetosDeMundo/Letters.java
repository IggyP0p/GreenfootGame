import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Letters extends ObjetosDeMundo
{
    private int size;
    private String message, credits, prologue;
    
    /*
     * Construtor da classe
     * @param message uma String que aparecerá na tela
     * @param size Define o tamanho desta String
     */
    public Letters(String message, int size)
    {
        this.message = message;
        this.size = size;
    }
    //Metodo que seta as Strings do prologo
    public void scene1()
    {
        prologue();
        setImage(new GreenfootImage(prologue, size, Color.BLACK, null));
    }
    //Metodo que seta as Strings dos créditos
    public void victory()
    {
        credits();
        setImage(new GreenfootImage(credits, size, Color.WHITE, null));
    }
    //Metodo da String GameOver, incrementa o tamanho crescendo a String
    public void gameOver()
    {
        if(size < 120)size += 1;
        setImage(new GreenfootImage(message, size, Color.RED, Color.BLACK));
    }
    //String do prologo
    private void prologue()
    {
        prologue="No ano de 1978. 33 anos após o fim da\nsegunda guerra mundial. Os Estados\nUnidos com interesse nos estudos dos\nalemães reuniu cientistas da alemanha\nnazista. Dentre esses cientistas estava\nRudol Von Stroheim. Um maligno cientista\nque sentia prazer em ver o desespero\nno olhar de suas vitimas. Stroheim acabou\nficando muito rico nos Estados Unidos\ncom vendas de Funko Pop. Apesar de\nserem muito feios muita gente comprava\nainda assim. Com toda a sua riqueza\nele comprou uma ilha ao leste extremo\nda linha entre Miami e Cuba. Onde iniciou\nsuas nefastas pesquisas. Uma organização\nde inteligência Soviêtica chamada NERV\nmonitorou por anos esses cientistas e\ndescobriu uma terrivel arma criada\npor Stroheim que seria capaz de devastar\num continente inteiro. Foi então que 2 \nsuper soldados da NERV foram mandados\npra ilha das sombras impedir que\nessa bomba seja lançada. Eles chegam\nentão a Praia Carry, onde enfrentarão\nas primeiras tropas do cientista...";
    }
    //String dos créditos
    private void credits()
    {
        credits="CREDITOS\n\nJogo feito pela equipe de Igor, Geovani, Pedro e Nadson\n\nORIENTADOR: Cleber Lira Santana\n\n\nCódigo por: Igor, Geovani, Pedro e Nadson\n\n\nArte por: Igor, Geovani, Pedro e Nadson\n\n\nMúsica fase 1: Iron Maiden - Aces High\nMúsica fase 2: Black Sabbath - Children of the sea\nMúsica fase 3: Judas Priest - Eletric Eye";
    }
}