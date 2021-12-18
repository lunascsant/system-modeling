import java.util.ArrayList;
import java.util.List;

public class Semestre {
    private String nome;
    private List<OfertaDisciplina> disciplinasOfertadas;

    public Semestre() {
        disciplinasOfertadas = new ArrayList<OfertaDisciplina>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<OfertaDisciplina> getDisciplinasOfertadas() {
        return disciplinasOfertadas;
    }

    public void setDisciplinasOfertadas(List<OfertaDisciplina> disciplinasOfertadas) {
        this.disciplinasOfertadas = disciplinasOfertadas;
    }

    public void adicionarDisciplina(OfertaDisciplina ofertaDisciplina){
        disciplinasOfertadas.add(ofertaDisciplina);
    }
}
