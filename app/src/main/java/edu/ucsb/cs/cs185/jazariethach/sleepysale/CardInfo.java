package edu.ucsb.cs.cs185.jazariethach.sleepysale;

/**
 * Created by Jazarie on 6/5/2015.
 */
public class CardInfo {
    public String itemName;
    public int itemPrice;
    public String contactInfo;
    public String description;
    public String tags;
    public int image;
    public boolean obo;
    public boolean sold;
    public boolean buyNow; //implies bidding
    public int numBids;

    public CardInfo(String name, int price, String contact, String desc,
                    int image, boolean obo, boolean sold, boolean buyNow, int numBids, String categories){

        this.itemName = name;
        this.itemPrice = price;
        this.contactInfo = contact;
        this.description = desc;
        this.image = image;
        this.obo = obo;
        this.sold = sold;
        this.buyNow = buyNow;
        this.numBids = numBids;
        this.tags = categories;
    }
}