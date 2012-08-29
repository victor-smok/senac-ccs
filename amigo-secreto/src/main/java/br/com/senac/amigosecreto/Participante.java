package br.com.senac.amigosecreto;

public class Participante {

    private String nome;
    private Participante amigoSecreto;

    public Participante() {
    }

    public Participante( String nome ) {
        this.nome = nome;
    }

    public Participante getAmigoSecreto() {
        return amigoSecreto;
    }

    public void setAmigoSecreto( Participante amigoSecreto ) {
        this.amigoSecreto = amigoSecreto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
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
}
