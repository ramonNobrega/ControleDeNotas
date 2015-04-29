package controledenotas.business;

/* block[extraImport]*/
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
/* block[extraImport]*/
/* block[extraImport_1]*/
import java.io.Serializable;
/* block[extraImport_1]*/

@BusinessController
public class DesempenhoBimestreCalculaMedia implements Serializable {

	private static final long serialVersionUID = 1L;

/* block[abrirCalcularMedia]*/
public static Double calcularMedia(Double nota1,Double nota2,Double nota3) {
/* block[abrirCalcularMedia]*/

/* block[corpoCalculandoMedia]*/
Double media = (nota1+nota2+nota3)/3;
return media;
/* block[corpoCalculandoMedia]*/

/* block[fechandoCalcularMedia]*/
}
/* block[fechandoCalcularMedia]*/

}

