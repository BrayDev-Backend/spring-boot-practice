package com.myself.practicing.domain.models;

public class Product {

    private Long id;
    private String name;
    private int amount;
    private String category;

    public Product(Long id, String name, int amount, String category)
    {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public Long getId()
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

}
