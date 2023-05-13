package project.enums;

public enum CompanyTypeName {
    ALL("all"),
    SOFT("soft"),
    DESIGN_HOUSE("design-house"),
    SYSTEM("system"),
    CHEMICAL("chemical"),
    DEVICE("device"),
    SEMICONDUCTOR("semiconductor");

    private final String typeName;

    private CompanyTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }


}
