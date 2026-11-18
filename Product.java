/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 *
 * @author Student
 */
public class Product implements IProduct {
    
    private String[] productNames = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket",
    };
    
    private int[][] sales = {
        {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
            
            
    };
    
    @Override
    public int GetTotalProductsSold() {
        
        int total = 0;
        
        for (int i = 0; i < sales.length; i++) {
            
            for int j = 0; j < sales[i].length; j++)
            {
                total += sales[i][j];
            }
        }
        
        return total;
    }
    
    @Override 
    public double 
            GetAverageProductsSold() {
                
                return GetTotalProductsSold() / 9.0;
            }
            
            @Override 
            public String GetMostPopularProdcuct() {
                int highest = 0;
                String popular = "";
                
                for (int i = 0; i < sales.length; i++)
            }
            
            if (sales[][] > highest) {
            
            highest = sales [i][j];
         popular = productNames[i];
}
}
}
 return popular + "("+ highest +")"

}
}
}