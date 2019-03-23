package de.uni_mannheim.informatik.swt.naorobotpipeline.unittesting.model;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.uni_mannheim.informatik.swt.naorobotpipeline.PipelineNaoRobotApplication;
import de.uni_mannheim.informatik.swt.naorobotpipeline.model.IWordMemory;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = PipelineNaoRobotApplication.class)
public class WordMemoryTest {

	@Autowired
	IWordMemory wordMemory;

	@Before
	public void initialSetup() {

		wordMemory.setWordList();
	}

	@After
	public void afterTest() {
	}

	/**
	 * Test successful add word and ask for size
	 */
	@Test
	public void testSuccessWordAddingSize() {
		String key = "MyBoss";
		String value = "Muro";

		wordMemory.addString(key, value);
		
		wordMemory.setWordList();

		assertTrue(wordMemory.getWords().size() == 3);
	}

	/**
	 * Test successful add word and find it again
	 */

	@Test
	public void testSuccessWordAddingFinding() {

		String key = "MyBoss";
		String value = "Muro";

		wordMemory.addString(key, value);

		String output = wordMemory.getString(key);

		assertTrue(value.trim().equals(output.trim()));
	}

	/**
	 * Test successful add and remove of word ask for size
	 */

	@Test
	public void testSuccessWordAddingRemoving() {

		String key = "MyBoss";
		String value = "Muro";

		wordMemory.addString(key, value);

		wordMemory.setWordList();

		assertTrue(wordMemory.getWords().size() == 3);

		wordMemory.removeString(key);

		wordMemory.setWordList();

		assertTrue(wordMemory.getWords().size() == 2);
	}

	/**
	 * Test successful add and remove of word, word should not be available
	 */

	@Test
	public void testSuccessWordAddRemoveNotFind() {

		String key = "MyBoss";
		String value = "Muro";

		wordMemory.addString(key, value);

		String output = wordMemory.getString(key);

		assertTrue(value.trim().equals(output.trim()));

		wordMemory.removeString(key);

		String output2 = wordMemory.getString(key);

		assertTrue(output2.trim().equals("Key is not known"));

	}
}
