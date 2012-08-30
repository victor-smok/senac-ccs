package br.com.senac.amigosecreto;

import java.util.Collections;
import java.util.List;

public class Recipiente {

    private List<Participante> participantes;

    public Recipiente( String[] nomes ) {
        this.participantes = Participante.transformar( nomes );
    }

    public Participante getAmigoSecreto( Participante participante ) {
        this.participantes.remove( participante ); // para garantir que o participante nao sorteie ele mesmo
        Collections.shuffle( participantes );
        Participante amigoSecreto = this.participantes.get( 0 );
        this.participantes.remove( amigoSecreto );
        this.participantes.add( participante );
        return amigoSecreto;
    }
}
