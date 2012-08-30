package br.com.senac.amigosecreto;

import java.util.List;
import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Testes unitarios para aplicacao AmigoSecreto.
 */
public class JogoAmigoSecretoTest  extends TestCase {
    /**
     * @param nomeTeste nome do teste unitario
     */
    public JogoAmigoSecretoTest( String nomeTeste ) {
        super( nomeTeste );
    }

    /**
     * Testa se todos os participantes possuem amigo secreto.
     */
    @Test()
    public void testSeTodosParticipantesPossuemAmigoSecreto() {
        String[] participantes = new String[] { "Tony Stark", "Thor Odinson", "Clinton Barton", "Bruce Banner", "Steve Rogers", "Natalia Romanova", "Nicholas Fury",  "Loki" };
        JogoAmigoSecreto jogo = new JogoAmigoSecreto();
        Sorteio sorteio = jogo.sortear( participantes );
        System.out.println( sorteio );
        assertNotNull( sorteio );
        assertFalse( sorteio.getParticipantes().isEmpty() );
        assertThat( sorteio.getParticipantes(), allOf( is( notNullValue() ) ) );
        for ( Participante participante : sorteio.getParticipantes() ) {
            assertNotNull( participante.getAmigoSecreto() );
        }
    }
    /**
     * Testa se o amigo secreto de um participante nao e ele mesmo.
     */
    public void testParticipanteNaoSeuProprioAmigoSecreto() {
        String[] participantes = new String[] { "Tony Stark", "Thor Odinson", "Clinton Barton", "Bruce Banner", "Steve Rogers", "Natalia Romanova", "Nicholas Fury",  "Loki" };
        JogoAmigoSecreto jogo = new JogoAmigoSecreto();
        Sorteio sorteio = jogo.sortear( participantes );
        System.out.println( sorteio );
        for (Participante participante : sorteio.getParticipantes() ) {
            assertFalse( participante.getAmigoSecreto().equals( participante ) );
        }
    }
}
