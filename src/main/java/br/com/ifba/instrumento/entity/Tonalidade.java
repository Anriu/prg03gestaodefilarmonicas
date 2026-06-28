package br.com.ifba.instrumento.entity;

public enum Tonalidade {

    DO("Dó"),
    SI_BEMOL("Si Bemol"),
    MI_BEMOL("Mi Bemol"),
    FA("Fá");

    private final String descricao;

    Tonalidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Tonalidade fromDescricao(String descricao) {
        for (Tonalidade tonalidade : values()) {
            if (tonalidade.getDescricao().equals(descricao)) {
                return tonalidade;
            }
        }
        throw new IllegalArgumentException("Tonalidade inválida: " + descricao);
    }

    @Override
    public String toString() {
        return descricao;
    }
}