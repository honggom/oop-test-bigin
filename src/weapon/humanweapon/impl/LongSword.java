package weapon.humanweapon.impl;

import character.Character;
import weapon.humanweapon.HumanWeapon;

public class LongSword implements HumanWeapon {

	@Override
	public void upgradeStat(Character character) {
		character.setAttackPower(character.getAttackPower() * 1.1);
	}

}
