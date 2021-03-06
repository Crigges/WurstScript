package tests.wurstscript.objectreader;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import de.peeeq.wurstio.objectreader.WTSFile;
import de.peeeq.wurstscript.WLogger;

public class TestWTS {

	
	@Test
	public void testWTS() throws IOException {
		File wts = new File("testscripts/mpq/war3map.wts");
		Map<Integer, String> result = WTSFile.parse(wts);
		for (Entry<Integer, String> e : result.entrySet()) {
			WLogger.info(e.getKey() + " -> '" + e.getValue() + "'");
			WLogger.info("");
		}
		assertEquals("Player 1", result.get(1));
		
	}


}
