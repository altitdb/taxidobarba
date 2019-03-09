package br.com.taxidobarba.utils;

import org.junit.Assert;
import org.junit.Test;

public class EncoderUtilsTest {

	@Test
	public void shouldEncoderText() {
		String text = "taxidobarba";
		String expected = "52007496FBC1E6093E711F0EBFD749A7957BDEFE44EE82DA80E2322848514FE3";

		EncoderUtils encoderUtils = new EncoderUtils();
		String textEncoded = encoderUtils.encoder(text);

		Assert.assertEquals(expected, textEncoded);
	}

}
