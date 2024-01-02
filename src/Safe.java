public class Safe {

    private int money;

    public Safe(int initialMoney){
        this.money = initialMoney;
    }

    public int getMoney(){
        return money;
    }

    public void addMoney(int amount){
        money += amount;
    }

    public void deductMoney(int amount){
        money -= amount;
    }
}
