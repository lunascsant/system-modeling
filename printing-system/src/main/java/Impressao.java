public class Impressao {
    private String diretorio;
    private int numCopias;

    public Impressao(String diretorio, int numCopias) {
        this.diretorio = diretorio;
        this.numCopias = numCopias;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }
}
