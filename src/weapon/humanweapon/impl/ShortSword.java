package weapon.humanweapon.impl;

import character.Character;
import weapon.humanweapon.HumanWeapon;

public class ShortSword implements HumanWeapon {

	@Override
	public void upgradeStat(Character character) {
		character.setAttackPower(character.getAttackPower() * 1.05);
	}

}
