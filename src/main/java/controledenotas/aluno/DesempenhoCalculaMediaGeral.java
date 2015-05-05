package controledenotas.aluno;

/* block[extraImport]*/
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
/* block[extraImport]*/
/* block[extraImport_1]*/
import java.io.Serializable;
/* block[extraImport_1]*/

@BusinessController
public class DesempenhoCalculaMediaGeral implements Serializable {

	private static final long serialVersionUID = 1L;

/* block[calculaMediaGeral]*/
public Double calculaMediaGeral(Double mediaBimestral1, Double mediaBimestral2, Double mediaBimestral3, Double mediaBimestral4){
	Double mediaParcial = (mediaBimestral1+mediaBimestral2+mediaBimestral3+mediaBimestral4)/4;
	return mediaParcial;
}
/* block[calculaMediaGeral]*/

}

