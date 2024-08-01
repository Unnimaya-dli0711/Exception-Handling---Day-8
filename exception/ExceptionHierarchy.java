package exception;

public class ExceptionHierarchy {
    public static void main(String[] args) {
        try {
            int result=10/0;
            String string=null;
        }catch (ArithmeticException e){
            System.out.println(e);
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
