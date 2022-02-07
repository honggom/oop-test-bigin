package main;

import character.Human;
import monster.Golem;
import weapon.humanweapon.HumanWeapon;
import weapon.humanweapon.impl.ShortSword;

public class Main {
	public static void main(String[] args) {
		Human human = new Human();
		Golem golem = new Golem();
		HumanWeapon shortSword = new ShortSword();
		human.setHumanWeapon(shortSword);
		
		human.attack(golem);
		human.attack(golem);
		
		human.basicSkil();
		
		human.attack(golem);
		human.attack(golem);
		
		golem.attack(human);
		golem.attack(human);
		
		human.ultimateSkil();
		
		golem.attack(human);
		golem.attack(human);
	}
}
