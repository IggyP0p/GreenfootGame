import greenfoot.*;

public class Cientista extends Boss
{
    private GreenfootImage[] drinking = new GreenfootImage[15]; //Imagens do cientista bebendo
    private String[] dialogue = new String[16]; //Strings do monologo
    public static boolean talk=false; //Aciona quando o cientista precisa falar
    public int cont, i=0, t=0;
    
    public Cientista()
    {
        cutscene(); //Arrays do monologo
    }
    
    public void act()
    {
        dialogue(); //muda as frases do cientista
        transform(); //inicia a transformação
    }
    
    /*
     * Metodo que realiza a transformação do cientista. 150 = 3 segundos.
     */
    public void transform()
    {
        if(cont >= 150*16)
            {
                //corre o array de aniamações com pausa de 1 segundo
                if(cont % 55 == 0)
                {
                    setImage(drinking[t]);
                    t++;
                    sound.dramaST.stop();
                    sound.laboratorioST.play();
                }
                //Fim da transformação
                if(cont % 40 == 0 && t == 15)
                {
                    getWorld().addObject(new Lobisomem(), getX(), getY());
                    getWorld().removeObject(this);
                }

                cont++;
            }
    }
    //METODO RESPONSAVEL PELO MONOLOGO DO CIENTISTA DO MAL
    public void dialogue()
    {
        if(talk == true)
        {    
            if(cont >= 150*16)return; //Impede o IndexOutOfBoundsException
            //Adiciona no mundo as frases.
            if(cont % 150 == 0){getWorld().addObject(new Cutscene(dialogue[i], 15, 150), getX() + 10, getY()-25);i++;}
            cont++;
        }
    }
    
    /*
     * Metodo com as frases do cientista do mal
     */
    public void cutscene()
    {
        dialogue[0]= "malditos!";
        dialogue[1]= "acham que podem me impedir?";
        dialogue[2]= "quando eu lançar essa bomba";
        dialogue[3]= "todos esses humanos sujos";
        dialogue[4]= "serão infectados pelo vírus";
        dialogue[5]= "e sofrerão com a morte";
        dialogue[6]= "lenta e cruel";
        dialogue[7]= "ja ouço as vozes das pessoas..";
        dialogue[8]= "gritando por socorro nas ruas";
        dialogue[9]= "filhos e filhas chorando..";
        dialogue[10]= "no peito de seus pais MORTOS!";
        dialogue[11]= "a civilização em ruina";
        dialogue[12]= "e vocês... SOVIETICOS!";
        dialogue[13]= "irei fazer um favor ao mundo";
        dialogue[14]= "eliminando vocês IMUNDOS";
        dialogue[15]= "hora de por o lixo pra fora.";
        
        for(int x=0; x<drinking.length; x++)
        {       
            drinking[x]= new GreenfootImage("CientistaAnimation"+ x +".png");
        }
    }
}
