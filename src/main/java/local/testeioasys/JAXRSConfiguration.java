package local.testeioasys;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import local.testeioasys.repositorio.ControladorAcesso;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
@ApplicationPath("API")
public class JAXRSConfiguration extends Application {

    @Override
    protected void finalize() throws Throwable {
        try {
            ControladorAcesso.getGlobalEntityManager().close();
            System.out.println("Finalizado Conexão");
        } finally {
            super.finalize();
        }
    }
}
