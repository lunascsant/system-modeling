import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Professor extends Usuario {

    private String horarioAtendimento;
    private static int MAX_COPIAS_GRATUITAS = 200;
    private List<OfertaDisciplina> disciplinasMinistradas;
    private Semestre semestreAtual;

    public Professor(String nome, String sexo, Calendar dataNascimento, String horarioAtendimento) {
        super(nome, sexo, dataNascimento);
        this.horarioAtendimento = horarioAtendimento;
    }

    public List<OfertaDisciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(List<OfertaDisciplina> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

    public void adicionaDisciplina(Disciplina novaDisciplina){
        for (OfertaDisciplina i: semestreAtual.getDisciplinasOfertadas()){
            if(i.getDisciplina().getCodigo() == novaDisciplina.getCodigo()) {
                return;
            }
        }

        for (OfertaDisciplina i: disciplinasMinistradas){
            if(i.getDisciplina().getCodigo() == novaDisciplina.getCodigo()) {
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

    public static int getMaxCopiasGratuitas() {
        return MAX_COPIAS_GRATUITAS;
    }

    public void solicitarPedidoImpressao(int numero, Date dataHoraPedido, List<Impressao> arquivosImpressao, String corImpressao) {
        Secretario.registrarPedidoImpressao(this, this.getMaxCopiasGratuitas(), numero, dataHoraPedido, arquivosImpressao, corImpressao);
    }
}
