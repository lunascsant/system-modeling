import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Usuários
        Date birthDate = new Date(2000, 7, 27, 0, 0, 0);
        Secretario secretario = new Secretario("Alberto Santos", "m", birthDate, "Segunda à sexta - 10h - 18h");
        Professor professor = new Professor("José da Silva", "m", birthDate, "Terça - 19h às 20h");
        Professor professor2 = new Professor("João da Silva", "m", birthDate, "Terça - 19h às 20h");
        Aluno aluno = new Aluno("Maria Dias", "f", birthDate, "202065566C", "Ciência da Computação");
        secretario.adicionaUsuario(professor);
        secretario.adicionaUsuario(professor2);
        secretario.adicionaUsuario(aluno);
        secretario.adicionaUsuario(secretario);

        // Testando para ver se o secretário mantém o registro dos usuários
        for(Usuario u : secretario.getUsuariosRegistrados()) {
            System.out.println(u.getNome());
        }

        // Testando cálculo da idade
        System.out.println("Idade do professor José, nascido em " + professor.getDataNascimento().getYear() + " é " + professor.getIdade() + " anos.");

        // Testando adição de disciplina por professor
        Disciplina disciplina = new Disciplina("MAT166");
        Disciplina disciplina2 = new Disciplina("DCC123");
        Semestre semestre = new Semestre("2021/1");

        professor.setSemestreAtual(semestre);
        professor2.setSemestreAtual(semestre);

        // Testa dar a mesma disciplina para dois professores
        professor.adicionaDisciplina(disciplina);
        professor2.adicionaDisciplina(disciplina);

        // Testa dar a mesma disciplina para o mesmo professor
        professor.adicionaDisciplina(disciplina2);
        professor.adicionaDisciplina(disciplina2);

        // Imprime disciplinas do professor
        for (OfertaDisciplina disciplinaOfertada : professor.getDisciplinasMinistradas()) {
            System.out.println(disciplinaOfertada.getDisciplina().getCodigo());
        }

        // Testando solicitação impressão
        Impressao impressao1 = new Impressao("C:\\Users\\lucia\\Documents\\ProvaA", 10);
        Impressao impressao2 = new Impressao("C:\\Users\\lucia\\Documents\\ProvaB", 10);
        Impressao impressao3 = new Impressao("C:\\Users\\lucia\\Documents\\ProvaC", 202);
        Impressao impressao4 = new Impressao("C:\\Users\\lucia\\Documents\\ProvaC", 51);
        List<Impressao> impressoes = new ArrayList<Impressao>();
        List<Impressao> impressoes2 = new ArrayList<Impressao>();
        List<Impressao> impressoes3 = new ArrayList<Impressao>();
        impressoes.add(impressao1);
        impressoes.add(impressao2);
        impressoes3.add(impressao3);
        impressoes2.add(impressao4);

        aluno.solicitarImpressao(0, new Date(), impressoes, "Preto");
        aluno.solicitarImpressao(1, new Date(), impressoes2, "Colorido");
        professor.solicitarImpressao(2, new Date(), impressoes3, "Preto");

        // Testando consulta fila de impressões
        secretario.consultaPedidosImpressaoSolicitados();

        // Testando impressão e entrega de pedidos de impressão
        while (secretario.getFilaParaImprimir().getPedidos().size() != 0) {
            secretario.imprimeProximo();
            secretario.consultaPedidosImpressaoSolicitados();
        }

        secretario.consultaPedidosImpressaoConcluidos();

        // Testando pagamento e entrega
        secretario.entregarPedidoImpressao("Gratuito", 0);
        secretario.consultaPedidosImpressaoConcluidos();
        secretario.entregarPedidoImpressao("Crédito", 1);
        secretario.consultaPedidosImpressaoConcluidos();
        secretario.entregarPedidoImpressao("Fiado", 2);
        secretario.consultaPedidosImpressaoConcluidos();
        secretario.entregarPedidoImpressao("Débito", 2);

        secretario.consultaPedidosImpressaoConcluidos();
    }
}
