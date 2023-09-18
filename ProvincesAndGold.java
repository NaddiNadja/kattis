public class ProvincesAndGold {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int gold = io.getInt();
        int silver = io.getInt();
        int copper = io.getInt();
        int buyingpower = gold*3 + silver*2 + copper*1;
        
        String victoryCard;
        String treasureCard;
        
        if (buyingpower >= 8) victoryCard = "Province";
        else if (buyingpower >= 5) victoryCard = "Duchy";
        else if (buyingpower >= 2) victoryCard = "Estate";
        else victoryCard = null;

        
        if (buyingpower >= 6) treasureCard = "Gold";
        else if (buyingpower >= 3) treasureCard = "Silver";
        else treasureCard = "Copper";

        if (victoryCard == null) System.out.println(treasureCard);
        else System.out.println(victoryCard + " or " + treasureCard);
    }
}