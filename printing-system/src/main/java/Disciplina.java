import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private List<OfertaDisciplina> ofertas;


    public Disciplina(String codigo) {
        this.codigo = codigo;
        ofertas = new ArrayList<OfertaDisciplina>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    void adicionarOfertaDisciplina(OfertaDisciplina oferta){
        if(this.codigo == oferta.getDisciplina().getCodigo()) {
            return;
        }

        this.ofertas.add(oferta);
    }


}
