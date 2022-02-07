package test.character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import character.Elf;

class CharacterTest {

	@DisplayName("공통 스킬 Heal 사용 테스트")
	@Test
	void healTest() {
		// given
		Elf elf = new Elf();
		int beforeHp = elf.getHp();
		int beforeMp = elf.getMp();
		
		// when
		elf.heal(10);
		int afterHp = elf.getHp();
		int afterMp = elf.getMp();
		
		// then
		assertNotEquals(beforeHp, afterHp);
		assertNotEquals(beforeMp, afterMp);

	}
	
	@DisplayName("공통 스킬 Steam 사용 테스트")
	@Test
	void steamTest() {
		// given
		Elf elf = new Elf();
		double beforeAttackPower = elf.getAttackPower();
		int beforeMp = elf.getMp();
		
		// when
		elf.steam();
		double afterAttackPower = elf.getAttackPower();
		int afterMp = elf.getMp();
		
		// then
		assertNotEquals(beforeAttackPower, afterAttackPower);
		assertEquals(beforeMp, afterMp + 20);

	}

}
