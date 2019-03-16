package de.uni_mannheim.informatik.swt.naorobotpipeline.controller;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import de.uni_mannheim.informatik.swt.naorobotpipeline.PipelineNaoRobotApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PipelineNaoRobotApplication.class)
public class WordControllerTest {

	@Autowired
	WordController contr;

	@Before
	public void initialSetup() {
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
		String text = "$Master";

		String success = "Murat Ugur Selcuk";

		contr.getMemory();

		String output = contr.determineTextToSay(text);

		assertTrue(output.trim().equals(success.trim()));
	}
}
