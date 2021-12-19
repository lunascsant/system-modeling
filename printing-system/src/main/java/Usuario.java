import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Usuario {
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private int idade;

    public Usuario (String nome, String sexo, Date dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;

        Date agora = new Date();
        LocalDate aniversario = LocalDate.of(dataNascimento.getYear(), dataNascimento.getMonth(), dataNascimento.getDate());
        LocalDate nesseMomento = LocalDate.of(agora.getYear() + 1900, agora.getMonth(), agora.getDate());
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
