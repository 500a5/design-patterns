package singleton;

public class SingletonJava {
    private static SingletonJava instance = null;

    private SingletonJava() {
    }

    public static synchronized SingletonJava getInstance() {
        if (instance == null) {
            instance = new SingletonJava();
        }
        return instance;
    }

    String value = "s";

    void function() {
        System.out.println("function in singleton.SingletonKotlin");

    }

}
