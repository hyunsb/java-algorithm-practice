package Level1;

public class StringSortReverse {
    public static void main(String[] args) {
        String str = "Hello, world!";
        //Use StringBuffer
        String reverseBuffer = new StringBuffer(str).reverse().toString();

        //Use Stream :: JAVA8
        String reverseStream = str.chars().sorted().collect(
                                                        StringBuilder::new,
                                                        StringBuilder::appendCodePoint,
                                                        StringBuilder::append).toString();
        System.out.println(reverseBuffer);
        System.out.println(reverseStream);
    }
}
