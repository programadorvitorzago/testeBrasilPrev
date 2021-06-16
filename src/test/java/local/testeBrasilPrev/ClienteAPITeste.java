package local.testeBrasilPrev;

import io.micrometer.core.ipc.http.HttpSender;
import java.util.List;
import local.testeBrasilPrev.controller.ClienteAPIService;
import local.testeBrasilPrev.repositorio.entidade.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.Assert;
import org.springframework.web.servlet.resource.HttpResource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteAPITeste {

    @Autowired
    private ClienteAPIService clienteAPI;
        
    @Test
    public void Teste_MetodosAPI() {
        Long ID_clientePivo = null;
        ResponseEntity<Cliente> resp;
        ResponseEntity<Void> respVoid;
                
        // INSERT
        Cliente novoCli = new Cliente();
        novoCli.setNome("Cliente 01");
        novoCli.setCpf("CPF cliente 01");
        novoCli.setEndereco("Enredeço Cliente 01");
                
        resp = clienteAPI.adicionar(novoCli);
        Assert.isTrue(resp.getStatusCodeValue() == HttpStatus.CREATED.value(), "Status HTTP deveria ser CREATED");
        Assert.notNull(novoCli.getId(), "Novo cliente cadastrado deveria vir com ID preenchido.");
        
        System.out.println("Teste de cadastro de novo Cliente: OK");
        
        ID_clientePivo = novoCli.getId();
        
        // Select ALL
        List<Cliente> listaCli = clienteAPI.listar();
        
        Assert.isTrue(listaCli.size() == 1, "A lista de Clientes deveria ser 1");
        System.out.println("Teste de lista de Clientes: OK");
        
        // UPDATE
        resp = clienteAPI.buscar(ID_clientePivo);
        if(resp.hasBody())
        {
            Cliente cli = resp.getBody();
            cli.setEndereco("Endereço Cli01 - Rua Matilde");
            
            resp = this.clienteAPI.atualizar(ID_clientePivo, cli);
            
            Assert.isTrue(resp.getStatusCodeValue() == HttpStatus.ACCEPTED.value(), "Não foi atualizado com êxito.");
            System.out.println("Teste de atualizaçao de Cliente: OK");
        }
        else
        {
            Assert.isTrue(false, String.format("Um cliente de ID %d deveria existir.", ID_clientePivo));
        }
        
        // DELETE
        respVoid = this.clienteAPI.remover(ID_clientePivo);
        Assert.isTrue(resp.getStatusCodeValue() == HttpStatus.NO_CONTENT.value(), "Status HTTP deveria ser NO_CONTENT");
        System.out.println("Teste de deleção de Cliente: OK");
        
    }
    

}
