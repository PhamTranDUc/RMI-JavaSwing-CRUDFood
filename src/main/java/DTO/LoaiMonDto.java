/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author phamduc
 */
import java.io.Serializable;
import java.util.Objects;

public class LoaiMonDto implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private String name;
    private String description;
    private String code;

    public LoaiMonDto(String code,String name, String description) {
        this.name = name;
        this.description = description;
        this.code=code;
    }

    public LoaiMonDto() {
    }
    

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LoaiMonDto(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoaiMonDto other = (LoaiMonDto) obj;
        return Objects.equals(this.code, other.code);
    }
    
    
}

