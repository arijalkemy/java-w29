import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocatorChecker {
    private final RepositoryClient repositoryClient;

    public LocatorChecker(RepositoryClient repositoryClient) {
        this.repositoryClient = repositoryClient;
    }


    public Integer getAmountOfLocators() {
        return repositoryClient.getLocators().size();
    }

    public Integer getTotalAmountOfBookings() {
        return repositoryClient.getLocators().stream()
                .mapToInt(locator ->
                        locator.getBookings().size()
                )
                .sum();
    }

    public List<Booking> getTotalBookings() {
        return repositoryClient.getLocators().stream()
                .flatMap(l -> l.getBookings().stream())
                .toList();
    }

    public Map<Booking.BookingType, List<Booking>> getTotalBookingsByType() {
        Map<Booking.BookingType, List<Booking>> bookingMap = new HashMap<>();
        getTotalBookings().forEach(booking -> {
            bookingMap.computeIfAbsent(booking.getType(), k -> new ArrayList<>()).add(booking);
        });
        return bookingMap;
    }

    public Double getTotalSelled() {
        return repositoryClient.getLocators().stream()
                .mapToDouble(Locator::getTotal)
                .sum();
    }

    public Double getTotalSelledAvg() {
        return getTotalSelled() / getAmountOfLocators();
    }
}
