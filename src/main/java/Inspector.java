import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {

    private final List<ConditionalAction> conditionalActions;

    public Inspector(final ConditionalAction... conditionalActions) {
        this.conditionalActions = Arrays.asList(conditionalActions);
    }

    public List<Report> inspect(final Facts facts) {
        final List<Report> reportList = new ArrayList<>();
        for (ConditionalAction conditionalAction: conditionalActions) {
            final boolean conditionResult = conditionalAction.evaluate(facts);
            reportList.add(new Report(conditionalAction, facts, conditionResult));
        }
        return reportList;
    }

}
