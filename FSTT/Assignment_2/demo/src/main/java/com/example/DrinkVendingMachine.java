package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class DrinkVendingMachine {

    private BRANDS brandName = null;
    private float availableCredit = 0;
    private ArrayList<Snack> drinkList = new ArrayList<Snack>();

    public DrinkVendingMachine(){
        int size = BRANDS.values().length;
        int index = (int)(Math.random()) * size;

        //Select random Brand
        this.brandName = BRANDS.values()[index];
        populateDrinkList();
    }

    public DrinkVendingMachine(float startCredit, BRANDS brand) {
        this.availableCredit = startCredit;
        this.brandName = brand;

        populateDrinkList();
    }
    
    //===============================
    //===  Methods
    //===============================

    //Don't worry this is just populating our drink list
    private void populateDrinkList(){
        this.drinkList.addAll(Arrays.asList(DefaultSnacks.snackList));
    }

    // This is how we'll select our "snack" from the array
    public Snack selectDrink(int arrayPosition){
        if(arrayPosition <=  drinkList.size()) {
            Snack selection = drinkList.get(arrayPosition);

            if(this.availableCredit < selection.cost()){
                //TODO replace with Log4j
                System.out.println("WARNING: you do not have enough credit!");
                System.out.println("WARNING: machine credit - £" + this.availableCredit);
                return null;
            }
            else {
                // let's deduct machine credit
                availableCredit -= selection.cost();
                return selection;
            }
        }
        else{
            //TODO replace with Log4j
            System.out.println("WARNING: Item does not exist.");
            return null;
        }
    }

    public void giveCredit(Person user, float credit){
        //TODO replace with Log4j
        System.out.println("INFO: You have entered �"+credit);
        this.availableCredit += user.getCredit(credit) == 0 ? credit : user.getCredit(credit);
    }

    //===============================
    //===  'get'ors
    //===============================
    public float getAvailableCredit() {
        return availableCredit;
    }

    public ArrayList<Snack> getDrinkList() {
        return drinkList;
    }

    public BRANDS getBrandName() {
        return brandName;
    }

    //===============================
    //===  'set'ors
    //===============================
    public void setAvailableCredit(float availableCredit) {
        this.availableCredit = availableCredit;
    }

    public void setDrinkList(ArrayList<Snack> drinkList) {
        this.drinkList = drinkList;
    }

    public void setBrandName(BRANDS brandName) {
        this.brandName = brandName;
    }

}
