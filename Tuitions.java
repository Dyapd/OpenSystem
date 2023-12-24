package taskp;

import java.util.Scanner;

//method is for payment type
public class Tuitions {
    public String tuitions(String course) {
        Scanner scanner = new Scanner(System.in);

        double tuitionFee = getTuitionFee(course);
        String con;
        Scanner in = new Scanner(System.in);
        
        //input not found in choices return 0 fee
        //if 0 fee then invalid course
        if (tuitionFee == 0.0) {
            System.out.println("Invalid course."); 
        }
        
        //while loop to allow decision of user
        while (true) {
        	while(true) {
        System.out.println("Course: " + course);
        System.out.println("Tuition Fee: PHP " + formatCurrency(tuitionFee));

        System.out.print("Choose the payment type (I - Installment, F - Full Payment): ");
        String paymentType = scanner.nextLine().toUpperCase();

        //installment payment type
        //displays installment plan
        if (paymentType.equalsIgnoreCase("I")) {
            int numberOfInstallments = getNumberOfInstallments(course);
            double installmentAmount = tuitionFee * 1.1;
            double totalPaymentPerSemester = installmentAmount / numberOfInstallments;

            System.out.println("Installment Plan:");
            System.out.println("Number of Installments: " + numberOfInstallments);
            System.out.println("Installment Amount : PHP " + formatCurrency(installmentAmount));
            System.out.println("Total Payment for 1st month: PHP " + formatCurrency(totalPaymentPerSemester));
            System.out.println("Total Payment for 2nd month: PHP " + formatCurrency(totalPaymentPerSemester));
            System.out.println("Total Payment for 3rd month: PHP " + formatCurrency(totalPaymentPerSemester));
            System.out.println("Total Payment for 4th month: PHP " + formatCurrency(totalPaymentPerSemester) + "\n");
            
            System.out.print("Confirm? [Y/N]: ");
            con = in.nextLine();        
            System.out.println("______________________________________________________________________________________________________________");
            
            if (con.equalsIgnoreCase("y")) {
            	return "I";
            }
            else if (con.equalsIgnoreCase("n")) {
            	break;
            }
           
            
        //fullpayment type
        //displays payment plan
        } else if (paymentType.equalsIgnoreCase("F")) {
            double totalPaymentPerSemester = tuitionFee;

            System.out.println("Full Payment Plan:");
            System.out.println("Payment Amount for whole Semester: " + formatCurrency(totalPaymentPerSemester));
            
            System.out.print("Confirm? [Y/N]: ");
            con = in.nextLine();        
            System.out.println("______________________________________________________________________________________________________________");
            
            
            if (con.equalsIgnoreCase("y")) {
            	return "F";
            }
            //loops
            else if (con.equalsIgnoreCase("n")) {
            	break;
            }
            
        } else {
            System.out.println("Invalid payment type.");
        }
        }

        }
    }

    
    
    //returns double based on course input
    public static double getTuitionFee(String course) {
        switch (course) {
            case "BSIT":
                return 60000.00;
            case "BSCS":
                return 55000.00;
            case "BSCPE":
                return 57000.00;
            case "BSBA":
                return 50000.00;
            case "BSA":
                return 48000.00;
            case "BSTM":
                return 52000.00;
            case "BSHM":
                return 51000.00;
            default:
                return 0.0;
        }
    }
    
    //returns number of installments for installment plan
    public static int getNumberOfInstallments(String course) {
        switch (course) {
            case "BSIT":
            case "BSCS":
            case "BSCPE":
            case "BSBA":
            case "BSA":
            case "BSTM":
            case "BSHM":
                return 4;
            default:
                return 0;
        }
    }
    
    //formats the payment plan
    public static String formatCurrency(double amount) {
        long roundedAmount = Math.round(amount * 100);
        long pesos = roundedAmount / 100;
        long cents = roundedAmount % 100;
        return String.format("%,d.%02d", pesos, cents);
    }
}