package club.huitu.ds.tree.string;

/**
 * 基于KMP的子串匹配算法
 * @author hiutu
 * Created by huitu on 2019/9/22.
 */
public class KMPIndexOf {

	public static int IndexOf(String source, String target) {
		if(source == null) { return -1; }
		if(target == null) { return -1; }
		return indexOf(source.toCharArray(), target.toCharArray(), 0);
	}

	public static int IndexOf(String source, String target, int start) {
		if(source == null) { return -1; }
		if(target == null) { return -1; }
		return indexOf(source.toCharArray(), target.toCharArray(), start);
	}

	/**
	 * 在source中找出target第一次出现的位置
	 * @param source 被匹配的字符数组
	 * @param target 要匹配的字符数组
	 * @param start 开始匹配的位置
	 * @return 第一次出现的位置
	 */
	public static int indexOf(char[] source, char[] target, int start) {
		if(source == null || target == null || start > source.length - 1) { return -1; }
		if(target.length == 0) { return 0; }

		int pos = start;
		int i = 0;
		int[] next = getNext(target);

		while (pos < source.length && i < target.length ) {
			if(source[pos] == target[i]) {
				pos++;
				i++;
			}
			else {
				if(i == 0) { pos++; }
				i = next[i];
			}
		}
		return i == target.length ? pos - target.length : -1;
	}

	private static int[] getNext(char[] target) {
		int[] next = new int[target.length];
		next[0] = 0;
		for(int i = 1, pos = 0; i < target.length; ) {
			if(pos == 0 || target[i] == target[pos]) {
				next[i++] = pos++;
			}
			else {
				pos = next[pos];
			}
		}
		return next;
	}


}
