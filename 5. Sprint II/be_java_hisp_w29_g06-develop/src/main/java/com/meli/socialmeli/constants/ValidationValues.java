package com.meli.socialmeli.constants;

public class ValidationValues {
    public static final String NAME_MAX_LENGTH = "El nombre no debe tener más de 15 caracteres";
    public static final int NAME_MAX_LENGTH_NUMBER = 15;

    public static final String ID_CANT_BE_EMPTY = "El id no puede estar vacio";
    public static final String ID_POSITIVE_NUMBER = "El id debe ser mayor a cero";

    public static final String FIELD_CANT_BE_EMPTY = "El campo no puede estar vacio";
    public static final String DATE_CANT_BE_EMPTY = "La fecha no puede estar vacia";

    public static final long PRODUCT_MAX_VALUE = 10000000l;
    public static final String PRODUCT_MAX_VALUE_STRING = "El precio máximo por producto es de 10.000.000";

    public static final String REGEX_NO_SPECIAL_CHARACTERS = "^[a-zA-Z0-9 ]*$";
    public static final String REGEX_NO_SPECIAL_CHARACTERS_STRING = "El campo no puede poseer caracteres especiales.";

    public static final int PRODUCT_NAME_MAX_LENGTH_NUMBER = 40;
    public static final String PRODUCT_NAME_MAX_LENGTH = "La longitud no puede superar los 40 caracteres.";

    public static final int TYPE_NAME_MAX_LENGTH_NUMBER = 15;
    public static final String TYPE_MAX_LENGTH = "La longitud no puede superar los 15 caracteres.";

    public static final int BRAND_ID_MAX_LENGTH_NUMBER = 25;
    public static final String BRAND_ID_MAX_LENGTH = "La longitud no puede superar los 25 caracteres";

    public static final int COLOT_MAX_LENGTH_NUMBER = 15;
    public static final String COLOR_MAX_LENGTH = "La longitud no puede superar los 15 caracteres";

    public static final int NOTES_MAX_LENGTH_NUMBER = 80;
    public static final String NOTES_MAX_LENGTH = "La longitud no puede superar los 80 caracteres";
}
