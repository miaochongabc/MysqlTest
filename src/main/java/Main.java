import org.junit.Test;

public class Main {


        @Test
        public void test(){
                try {
                        System.out.println(JDBCTools.getConnection());
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

}

