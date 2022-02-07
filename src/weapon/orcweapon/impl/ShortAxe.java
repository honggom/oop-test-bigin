package weapon.orcweapon.impl;

import character.Character;
import weapon.orcweapon.OrcWeapon;

public class ShortAxe implements OrcWeapon {

	@Override
	public void upgradeStat(Character character) {
		character.setAttackPower(character.getAttackPower() * 1.1);
		character.setAttackSpeed(character.getAttackSpeed() * 0.95);
	}


}
