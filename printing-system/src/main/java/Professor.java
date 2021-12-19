import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Professor extends Funcionario {

    private String horarioAtendimento;
    private static int MAX_COPIAS_GRATUITAS = 200;
    private List<OfertaDisciplina> disciplinasMinistradas;
    private Semestre semestreAtual;

    public Professor(String nome, String sexo, Date dataNascimento,String matricula, String unidade, String departamento, String horarioAtendimento) {
        super(nome, sexo, dataNascimento, matricula, unidade, departamento);
        this.horarioAtendimento = horarioAtendimento;
        disciplinasMinistradas = new ArrayList<OfertaDisciplina>();
    }

    public List<OfertaDisciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(List<OfertaDisciplina> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

    public void adicionaDisciplina(Disciplina novaDisciplina){
        for (OfertaDisciplina i: semestreAtual.getDisciplinasOfertadas()){

            if(i.getDisciplina().getCodigo().equals(novaDisciplina.getCodigo())) {
                System.out.println("Disciplina "+novaDisciplina.getCodigo()
                                    +" já está sendo ofertada no semestre "+semestreAtual.getNome()
                                    +" pelo professor "+ i.getProfessor().getNome());
                return;
            }
        }

        for (OfertaDisciplina i: disciplinasMinistradas){
            if(i.getDisciplina().getCodigo().equals(novaDisciplina.getCodigo())) {
                System.out.println("Disciplina já é ministrada por esse professor.");
                return;
            }
        }

        OfertaDisciplina novaOfertaDisciplina = new OfertaDisciplina(this, novaDisciplina, semestreAtual);
        this.disciplinasMinistradas.add(novaOfertaDisciplina);
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public void setSemestreAtual(Semestre semestre) {
        this.semestreAtual = semestre;
    }

    public static int getMaxCopiasGratuitas() {
        return MAX_COPIAS_GRATUITAS;
    }

    public void solicitarImpressao(int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        Secretario.registrarPedidoImpressao(this, this.getMaxCopiasGratuitas(), numero, dataHoraPedido, arquivosImpressao, corImpressao);
    }
}
