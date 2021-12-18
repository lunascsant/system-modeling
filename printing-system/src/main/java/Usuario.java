import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class Usuario {
    private String nome;
    private String sexo;
    private Calendar dataNascimento;
    private int idade;

    public Usuario (String nome, String sexo, Calendar dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        Calendar agora = Calendar.getInstance();
        LocalDate aniversario = LocalDate.of(dataNascimento.get(Calendar.YEAR), dataNascimento.get(Calendar.MONTH), dataNascimento.get(Calendar.DAY_OF_MONTH));
        LocalDate nesseMomento = LocalDate.of(agora.get(Calendar.YEAR), agora.get(Calendar.MONTH), agora.get(Calendar.DAY_OF_MONTH));
        this.idade = Period.between(aniversario, nesseMomento).getYears();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
