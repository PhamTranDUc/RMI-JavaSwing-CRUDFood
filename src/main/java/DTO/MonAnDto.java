/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DTO.LoaiMonDto;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author phamduc
 */
public class MonAnDto implements Serializable{
    
    private static final long serialVersionUID = 123456727L;
     private String code;
    
    private String name;
    
    private  byte[] image;
    
    private Double price;
    
    private int time;
    
    private LoaiMonDto category;


    
    

    public MonAnDto(String code, String name, byte[] image, Double price, int time, LoaiMonDto category) {
        this.code = code;
        this.name = name;
        this.image = image;
        this.price = price;
        this.time = time;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public LoaiMonDto getCategory() {
        return category;
    }

    public MonAnDto() {
    }

    public void setCategory(LoaiMonDto category) {
        this.category = category;
    }
    
    public MonAnDto(String code, String name, byte[] image, Double price, int time,String category) throws RemoteException{
        this.code = code;
        this.name = name;
        this.image = image;
        this.price = price;
        this.time = time;
        this.category=new LoaiMonDto(category);
    }
    
    
    
}
