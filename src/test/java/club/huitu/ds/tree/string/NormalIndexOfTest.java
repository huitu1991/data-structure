package club.huitu.ds.tree.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hiutu
 * Created by huitu on 2019/9/22.
 */
public class NormalIndexOfTest {

	@Test
	public void testIndexOf() {

		Assert.assertEquals(
				NormalIndexOf.IndexOf("abc", ""), 0);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("abc", "a"), 0);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("abc", "c"), 2);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("abc", "e"), -1);

		Assert.assertEquals(
				NormalIndexOf.IndexOf("abc", "bc"), 1);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("abc", "huitu"), -1);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("ababcabcd", "abc"), 2);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("ababcabcd", "abcd"), 5);

		//测试 start 参数
		Assert.assertEquals(
				NormalIndexOf.IndexOf("ababcabcd", "abc", 4), 5);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("ababcabcd", "abc", 5), 5);
		Assert.assertEquals(
				NormalIndexOf.IndexOf("ababcabcd", "abc", 6), -1);

	}

}
