package test.character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import character.Orc;

class OrcTest {

	@DisplayName("오크 스킬 Anger 사용 테스트")
	@Test
	void elusionTest() {
		// given
		Orc orc = new Orc();
		double beforeAttackPower = orc.getAttackPower();
		double beforeDefensePower = orc.getDefensePower();
		
		// when
		orc.basicSkil();
		
		// then
		double afterAttackPower = orc.getAttackPower();
		double afterDefensePower = orc.getDefensePower();
		assertEquals(beforeAttackPower * 1.5, afterAttackPower);
		assertEquals(beforeDefensePower * 0.9, afterDefensePower);
	}
	
	@DisplayName("오크 궁극 스킬 Frenzy 사용 테스트")
	@Test
	void frenzyTest() throws Exception {
		// given
		Orc orc = new Orc();
		double beforeAttackPower = orc.getAttackPower();
		
		// when
		orc.ultimateSkil();
		
		// then 1. : 공격력이 올라간다.
		double afterAttackPower = orc.getAttackPower();
		assertEquals(beforeAttackPower * 5, afterAttackPower);
		
		// 1분 5초 sleep
		Thread.sleep(65000);
		
		// then 2. : 1분이 지나고 공격력이 다시 되돌아온다.
		assertEquals(beforeAttackPower, orc.getAttackPower());
	}

}
