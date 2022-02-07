package monster;

import character.Character;
import util.ChanceUtil;

public abstract class Monster {
	
	int hp;
	double attackPower;
	double defensePower;
	
	public void attack(Character character) {
		if(this.isAlive()) {
			if (character.isAlive()) {
				character.attacked(this.attackPower);
			} else {
				System.out.println("죽은 캐릭터입니다.");
			}
		} else {
			System.out.println("몬스터가 죽었습니다.");
		}
	}
	
	public void attacked(double attackPower) {
		this.hp -= (int) (attackPower - this.defensePower);
	}
	
	private void counter(Character character) {
		if (ChanceUtil.percent(0.3f)) {
			System.out.println("몬스터의 반격!");
			character.attacked((int)(character.getAttackPower() * 0.7));
		}
	}
	
	public void passiveSkils(Character character) {
		counter(character);
	}
	
	public boolean isAlive() {
		if (this.hp > 0) {
			return true;
		}
		return false;
	}
	
	public int getHp() {
		return hp;
	}
}
