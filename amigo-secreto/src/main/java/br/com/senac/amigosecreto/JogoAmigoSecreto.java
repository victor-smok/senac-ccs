package br.com.senac.amigosecreto;

import java.util.ArrayList;
import java.util.List;


public class JogoAmigoSecreto {

    private ArrayList<Participante> participantes;

    List<Participante> sortear( String[] participantes ) {
        
        this.participantes = new ArrayList<Participante>(); 
        ArrayList<Participante> toGame = new ArrayList<Participante>(); 

        for(String participante : participantes) {      
            Participante novoParticipante = new Participante(participante); 
            this.participantes.add(novoParticipante);
            toGame.add(novoParticipante);            
        }
        
        
        for(Participante participante : this.participantes) {      
            while(true) {
                int valorSorteado = (int)(Math.random() * toGame.size());
                Participante sorteado = toGame.get(valorSorteado);
                if(sorteado.equals(participante)) {
                    continue;
                } else {
                    participante.setSecretFriend(sorteado);
                    toGame.remove(valorSorteado);
                    break;
                }
            }
        }
        
        return this.participantes;
               
    }
}
