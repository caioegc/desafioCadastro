package adocao;

public enum TipoAnimal {
    Cachorro,
    Gato;

    public static TipoAnimal fromString(String tipo) {
        if (tipo == null) return null;
        switch (tipo.trim().toLowerCase()) {
            case "cachorro":
                return Cachorro;
            case "gato":
                return Gato;
            default:
                throw new IllegalArgumentException("Tipo de animal inválido. Use 'Cachorro' ou 'Gato'.");
        }
    }

    }
