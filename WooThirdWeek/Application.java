package WooThirdWeek;

public class Application {
    public static void main(String[] args) {
        Domain domain = new Domain();
        try{
            domain.buyTicket();
            domain.receiveWinningNumber();
            domain.printPrize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
