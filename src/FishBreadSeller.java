import java.util.ArrayList;

public class FishBreadSeller {

    private ArrayList<FishBread> availableFishBreads = new ArrayList<>();
    private Safe safe;

    public FishBreadSeller(Safe safe) {
        this.safe = safe;
        availableFishBreads.add(new FishBread("팥 붕어빵",1000));
        availableFishBreads.add(new FishBread("크림 붕어빵",1500));
        availableFishBreads.add(new FishBread("매운 붕어빵",2000));

    }

    public ArrayList<FishBread> getAvailableFishBreads(){
        return availableFishBreads;
    }

    public void sellFishBread(FishBread fishBread, int count) {
        int totalPrice = fishBread.getPrice() * count;
        if (count > 0 && count <= availableFishBreads.size() && totalPrice <= safe.getMoney()) {
            System.out.println( "구매완료: " + count + "개의" + fishBread.getFlavor() + "( " + totalPrice + "원" );
            safe.deductMoney( totalPrice );
        } else {
            System.out.println( "구매 실패: 잘못된 주문 또는 잔액이 부족" );
        }
    }

    public Safe getSafe() {
        return safe;
    }
}


