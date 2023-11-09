import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BusinessRuleEngineTest {

    @Test
    void shouldHaveNoRulesInitially() {
        final Facts facts = new Facts();
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);

        assertEquals(0, businessRuleEngine.count());

    }

    @Test
    void shouldAddActions() {
        final Facts facts = new Facts();
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);

        businessRuleEngine.addAction(fact -> {});
        businessRuleEngine.addAction(fact -> {});

        assertEquals(2, businessRuleEngine.count());
    }

    /*@Test
    void shouldExecuteOneAction() {
        final Facts facts = new Facts();
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
        final Action mockAction = mock(Action.class);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute(facts);
    }*/

    @Test
    void shouldExecuteAnActionWithFacts() {
        final Action mockAction = mock(Action.class);
        final Facts mockFacts = mock(Facts.class);
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute(mockFacts);
    }
}