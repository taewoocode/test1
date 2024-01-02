import java.util.ArrayList;

public class Customer {

    private int money;
    private ArrayList<FishBread> ownedFishBreads = new ArrayList<>();


    public Customer(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }

    public ArrayList<FishBread> getOwnedFishBreads(){
        return ownedFishBreads;
    }

    public void orderfishBreads(FishBread fishBread, int count, FishBreadSeller seller){
        Customer customer = null;
        seller.sellFishBread(fishBread, count, customer );
        if(count > 0 && count <= seller.getAvailableFishBreads().size()){
            for(int i = 0; i < count; i++){
                ownedFishBreads.add(fishBread);

            }
        }
    }

    public void addFishBread(FishBread fishBread) {
        ownedFishBreads.add(fishBread);
    }


    public void eatFishBread(int index){
        if(index >= 0  && index < ownedFishBreads.size()){
            FishBread fishBread = ownedFishBreads.remove(index);
            System.out.println("아이 맛있다~ " + fishBread.getFlavor() + "맛이네~");
            }else {
            System.out.println("잘못된 번호");
        }
    }

    public void decreaseMoney(int amount) {
        if (amount <= money) {
            money -= amount;
        } else {
            System.out.println( "잔액이 부족합니다." );
        }
    }
}




