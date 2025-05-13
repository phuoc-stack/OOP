import java.util.Scanner;

public class PaymentProcessor {
	private double subtotal;
	private double totalBeforeDiscount = 0;
	private double voucherDiscount = 0;
	private double shippingFee;
	private double rankDiscount = 0;
	final double DISCOUNT_RATE_DIAMOND = 0.03;
	final double DISCOUNT_RATE_GOLD = 0.02;

	public double calculateSubTotal(Customer customer) {
		subtotal = 0;
		for (CartItem item : customer.customerCart.items) {
			subtotal += item.price * item.quantity;
		}
		return subtotal;
	}

	public double calculateShippingFee(Customer customer) {
		shippingFee = 5;
		String currentRank = customer.rank;
		if (currentRank.equalsIgnoreCase("silver")) {
			shippingFee *= 0.5;
		}
		return shippingFee;
	}

	public double calculateRankDiscount(Customer customer) {
		double totalBeforeDiscount = subtotal + shippingFee;
		if (customer.rank.equalsIgnoreCase("diamond")) {
			rankDiscount = totalBeforeDiscount * DISCOUNT_RATE_DIAMOND;
		} else if (customer.rank.equalsIgnoreCase("gold")) {
			rankDiscount = totalBeforeDiscount * DISCOUNT_RATE_GOLD;
		}
		return rankDiscount;
	}
	
	public double calculateVoucherDiscount(Scanner input) {
		System.out.println("Do you have voucher AAA? (Y/N) ");
		String optionVoucher = input.nextLine();
		if (optionVoucher.equalsIgnoreCase("Y")) {
			voucherDiscount = 1;
		}
		return voucherDiscount;
	}

	public double calculateFinalPayment() {
		totalBeforeDiscount = subtotal + shippingFee;
		return totalBeforeDiscount - rankDiscount - voucherDiscount;
	}
	
	public void displayReceipt(Customer customer, Scanner input) {
		    calculateSubTotal(customer);
		    
		    System.out.println("Proceed with payment? (Y/N) ");
		    String payOption = input.nextLine();
		    
		    if (payOption.equalsIgnoreCase("Y")) {
		        calculateShippingFee(customer);
		        calculateVoucherDiscount(input);
		        calculateRankDiscount(customer);
		        double totalPayment = calculateFinalPayment();
		        
		        System.out.println("\n-----------------------------");
		        
		        // Display items
		        for (CartItem item : customer.customerCart.items) {
		            System.out.println(item.name + " x" + item.quantity + " : " + (item.price * item.quantity) + " aud");
		        }
		        
		        System.out.println("-----------------------------");
		        System.out.println("Subtotal: " + String.format("%.2f", subtotal) + " aud");
		        System.out.println("Shipping Fee: " + String.format("%.2f", shippingFee) + " aud");
		        
		        // Only show discounts if they are greater than zero
		        if (rankDiscount > 0) {
		            System.out.println("Rank Discount: -" + String.format("%.2f", rankDiscount) + " aud") ;
		        }
		        
		        if (voucherDiscount > 0) {
		            System.out.println("Voucher Discount: -" + String.format("%.2f", voucherDiscount) + " aud");
		        }
		        
		        System.out.println("-----------------------------");
		        System.out.println("Total Payment: " + String.format("%.2f", totalPayment) + " aud");
		    }
		}
    }
