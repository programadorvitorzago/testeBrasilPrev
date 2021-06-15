/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.testeioasys.API;

import com.google.gson.Gson;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import local.testeioasys.Auxiliar.StringHelper;
import local.testeioasys.repositorio.*;
import local.testeioasys.repositorio.entidade.Cliente;

/**
 *
 * @author Vitor
 */
@Stateless
@Path("/client")
public class ClientREST extends APIBase {
    
    // Repositorio
    private RepositorioCliente repCliente = new RepositorioCliente();
    
    // CADASTRO
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response insert(String entidadeJson) {
        try
        {
            if(!StringHelper.isNullOrEmpty(entidadeJson))
            {
                
                Cliente entidade = repCliente.fromJson(entidadeJson);
                this.repCliente.INSERT(entidade);

                return super.CreateOK();
            }
            else
            {
                throw new Exception("String vazia");
            }
        }
        catch(Exception ex)
        {
            return super.ServerError(ex);
        }
    }
    
    // GET
    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Response getById(@PathParam("id") Integer id) {
        try
        {
            Cliente entidade = repCliente.GET(id);

            return super.CreateOK(entidade);
        }
        catch(Exception ex)
        {
            return super.ServerError(ex);
        }
    }
    
    // EDIT
    @PUT
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response edit(@PathParam("id") Integer id, String entidadeJson) {
        try
        {
            Cliente entidade = this.repCliente.fromJson(entidadeJson);
            entidade.setId(id);
            
            this.repCliente.UPDATE(entidade);
            
            return ResponseOK();
        }
        catch(Exception ex)
        {
            return super.ServerError(ex);
        }
    }
    
    // EDIT
    @DELETE
    @Path("/{id}")
    @Produces({"application/json"})
    public Response edit(@PathParam("id") Integer id) {
        try
        {
            Cliente entidade = this.repCliente.GET(id);
            if (entidade != null) {
                this.repCliente.DELETE(entidade);
                return ResponseOK();
            }
            else
            {
                throw new Exception(String.format("Não encontrado Entidade de id %02d", id));
            }
        }
        catch(Exception ex)
        {
            return super.ServerError(ex);
        }
    }
}
