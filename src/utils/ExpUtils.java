package utils;

public class ExpUtils {
	public static int[] needExp = new int[91];

	static {
		initNeedExp();
	}

	private static void initNeedExp() {
		needExp[1] = 15;
		needExp[2] = 33;
		needExp[3] = 56;
		needExp[4] = 70;
		needExp[5] = 94;
		needExp[6] = 105;
		needExp[7] = 174;
		needExp[8] = 232;
		needExp[9] = 258;
		needExp[10] = 361;
		needExp[11] = 400;
		needExp[12] = 460;
		needExp[13] = 550;
		needExp[14] = 645;
		needExp[15] = 707;
		needExp[16] = 820;
		needExp[17] = 1024;
		needExp[18] = 1116;
		needExp[19] = 1374;
		needExp[20] = 1653;
		needExp[21] = 2074;
		needExp[22] = 2383;
		needExp[23] = 2679;
		needExp[24] = 3012;
		needExp[25] = 3415;
		needExp[26] = 3861;
		needExp[27] = 4565;
		needExp[28] = 5229;
		needExp[29] = 6025;
		needExp[30] = 6769;
		needExp[31] = 8092;
		needExp[32] = 8945;
		needExp[33] = 10821;
		needExp[34] = 12134;
		needExp[35] = 13529;
		needExp[36] = 14717;
		needExp[37] = 15702;
		needExp[38] = 16561;
		needExp[39] = 17538;
		needExp[40] = 19112;
		needExp[41] = 21999;
		needExp[42] = 23253;
		needExp[43] = 25544;
		needExp[44] = 27271;
		needExp[45] = 29087;
		needExp[46] = 31739;
		needExp[47] = 34318;
		needExp[48] = 37963;
		needExp[49] = 40836;
		needExp[50] = 43912;
		needExp[51] = 47934;
		needExp[52] = 50318;
		needExp[53] = 54570;
		needExp[54] = 57263;
		needExp[55] = 60428;
		needExp[56] = 63433;
		needExp[57] = 65171;
		needExp[58] = 69345;
		needExp[59] = 75230;
		needExp[60] = 82359;
		needExp[61] = 86681;
		needExp[62] = 91347;
		needExp[63] = 122029;
		needExp[64] = 139981;
		needExp[65] = 145257;
		needExp[66] = 154901;
		needExp[67] = 166768;
		needExp[68] = 178629;
		needExp[69] = 182457;
		needExp[70] = 198799;
		needExp[71] = 201234;
		needExp[72] = 212348;
		needExp[73] = 229872;
		needExp[74] = 233987;
		needExp[75] = 244806;
		needExp[76] = 254564;
		needExp[77] = 268390;
		needExp[78] = 272415;
		needExp[79] = 280718;
		needExp[80] = 299871;
		needExp[81] = 309809;
		needExp[82] = 313482;
		needExp[83] = 332009;
		needExp[84] = 362387;
		needExp[85] = 394921;
		needExp[86] = 474809;
		needExp[87] = 552387;
		needExp[88] = 622837;
		needExp[89] = 704381;
		needExp[90] = 99999999;
	}

	public static int[] getNeedExp() {
		return needExp;
	}
}