package br.com.senac.amigosecreto;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class JogoAmigoSecreto {

    public List<Participante> sortear( String[] participantes ) {
        List<Participante> sorteio = new ArrayList<Participante>();
        List<Participante> temp = new ArrayList<Participante>();
        List<String> nomes = new ArrayList<String>( Arrays.asList( participantes ) );
        for ( String nome : nomes ) {
            sorteio.add( new Participante( nome ) );
            temp.add( new Participante( nome ) );
        }
        while ( !nomes.isEmpty() ) {
            Participante participante = temp.get( ( (int) ( Math.random() * temp.size() ) ) );
            String nome = nomes.get( ( (int) ( Math.random() * nomes.size() ) ) );
            if ( !participante.getNome().equals( nome ) ) {
                participante.setAmigoSecreto( new Participante( nome ) );
                nomes.remove( nome );
                temp.remove( participante );
            }
        }
        return sorteio;
    }
}