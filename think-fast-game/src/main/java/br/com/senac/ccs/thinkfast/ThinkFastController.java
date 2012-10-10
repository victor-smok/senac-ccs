package br.com.senac.ccs.thinkfast;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping( value= "/thinkfast/*", produces={"application/json"} )
public class ThinkFastController {
    
    private ThinkFastGame game;

    @RequestMapping(value="/play", method= RequestMethod.GET)
    public @ResponseBody Result play(@RequestParam String name, HttpSession session)
    {
        String id = session.getId();
        
        DeferredResult<Result> deferredResult = new DeferredResult<Result>();
        
        Screen screen = new WebScreen( deferredResult );
        
        return game.play(id, name, screen);
    }
    
    public void bind(HttpSession session)
    {
    }
    
    public void awnswer(@RequestParam String answer, HttpSession session)
    {
    }
    
    protected void doGet( HttpServletRequest req,
                          HttpServletResponse resp )
            throws ServletException, IOException {

        String action = req.getParameter( "action" );
        String id = req.getSession().getId();
        
        if ( "play".equals( action ) ) {
            String name = req.getParameter( "name" );
            AsyncContext async = req.startAsync();
            game.play( id, name, async );
        }
        else if ( "answer".equals( action ) ) {
            String answer = req.getParameter( "answer" );
            game.answer( id, answer );
        }
        else if ( "bind".equals( action ) ) {
            AsyncContext async = req.startAsync();
            game.bind( id, async );
        }
    }
}