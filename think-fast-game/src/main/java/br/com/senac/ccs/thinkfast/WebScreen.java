/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.ccs.thinkfast;

import org.springframework.web.context.request.async.DeferredResult;

/**
 *
 * @author Victor
 */
public class WebScreen implements Screen{

    private DeferredResult<Result> deferredResult;
    
    public WebScreen(DeferredResult<Result> deferredResult)
    {
        this.deferredResult = deferredResult;
    }
    
    public void show(Result result) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
