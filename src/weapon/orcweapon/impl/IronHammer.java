package weapon.orcweapon.impl;

import character.Character;
import weapon.orcweapon.OrcWeapon;

public class IronHammer implements OrcWeapon {

	@Override
	public void upgradeStat(Character character) {
		character.setAttackPower(character.getAttackPower() * 1.2);
		character.setAttackSpeed(character.getAttackSpeed() * 0.9);
	}

}
