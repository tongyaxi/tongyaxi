package com.knowledge.tongyaxi.DBC_SBC_Change;

public class TestDemo{

	/**
     * ASCII表中可见字符从!开始，偏移位值为33(Decimal)
     */
    static final char DBC_CHAR_START = 33; // 半角!

    /**
     * ASCII表中可见字符到~结束，偏移位值为126(Decimal)
     */
    static final char DBC_CHAR_END = 126; // 半角~

    /**
     * 全角对应于ASCII表的可见字符从！开始，偏移值为65281
     */
    static final char SBC_CHAR_START = 65281; // 全角！

    /**
     * 全角对应于ASCII表的可见字符到～结束，偏移值为65374
     */
    static final char SBC_CHAR_END = 65374; // 全角～

    /**
     * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
     */
    static final int CONVERT_STEP = 65248; // 全角半角转换间隔

    /**
     * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
     */
    static final char SBC_SPACE = 12288; // 全角空格 12288

    /**
     * 半角空格的值，在ASCII中为32(Decimal)
     */
    static final char DBC_SPACE = ' '; // 半角空格

    static final char DBC_SPACE33 = 33;
    static final char DBC_SPACE47 = 47;
    static final char DBC_SPACE58 = 58;
    static final char DBC_SPACE64 = 64;
    static final char DBC_SPACE48 = 48;
    static final char DBC_SPACE57 = 57;
    static final char DBC_SPACE65 = 65;
    static final char DBC_SPACE90 = 90;
    static final char DBC_SPACE91 = 91;
    static final char DBC_SPACE96 = 96;
    static final char DBC_SPACE97 = 97;
    static final char DBC_SPACE122 = 122;
    static final char DBC_SPACE123 = 123;
    static final char DBC_SPACE126 = 126;

    /**
     * <PRE>
     * 半角字符->全角字符转换
     * 只处理空格，!到&tilde;之间的字符，忽略其他
     * </PRE>
     */
    public static String bj2qj(String src) {
        if (src == null) {
            return src;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < ca.length; i++) {
//            if (ca[i] == DBC_SPACE) { // 如果是半角空格，直接用全角空格替代
//                buf.append(SBC_SPACE);
//            } else if ((ca[i] >= DBC_CHAR_START) && (ca[i] <= DBC_CHAR_END)) { // 字符是!到~之间的可见字符
//                buf.append((char) (ca[i] + CONVERT_STEP));
//            } else { // 不对空格以及ascii表中其他可见字符之外的字符做任何处理
//                buf.append(ca[i]);
//            }
        	if (ca[i] == DBC_SPACE) { // 如果是半角空格，直接用全角空格替代
                buf.append(SBC_SPACE);
            } else if ((ca[i] >= DBC_SPACE33) && (ca[i] <= DBC_SPACE47)) { // 字符是!到~之间的可见字符
                buf.append((char) (ca[i] + CONVERT_STEP));
            } else if ((ca[i] >= DBC_SPACE48) && (ca[i] <= DBC_SPACE57)) {
            	buf.append(ca[i]);
			} else if ((ca[i] >= DBC_SPACE58) && (ca[i] <= DBC_SPACE64)) {
				buf.append((char) (ca[i] + CONVERT_STEP));
			} else if ((ca[i] >= DBC_SPACE65) && (ca[i] <= DBC_SPACE90)) {
				buf.append(ca[i]);
			} else if ((ca[i] >= DBC_SPACE91) && (ca[i] <= DBC_SPACE96)) {
				buf.append((char) (ca[i] + CONVERT_STEP));
			} else if ((ca[i] >= DBC_SPACE97) && (ca[i] <= DBC_SPACE122)) {
				buf.append(ca[i]);
			} else if ((ca[i] >= DBC_SPACE123) && (ca[i] <= DBC_SPACE126)) {
				buf.append((char) (ca[i] + CONVERT_STEP));
			} else {
				buf.append(ca[i]);
			}
        }
        return buf.toString();
    }

    /**
     * <PRE>
     * 全角字符->半角字符转换
     * 只处理全角的空格，全角！到全角～之间的字符，忽略其他
     * </PRE>
     */
    public static String qj2bj(String src) {
        if (src == null) {
            return src;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < src.length(); i++) {
            if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内
                buf.append((char) (ca[i] - CONVERT_STEP));
            } else if (ca[i] == SBC_SPACE) { // 如果是全角空格
                buf.append(DBC_SPACE);
            } else { // 不处理全角空格，全角！到全角～区间外的字符
                buf.append(ca[i]);
            }
        }
        return buf.toString();
    }


	public static void main(String[] args){
		System.out.println(bj2qj("ｶﾞﾝﾎｰ ﾌｫｰ H"));
	}
}
