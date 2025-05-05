//Sebastian Arana
// This class models a real world PiggyBank to which pennies, nickels, dimes and quarters can be added.
public class PiggyBank {

	private double balance;

	public PiggyBank(int pennies, int nickels, int dimes, int quarters) {
		balance = pennies * .01 + nickels * .05 + dimes * .1 + quarters * .25;
	}

	public double getTotal() {
		return balance;
	}

	public void addPennies(int pennies) {
		balance += pennies * .01;
	}

	public void addNickels(int nickels) {
		balance += nickels * .05;
	}

	public void addDimes(int dimes) {
		balance += dimes * .1;
	}

	public void addQuarters(int quarters) {
		balance += quarters * .25;
	}

}
