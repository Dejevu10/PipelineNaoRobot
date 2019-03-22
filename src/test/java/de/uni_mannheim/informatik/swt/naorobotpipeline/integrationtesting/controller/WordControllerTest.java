package de.uni_mannheim.informatik.swt.naorobotpipeline.integrationtesting.controller;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import de.uni_mannheim.informatik.swt.naorobotpipeline.PipelineNaoRobotApplication;
import de.uni_mannheim.informatik.swt.naorobotpipeline.controller.WordController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PipelineNaoRobotApplication.class)
public class WordControllerTest {

	@Autowired
	WordController contr;

	@Before
	public void initialSetup() {
		contr.getMemory();
	}

	@After
	public void afterTest() {
	}

	/**
	 * test the successful splitting of words
	 * 
	 * 
	 */
	@Test
	public void testSuccessSplitting() {
		String text = "Hello my $Master";

		String success = "Hello my Murat Ugur Selcuk";

		String output = contr.determineTextToSay(text);

		assertTrue(output.trim().equals(success.trim()));
	}

	/**
	 * Test successful add word and ask for size
	 */
	@Test
	public void testSuccessWordAddingSize() {
		String key = "MyBoss";
		String value = "Muro";

		contr.addWord(key, value);

		assertTrue(contr.getMemory().getWords().size() == 3);
	}

	/**
	 * Test successful add word and find it again
	 */

	@Test
	public void testSuccessWordAddingFinding() {

		String key = "MyBoss";
		String value = "Muro";

		contr.addWord(key, value);

		String keyToFind = "$" + key;

		String output = contr.determineTextToSay(keyToFind);

		assertTrue(value.trim().equals(output.trim()));
	}

	/**
	 * Test successful add and remove of word ask for size
	 */

	@Test
	public void testSuccessWordAddingRemoving() {

		String key = "MyBoss";
		String value = "Muro";

		contr.addWord(key, value);

		assertTrue(contr.getMemory().getWords().size() == 3);

		contr.removeString(key);

		assertTrue(contr.getMemory().getWords().size() == 2);
	}

	/**
	 * Test successful add and remove of word, word should not be findable
	 */

	@Test
	public void testSuccessWordAddRemoveNotFind() {

		String key = "MyBoss";
		String value = "Muro";

		contr.addWord(key, value);

		String keyToFind = "$" + key;

		String output = contr.determineTextToSay(keyToFind);

		assertTrue(value.trim().equals(output.trim()));

		contr.removeString(key);

		String output2 = contr.determineTextToSay(keyToFind);

		assertTrue(output2.trim().equals("Key is not known"));

	}
}
