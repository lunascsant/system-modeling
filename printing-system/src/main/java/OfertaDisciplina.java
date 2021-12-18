import java.util.List;

public class OfertaDisciplina {
    private Disciplina disciplina;
    private Professor professor;
    private Semestre semestre;


    public OfertaDisciplina(Professor professor, Disciplina disciplina, Semestre semestre) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.semestre = semestre;

        professor.adicionaDisciplina(disciplina);
        disciplina.adicionarOfertaDisciplina(this);
        semestre.adicionarDisciplina(this);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
