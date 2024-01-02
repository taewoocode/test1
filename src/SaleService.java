import java.util.ArrayList;
import java.util.Scanner;

public class SaleService {


    private FishBreadSeller fishBreadSeller;
    private Customer customer;

    public SaleService(FishBreadSeller fishBreadSeller, Customer customer) {
        this.fishBreadSeller = fishBreadSeller;
        this.customer = customer;
    }

    public void sellFishBread(int fishBreadIndex, int count) {
        if (fishBreadIndex >= 0 && fishBreadIndex < fishBreadSeller.getAvailableFishBreads().size()) {
            FishBread selectedFishBread = fishBreadSeller.getAvailableFishBreads().get(fishBreadIndex);
            fishBreadSeller.sellFishBread(selectedFishBread, count, customer);
        } else {
            System.out.println("잘못된 붕어빵 번호");
        }
    }

    public void displayAvailableFishBreads() {
        System.out.println("판매 중인 붕어빵 목록과 가격:");
        ArrayList<FishBread> sellingFishBreads = fishBreadSeller.getAvailableFishBreads();
        for (int i = 0; i < sellingFishBreads.size(); i++) {
            FishBread fishBread = sellingFishBreads.get(i);
            System.out.println(i + 1 + ". " + fishBread.getFlavor() + " - " + fishBread.getPrice() + "원");
        }
    }

    public void displayCustomerMoney() {
        System.out.println("나의 소지금 확인: " + customer.getMoney() + "원");
    }

    public void displaySafeMoney() {
        System.out.println("붕어빵 장수의 금고 돈 확인: " + fishBreadSeller.getSafe().getMoney() + "원");
    }
}

