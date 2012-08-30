package br.com.senac.amigosecreto;

public class JogoAmigoSecreto {

    public Sorteio sortear( String[] nomes ) {
        Sorteio sorteio = new Sorteio( nomes );
        Recipiente recipiente = new Recipiente( nomes );
        for ( Participante participante : sorteio.getParticipantes() ) {
            participante.sortear( recipiente );
        }
        return sorteio;
    }
}
