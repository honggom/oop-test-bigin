package character;

import util.ChanceUtil;
import util.TimerUtil;
import weapon.humanweapon.HumanWeapon;

public class Human extends Character {

	private boolean isInvincible = false;

	public Human() {
		this.level = 100;
		this.hp = 100;
		this.mp = 70;
		this.attackPower = 10;
		this.attackSpeed = 1f;
		this.defensePower = 5;
		this.avoid = 0.2f;
	}

	@Override
	public void basicSkil() {
		int requireMp = 10;

		if (this.isEnough(requireMp)) {
			this.guard();
			this.mp -= requireMp;
		} else {
			System.out.println("mp가 부족합니다.");
		}
	}
	
	private void guard() {
		System.out.println("스킬 'Guard' 사용");
		this.defensePower = this.defensePower * 1.3;
	}
	
	@Override
	public void ultimateSkil() {
		if (this.level >= 99) {
			int requireMp = 50;

			if (this.isEnough(requireMp)) {
				this.invincible();
				this.mp -= requireMp;
			} else {
				System.out.println("mp가 부족합니다.");
			}
		} else {
			System.out.println("아직 궁극 스킬을 사용할 수 없습니다.");
		}
	}
	
	private void invincible() {
		System.out.println("궁극 스킬 'Invincible' 사용");

		this.isInvincible = true;

		TimerUtil.doAfter(10000, () -> {
			this.isInvincible = false;
		});
	}
	
	@Override
	public void attacked(double attackPower) {
		if (!this.isInvincible) {
			if (ChanceUtil.percent(this.avoid)) {
				System.out.println("공격을 회피했습니다.");
			} else {
				this.hp -= (int) (attackPower - this.defensePower);
				System.out.printf("몬스터에게 공격당했습니다. (현재 hp : [%d])\n", this.hp);
			}
		} else {
			System.out.println("무적 상태입니다.");
		}
	}

	public void setHumanWeapon(HumanWeapon humanWeapon) {
		this.weapon = humanWeapon;
		humanWeapon.upgradeStat(this);
	}
	
	public boolean isInvincible() {
		return isInvincible;
	}
}