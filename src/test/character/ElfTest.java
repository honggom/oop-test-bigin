package test.character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import character.Elf;

public class ElfTest {
	
	@DisplayName("엘프 스킬 Elusion 사용 테스트")
	@Test
	void elusionTest() {
		// given
		Elf elf = new Elf();
		double beforeAvoid = elf.getAvoid();
		
		// when
		elf.basicSkil();
		
		// then
		double afterAvoid = elf.getAvoid();
		assertEquals(beforeAvoid * 1.3, afterAvoid);
	}
	
	@DisplayName("엘프 궁극 스킬 Rapid 사용 테스트")
	@Test
	void rapidTest() throws Exception {
		// given
		Elf elf = new Elf();
		double beforeAttackSpeed = elf.getAttackSpeed();
		
		// when
		elf.ultimateSkil();
		
		// then 1. : 공격속도가 올라간다.
		double afterAttackSpeed = elf.getAttackSpeed();
		assertEquals(beforeAttackSpeed * 5, afterAttackSpeed);
		
		// 1분 5초 sleep
		Thread.sleep(65000);
		
		// then 2. : 1분이 지나고 공격속도가 다시 되돌아온다.
		assertEquals(beforeAttackSpeed, elf.getAttackSpeed());
	}
	

}
