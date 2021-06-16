package local.testeBrasilPrev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path="/API")
public class APIUtilService {
    
    /**
     * Método rápido para testar se o servidor está on-line
     *   e recebendo requisições HTTP.
     * @return 
     */
    @RequestMapping(method = {RequestMethod.POST}, path = "IsAlive")
    public String IsAlive() {
        return "OK";
    }

}
