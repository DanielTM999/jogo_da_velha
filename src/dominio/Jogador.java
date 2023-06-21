package dominio;
public class Jogador {
    private String simbolo;
    private boolean jogando = false;




    public Jogador(String simbolo, boolean jogando) {
        this.simbolo = simbolo;
        this.jogando = jogando;
    }




    public String getSimbolo() {
        return simbolo;
    }




    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }




    public boolean isJogando() {
        return jogando;
    }




    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }




    public void alterarJogador(){
        if(jogando){
            setJogando(false);
        }else{
           setJogando(true);
        }
    }
}
