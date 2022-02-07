package character;

import monster.Monster;
import util.DelayUtil;
import weapon.Weapon;

public abstract class Character {

	Weapon weapon;
	int level;
	int hp;
	int mp;
	double attackPower;
	double attackSpeed;
	double defensePower;
	double avoid;

	// 공통 스킬 1.
	public void heal(int mp) {
		if (this.isAlive()) {
			if (this.isEnough(mp)) {
				this.hp += mp;
				this.mp -= mp;
				System.out.println("스킬 'Heal' 사용");
			} else {
				System.out.println("mp가 부족합니다.");
			}
		} else {
			System.out.println("캐릭터가 죽었습니다.");
		}
	}

	// 공통 스킬 2.
	public void steam() {
		if (this.isAlive()) {
			int requireMp = 20;

			if (this.isEnough(requireMp)) {
				System.out.println("스킬 'Steam' 사용");
				this.attackPower *= 1.2;
				this.mp -= requireMp;
			} else {
				System.out.println("mp가 부족합니다.");
			}
		} else {
			System.out.println("캐릭터가 죽었습니다.");
		}
	}

	public boolean isEnough(int mp) {
		if (this.mp >= mp) {
			return true;
		}
		return false;
	}

	public boolean isAlive() {
		if (this.hp > 0) {
			return true;
		}
		return false;
	}

	// 몬스터를 공격할 때 사용하는 메서드
	public void attack(Monster monster) {
		if (this.isAlive()) {
			if (monster.isAlive()) {
				if (this.weapon != null) {
					checkPassiveSkills(monster);

					monster.attacked(this.attackPower);

					if (!monster.isAlive()) {
						System.out.println("몬스터를 처치했습니다.");
						this.levelUp();
					} else {
						System.out.printf("몬스터를 공격했습니다. (몬스터의 현재 체력 : [%d])\n", monster.getHp());
					}
					DelayUtil.delay(this.attackSpeed);
				} else {
					System.out.println("무기를 장착해야됩니다.");
				}
			} else {
				System.out.println("죽은 몬스터입니다.");
			}
		} else {
			System.out.println("캐릭터가 죽었습니다.");
		}
	}

	private void checkPassiveSkills(Monster monster) {
		monster.passiveSkils(this);
	}

	private void levelUp() {
		this.level += 1;
		System.out.printf("레벨업 !! (현재 레벨 : [%d])\n", this.level);

		if (this.level == 99) {
			System.out.println("이제 궁극 스킬을 사용할 수 있습니다.");
		}
	}

	abstract void basicSkil();

	abstract void ultimateSkil();
	
	public abstract void attacked(double attackPower);

	// Getter & Setter
	public int getHp() {
		return hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public double getAvoid() {
		return avoid;
	}
	
	public double getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(double attackPower) {
		this.attackPower = attackPower;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	public double getDefensePower() {
		return defensePower;
	}
}