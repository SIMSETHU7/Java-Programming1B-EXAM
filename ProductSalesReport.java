/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesreport;

/**
 *
 * @author Student
 */

import java.util.Scanner;
public class ProductSalesReport {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket",
        };
        
        int sales[][] = new int[3][3];
        
        int totalSales = 0;
        int highestSales = 0;
        String mostPopularProduct = "";
        
        //Enter sales for each product
        for (int i=0;i < products.length; i++) {
            
            for (int j = 0; j < 3; j++) {
                
                System.out.print("Enter number of sales for month"
                        + (j + 1) + "for" + 
                        products[i]+ "mattress:");
                
                sales[i][j] = input.nextInt();
                
                totalSales += sales [i][j];
                
                //Find highest individual monthly sales
                
                if (sales[i][j] > highestSales) {
                    highestSales = sales[i][j];
                    mostPopularProduct = products[i];
                    
                }
            }
        }
        
        //Calculate average sales
        double averageSales = totalSales / 9.0;
        
        //Display report 
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        
        System.out.println("********************");
        
        System.out.println("TPOTAL PRODUCT SALES: + totalSales");
        
        System.out.println("AVERAGE PRODUCT SALES:"
         + (int) averageSales);
        
        System.out.println("MOST POPULAR PRODUCT:"
        + mostPopularProduct + "(" + highestSales + ")");
        
        input.close();
        
        
    }
}
