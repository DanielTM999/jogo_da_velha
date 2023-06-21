package dominio;

public class Tabuleiro {
    private String[][] tabuleiro = new String[3][3];
    private Jogador X = new Jogador("X", true);
    private Jogador O = new Jogador("O", false);
    private int contJogadas = 0;
    private boolean gameloop = true;

    public Tabuleiro(){
        auto_preencher();
    }

    public void initTUI(){
        while(gameloop){
            MostrarJogo();
            game();
            if(verificarVencedor() != null){
                MostrarJogo();
                System.out.println("jogador " + verificarVencedor().getSimbolo() + " venceu");
                gameloop = false;
            }else if(contJogadas > 8){
                MostrarJogo();
                System.out.println("joga terminado devido a imposibilidade de jogadas");
                gameloop = false;
            }
        }
    }

    private void MostrarJogo(){
        for(int i = 0; i < tabuleiro.length; i++){
            if(i != 0){
                System.out.println("----------");
            }

            for(int j = 0; j < tabuleiro[i].length; j++){
                if(j != 2){
                    System.out.print(this.tabuleiro[i][j]+" | ");
                }else{
                    System.out.print(this.tabuleiro[i][j]);
                }
            }

            System.out.println();

        }
    }

    private void auto_preencher(){
        int cont = 1;
        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < tabuleiro[i].length; j++){
                tabuleiro[i][j] = String.valueOf(cont);
                cont++;
            }
        }
    }

    private void game(){
        if(X.isJogando()){
            try {
                int escoha = TuiUtils.getInteger("jogador "+ X.getSimbolo() + " Informe uma posição:");
                marcar(X, escoha);
                X.alterarJogador();
                contJogadas++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            try {
                int escoha = TuiUtils.getInteger("jogador "+ O.getSimbolo() + " Informe uma posição:");
                marcar(O, escoha);
                X.alterarJogador();
                contJogadas++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void marcar(Jogador jogada, int escolha) throws Exception{
        if(escolha == 1){
            if(verificarmarca(0, 0)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[0][0] = jogada.getSimbolo();
            }
        }else if(escolha == 2){
            if(verificarmarca(0, 1)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[0][1] = jogada.getSimbolo();
            }
        }else if(escolha == 3){
            if(verificarmarca(0, 2)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[0][2] = jogada.getSimbolo();

            }
        }else if(escolha == 4){
            if(verificarmarca(1, 0)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[1][0] = jogada.getSimbolo();
            }
        }else if(escolha == 5){
            if(verificarmarca(1, 1)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[1][1] = jogada.getSimbolo();
            }
        }else if(escolha == 6){
            if(verificarmarca(1, 2)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[1][2] = jogada.getSimbolo();
            }
        }else if(escolha == 7){
            if(verificarmarca(2, 0)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[2][0] = jogada.getSimbolo();
            }
        }else if(escolha == 8){
            if(verificarmarca(2, 1)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[2][1] = jogada.getSimbolo();
            }
        }else if(escolha == 9){
            if(verificarmarca(2, 2)){
                throw new Exception("Local ja marcado");
            }else{
                tabuleiro[2][2] = jogada.getSimbolo();
            }
        }else{
             throw new Exception("selecione um valor valido");
        }

    }

    private boolean verificarmarca(int x, int y){
        if(tabuleiro[x][y].equals("O") || tabuleiro[x][y].equals("X")){
            return true;
        }else{
            return false;
        }
    }

    private Jogador verificarVencedor(){
        if(tabuleiro[0][0].equals(tabuleiro[1][0]) && tabuleiro[1][0].equals(tabuleiro[2][0])){
            return retornaJogador(0, 0);
        }else if(tabuleiro[0][1].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][1])){
            return retornaJogador(0, 1);
        }else if(tabuleiro[0][2].equals(tabuleiro[1][2]) && tabuleiro[1][2].equals(tabuleiro[2][2])){
            return retornaJogador(0, 2);
        }else if(tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][2])){
            return retornaJogador(1, 1);
        }else if(tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][0])){
            return retornaJogador(1, 1);
        }else if(tabuleiro[0][0].equals(tabuleiro[0][1]) && tabuleiro[0][1].equals(tabuleiro[0][2])){
            return retornaJogador(1, 1);
        }else if(tabuleiro[1][0].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[1][2])){
            return retornaJogador(1, 1);
        }else if(tabuleiro[2][0].equals(tabuleiro[2][1]) && tabuleiro[2][1].equals(tabuleiro[2][2])){
            return retornaJogador(1, 1);
        }

        return null;
    }

    private Jogador retornaJogador(int x, int y){
        if(X.getSimbolo().contains(tabuleiro[x][y])){
            return X;
        }else{
            return O;
        }
    }

}
