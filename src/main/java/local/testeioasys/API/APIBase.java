/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeioasys.API;

import com.google.gson.Gson;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vitor
 */
public abstract class APIBase {
    
    private Gson jsonPARSER = new Gson();
    /**
     * Retirona uma resposta padrão de êxito
     * @return 
     */
    public Response CreateOK()
    {
        return Response.status(201).build();
    }
    
    /**
     * Retorna uma resposta Padrão de êxito com corpo
     * @return 
     */
    public Response CreateOK(Object objeto)
    {
        return Response.ok()
                .entity(jsonPARSER.toJson(objeto)).build();
    }
    
    public Response ResponseOK()
    {
        return Response.ok().build();
    }
    
    public Response ServerError(Exception ex)
    {
        return Response.serverError().entity("Falha: " + ex.getMessage())
                    .build();
    }
}
