package weapon.elfweapon.impl;

import character.Character;
import weapon.elfweapon.ElfWeapon;

public class IronBow implements ElfWeapon {

	@Override
	public void upgradeStat(Character character) {
		character.setAttackSpeed(character.getAttackSpeed() * 1.1);
	}

}
