package br.com.senac.ccs.thinkfast;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;

public class Participant {

    private String id;
    private String name;
    private int score;
    private Screen screen;

    public Participant() {
        this.score = 0;
    }

    public Participant( String id, String name ) {
        this();
        this.id = id;
        this.name = name;
    }

    public Participant( String id, String name, Screen screen ) {
        this( id, name );
        this.screen = screen;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
    public void incrementScore() {
        this.score++;
    }

    public void setAsyncContext( Screen screen ) {
        this.screen = screen;
    }


    public void notify( Result result ) throws IOException 
    {
        if ( screen != null ) 
        {
            screen.show(result);
        }
    }
}
