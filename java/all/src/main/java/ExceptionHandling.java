public class ExceptionHandling {
    public static void main(String[] args) {
        ExceptionHandling eh = new ExceptionHandling();
        eh.testException();
    }

    public int testException() {
        try{
            System.out.println("test");
            throw new Error();

        } catch(Throwable e) {
            System.out.println("In error");
        } finally {
            System.out.println("Finally");
        }
        return 1;
    }

    public int test() {
        System.out.println("test2");
        return 0;
    }
}
