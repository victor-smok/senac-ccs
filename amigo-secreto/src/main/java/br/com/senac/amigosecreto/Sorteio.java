package br.com.senac.amigosecreto;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Sorteio {

    private Date sorteadoEm;
    private List<Participante> participantes;

    public Sorteio( String[] nomes ) {
        this.participantes = Collections.unmodifiableList( Participante.transformar( nomes ) );
        this.sorteadoEm = new Date();
    }

    public Date getSorteadoEm() {
        return sorteadoEm;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public String toString() {
        return String.format( "%1$s %2$tm %2$te,%2$tY %2$tT - %3$s", "Sorteado em:", sorteadoEm, participantes );
    }
}
