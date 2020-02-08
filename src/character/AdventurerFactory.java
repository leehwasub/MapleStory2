package character;

import hunt.FighterHuntEvent;
import hunt.PageHuntEvent;
import hunt.SpearManHuntEvent;
import skill.SkillFactory;

public class AdventurerFactory {
	public static Adventurer makeAdventurer(String name, String adventurerType) {
		switch (adventurerType) {
		case "남자초보모험가":
			return new Adventurer(name, "newbieMan",
					new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 3, 0, 0, 0, 0, 0, 0, 0),
					new Status(4, 4, 4, 4), "초보자");
		case "여자초보모험가":
			return new Adventurer(name, "newbieWoman",
					new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 3, 0, 0, 0, 0, 0, 0, 0),
					new Status(4, 4, 4, 4), "초보자");
		case "남자1차모험가":
			Adventurer adventurer = new Adventurer(name, "warriorMan",
					new Strength(new Resistance(100, 100, 100, 100, 100, 100), 25, 15, 3, 0, 0, 0, 0, 0, 0, 0),
					new Status(104, 24, 4, 4), "검사");
			//TEST
			adventurer.addSkillPoint(15 * 3);
			adventurer.setSex("남자");
			//
			return adventurer;
		case "여자1차모험가":
			Adventurer adventurer2 = new Adventurer(name, "warriorWoman",
					new Strength(new Resistance(100, 100, 100, 100, 100, 100), 25, 15, 3, 0, 0, 0, 0, 0, 0, 0),
					new Status(104, 24, 4, 4), "검사");
			//TEST
			adventurer2.addSkillPoint(15 * 3);
			adventurer2.setSex("여자");
			//
			return adventurer2;
		}
		return null;
	}
	
	public static void upgradeAdventurer(String careerName, Adventurer adventurer) {
		StringBuffer imageUrl = new StringBuffer("warrior");
		switch(careerName) {
		case "검사":
			adventurer.setCareerLevel(1);
			adventurer.addSkill(1, SkillFactory.makeSkill("HP증가"));
			adventurer.addSkill(1, SkillFactory.makeSkill("파워스트라이크"));
			adventurer.addSkill(1, SkillFactory.makeSkill("아이언바디"));
			break;
		case "파이터":
			adventurer.setCareerLevel(2);
			adventurer.addSkill(2, SkillFactory.makeSkill("검마스터리"));
			adventurer.addSkill(2, SkillFactory.makeSkill("피지컬트레이닝"));
			adventurer.addSkill(2, SkillFactory.makeSkill("브랜디쉬"));
			adventurer.addSkill(2, SkillFactory.makeSkill("분노"));
			adventurer.addSkill(2, SkillFactory.makeSkill("콤보어택"));
			adventurer.setHuntEvent(new FighterHuntEvent());
			imageUrl.append("2");
			break;
		case "크루세이더":
			adventurer.setCareerLevel(3);
			adventurer.addSkill(3, SkillFactory.makeSkill("찬스어택"));
			adventurer.addSkill(3, SkillFactory.makeSkill("브레이브슬래시"));
			adventurer.addSkill(3, SkillFactory.makeSkill("패닉"));
			adventurer.addSkill(3, SkillFactory.makeSkill("샤우트"));
			adventurer.addSkill(3, SkillFactory.makeSkill("콤보시너지"));
			imageUrl.append("3");
			break;
		case "페이지":
			adventurer.setCareerLevel(2);
			adventurer.addSkill(2, SkillFactory.makeSkill("검마스터리"));
			adventurer.addSkill(2, SkillFactory.makeSkill("피지컬트레이닝"));
			adventurer.addSkill(2, SkillFactory.makeSkill("플레임차지"));
			adventurer.addSkill(2, SkillFactory.makeSkill("블리자드차지"));
			adventurer.addSkill(2, SkillFactory.makeSkill("엘리멘탈차지"));
			adventurer.setHuntEvent(new PageHuntEvent());
			imageUrl.append("2");
			break;
		case "나이트":
			adventurer.setCareerLevel(3);
			adventurer.addSkill(3, SkillFactory.makeSkill("실드마스터리"));
			adventurer.addSkill(3, SkillFactory.makeSkill("블레싱아머"));
			adventurer.addSkill(3, SkillFactory.makeSkill("라이트닝차지"));
			adventurer.addSkill(3, SkillFactory.makeSkill("위협"));
			adventurer.addSkill(3, SkillFactory.makeSkill("컴뱃오더스"));
			imageUrl.append("3");
			break;
		case "스피어맨":
			adventurer.setCareerLevel(2);
			adventurer.addSkill(2, SkillFactory.makeSkill("창마스터리"));
			adventurer.addSkill(2, SkillFactory.makeSkill("피지컬트레이닝"));
			adventurer.addSkill(2, SkillFactory.makeSkill("피어싱쓰루"));
			adventurer.addSkill(2, SkillFactory.makeSkill("아이언월"));
			adventurer.addSkill(2, SkillFactory.makeSkill("하이퍼바디"));
			adventurer.setHuntEvent(new SpearManHuntEvent());
			imageUrl.append("2");
			break;
		case "버서커":
			adventurer.setCareerLevel(3);
			adventurer.addSkill(3, SkillFactory.makeSkill("로드오브다크니스"));
			adventurer.addSkill(3, SkillFactory.makeSkill("비홀더스버프"));
			adventurer.addSkill(3, SkillFactory.makeSkill("라만차스피어"));
			adventurer.addSkill(3, SkillFactory.makeSkill("비홀더쇼크"));
			adventurer.addSkill(3, SkillFactory.makeSkill("크로스오버체인"));
			imageUrl.append("3");
			break;
		}
		if(adventurer.getSex().equals("남자")) {
			imageUrl.append("Man");
		} else if(adventurer.getSex().equals("여자")) {
			imageUrl.append("Woman");
		}
		adventurer.setCareer(careerName);
		adventurer.setImageUrl(imageUrl.toString());
	}
	
}
