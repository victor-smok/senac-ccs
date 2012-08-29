package br.com.senac.amigosecreto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class JogoAmigoSecreto {

    public List<Participante> sortear( String[] nomes ) {
        List<Participante> participantes = new ArrayList<Participante>();
        for ( int i = 0; i < nomes.length; i++ ) {
            Participante participante = new Participante( nomes[i] );
            participantes.add( participante );
        }
        Collections.shuffle( participantes );
        List<Participante> caixa = new ArrayList<Participante>( participantes );
        for ( Participante participante : participantes ) {
            caixa.remove( participante ); // para garantir que o participante nao sorteie ele mesmo
            Collections.shuffle( caixa );
            Participante amigoSecreto = caixa.get( 0 );
            caixa.remove( amigoSecreto );
            caixa.add( participante );
            participante.setAmigoSecreto( amigoSecreto );
        }
        return participantes;
    }
}
