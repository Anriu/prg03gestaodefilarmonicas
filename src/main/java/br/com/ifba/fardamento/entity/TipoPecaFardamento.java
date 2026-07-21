package br.com.ifba.fardamento.entity;

public enum TipoPecaFardamento{
    BLAZER("Blazer"),
    BLUSA("Blusa"),
    CALCA("Calça"),
    CORDAO("Cordão"),
    GRAVATA("Gravata"),
    QUEPE("Quepe"),
    SAIA("Saia");

    private final String descricao;

    TipoPecaFardamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}