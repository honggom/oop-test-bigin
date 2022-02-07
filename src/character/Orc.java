package character;

import util.ChanceUtil;
import util.TimerUtil;
import weapon.orcweapon.OrcWeapon;

public class Orc extends Character {

	public Orc() {
		this.level = 99;
		this.hp = 150;
		this.mp = 50;
		this.attackPower = 15;
		this.attackSpeed = 0.8f;
		this.defensePower = 1;
		this.avoid = 0.1f;
	}

	@Override
	public void basicSkil() {
		int requireMp = 10;

		if (this.isEnough(requireMp)) {
			this.anger();
			this.mp -= requireMp;
		} else {
			System.out.println("mp가 부족합니다.");
		}
	}
	
	private void anger() {
		System.out.println("스킬 'Anger' 사용");
		this.attackPower = this.attackPower * 1.5;
		this.defensePower = this.defensePower * 0.9;
	}

	@Override
	public void ultimateSkil() {
		if (this.level >= 99) {
			int requireMp = 50;

			if (this.isEnough(requireMp)) {
				this.frenzy();
				this.mp -= requireMp;
			} else {
				System.out.println("mp가 부족합니다.");
			}
		} else {
			System.out.println("아직 궁극 스킬을 사용할 수 없습니다.");
		}
	}
	
	private void frenzy() {
		System.out.println("궁극 스킬 'Frenzy' 사용");

		this.attackPower *= 5;

		TimerUtil.doAfter(60000, () -> {
			this.attackPower /= 5;
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

	public void setOrcWeapon(OrcWeapon orcWeapon) {
		this.weapon = orcWeapon;
		orcWeapon.upgradeStat(this);
	}

}