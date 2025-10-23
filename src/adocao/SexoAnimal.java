package adocao;

public enum SexoAnimal {
    M,
    F;
    public static SexoAnimal fromString(String sexo) {
        if (sexo == null) return null;
        switch (sexo.trim().toUpperCase()) {
            case "M":
                return M;
            case "F":
                return F;
            default:
                throw new IllegalArgumentException("Sexo inválido. Use 'M' ou 'F'.");
        }
    }


    }
