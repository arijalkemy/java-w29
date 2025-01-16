//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Series2 series2 = new Series2(1);
        Series3 series3 = new Series3();

        series2.next();
        series2.next();
        series2.next();
        series2.next();
        series2.setInitialValue(99);
        series2.next();

        series3.next();
        series3.next();
        series3.next();
        series3.restart();
        series3.next();

    }
}