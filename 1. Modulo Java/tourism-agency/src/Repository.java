import java.util.List;

public class Repository {
    private List<Locator> locators;

    public Repository(List<Locator> locators) {
        this.locators = locators;
    }

    public void printLocators() {
        locators.forEach(System.out::println);
    }

    public void addLocator(Locator locator) {
        locators.add(locator);
    }

    // Getters and setters
    public List<Locator> getLocators() {
        return locators;
    }

    public void setLocators(List<Locator> locators) {
        this.locators = locators;
    }
}
