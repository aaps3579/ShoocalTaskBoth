package com.example.aman.shoocaltaskboth.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListData {
    public static HashMap<String, List<SingleRow>> getFullData() {
        HashMap<String, List<SingleRow>> expandableDataHm = new HashMap<>();

        //Adventure List
        List<SingleRow> adventureList = new ArrayList<>();
        adventureList.add(new SingleRow("Adventure: 11", false));
        adventureList.add(new SingleRow("Adventure: 12", false));
        adventureList.add(new SingleRow("Adventure: 12", false));
        adventureList.add(new SingleRow("Adventure: 12", false));
        adventureList.add(new SingleRow("Adventure: 12", false));

        //art list
        List<SingleRow> artList = new ArrayList<>();
        artList.add(new SingleRow("Art : 11", false));
        artList.add(new SingleRow("Art : 11", false));
        artList.add(new SingleRow("Art : 11", false));
        artList.add(new SingleRow("Art : 11", false));
        artList.add(new SingleRow("Art : 11", false));

        //cooking list
        List<SingleRow> cookingList = new ArrayList<>();
        cookingList.add(new SingleRow("Cooking : 11", false));
        cookingList.add(new SingleRow("Cooking : 11", false));
        cookingList.add(new SingleRow("Cooking : 11", false));
        cookingList.add(new SingleRow("Cooking : 11", false));
        cookingList.add(new SingleRow("Cooking : 11", false));

        //adding key and values
        expandableDataHm.put("Adventure", adventureList);
        expandableDataHm.put("Art", artList);
        expandableDataHm.put("Cooking", cookingList);
        return expandableDataHm;
    }

    public static List<String> getTitleData() {
        List<String> singleRowList = new ArrayList<>();
        singleRowList.add("Adventure");
        singleRowList.add("Art");
        singleRowList.add("Cooking");
        return singleRowList;
    }
}
