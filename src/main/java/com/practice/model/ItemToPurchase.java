package com.practice.model;

//****** This class is used to get/set Item name , ItemPrice , ItemQuantity

public class ItemToPurchase {

        public String itemName;
        public double itemPrice;
        public int itemQuantity;

   public ItemToPurchase()
        {
            itemName="none";
            itemPrice=0;
            itemQuantity=0;
        }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
