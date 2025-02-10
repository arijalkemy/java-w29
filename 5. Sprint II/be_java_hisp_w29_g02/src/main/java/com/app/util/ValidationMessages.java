package com.app.util;

public class ValidationMessages {

    // Post Validations
    public static final String VALIDATION_POST_ID_NOT_NULL = "El postId no puede estar vacío.";
    public static final String VALIDATION_POST_ID_MIN = "El postId debe ser mayor a cero.";
    public static final String VALIDATION_USER_ID_NOT_NULL = "El userId no puede estar vacío.";
    public static final String VALIDATION_USER_ID_MIN = "El userId debe ser mayor a cero.";
    public static final String VALIDATION_DATE_NOT_BLANK = "La fecha no puede estar vacía.";
    public static final String VALIDATION_DATE_PATTERN = "Fecha inválida. Formato esperado: dd-MM-yyyy.";
    public static final String VALIDATION_PRODUCT_NOT_NULL = "El producto no puede ser nulo.";
    public static final String VALIDATION_CATEGORY_MIN = "La categoría debe ser mayor a cero.";
    public static final String VALIDATION_PRICE_MAX = "El precio no puede exceder 10,000,000.";
    public static final String VALIDATION_FIELD_NOT_NULL = "El campo no puede ser nulo.";
    public static final String VALIDATION_DISCOUNT_MIN = "El descuento debe ser al menos 0.0.";
    public static final String VALIDATION_DISCOUNT_MAX = "El descuento no puede exceder 0.99.";
    public static final String VALIDATION_PROMO_DISCOUNT = "Si hay promoción, el descuento debe ser mayor a 0.0.";

    // Product Validations
    public static final String VALIDATION_PRODUCT_ID_NOT_NULL = "El ID del producto no puede ser nulo.";
    public static final String VALIDATION_PRODUCT_ID_MIN = "El ID del producto debe ser mayor a cero.";
    public static final String VALIDATION_PRODUCT_NAME_NOT_BLANK = "El nombre del producto no puede estar vacío.";
    public static final String VALIDATION_PRODUCT_NAME_SIZE = "El nombre del producto debe tener como máximo 40 caracteres.";
    public static final String VALIDATION_PRODUCT_TYPE_NOT_BLANK = "El tipo del producto no puede estar vacío.";
    public static final String VALIDATION_PRODUCT_TYPE_SIZE = "El tipo del producto debe tener como máximo 15 caracteres.";
    public static final String VALIDATION_PRODUCT_BRAND_NOT_BLANK = "La marca del producto no puede estar vacía.";
    public static final String VALIDATION_PRODUCT_BRAND_SIZE = "La marca del producto debe tener como máximo 25 caracteres.";
    public static final String VALIDATION_PRODUCT_COLOR_NOT_BLANK = "El color del producto no puede estar vacío.";
    public static final String VALIDATION_PRODUCT_COLOR_SIZE = "El color del producto debe tener como máximo 15 caracteres.";
    public static final String VALIDATION_PRODUCT_NOTES_NOT_BLANK = "Las notas del producto no pueden estar vacías.";
    public static final String VALIDATION_PRODUCT_NOTES_SIZE = "Las notas del producto deben tener como máximo 80 caracteres.";

    private ValidationMessages() {}



}
