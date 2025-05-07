package coding;

import oop.Citizen;

public class SubCitizen extends Citizen {
	String address;

	void showAdress() {
		System.out.println("Sub Citizen is showing addres  = " + address);
	}

	void showAdress(String address) {
		System.out.println("Sub Citizen is showing addres  = " + address);
	}

	void showAdress(String address1, String addres2) {
		System.out.println("Sub Citizen is showing addres  = " + address1 + addres2);
	}

	@Override
	protected void cry(String noise) {
		// implementation
		System.out.println("Sub Citizen " + address + " crying " + noise);
	}

	@Override
	protected void showName() {
		System.out.println("citizen name = " +  gender);
	}
}
