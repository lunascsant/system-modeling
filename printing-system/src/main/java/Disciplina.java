import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private List<OfertaDisciplina> ofertas;


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
        this.ofertas.add(oferta);
    }
}
