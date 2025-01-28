package com.social_media.social_media.utils;

import com.social_media.social_media.exception.InvalidOrderException;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Function;

public final class ComparatorOrder {
    private static final Set<String> VALID_ORDERS = Set.of("date_asc", "date_desc", "name_asc", "name_desc");
    private ComparatorOrder() {}

    private static void validateOrder(String order) {
        if (!VALID_ORDERS.contains(order)) {
            throw new InvalidOrderException(MessagesExceptions.INVALID_ORDER);
        }
    }

    public static <T> Comparator<T> getComparator(String order,
                                                  Function<T, Comparable> firstCriteria,
                                                  Function<T, Comparable> secondCriteria) {
        validateOrder(order);
        String typeOfOrder = order.split("_")[1];

        Comparator<T> comparator = Comparator.comparing(firstCriteria);
        comparator = switch (typeOfOrder) {
            case "asc" -> comparator;
            case "desc" -> comparator.reversed();
            default -> throw new InvalidOrderException(MessagesExceptions.INVALID_ORDER);
        };

        if (secondCriteria != null) {
            comparator = comparator.thenComparing(secondCriteria);
        }

        return comparator;
    }

    public static <T> Comparator<T> getComparator(String order, Function<T, Comparable> criteria) {
        return getComparator(order, criteria, null);
    }
}
