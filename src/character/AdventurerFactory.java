package character;

public class AdventurerFactory {
	public static Adventurer makeAdventurer(String name, String adventurerType)
  {
    switch (adventurerType)
    {
    case "남자초보모험가": 
        return new Adventurer(name, "newbieMan", new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 4, 0, 0, 0, 0, 0, 0, 0), new Status(4, 4, 4, 4), "초보자");
    case "여자초보모험가": 
        return new Adventurer(name, "newbieWoman", new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 4, 0, 0, 0, 0, 0, 0, 0), new Status(4, 4, 4, 4), "초보자");
    }
    return null;
  }
}
