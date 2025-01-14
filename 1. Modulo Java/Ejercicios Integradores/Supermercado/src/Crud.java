public interface Crud<T> {
    public void crear(T t);
    public T consultar(String id);
    public void actualizar(T t, String id);
    public void eliminar(String id);
}