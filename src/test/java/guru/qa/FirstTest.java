//package guru.qa;
//
//
//import org.junit.jupiter.api.*;
//
//public class FirstTest {
//
//    @BeforeAll
//    static void beforeAll(){
//        System.out.println("This is the Before all method!");
//    }
//
//    @AfterAll
//    static void afterAll(){
//        System.out.println("This is the After all method!");
//    }
//
//    @BeforeEach
//    void openYandex(){
//        System.out.println("    open(\"ya.ru\")");
//    }
//
//    @AfterEach
//    void takeScreenshot(){
//        System.out.println("    takeScreenshot();");
//    }
//
//    @Test
//    void  firstTest(){
//        System.out.println("        First Test");
//        Assertions.assertTrue(true);
//    }
//
//    @Test
//    void  secondTest(){
//        System.out.println("        Second Test");
//        Assertions.assertTrue(true);
//    }
//}
