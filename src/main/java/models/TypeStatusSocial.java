package models;

public enum TypeStatusSocial {
    BAJO("bajo"),
    MEDIO("medio"),
    ALTO("alto");

    private String description;

    TypeStatusSocial(String description){this.description = description;}

    public static TypeStatusSocial find(String value){
        for (TypeStatusSocial statusSocial: values()){
            if(statusSocial.toString().equalsIgnoreCase(value)){
                return statusSocial;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid Social status type %s", value));
    }
}
