package gustavo.franca.mag_bank.domain.enums;

public enum UserType {
    ADMIN(0, "ROLE_ADMIN"),
    USER(1, "ROLE_USER");

    private final Integer code;
    private final String description;

    UserType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static UserType fromCode(Integer code) {
        if (code == null) {
            throw new IllegalArgumentException("Código não pode ser nulo");
        }
        for (UserType type : UserType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + code);
    }
}
