package character;

import util.ChanceUtil;
import util.TimerUtil;
import weapon.elfweapon.ElfWeapon;

public class Elf extends Character {

	public Elf() {
		this.level = 99;
		this.hp = 50;
		this.mp = 150;
		this.attackPower = 15;
		this.attackSpeed = 2f;
		this.defensePower = 2;
		this.avoid = 0.5f;
	}

	@Override
	public void basicSkil() {
		int requireMp = 10;

		if (isEnough(requireMp)) {
			this.elusion();
			this.mp -= requireMp;
		} else {
			System.out.println("mp가 부족합니다.");
		}
	}
	
	private void elusion() {
		System.out.println("스킬 'Elusion' 사용");
		this.avoid = this.avoid * 1.3;
	}

	@Override
	public void ultimateSkil() {
		if (this.level >= 99) {
			int requireMp = 50;

			if (this.isEnough(requireMp)) {
				this.rapid();
				this.mp -= requireMp;
			} else {
				System.out.println("mp가 부족합니다.");
			}
		} else {
			System.out.println("아직 궁극 스킬을 사용할 수 없습니다.");
		}
	}
	
	private void rapid() {
		System.out.println("궁극 스킬 'Rapid' 사용");

		this.attackSpeed *= 5;

		TimerUtil.doAfter(60000, () -> {
			this.attackSpeed /= 5;
		});
	}

	@Override
	public void attacked(double attackPower) {
		if (ChanceUtil.percent(this.avoid)) {
			System.out.println("공격을 회피했습니다.");
		} else {
			this.hp -= (int) (attackPower - this.defensePower);
			System.out.printf("몬스터에게 공격당했습니다. (현재 hp : [%d])\n", this.hp);
		}
	}

	public void setElfWeapon(ElfWeapon elfWeapon) {
		this.weapon = elfWeapon;
		elfWeapon.upgradeStat(this);
	}

}