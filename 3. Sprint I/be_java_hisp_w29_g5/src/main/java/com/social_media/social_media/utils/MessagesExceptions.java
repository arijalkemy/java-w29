package com.social_media.social_media.utils;

public final class MessagesExceptions {
    private MessagesExceptions() {
    }

    public static final String SELLER_ID_NOT_EXIST = "El vendedor no existe";
    public static final String FOLLOWED_USER_NOT_SELLER = "El usuario a seguir no es un vendedor";
    public static final String NOT_FOLLOW_ALREADY_EXISTS = "No existe seguimiento de este usuario hacia el usuario especificado.";
    public static final String THE_USER_CANNOT_FOLLOW_THEMSELVES = "El usuario no se puede seguir a si mismo";
    public static final String FOLLOW_ALREADY_EXISTS = "Este usuario ya está siguiendo al usuario especificado.";
    public static final String USER_NOT_FOUND = "El usuario no fue encontrado";
    public static final String NO_FOLLOWERS_FOUND = "No se encontraron seguidores para el usuario con ID: ";
    public static final String NO_RECENT_POSTS_FOUND = "No se encontraron publicaciones recientes para los seguidores del usuario con ID: ";
    public static final String END_DATE_BEFORE_PUBLICATION_DATE = "La fecha de finalización de la promoción no puede ser anterior a la fecha de publicación.";
    public static final String INVALID_ORDER = "El orden indicado es inválido.";
    public static final String INVALID_FOLLOW_ENTITY = "La entidad Follow es inválida";
    public static final String INVALID_POST_ENTITY = "La entidad Post es inválida";
    public static final String INVALID_USER_ENTITY = "La entidad User es inválida";
    public static final String POST_NOT_FOUND = "La publicación no fue encontrada";
    public static final String POST_ALREADY_FAVORITE = "La publicación ya es favorita para ese usuario";
    public static final String NO_FAVOURITE_POSTS = "El usuario no posee posts favoritos.";
    public static final String NO_SUGGESTIONS = "No encontramos sugerencias de vendedores que el usuario pueda seguir.";
}
