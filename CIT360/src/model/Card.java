package model;

public class Card {

	String code;
	String suit;
	String value;
	
	public Card (String code, String suit, String value) {
		this.code = code;
		this.suit = suit;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public String getSuit() {
		return suit;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return new String(this.value + " of " + this.suit);
	}
}
