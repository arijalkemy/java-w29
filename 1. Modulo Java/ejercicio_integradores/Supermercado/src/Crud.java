public interface Crud <T> {
    public void create(T object);

    public void update(T object);
    public void delete();
    public void read();
}
