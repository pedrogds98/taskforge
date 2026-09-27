package br.com.docodigoaocontrato.taskforge.dto;


import java.util.List;

public class CatalogoDTO {
    private String nomeDoCatalogo;
    private int total;
    private List<MidiaDTO> midias;

    public CatalogoDTO(String nomeDoCatalogo, int total, List<MidiaDTO> midias) {
        this.nomeDoCatalogo = nomeDoCatalogo;
        this.total = total;
        this.midias = midias;
    }

    public String getNomeDoCatalogo() {
        return nomeDoCatalogo;
    }

    public void setNomeDoCatalogo(String nomeDoCatalogo) {
        this.nomeDoCatalogo = nomeDoCatalogo;
    }

    public List<MidiaDTO> getMidias() {
        return midias;
    }

    public void setMidias(List<MidiaDTO> midias) {
        this.midias = midias;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
