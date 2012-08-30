package br.com.senac.amigosecreto;

public class Participante {

    private String name;
    private Participante secretFriend;
    
    public Participante(String name) {
		this.name = name;
		this.secretFriend = null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Participante getSecretFriend() {
		return this.secretFriend;
	}
	
	public void setSecretFriend(Participante secretFriend) {
		this.secretFriend = secretFriend;
	}
	
	public boolean equals(Participante outro) {
		return this.name.equals(outro.getName());
	}
	
	public boolean equals(String outro) {
		return this.name.equals(outro);
	}
	   
     
}