package edu.ucsb.cs.cs185.jazariethach.sleepysale;

/**
 * Created by Jazarie on 6/5/2015.
 */
public class CardInfo {
    public String itemName;
    public int itemPrice;
    public String description;
    public String tags;
    public int image;
    public int days;
    public boolean sold;
    public boolean buyNow; //implies bidding
    public int numBids;

    public CardInfo(String name, int price, String desc,
                    int image, int days, boolean sold, int numBids, String categories){

        this.itemName = name;
        this.itemPrice = price;
        this.description = desc;
        this.image = image;
        this.days = days;
        this.sold = sold;
        this.buyNow = buyNow;
        this.numBids = numBids;
        this.tags = categories;
    }
}