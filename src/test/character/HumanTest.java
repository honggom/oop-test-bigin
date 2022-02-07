package test.character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import character.Human;

class HumanTest {

	@DisplayName("휴먼 스킬 Guard 사용 테스트")
	@Test
	void guardTest() {
		// given
		Human human = new Human();
		double beforeDefensePower = human.getDefensePower();
		
		// when
		human.basicSkil();
		
		// then
		double afterDefensePower = human.getDefensePower();
		assertEquals(beforeDefensePower * 1.3, afterDefensePower);
	}
	
	@DisplayName("휴먼 궁극 스킬 Invincible 사용 테스트")
	@Test
	void invincibleTest() throws Exception {
		// given
		Human human = new Human();
		
		// when
		human.ultimateSkil();
		
		// then 1. : 무적 상태가 된다.
		assertEquals(true, human.isInvincible());
		
		// 11초 sleep
		Thread.sleep(11000);
		
		// then 2. : 10초가 지나고 무적 상태가 해제된다.
		assertEquals(false, human.isInvincible());
	}

}
