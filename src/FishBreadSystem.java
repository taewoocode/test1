import java.util.ArrayList;
import java.util.Scanner;

public class FishBreadSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Safe safe = new Safe(10000);
    private static FishBreadSeller fishBreadSeller = new FishBreadSeller(safe);
    private static Customer customer = new Customer(10000);
    private static SaleService saleService = new SaleService(fishBreadSeller, customer);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    handleOrder();
                    break;
                case 2:
                    handleDisplayOwnedFishBreads();
                    break;
                case 3:
                    handleEatFishBread();

                    break;
                case 4:
                    saleService.displayAvailableFishBreads();
                    break;
                case 5:
                    saleService.displayCustomerMoney();
                    break;
                case 6:
                    saleService.displaySafeMoney();
                    break;
                case 7:
                    handleProgramExit();
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. 붕어빵 주문하기");
        System.out.println("2. 내 붕어빵 목록 출력");
        System.out.println("3. 붕어빵 먹기");
        System.out.println("4. 판매 중인 붕어빵 목록과 가격 출력");
        System.out.println("5. 나의 소지금 확인");
        System.out.println("6. 붕어빵 장수의 금고 돈 확인");
        System.out.println("7. 프로그램 종료");
        System.out.print("원하는 작업을 선택하세요: ");
    }

    private static int getChoice() {
        return scanner.nextInt();
    }

    private static void handleOrder() {
        saleService.displayAvailableFishBreads();
        System.out.print("주문할 붕어빵 번호를 선택하세요 (0: 취소): ");
        int orderChoice = scanner.nextInt();
        if (orderChoice != 0) {
            System.out.print("주문할 개수를 입력하세요: ");
            int orderCount = scanner.nextInt();
            saleService.sellFishBread(orderChoice - 1, orderCount);
        }
    }

    private static void handleDisplayOwnedFishBreads() {
        ArrayList<FishBread> ownedFishBreads = customer.getOwnedFishBreads();
        System.out.println("내 붕어빵 목록:");
        for (int i = 0; i < ownedFishBreads.size(); i++) {
            FishBread fishBread = ownedFishBreads.get(i);
            System.out.println(i + 1 + ". " + fishBread.getFlavor());
        }
        System.out.print("먹을 붕어빵 번호를 선택하세요 (0: 취소): ");
        int eatChoice = scanner.nextInt();
        if (eatChoice != 0) {
            customer.eatFishBread(eatChoice - 1);
        }
    }

    private static void handleEatFishBread() {
        if (customer.getOwnedFishBreads().isEmpty()) {
            System.out.println("먹을 붕어빵이 없습니다.");
        } else {
            System.out.print("먹을 붕어빵 번호를 선택하세요: ");
            int eatChoice = scanner.nextInt();
            customer.eatFishBread(eatChoice - 1);
        }
    }

    private static void handleProgramExit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
