package br.com.senac.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class Participante {

    private String nome;
    private Participante amigoSecreto;

    public Participante( String nome ) {
        this.nome = nome;
    }

    public void sortear( Recipiente recipiente ) {
        this.amigoSecreto = recipiente.getAmigoSecreto( this );
    }

    public Participante getAmigoSecreto() {
        return amigoSecreto;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals( Object object ) {
        return ( this == object ) || object instanceof Participante && this.hashCode() == object.hashCode();
    }

    @Override
    public int hashCode() {
        return this.nome == null ? 0 : this.nome.hashCode();
    }

    @Override
    public String toString() {
        return String.format( "%s - %s", this.nome, this.amigoSecreto != null ? this.amigoSecreto.getNome() : "indefinido" );
    }
    
    public static List<Participante> transformar( String[] nomes ) {
        List<Participante> participantes = new ArrayList<Participante>();
        for ( int i = 0; i < nomes.length; i++ ) {
            Participante participante = new Participante( nomes[i] );
            participantes.add( participante );
        }
        return participantes;
    }
}
