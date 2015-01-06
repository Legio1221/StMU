package w2FormatEditor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EditorLogicTest {
	EditorLogic example;

	@Before
	public void setUp() throws Exception {
		example = new EditorLogic(79, 26, 12, 55);
	}

	@Test
	public void testWriteW2Format() {
		System.out.println(example.writeW2Format());
		example.fileLogic();
	}

}
